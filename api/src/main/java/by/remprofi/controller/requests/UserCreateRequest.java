package by.remprofi.controller.requests;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.sql.Timestamp;

@Setter
@Getter
@RequiredArgsConstructor
@AllArgsConstructor
@Validated
public class UserCreateRequest {

    @Size(min = 2, max = 10)
    @NotNull
    private String name;

    @NotNull
    private String surname;

    @NotNull
    private String fullName;

    @NotNull
    private Timestamp birthDate;

    @NotNull
    private Double rating;

    @NotNull
    private Long passportNumber;

    @NotNull
    private String passportSerial;

    @NotNull
    private Long drivingLicense;
}
