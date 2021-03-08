package com.example.cours9_roomdb.api_service;

import com.example.cours9_roomdb.model.User;

import java.util.ArrayList;

public interface UserApiService {

    User getUser(long id);

    User createUser(User user);

    User updateUser(User user);

    boolean removeUser(long id);

    ArrayList<User> getAllUsers();

    ArrayList<User> getMajorUsers();
}
