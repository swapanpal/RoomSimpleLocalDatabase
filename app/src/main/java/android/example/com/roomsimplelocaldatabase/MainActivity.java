package android.example.com.roomsimplelocaldatabase;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
// Source = https://www.youtube.com/watch?v=dBbUMjU3dGQ
// 1. User, 2. UserDao, 3. UserDatabase, 4. UserRepository
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}