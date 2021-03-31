package android.example.com.roomsimplelocaldatabase.viewModel;

import android.app.Application;
import android.example.com.roomsimplelocaldatabase.model.User;
import android.example.com.roomsimplelocaldatabase.roomDatabase.UserRepository;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

public class UserViewModel extends AndroidViewModel {

    UserRepository mRepository;
    private LiveData<List<User>> userList;

    // default Constructor
    public UserViewModel(@NonNull Application application) {
        super(application);
        mRepository = new UserRepository(application);
        userList = mRepository.getUserList();
    }

    public LiveData<List<User>> getUserList() {
        return userList;
    }
    public void insert(User user){
        mRepository.insert(user);
    }
    public void delete(User user){
        mRepository.delete(user);
    }
}
