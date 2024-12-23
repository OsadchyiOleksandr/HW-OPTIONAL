package app.controller;

import app.entity.User;
import app.repository.UserRepository;
import app.view.UserView;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class UserController {
    
    UserView userView = new UserView();
    UserRepository userRepository = new UserRepository();

    public void runApp() {
        userView.toDisplay("Task 1");
        findUserById();
        userView.toDisplay("Task 2");
        findUserByEmail();
        userView.toDisplay("Task 3");
        getAllUsers();
        userView.toDisplay("Task 4");
        getAllUsersList();
    }

    private void findUserById() {
        List<Integer> searchIDs = new ArrayList<>();
        searchIDs.add(2);
        searchIDs.add(20);
        for (int id : searchIDs) {
            Optional<User> userById = userRepository.findUserById(id);
            userById.ifPresentOrElse(
                    user -> userView.toDisplay("User found by ID " + id + ": \n" + user),
                    () -> userView.toDisplay("User with ID " + id + ": \nnot found.")
            );
        }
    }

    private void findUserByEmail() {
        List<String> searchEmails = new ArrayList<>();
        searchEmails.add("alice.qa@db.team.com");
        searchEmails.add("ira.ceo@sso.team.com");
        for (String email : searchEmails) {
            Optional<User> userByEmail = userRepository.findUserByEmail(email);
            userByEmail.ifPresentOrElse(
                    user -> userView.toDisplay("User found by email " + email + ": \n" + user),
                    () -> userView.toDisplay("User with email " + email + ": \nnot found.")
            );
        }
    }

    private void getAllUsers() {
        Optional<List<User>> allUsers = userRepository.findAllUsers();
        allUsers.ifPresentOrElse(
                users -> userView.toDisplay("Total users: " + users.size()),
                () -> userView.toDisplay("No users found.")
            );
    }

    private void getAllUsersList() {
        Optional<List<User>> allUsers = userRepository.findAllUsers();
        allUsers.ifPresentOrElse(
                users -> {
                    StringBuilder userList = new StringBuilder("List of users:\n");
                    for (User user : users) {
                        userList.append(user.toString()).append("\n");
                    }
                    userView.toDisplay(userList.toString());
                },
                () -> userView.toDisplay("No users found.")
        );
    }
}

