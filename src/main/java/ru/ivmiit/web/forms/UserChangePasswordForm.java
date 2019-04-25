package ru.ivmiit.web.forms;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserChangePasswordForm {
    private String currentPassword;
    private String password;
    private String passwordRepeat;
}
