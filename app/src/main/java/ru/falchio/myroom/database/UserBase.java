package ru.falchio.myroom.database;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import ru.falchio.myroom.roomdao.UserDao;

@Database(entities = {User.class}, version = 1, exportSchema = false)
public abstract class UserBase extends RoomDatabase {
    public abstract UserDao getUserDao();
}
