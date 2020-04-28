package ru.falchio.myroom;

import android.util.Log;

import io.reactivex.Completable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import ru.falchio.myroom.database.User;
import ru.falchio.myroom.roomdao.UserDao;

public class UserPresenter {
    private final String TAG = this.getClass().getSimpleName();
    private UserDao userDao;
    User user = new User(
            "Ivan",
            "Ivanov",
            27);

    public UserPresenter() {
        this.userDao = MyApplication.getInstance().getUserDao();
    }

    void putUser1(){
        Disposable disposable = userDao.insertUser(user).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
                .subscribe(name ->{
                    Log.d(TAG, "putUser1: " + name);
                }, throwable -> {
                    Log.e(TAG, "putUser1: " + throwable );
                });
    }

    void putUser2(){
        User user = new User(
                "Petr",
                "Petrov",
                31);
        Disposable disposable = userDao.insertUser(user).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
                .subscribe(name ->{
                    Log.d(TAG, "putUser2: " + name);
                }, throwable -> {
                    Log.e(TAG, "putUser2: " + throwable );
                });
    }

    void getUsers(){
        Disposable disposable = userDao.getAllUsers().subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        users -> {
                            Log.d(TAG, "getData: " + users);
                        }, throwable -> {
                            Log.e(TAG, "getData: " + throwable );
                        }
                );
    }

    void updateUser(){
        user.setId(2);
        Disposable disposable = userDao.updateUser(user).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        age->{
                            Log.d(TAG, "updateUser: " + age);
                        }, throwable -> {
                            Log.e(TAG, "updateUser: " + throwable );
                        }
                );
    }

    void deleteAllUsers(){
        Completable.fromAction(userDao::deleteAll).subscribeOn(Schedulers.io()).subscribe();
    }

    void deleteUser(){
        user.setId(1);
        Disposable disposable = userDao.deleteUser(user).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(name->{
            Log.d(TAG, "deleteUser: " + name);
        }, throwable -> {
            Log.e(TAG, "deleteUser: " + throwable );
        });
    }


}
