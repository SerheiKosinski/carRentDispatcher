package by.remprofi.repository.impl;

import by.remprofi.domain.Role;
import by.remprofi.domain.User;
import by.remprofi.repository.UserRepository;
import by.remprofi.repository.rmapper.RoleRowMapper;
import by.remprofi.repository.rmapper.UserRowMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.core.annotation.Order;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@Primary
@Order(1)
@RequiredArgsConstructor
public class UserRepositoryJTImpl implements UserRepository {

    private final JdbcTemplate jdbcTemplate;

    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    private final UserRowMapper userRowMapper;

    private final RoleRowMapper roleRowMapper;

    @Override
    public User findOne(Long id) {
        return jdbcTemplate.queryForObject("select * from users where id = " + id, userRowMapper);
    }

    @Override
    public List<User> findAll() {
        return jdbcTemplate.query("select * from users order by id desc", userRowMapper);
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

        final String sqlQuery =
                "select * " +
                        " from users " +
                        " where lower(name) like '%" + query + "%' and " +
                        " rating > " +  rating +
                        " order by id desc";

        return jdbcTemplate.query(sqlQuery, userRowMapper);
    }



    @Override
    public boolean support(String param) {
        return param.equalsIgnoreCase("jdbctemplate");
    }

    @Override
    public List<Role> getUserAuthorities(Long userId) {
        final String sqlQueryAuthorities =
                "select * " +
                        " from roles " +
                        " inner join users u on u.id = roles.user_id" +
                        " where user_id = " + userId +
                        " order by roles.id desc";

        return jdbcTemplate.query(sqlQueryAuthorities, roleRowMapper);
    }

    @Override
    public Optional<User> findByEmail(String email) {

        User user = jdbcTemplate.queryForObject("select * from users where email = '" + email + "'", userRowMapper);

        return Optional.of(user);
    }
}


