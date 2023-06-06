package by.remprofi.repository.impl;

import by.remprofi.domain.Role;
import by.remprofi.repository.RoleRepository;
import by.remprofi.repository.rmapper.RoleRowMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.core.annotation.Order;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Primary
@Order(0)
@RequiredArgsConstructor
public class RoleRepositoryImpl implements RoleRepository {

    private final JdbcTemplate jdbcTemplate;

    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    private final RoleRowMapper roleRowMapper;

    @Override
    public Role findOne(Long id) {
        return null;
    }

    @Override
    public List<Role> findAll() {
        return jdbcTemplate.query("select * from roles order by id desc", roleRowMapper);
    }

    @Override
    public Role create(Role object) {
        return null;
    }

    @Override
    public Role update(Role object) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }
}
