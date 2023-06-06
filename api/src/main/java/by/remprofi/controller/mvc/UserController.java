package by.remprofi.controller.mvc;

import by.remprofi.controller.requests.SearchCriteria;
import by.remprofi.domain.User;
import by.remprofi.servis.UserService;
import lombok.RequiredArgsConstructor;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequiredArgsConstructor
@RequestMapping("/users")
public class UserController {

    private static final Logger log = Logger.getLogger(UserController.class);

    private final UserService userService;

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView findAllUsers() {

        List<User> users = userService.findAll();

        String collect = users.stream().map(User::getName).collect(Collectors.joining(","));

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("userName", collect);
        modelAndView.addObject("users", users);

        modelAndView.setViewName("hello");

        return modelAndView;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ModelAndView findUserById(@PathVariable String id) {

        Long parsedUserId;

        try {
            parsedUserId = Long.parseLong(id);
        } catch (NumberFormatException e) {
            log.error("User id: " + id + " cannot be parsed to Long", e);
            parsedUserId = 1L;
        }

        User user = userService.findOne(parsedUserId);

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("userName", user.getFullName());
        modelAndView.addObject("users", Collections.singletonList(user));

        modelAndView.setViewName("hello");

        return modelAndView;
    }

    @RequestMapping(value = "/search", method = RequestMethod.GET)

    public ModelAndView searchUserByParam(@Valid @ModelAttribute SearchCriteria criteria, BindingResult result) {

        System.out.println(result);

        Double parsedRating;

        try {
            parsedRating = Double.parseDouble(criteria.getRating());
        } catch (NumberFormatException e) {
            log.error("User param rating: " + criteria.getRating() + " cannot be parsed to Double", e);
            parsedRating = 50D;
        }

        List<User> searchList = userService.search(criteria.getQuery(), parsedRating);

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("userName", "Search Result");
        modelAndView.addObject("users", searchList);

        modelAndView.setViewName("hello");

        return modelAndView;
    }


}
