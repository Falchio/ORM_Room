package ru.falchio.myroom;

import android.app.Application;
import androidx.room.Room;
import ru.falchio.myroom.database.UserBase;
import ru.falchio.myroom.roomdao.UserDao;

public class MyApplication extends Application {
    private static MyApplication instance;
    private UserBase userBase;

    @Override
    public void onCreate() {
        super.onCreate();
        instance=this;
        userBase = Room.databaseBuilder(
                getApplicationContext(),
                UserBase.class,
                "users_base").build();
    }

    public static MyApplication getInstance(){
        return instance;
    }

    public UserDao getUserDao(){
        return userBase.getUserDao();
    }
}
