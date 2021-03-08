package com.example.cours9_roomdb.data_base;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.OnConflictStrategy;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import com.example.cours9_roomdb.dao.UserDao;
import com.example.cours9_roomdb.model.User;

@Database(entities = {User.class}, version = 1)
public abstract class DataBase extends RoomDatabase {
//    public abstract WordDao wordDao();

    private static DataBase INSTANCE;

    public abstract UserDao userDao();

    public static DataBase getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (DataBase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(
                            context.getApplicationContext(),
                            DataBase.class, "database")
                            .addCallback(sOnOpenCallback)
                            .fallbackToDestructiveMigration()
                            .allowMainThreadQueries()
                            .build();
                }
            }
        }
        return INSTANCE;
    }


    /**
     * Permet de realiser une action comme peupler la base lors de sa creation
     */
    private static final RoomDatabase.Callback sOnOpenCallback =
            new RoomDatabase.Callback() {
                @Override
                public void onOpen(@NonNull SupportSQLiteDatabase db) {
                    super.onOpen(db);
                    String count = "SELECT count(*) FROM user";
                    Cursor cursor = db.query(count, null);
                    cursor.moveToFirst();
                    int cursorCount = cursor.getInt(0);
                    if (cursorCount <= 0) {
                        for (int i = 0; i < 10; i++) {
                            ContentValues contentValues = new ContentValues();
                            contentValues.put("name", "Philippe" + i);
                            contentValues.put("age", String.valueOf(20 + i));

                            db.insert("User", OnConflictStrategy.REPLACE, contentValues);
                        }
                    }
                }
            };

}