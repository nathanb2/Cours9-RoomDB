package com.example.cours9_roomdb.activity;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;

import com.example.cours9_roomdb.R;
import com.example.cours9_roomdb.model.User;
import com.example.cours9_roomdb.repository.UserRepository;

import java.util.List;

/**
 * Affiche les donnees  ou en ajoute suite a un click utilisateur
 * Ne connait que userRepository et n'a aucune idee que userRepository amene le donnees depuis une DataBAse , ce n'est pas son probleme.
 * MainActivity demande des users ou indique en creer un au repository , celui ci se chargera de le faire realiser au responsable des donnees (ic la DB avec son DAO)
 *
 * MainActivity peut reactualiser l'affichage des qu'il y a modification des donnees a afficher grace au LiveData voire ci-dessous
 */
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView textView = findViewById(R.id.AM_tv);
        UserRepository userRepository = new UserRepository(this.getApplication());

        //getAllUsers retournant un LiveData, on peut l'observer
        userRepository.getAllUsers().observe(this, new Observer<List<User>>() {
            //onChanged est appele a chauqe fois que la valeurs de getALlUsers change et recoit en parametre  la nouvelle valeur de getAllUsers
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
