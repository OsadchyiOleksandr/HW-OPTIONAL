package app.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class UserRepository {
    private List<User> users;

    public UserRepository() {
        this.users = new ArrayList<>();
        users.add(new User(1, "Ada", "ada.manager@sso.team.com"));
        users.add(new User(2, "Ira", "ira.ceo@sso.team.com"));
        users.add(new User(3, "Sasha", "sasha.pm@sso.team.com"));
    }

    public Optional<User> findUserById(int id) {
        return users.stream()
                .filter(user -> user.getId() == id)
                .findFirst();
    }

    public Optional<User> findUserByEmail(String email) {
        return users.stream()
                .filter(user -> user.getEmail().equalsIgnoreCase(email))
                .findFirst();
    }

    public Optional<List<User>> findAllUsers() {
        return Optional.ofNullable(users.isEmpty() ? null : users);
    }
}
