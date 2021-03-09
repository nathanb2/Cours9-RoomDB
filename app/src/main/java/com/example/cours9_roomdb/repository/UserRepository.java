package com.example.cours9_roomdb.repository;

import android.app.Application;

import androidx.lifecycle.LiveData;

import com.example.cours9_roomdb.dao.UserDao;
import com.example.cours9_roomdb.data_base.DataBase;
import com.example.cours9_roomdb.model.User;

import java.util.List;

/**
 * Voire cours-8 (on remplace juste le UserApiService simple de cours-8 par une autre interface annote pour Room qui est le UserDao)
 */
public class UserRepository {

    UserDao userDao;

    public UserRepository(Application application) {
        DataBase dataBase = DataBase.getDatabase(application);
        userDao = dataBase.userDao();
    }

    public User getUser(long id) {
        return userDao.getUser(id);
    }

    public void createUser(User user) {
        userDao.createUser(user);
    }

    public void updateUser(User user) {
        userDao.updateUser(user);
    }

    public void removeUser(User user) {
        userDao.removeUser(user);
    }

    /**
     * @return userDao.getAllUsers() qui est lui meme un liveData
     */
    public LiveData<List<User>> getAllUsers() {
        return userDao.getAllUsers();
    }

    public List<User> getMajorUsers() {
        return userDao.getMajorUsers();
    }
}
