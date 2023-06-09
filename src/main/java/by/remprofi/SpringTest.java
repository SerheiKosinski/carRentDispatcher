package by.remprofi;

import by.remprofi.repository.UserRepository;
import by.remprofi.servis.UserService;
import by.remprofi.util.RandomValuesGenerator;
import lombok.RequiredArgsConstructor;
import org.apache.log4j.Logger;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Controller;

@Controller
@RequiredArgsConstructor
public class SpringTest {

    private static final Logger logger = Logger.getLogger(SpringTest.class);


    public static void main(String[] args) {
//        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:application-context.xml");
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext("by.remprofi");

        UserRepository userRepository = applicationContext.getBean("userRepositoryImpl", UserRepository.class);
        UserService userService = applicationContext.getBean("userServiceImpl", UserService.class);
        RandomValuesGenerator randomValuesGenerator = applicationContext.getBean("getRandomGenerator", RandomValuesGenerator.class);

        logger.info(userRepository.findOne(1L));
        logger.info(userService.findAll());
        logger.info(randomValuesGenerator.generateRandomString());

    }
}

