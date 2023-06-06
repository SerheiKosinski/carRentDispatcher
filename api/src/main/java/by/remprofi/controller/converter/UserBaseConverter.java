package by.remprofi.controller.converter;

import by.remprofi.controller.requests.UserCreateRequest;
import by.remprofi.domain.hiber.HiberUser;
import org.springframework.core.convert.converter.Converter;

import java.sql.Timestamp;

public abstract class UserBaseConverter<S, T> implements Converter<S, T> {

    public HiberUser doConvert(HiberUser userForUpdate, UserCreateRequest request) {

        userForUpdate.setName(request.getName());
        userForUpdate.setSurname(request.getSurname());

        Timestamp birthDate = request.getBirthDate();
        userForUpdate.setBirthDate((birthDate.toLocalDateTime()));
        userForUpdate.setRating(request.getRating());
        userForUpdate.setViolations(request.getViolations());
        userForUpdate.setFullName(request.getFullName());

        return userForUpdate;
    }

}
