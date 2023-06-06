package by.remprofi.controller.converter;

import by.remprofi.controller.requests.UserCreateRequest;
import by.remprofi.domain.hiber.AuthenticationInfo;
import by.remprofi.domain.hiber.HiberUser;
import by.remprofi.util.UserFieldsGenerator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UserCreateConverter extends UserBaseConverter<UserCreateRequest, HiberUser> {

    private final UserFieldsGenerator fieldsGenerator;

    @Override
    public HiberUser convert(UserCreateRequest request) {

        HiberUser hiberUser = new HiberUser();

        String generateEmail = fieldsGenerator.generateEmail(hiberUser);
        String generatePassword = fieldsGenerator.generatePassword();
        AuthenticationInfo info = new AuthenticationInfo(generateEmail, generatePassword);

        hiberUser.setAuthenticationInfo(info);

        return doConvert(hiberUser, request);
    }
}
