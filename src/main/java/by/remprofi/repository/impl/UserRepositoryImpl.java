package by.remprofi.repository.impl;

import by.remprofi.domain.Role;
import by.remprofi.domain.User;
import by.remprofi.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.apache.log4j.Logger;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

import static by.remprofi.repository.columns.UserColumns.BIRTH_DATE;
import static by.remprofi.repository.columns.UserColumns.DRIVING_L;
import static by.remprofi.repository.columns.UserColumns.ID;
import static by.remprofi.repository.columns.UserColumns.NAME;
import static by.remprofi.repository.columns.UserColumns.PASS_N;
import static by.remprofi.repository.columns.UserColumns.PASS_S;
import static by.remprofi.repository.columns.UserColumns.RATING;
import static by.remprofi.repository.columns.UserColumns.SURNAME;

@Repository
@RequiredArgsConstructor
@Order(0)
public class UserRepositoryImpl implements UserRepository {

    private final Logger logger = Logger.getLogger(UserRepositoryImpl.class);



    @Override
    public List<User> findAll() {

        return  null;
    }

    private User parseResultSet(ResultSet rs) {

        User user;

        try {
            user = new User();
            user.setId(rs.getLong(ID));
            user.setName(rs.getString(NAME));
            user.setSurname(rs.getString(SURNAME));
            user.setBirthDate(rs.getTimestamp(BIRTH_DATE));
            user.setRating(rs.getDouble(RATING));
            user.setPassportNumber(rs.getLong(PASS_N));
            user.setPassportSerial(rs.getString(PASS_S));
            user.setDrivingLicense(rs.getLong(DRIVING_L));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return user;
    }


    @Override
    public User findOne(Long id) {

        return findAll().stream().findFirst().get();
    }

    @Override
    public User create(User object) {

        return null;
    }

    @Override
    public User update(User object) {

        return null;
    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public List<User> searchUser(String query, Double rating) {
        return null;
    }

    @Override
    public boolean support(String param) {
        return param.equalsIgnoreCase("jdbc");

    }
    @Override
    public List<Role> getUserAuthorities(Long userId) {
        return null;
    }

    @Override
    public Optional<User> findByEmail(String email) {
        return Optional.empty();
    }
}
