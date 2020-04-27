package ru.falchio.myroom;

import android.app.Application;
import androidx.room.Room;
import ru.falchio.myroom.database.UserBase;
import ru.falchio.myroom.roomdao.UserDao;

public class MyApplication extends Application {
    private static MyApplication instance;
    private UserBase userBase;
    private static final String DATABASE_NAME = "USERS_BASE";

    @Override
    public void onCreate() {
        super.onCreate();
        instance=this;
        userBase = Room.databaseBuilder(
                getApplicationContext(),
                UserBase.class,
                DATABASE_NAME).build();
    }

    public static MyApplication getInstance(){
        return instance;
    }

    public UserDao getUserDao(){
        return userBase.getUserDao();
    }

    public UserBase getUserBase() {
        return userBase;
    }
}
