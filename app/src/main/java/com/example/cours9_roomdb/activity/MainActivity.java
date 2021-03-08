package com.example.cours9_roomdb.activity;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.cours9_roomdb.R;
import com.example.cours9_roomdb.model.User;
import com.example.cours9_roomdb.repository.UserRepository;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView textView = findViewById(R.id.AM_tv);
        UserRepository userRepository = new UserRepository(this.getApplication());

        Runnable runnable = new Runnable() {
            public void run() {
                userRepository.createUser(new User("Patrick", 25));

                User user = userRepository.getAllUsers().get(0);

                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        textView.setText(user.getName());
                    }
                });

            }
        };

        Thread thread = new Thread(runnable);
        thread.start();

    }

}
