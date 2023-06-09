package by.remprofi.repository.rowmapper;

import by.remprofi.domain.User;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

import static by.remprofi.repository.columns.UserColumns.BIRTH_DATE;
import static by.remprofi.repository.columns.UserColumns.DRIVING_L;
import static by.remprofi.repository.columns.UserColumns.EMAIL;
import static by.remprofi.repository.columns.UserColumns.FULL_NAME;
import static by.remprofi.repository.columns.UserColumns.ID;
import static by.remprofi.repository.columns.UserColumns.NAME;
import static by.remprofi.repository.columns.UserColumns.PASSWORD;
import static by.remprofi.repository.columns.UserColumns.PASS_N;
import static by.remprofi.repository.columns.UserColumns.PASS_S;
import static by.remprofi.repository.columns.UserColumns.RATING;
import static by.remprofi.repository.columns.UserColumns.SURNAME;

@Component
public class UserRowMapper implements RowMapper<User> {
    @Override
    public User mapRow(ResultSet rs, int rowNum) throws SQLException {
        User user;

        try {

            user = User.builder()
                    .id(rs.getLong(ID))
                    .name(rs.getString(NAME))
                    .surname(rs.getString(SURNAME))
                    .fullName(rs.getString(FULL_NAME))
                    .birthDate(rs.getTimestamp(BIRTH_DATE))
                    .rating(rs.getDouble(RATING))
                    .passportNumber(rs.getLong(PASS_N))
                    .passportSerial(rs.getString(PASS_S))
                    .drivingLicense(rs.getLong(DRIVING_L))
                    .email(rs.getString(EMAIL))
                    .password(rs.getString(PASSWORD))
                    .build();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return user;
    }
}

