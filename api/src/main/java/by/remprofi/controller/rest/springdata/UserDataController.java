package by.remprofi.controller.rest.springdata;

import by.remprofi.controller.exceptions.IllegalRequestException;
import by.remprofi.controller.requests.SearchCriteria;
import by.remprofi.controller.requests.UserCreateRequest;
import by.remprofi.controller.requests.UserUpdateRequest;
import by.remprofi.domain.Violations;
import by.remprofi.domain.hibernate.AuthenticationInfo;
import by.remprofi.domain.hibernate.HiberUser;
import by.remprofi.exception.EntityNotFoundException;
import by.remprofi.repository.springdata.UserDataRepository;
import by.remprofi.util.UserFieldsGenerator;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
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
@RequestMapping("/rest/springdata/users")
@RequiredArgsConstructor
public class UserDataController {

    private final UserDataRepository repository;

    private final UserFieldsGenerator fieldsGenerator;

    @GetMapping
    public ResponseEntity<Object> getAllUsers() {
        List<HiberUser> users = repository.findAll();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }


    @GetMapping("/test")
    public ResponseEntity<Object> testSpringDataMethods() {

        List<HiberUser> result =
                repository.findByHQLQuery("Wilson444@wear.com", "Wilson");

        return new ResponseEntity<>(Collections.singletonMap("result", result), HttpStatus.OK);
    }

    @GetMapping("/page/{page}")
    public ResponseEntity<Object> testEndpoint(@PathVariable int page) {

        return new ResponseEntity<>(Collections.singletonMap("result",
                repository.findAll(PageRequest.of(page, 4))), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Object> saveUser(@Valid @RequestBody UserCreateRequest request, BindingResult result) {

        if (result.hasErrors()) {
            throw new IllegalRequestException(result);
        }

        HiberUser hiberUser = HiberUser.builder()
                .name(request.getName())
                .birthDate(request.getBirthDate())
                .surname(request.getSurname())
                .rating(request.getRating())
                .violations(Violations.NOT_SELECTED)
                .fullName(request.getFullName())
                .passportNumber(request.getPassportNumber())
                .passportSerial(request.getPassportSerial())
                .drivingLicense(request.getDrivingLicense())
                .build();

        String generateEmail = fieldsGenerator.generateEmail(hiberUser);
        String generatePassword = fieldsGenerator.generatePassword();
        AuthenticationInfo info = new AuthenticationInfo(generateEmail, generatePassword);

        hiberUser.setAuthenticationInfo(info);

        hiberUser = repository.save(hiberUser);
        return new ResponseEntity<>(hiberUser, HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<Object> updateUser(Principal principal, @RequestBody UserUpdateRequest request) {

        HiberUser one = repository.findById(request.getId()).orElseThrow(EntityNotFoundException::new);

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

        one = repository.save(one);
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

        List<HiberUser> searchList = Collections.emptyList();

        return new ResponseEntity<>(Collections.singletonMap("users", searchList), HttpStatus.OK);
    }
}
