package by.remprofi.controller.rest;

import by.remprofi.controller.exceptions.IllegalRequestException;
import by.remprofi.controller.requests.SearchCriteria;
import by.remprofi.controller.requests.UserCreateRequest;
import by.remprofi.controller.requests.UserUpdateRequest;
import by.remprofi.domain.Violations;
import by.remprofi.domain.hibernate.AuthenticationInfo;
import by.remprofi.domain.hibernate.HiberUser;
import by.remprofi.servis.HibernateUserService;
import by.remprofi.util.UserFieldsGenerator;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.security.Principal;
import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/rest/hibernate/users")
@RequiredArgsConstructor
public class HibernateUserController {

    private final HibernateUserService userService;

    private final UserFieldsGenerator emailGenerator;

    @GetMapping
    public ResponseEntity<Object> getAllUsers() {
        List<HiberUser> users = userService.findAll();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Object> saveUser(@Valid @RequestBody UserCreateRequest request, BindingResult result) {

        //Spring Converter: request -> entity
        //HibernateUser hibernateUser = converterService.convert(request, HibernateUser.class);

        if (result.hasErrors()) {
            throw new IllegalRequestException(result);
        }

        HiberUser hiberUser = HiberUser.builder()
                .name(request.getName())
                .surname(request.getSurname())
                .birthDate(request.getBirthDate())
                .rating(request.getRating())
                .violations(Violations.NOT_SELECTED)
                .fullName(request.getFullName())
                .passportNumber(request.getPassportNumber())
                .passportSerial(request.getPassportSerial())
                .drivingLicense(request.getDrivingLicense())
                .build();

        String generateEmail = emailGenerator.generateEmail(hiberUser);
        String generatePassword = emailGenerator.generatePassword();
        AuthenticationInfo info = new AuthenticationInfo(generateEmail, generatePassword);

        hiberUser.setAuthenticationInfo(info);

        hiberUser = userService.create(hiberUser);
        return new ResponseEntity<>(hiberUser, HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<Object> updateUser(Principal principal, @RequestBody UserUpdateRequest request) {


        HiberUser one = userService.findOne(request.getId());

        one.setId(request.getId());
        one.setName(request.getName());
        one.setSurname(request.getSurname());
        one.setBirthDate(request.getBirthDate());
        one.setRating(request.getRating());
        one.setViolations(Violations.valueOf(request.getViolations()));
        one.setFullName(request.getFullName());
        one.setPassportNumber(request.getPassportNumber());
        one.setPassportSerial(request.getPassportSerial());
        one.setDrivingLicense(request.getDrivingLicense());

        one = userService.update(one);
        return new ResponseEntity<>(one, HttpStatus.CREATED);
    }

    @GetMapping("/search")
    public ResponseEntity<Object> searchUsersByFullName(@Valid @ModelAttribute SearchCriteria criteria, BindingResult result) {
        System.out.println(result);

        Double parsedRating;

        try {
            parsedRating = Double.parseDouble(criteria.getRating());
        } catch (NumberFormatException e) {
            parsedRating = 50D;
        }

        List<HiberUser> searchList = userService.search(criteria.getQuery(), parsedRating);

        return new ResponseEntity<>(Collections.singletonMap("users", searchList), HttpStatus.OK);
    }

}
