package by.remprofi.servis;

import by.remprofi.domain.Role;
import by.remprofi.domain.hiber.HiberUser;
import by.remprofi.repository.hiber.HibernateUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class HiberUserServiceImpl implements HiberUserService {

    private final HibernateUserRepository userRepository;

    @Override
    public HiberUser findOne(Long id) {
        return userRepository.findOne(id);
    }

    @Override
    public List<HiberUser> findAll() {
        return userRepository.findAll();
    }

    @Override
    public HiberUser create(HiberUser object) {
        return userRepository.create(object);
    }

    @Override
    public HiberUser update(HiberUser object) {
        return userRepository.update(object);
    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public List<HiberUser> search(String query, Double rating) {
        return userRepository.searchUser(query, rating);
    }

    @Override
    public List<Role> getHiberUserAuthorities(Long userId) {
        return null;
    }

    @Override
    public Optional<HiberUser> findByEmail(String email) {
        return Optional.empty();
    }
}