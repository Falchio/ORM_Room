package ru.falchio.myroom;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    private UserPresenter userPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        userPresenter = new UserPresenter();
    }

    public void putUser1(View v){
        userPresenter.putUser1();
    }

    public void putUser2(View v){
        userPresenter.putUser2();
    }

    public void getUsers(View v){
        userPresenter.getUsers();
    }

    public void updateUser(View v){
        userPresenter.updateUser();
    }

    public void deleteAllUsers(View v){
        userPresenter.deleteAllUsers();
    }

    public void deleteUser(View v){
        userPresenter.deleteUser();
    }
}
