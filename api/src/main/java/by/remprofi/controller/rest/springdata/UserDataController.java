package by.remprofi.controller.rest.springdata;

import by.remprofi.controller.exceptions.IllegalRequestException;
import by.remprofi.controller.requests.SearchCriteria;
import by.remprofi.controller.requests.UserCreateRequest;
import by.remprofi.controller.requests.UserUpdateRequest;
import by.remprofi.domain.Violations;
import by.remprofi.domain.hiber.HiberUser;
import by.remprofi.repository.sprdata.UserDataRepository;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.core.convert.ConversionService;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
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
import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/rest/springdata/users")
@RequiredArgsConstructor
public class UserDataController {

    private final UserDataRepository repository;

    private final ConversionService conversionService;

    @Operation(summary = "Spring Data User Find All Search",
            description = "Find All Users without limitations",
            responses = {
               @ApiResponse(
                       responseCode = "OK",
                       description = "Successfully loaded Users",
                       content = @Content(mediaType = "application/json",
                               schema = @Schema(implementation = HiberUser.class)))})


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

    @Operation(
            summary = "Spring Data User Search with Pageable Params",
            description = "Load page by number with sort and offset params",
            responses = {
                    @ApiResponse(responseCode = "OK",
                         description = "Successfully loaded Users",
                         content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = PageImpl.class)))})

    @GetMapping("/page/{page}")
    public ResponseEntity<Object> testEndpoint(@Parameter(name = "page", example = "1", required = true) @PathVariable int page) {
        return new ResponseEntity<>(Collections.singletonMap("result",
                repository.findAll(PageRequest.of(page, 4))), HttpStatus.OK);
    }

    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    @PostMapping
    public ResponseEntity<Object> saveUser(@Valid @RequestBody UserCreateRequest request, BindingResult result) {

        if (result.hasErrors()) {
            throw new IllegalRequestException(result);
        }

        HiberUser hiberUser = conversionService.convert(request, HiberUser.class);
        hiberUser = repository.save(hiberUser);
        return new ResponseEntity<>(hiberUser, HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<Object> updateUser(@Valid @RequestBody UserUpdateRequest request) {

        HiberUser hiberUser = conversionService.convert(request, HiberUser.class);
        hiberUser = repository.save(hiberUser);
        return new ResponseEntity<>(hiberUser, HttpStatus.OK);

    }


    @Operation(
            summary = "Spring Data User Search According to query params",
            description = "Spring Data User Search According to query params",
            parameters = {
                    @Parameter(name = "query",
                            required = true,
                            in = ParameterIn.QUERY,
                            schema = @Schema(requiredMode = Schema.RequiredMode.REQUIRED, example = "query", type = "string", description = "text query")),
                    @Parameter(name = "rating",
                            required = true,
                            in = ParameterIn.QUERY,
                            schema = @Schema(requiredMode = Schema.RequiredMode.REQUIRED, example = "5", type = "double", description = "user rating")),
                    @Parameter(name = "violations",
                            required = true,
                            in = ParameterIn.QUERY,
                            schema = @Schema(requiredMode = Schema.RequiredMode.REQUIRED, example = "NOT_SELECTED", type = "Violations", implementation = Violations.class, description = "user violations"))
            },
            responses = {
                    @ApiResponse(
                            responseCode = "OK",
                            description = "Successfully loaded Users",
                            content = @Content(
                                    mediaType = "application/json",
                                    schema = @Schema(implementation = HiberUser.class)
                            )
                    )
            }
    )

    @GetMapping("/search")
    public ResponseEntity<Object> searchUsersByFullName(
            @Parameter(hidden = true) @Valid @ModelAttribute SearchCriteria criteria,
            BindingResult result) {

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
