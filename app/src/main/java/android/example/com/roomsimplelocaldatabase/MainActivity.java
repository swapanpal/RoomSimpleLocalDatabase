package android.example.com.roomsimplelocaldatabase;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;

import android.example.com.roomsimplelocaldatabase.model.User;
import android.example.com.roomsimplelocaldatabase.viewModel.UserViewModel;
import android.os.Bundle;

import java.util.List;

// Source = https://www.youtube.com/watch?v=dBbUMjU3dGQ
// 1. User, 2. UserDao, 3. UserDatabase, 4. UserRepository
public class MainActivity extends AppCompatActivity {
    private UserViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewModel = ViewModelProviders.of(this).get(UserViewModel.class);

        viewModel.getUserList().observe(this, new Observer<List<User>>() {
            @Override
            public void onChanged(List<User> users) {

            }
        });
    }
}