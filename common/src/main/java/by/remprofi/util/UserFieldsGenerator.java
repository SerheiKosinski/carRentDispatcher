package by.remprofi.util;

import by.remprofi.domain.hiber.HiberUser;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.stereotype.Service;

@Service
public class UserFieldsGenerator {

    public String generateEmail(HiberUser user) {
        return user.getName() + "_" + user.getSurname() + "_" + user.getBirthDate() + "@wear.com";
    }

    public String generatePassword() {
        return RandomStringUtils.random(20, true, true);
    }
}
