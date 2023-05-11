package by.remprofi.servis;

import by.remprofi.domain.User;
import by.remprofi.repository.UserRepository;
import by.remprofi.repository.UserRepositoryImpl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserAggServiceImpl implements UserAggregationService {

    private final UserRepository userRepository = new UserRepositoryImpl();
    private final UserService userService = new UserServiceImpl();

    @Override
    public Map<String, Object> getStats() {

        List<User> users = userRepository.findAll();
        User one = userRepository.findOne(2L);
        userRepository.searchUser();

        Map<String, Object> resultMap = new HashMap<>();

        resultMap.put("allUsers", users);
        resultMap.put("oneUser", one);

        return resultMap;
    }
}
