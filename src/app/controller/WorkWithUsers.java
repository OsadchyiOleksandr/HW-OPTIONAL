package app.controller;

import app.model.User;
import app.model.UserRepository;
import app.view.Show;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class WorkWithUsers {
    public static void start() {
        UserRepository userRepository = new UserRepository();

        List<Integer> searchIDs = new ArrayList<>();
        searchIDs.add(2);
        searchIDs.add(20);
        for (int id : searchIDs) {
            Optional<User> userById = userRepository.findUserById(id);
            userById.ifPresentOrElse(
                    user -> Show.messageToDisplay("User found by ID " + id + ": \n" + user),
                    () -> Show.messageToDisplay("User with ID " + id + ": \nnot found.")
            );
        }

        Show.messageToDisplay("------------------------------------------------------");

        List<String> searchEmails = new ArrayList<>();
        searchEmails.add("alice.qa@db.team.com");
        searchEmails.add("ira.ceo@sso.team.com");
        for (String email : searchEmails) {
            Optional<User> userByEmail = userRepository.findUserByEmail(email);
            userByEmail.ifPresentOrElse(
                    user -> Show.messageToDisplay("User found by email " + email + ": \n" + user),
                    () -> Show.messageToDisplay("User with email " + email + ": \nnot found.")
            );
        }

        Show.messageToDisplay("------------------------------------------------------");

        Optional<List<User>> allUsers = userRepository.findAllUsers();
        allUsers.ifPresentOrElse(
                users -> Show.messageToDisplay("Total users: " + users.size()),
                () -> Show.messageToDisplay("No users found.")
            );
    }
}

