package com.cgi.weatherman.builder;

import com.cgi.weatherman.model.User;

public class UserBuilder extends ClientBuilder {
    protected String password;

    public UserBuilder(String username, String name, String surname, String password) {
        super(username, name, surname);
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public User apply() {
        return new User(this.username, this.password, this.email, this.name, this.surname, this.phoneNumber);
    }
}

