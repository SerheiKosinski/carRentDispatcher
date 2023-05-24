package by.remprofi.controller.requests;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.sql.Timestamp;

@Setter
@Getter
@RequiredArgsConstructor
@AllArgsConstructor
public class UserCreateRequest {

    private String name;

    private String surname;

    private String fullName;

    private Timestamp birthDate;

    private Double rating;

    private Long passportNumber;

    private String passportSerial;

    private Long drivingLicense;
}
