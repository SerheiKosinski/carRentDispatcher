package by.remprofi.domain;

import java.util.Objects;

public class User {

    private Long id;
    private String name;
    private String surname;
    private Long passportNumber;
    private String passportSerial;
    private Long drivingLicense;

    public User() {
    }

    public User(Long id, String name, String surname, Long passportNumber, String passportSerial, Long drivingLicense) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.passportNumber = passportNumber;
        this.passportSerial = passportSerial;
        this.drivingLicense = drivingLicense;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Long getPassportNumber() {
        return passportNumber;
    }

    public void setPassportNumber(Long passportNumber) {
        this.passportNumber = passportNumber;
    }

    public String getPassportSerial() {
        return passportSerial;
    }

    public void setPassportSerial(String passportSerial) {
        this.passportSerial = passportSerial;
    }

    public Long getDrivingLicense() {
        return drivingLicense;
    }

    public void setDrivingLicense(Long drivingLicense) {
        this.drivingLicense = drivingLicense;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (!Objects.equals(id, user.id)) return false;
        if (!Objects.equals(name, user.name)) return false;
        if (!Objects.equals(surname, user.surname)) return false;
        if (!Objects.equals(passportNumber, user.passportNumber)) return false;
        if (!Objects.equals(passportSerial, user.passportSerial)) return false;
        return Objects.equals(drivingLicense, user.drivingLicense);
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (surname != null ? surname.hashCode() : 0);
        result = 31 * result + (passportNumber != null ? passportNumber.hashCode() : 0);
        result = 31 * result + (passportSerial != null ? passportSerial.hashCode() : 0);
        result = 31 * result + (drivingLicense != null ? drivingLicense.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", passportNumber=" + passportNumber +
                ", passportSerial='" + passportSerial + '\'' +
                ", drivingLicense=" + drivingLicense +
                '}';
    }
}

