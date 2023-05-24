package by.remprofi;

import by.remprofi.configuration.DatabaseProperties;
import by.remprofi.domain.User;
import by.remprofi.repository.UserRepository;
import by.remprofi.repository.impl.UserRepositoryImpl;

import java.util.List;

public class Main {

    //Ctrl+Alt+O - import optimizing
    //Ctrl+Alt+L - formatting

    public static void main(String[] args) {

        UserRepository userRepository = new UserRepositoryImpl(new DatabaseProperties());

        List<User> all = userRepository.findAll();

        for (User user : all) {
            System.out.println(user);
        }

    }
}