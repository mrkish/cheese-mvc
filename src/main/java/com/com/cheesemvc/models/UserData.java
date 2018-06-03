package com.com.cheesemvc.models;

import java.util.ArrayList;

public class UserData {

    public static ArrayList<User> users;

    public static ArrayList<User> getAllUsers() {
        return users;
    }

    public static void add(User newUser) {
        users.add(newUser);
    }

    public static User getById(int anId) {
        User userToGet = null;

        for (User candidateUser : users) {
            if (candidateUser.getId() == anId) {
                userToGet = candidateUser;
            }
        }

        return userToGet;
    }
}
