package android.example.com.roomsimplelocaldatabase.roomDatabase;

import android.content.Context;
import android.example.com.roomsimplelocaldatabase.model.User;
import android.service.autofill.UserData;

import androidx.lifecycle.LiveData;

import java.util.List;

public class UserRepository {
    private UserDao mDao;
    private LiveData<List<User>> userList;

   // Constructor
    public UserRepository(Context context) {
        UserDatabase database = UserDatabase.getInstance(context);
        mDao = database.getDao();
        userList = mDao.getAllUsers();
    }

    public LiveData<List<User>> getUserList() {
        return userList;
    }
    public void insert(User user){
        UserDatabase.executorService.execute(new Runnable() {
            @Override
            public void run() {
                mDao.insert(user);
            }
        });

    }
    public void delete(User user){
        UserDatabase.executorService.execute(new Runnable() {
            @Override
            public void run() {
                mDao.delete(user);
            }
        });

    }
}
