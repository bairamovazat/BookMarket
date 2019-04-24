package ru.ivmiit.web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.ivmiit.web.forms.UserRegistrationForm;
import ru.ivmiit.web.model.Role;
import ru.ivmiit.web.model.User;
import ru.ivmiit.web.repository.RoleRepository;
import ru.ivmiit.web.repository.UserRepository;
import ru.ivmiit.web.security.details.State;

import java.util.ArrayList;
import java.util.UUID;

@Service
public class RegistrationServiceImpl implements RegistrationService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private EmailService emailService;
    private final PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    @Value("${site.url}")
    private String siteUrl;

    private String emailMessage = "Здравствуйте! Перейдите по ссылке, чтобы подтвердить аккаунт %s/confirm/%s";
    private String restoreMessage = "Здравствуйте! Перейдите по ссылке, чтобы востановить пароль %s/restore/%s";

    @Override
    @Transactional
    public void register(UserRegistrationForm userForm) {
        UUID uuid = UUID.randomUUID();
        User newUser = User.builder()
                .login(userForm.getLogin())
                .hashPassword(passwordEncoder.encode(userForm.getPassword()))
                .state(State.CREATED)
                .email(userForm.getEmail())
                .name(userForm.getName())
                .roles(new ArrayList<>())
                .uuid(uuid)
                .build();
        Role role = roleRepository.findFirstByRole(ru.ivmiit.web.security.details.Role.USER);
        role.getUsers().add(newUser);
        newUser.getRoles().add(role);
        emailService.sendMail(String.format(emailMessage, siteUrl, uuid),"Подтверждение аккаунта",userForm.getEmail());
        userRepository.save(newUser);
    }


    @Override
    @Transactional
    public void sendRestoreCode(String login){
        User user = userRepository.findOneByLogin(login).orElseThrow(() -> new IllegalArgumentException("Пользователь не найден"));
        UUID uuid = UUID.randomUUID();
        user.setUuid(uuid);
        userRepository.save(user);
        emailService.sendMail(String.format(restoreMessage, siteUrl, uuid),"Востановление пароля", user.getEmail());
    }

    @Override
    @Transactional
    public void restorePassword(UUID uuid, String newPassword){
        User user = userRepository.findByUuid(uuid).orElseThrow(() -> new IllegalArgumentException("Неверный код"));
        user.setHashPassword(passwordEncoder.encode(newPassword));
        userRepository.save(user);
    }

}
