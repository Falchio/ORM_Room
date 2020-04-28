package ru.falchio.myroom.roomdao;

import android.hardware.usb.UsbRequest;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

import io.reactivex.Single;
import ru.falchio.myroom.database.User;

@Dao // <----- don't forget
public interface UserDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    Single<Long>  insertUser(User user);

    @Update
    Single<Integer> updateUser(User user);

    @Delete
    Single<Integer> deleteUser(User user);

    @Query("DELETE FROM users_base")
    void deleteAll();

//    @Query("DELETE FROM users_base WHERE id =:id")
//    Single<Integer> deleteUserByIdRoom(long id);

    @Query("SELECT * FROM users_base")
    Single<List<User>> getAllUsers();

//    @Query("SELECT * FROM users_base WHERE id=:id")
//    Single<User> getUserByIdRoom(long id);
//
//    @Query("SELECT COUNT() FROM users_base")
//    Single<Long> getCountUsers();


}
