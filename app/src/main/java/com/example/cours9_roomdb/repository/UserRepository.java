package com.example.cours9_roomdb.repository;

import android.app.Application;

import com.example.cours9_roomdb.dao.UserDao;
import com.example.cours9_roomdb.data_base.DataBase;
import com.example.cours9_roomdb.model.User;

import java.util.List;

public class UserRepository {

    UserDao userDao;

    public UserRepository(Application application){
        DataBase dataBase = DataBase.getDatabase(application);
        userDao = dataBase.userDao();
    }

    public User getUser(long id){
        return userDao.getUser(id);
    }

    public void createUser(User user){
        userDao.createUser(user);
    }

    public void updateUser(User user){
        userDao.updateUser(user);
    }

    public void removeUser(User user){
        userDao.removeUser(user);
    }

    public List<User> getAllUsers(){
        return userDao.getAllUsers();
    }

    public List<User> getMajorUsers(){
        return userDao.getMajorUsers();
    }
}
