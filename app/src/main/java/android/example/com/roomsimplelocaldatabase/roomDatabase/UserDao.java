package android.example.com.roomsimplelocaldatabase.roomDatabase;

import android.example.com.roomsimplelocaldatabase.model.User;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;


@Dao
public interface UserDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insert(User user);

    @Query("SELECT * FROM user_table ORDER BY firstName ASC")
    LiveData<List<User>> getAllUsers();

    @Delete
    void delete(User user);
}
