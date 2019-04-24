package ru.ivmiit.web.service;

import org.springframework.transaction.annotation.Transactional;
import ru.ivmiit.web.forms.UserRegistrationForm;

import java.util.UUID;

public interface RegistrationService {
    void register(UserRegistrationForm userForm);

    @Transactional
    void sendRestoreCode(String login);

    @Transactional
    void restorePassword(UUID uuid, String newPassword);
}
