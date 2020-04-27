package ru.falchio.myroom.roomdao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

import ru.falchio.myroom.database.User;

@Dao // <----- don't forget
public interface UserDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertUser(User user);

    @Update
    void updateUser(User user);

    @Delete
    void deleteUser(User user);

    @Query("DELETE FROM users_base WHERE id =:id")
    void deleteUserByIdRoom(long id);

    @Query("SELECT * FROM users_base")
    List<User> getAllUsers();

    @Query("SELECT * FROM users_base WHERE id=:id")
    User getUserByIdRoom(long id);

    @Query("SELECT COUNT() FROM users_base")
    long getCountUsers();


}
