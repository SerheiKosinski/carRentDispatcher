package by.remprofi.controller;


import by.remprofi.configuration.DatabaseProperties;
import by.remprofi.domain.User;
import by.remprofi.repository.UserRepositoryImpl;
import by.remprofi.servis.UserService;
import by.remprofi.servis.UserServiceImpl;
import by.remprofi.util.RandomValuesGenerator;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

public class FrontController extends HttpServlet {



    private final UserService userService = new UserServiceImpl(new UserRepositoryImpl(new DatabaseProperties()), new RandomValuesGenerator());


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doRequest(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doRequest(req, resp);
    }

    private void doRequest(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher dispatcher = req.getRequestDispatcher("/hello");
        if (dispatcher != null) {
            System.out.println("Forward will be done!");
            System.out.println("We are processing user request");

            List<User> users = userService.findAll();

            String collect = users.stream().map(User::getName).collect(Collectors.joining(","));

            req.setAttribute("userName", collect);
            req.setAttribute("users", users);

            dispatcher.forward(req, resp);
        }
    }
}
