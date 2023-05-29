package by.remprofi.servis;

import by.remprofi.domain.Role;
import by.remprofi.domain.User;
import by.remprofi.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {


    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    @Override
    public User findOne(Long id) {
        return userRepository.findOne(id);
    }

    @Override
    public List<User> findAll() {
              return userRepository.findAll();
    }

    @Override
    public User create(User object) {
        return userRepository.create(object);
    }

    @Override
    public User update(User object) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public List<User> search(String query, Double rating) {
        return userRepository.searchUser(query.toLowerCase(), rating);
    }

    @Override
    public List<Role> getUserAuthorities(Long userId) {
        return userRepository.getUserAuthorities(userId);
    }

    @Override
    public Optional<User> findByEmail(String email) {
        return userRepository.findByEmail(email);
    }
}
