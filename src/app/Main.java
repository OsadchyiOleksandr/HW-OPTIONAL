package app;

import app.controller.UserController;

public class Main {
    public static void main(String[] args) {
        UserController userController = new UserController();
        userController.runApp();
    }
}
