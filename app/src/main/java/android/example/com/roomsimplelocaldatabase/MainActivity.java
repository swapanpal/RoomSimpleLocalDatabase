package android.example.com.roomsimplelocaldatabase;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.example.com.roomsimplelocaldatabase.adapter.UserAdapter;
import android.example.com.roomsimplelocaldatabase.databinding.ActivityMainBinding;
import android.example.com.roomsimplelocaldatabase.model.User;
import android.example.com.roomsimplelocaldatabase.viewModel.UserViewModel;
import android.os.Bundle;

import java.util.List;

// Source = https://www.youtube.com/watch?v=dBbUMjU3dGQ
// 1. User, 2. UserDao, 3. UserDatabase, 4. UserRepository, 5.UI, 6.UserAdapter
public class MainActivity extends AppCompatActivity {
    private UserViewModel viewModel;
    private UserAdapter adapter;
    private ActivityMainBinding mainBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mainBinding = DataBindingUtil.setContentView( this ,R.layout.activity_main);
        mainBinding.recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new UserAdapter(this);
        mainBinding.recyclerView.setAdapter(adapter);

        viewModel = ViewModelProviders.of(this).get(UserViewModel.class);

        viewModel.getUserList().observe(this, new Observer<List<User>>() {
            @Override
            public void onChanged(List<User> users) {
                adapter.setUser(users);

            }
        });
    }
}