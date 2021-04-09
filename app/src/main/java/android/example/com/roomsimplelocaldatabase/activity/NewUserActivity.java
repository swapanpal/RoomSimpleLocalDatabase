package android.example.com.roomsimplelocaldatabase.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.example.com.roomsimplelocaldatabase.R;
import android.example.com.roomsimplelocaldatabase.databinding.ActivityNewUserBinding;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;

public class NewUserActivity extends AppCompatActivity {
    public static final String FIRST_NAME = "android.example.com.roomsimplelocaldatabase.firstname";
    public static final String LAST_NAME = "android.example.com.roomsimplelocaldatabase.lastname";
    public static final String PHONE_NUMBER = "android.example.com.roomsimplelocaldatabase.phonenumber";

    private ActivityNewUserBinding newUserBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        newUserBinding = DataBindingUtil.setContentView(this, R.layout.activity_new_user);
        newUserBinding.saveButton.setOnClickListener(view -> {
            Intent intent = new Intent();
            if (TextUtils.isEmpty(newUserBinding.firstNameTextView.getText().toString()) &&
                    TextUtils.isEmpty(newUserBinding.lastNameTextView.getText().toString()) &&
                    TextUtils.isEmpty(newUserBinding.PhoneNumberTextView.getText().toString())){

                setResult(RESULT_CANCELED, intent);
            }else {
                intent.putExtra(FIRST_NAME, newUserBinding.firstNameTextView.getText().toString());
                intent.putExtra(LAST_NAME, newUserBinding.lastNameTextView.getText().toString());
                intent.putExtra(PHONE_NUMBER, newUserBinding.PhoneNumberTextView.getText().toString());
                setResult(RESULT_OK, intent);
            }
            finish();

        });
    }
}