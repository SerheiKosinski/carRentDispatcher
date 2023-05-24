package by.remprofi.servis;

import by.remprofi.domain.User;
import by.remprofi.repository.UserRepository;
import by.remprofi.util.RandomValuesGenerator;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

//    @Autowired
//    @Qualifier("userSecondRepositoryImpl")

//    @Inject //JSR-330
//    @Named("userRepositoryImpl")
//    @Named("userRepositoryImpl")

    private final UserRepository userRepository;

    protected final RandomValuesGenerator randomValuesGenerator;

    public UserServiceImpl(UserRepository userRepository, RandomValuesGenerator randomValuesGenerator) {
        this.userRepository = userRepository;
        this.randomValuesGenerator = randomValuesGenerator;
    }
    @Override
    public User findOne(Long id) {
        return userRepository.findOne(id);
    }

    @Override
    public List<User> findAll() {
        /*Validation layer*/
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
}
