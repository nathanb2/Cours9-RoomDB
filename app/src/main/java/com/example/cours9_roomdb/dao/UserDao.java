package com.example.cours9_roomdb.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import com.example.cours9_roomdb.model.User;

import java.util.List;

@Dao
public interface UserDao {

    @Query("SELECT * FROM user where id = :id")
    User getUser(long id);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void createUser(User user);

    @Update
    void updateUser(User user);

    @Delete
    void removeUser(User user);

    @Query("SELECT * FROM user")
    LiveData<List<User>> getAllUsers();

    @Query("SELECT * FROM user where age >= 18")
    List<User> getMajorUsers();
}

