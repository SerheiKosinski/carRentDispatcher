package by.remprofi.servis;

import by.remprofi.domain.User;
import by.remprofi.repository.UserRepository;
import by.remprofi.util.RandomValuesGenerator;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
//id = userServiceImpl
public class UserServiceImpl implements UserService {

//    @Autowired
//    @Qualifier("userSecondRepositoryImpl")

//    @Inject //JSR-330
//    @Named("userRepositoryImpl")
//    @Named("userRepositoryImpl")

    private final UserRepository userRepository;

    private final RandomValuesGenerator randomValuesGenerator;

    public UserServiceImpl(UserRepository userRepository, RandomValuesGenerator randomValuesGenerator) {
        this.userRepository = userRepository;
        this.randomValuesGenerator = randomValuesGenerator;
    }
    @Override
    public User findOne(Long id) {
        return null;
    }

    @Override
    public List<User> findAll() {
        /*Validation layer*/
        return userRepository.findAll();
    }

    @Override
    public User create(User object) {
        /*Validation layer*/
        if (object.getDrivingLicense() > 80) {
            throw new RuntimeException("Something wrong!");
        }

        return userRepository.create(object);
    }

    @Override
    public User update(User object) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }
}
