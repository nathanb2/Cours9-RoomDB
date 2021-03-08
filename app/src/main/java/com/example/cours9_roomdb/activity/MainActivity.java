package com.example.cours9_roomdb.activity;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;

import com.example.cours9_roomdb.R;
import com.example.cours9_roomdb.model.User;
import com.example.cours9_roomdb.repository.UserRepository;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView textView = findViewById(R.id.AM_tv);
        UserRepository userRepository = new UserRepository(this.getApplication());

        userRepository.getAllUsers().observe(this, new Observer<List<User>>() {
            @Override
            public void onChanged(List<User> users) {
                // Update the UI, in this case, a TextView.
                textView.setText(users.get(0).getName());
            }
        });


        findViewById(R.id.AM_change_name).setOnClickListener(v -> {
            User user = userRepository.getAllUsers().getValue().get(0);
            user.setName("Nathan");
            userRepository.updateUser(user);
        });

    }

}
