package android.example.com.roomsimplelocaldatabase.activity;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.example.com.roomsimplelocaldatabase.R;
import android.example.com.roomsimplelocaldatabase.adapter.UserAdapter;
import android.example.com.roomsimplelocaldatabase.databinding.ActivityMainBinding;
import android.example.com.roomsimplelocaldatabase.model.User;
import android.example.com.roomsimplelocaldatabase.viewModel.UserViewModel;
import android.os.Bundle;
import android.view.View;

import java.util.List;

import static android.example.com.roomsimplelocaldatabase.activity.NewUserActivity.FIRST_NAME;
import static android.example.com.roomsimplelocaldatabase.activity.NewUserActivity.LAST_NAME;
import static android.example.com.roomsimplelocaldatabase.activity.NewUserActivity.PHONE_NUMBER;

// Source = https://www.youtube.com/watch?v=dBbUMjU3dGQ
// 1. User, 2. UserDao, 3. UserDatabase, 4. UserRepository, 5.UI, 6.UserAdapter
public class MainActivity extends AppCompatActivity {
    private static final int NEW_INTENT_REQUEST_CODE = 1;
    private UserViewModel viewModel;
    private UserAdapter adapter;
    private ActivityMainBinding mainBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mainBinding = DataBindingUtil.setContentView( this , R.layout.activity_main);
        mainBinding.recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new UserAdapter(this);
        mainBinding.recyclerView.setAdapter(adapter);

        // for decoration
        mainBinding.recyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));

        viewModel = ViewModelProviders.of(this).get(UserViewModel.class);

        viewModel.getUserList().observe(this, new Observer<List<User>>() {
            @Override
            public void onChanged(List<User> users) {
                adapter.setUser(users);

            }
        });
        mainBinding.fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, NewUserActivity.class);
                startActivityForResult(intent, NEW_INTENT_REQUEST_CODE);

            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == NEW_INTENT_REQUEST_CODE && resultCode == RESULT_OK && data != null){
            User user = new User(data.getStringExtra(FIRST_NAME), data.getStringExtra(LAST_NAME),
                    data.getStringExtra(PHONE_NUMBER));
            viewModel.insert(user);
        }
    }
}