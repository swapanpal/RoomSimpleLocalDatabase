package android.example.com.roomsimplelocaldatabase.model;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "user_table")
public class User {
    @PrimaryKey
    @NonNull

    @ColumnInfo(name = "firstName")
    private String first_name;
    @ColumnInfo(name = "lastName")
    private String lase_name;
    @ColumnInfo(name = "phoneNumber")
    private String phone_number;

    public User(String first_name, String lase_name, String phone_number) {
        this.first_name = first_name;
        this.lase_name = lase_name;
        this.phone_number = phone_number;
    }

    public String getFirst_name() {
        return first_name;
    }

    public String getLase_name() {
        return lase_name;
    }

    public String getPhone_number() {
        return phone_number;
    }
}
