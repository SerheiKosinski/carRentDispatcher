package by.remprofi.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor

public class User {

    private Long id;
    private String name;
    private String surname;
    private Long passportNumber;
    private String passportSerial;
    private Long drivingLicense;

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.JSON_STYLE);
    }

}
