package app.model;

import app.entities.User;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Model {

    private static Model instance = new Model();

    private List<User> model;

    public static Model getInstance() {
        return instance;
    }

    private Model() {
        model = new ArrayList<>();
    }

    public void add(User user) {
        model.add(user);
    }

    public void remove(String name, String password) {
        model.remove(model.indexOf(new User(name, password)));
    }

    public void update(String name, String password, User user){
        this.remove(name, password);
        this.add(user);
    }

    public List<User> getModel() {
        return model;
    }



    public List<String> list() {
        return model.stream()
                .map(User::getName)
                .collect(Collectors.toList());
    }
}

