package by.remprofi.controller.converter;

import by.remprofi.controller.requests.UserUpdateRequest;
import by.remprofi.domain.hiber.HiberUser;
import by.remprofi.exception.EntityNotFoundException;
import by.remprofi.repository.sprdata.UserDataRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class UserUpdateConverter extends UserBaseConverter<UserUpdateRequest, HiberUser> {

    private final UserDataRepository repository;

    @Override
    public HiberUser convert(UserUpdateRequest source) {

        Optional<HiberUser> user = repository.findById(source.getId());
        return doConvert(user.orElseThrow(EntityNotFoundException::new), source);
    }
}
