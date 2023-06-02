package by.remprofi.controller.rest;

import by.remprofi.controller.requests.UserCreateRequest;
import by.remprofi.domain.User;
import by.remprofi.servis.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/rest/users")
@RequiredArgsConstructor
public class UserRestController {

    private final UserService userService;

    @GetMapping
    public ResponseEntity<Object> getAllUsers() {
        List<User> users = userService.findAll();
        return new ResponseEntity<>(users, HttpStatus.OK);

    }

    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody UserCreateRequest request) {

        User build = User.builder()
                .name(request.getName())
                .surname(request.getSurname())
                .fullName(request.getFullName())
                .birthDate(request.getBirthDate())
                .rating(request.getRating())
                .passportNumber(request.getPassportNumber())
                .passportSerial(request.getPassportSerial())
                .drivingLicense(request.getDrivingLicense())
                .build();

        User createdUser = userService.create(build);

        return new ResponseEntity<>(createdUser, HttpStatus.CREATED);
    }



}
