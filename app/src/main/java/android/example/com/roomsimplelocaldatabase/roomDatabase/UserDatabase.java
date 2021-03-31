package android.example.com.roomsimplelocaldatabase.roomDatabase;

import android.content.Context;
import android.example.com.roomsimplelocaldatabase.model.User;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Database(entities = (User.class),version = 1, exportSchema = false)
public abstract class UserDatabase extends RoomDatabase {

    public abstract UserDao getDao();
    public static volatile UserDatabase INSTANCE;
    private static final int NUMBER_OF_THREAD = 4;
    public static ExecutorService executorService = Executors.newFixedThreadPool(NUMBER_OF_THREAD);

    public static UserDatabase getInstance(Context context){
        if (INSTANCE == null){
            synchronized (UserDatabase.class){
                if (INSTANCE == null){
                    INSTANCE = Room.databaseBuilder(context, UserDatabase.class, "user_database")
                            .build();
                }
            }
        }
        return INSTANCE;
    }

}
