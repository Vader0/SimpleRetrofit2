package com.danielstrelnikov.simpleretrofit2.Pesenter;

import android.util.Log;

import com.danielstrelnikov.simpleretrofit2.Model.Model;
import com.danielstrelnikov.simpleretrofit2.Model.User.User;
import com.danielstrelnikov.simpleretrofit2.View.MainActivity;
import com.danielstrelnikov.simpleretrofit2.View.UserActivity;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Presenter {

    MainActivity activity;

    public Presenter(MainActivity activity)
    {
        this.activity = activity;
    }

    public void downloadBtnClicked(){
        setLoader();
        downloadUser();
    }
    public void userClicked(String name){
        for (User user: Model.getUsers()) {
            if(user.getName().equals(name))
            {
                activity.gotoUserActivity(name);
            }
        }
    }


    private void setLoader(){
        activity.setLoader();
    }
    private void removeLoader(){
        activity.removeLoader();
    }
    private void showUsers(String[] names){
        activity.showUsers(names);
    }
    private String[] getNames(){
        String[] names = new String[10];
        ArrayList<User> users = Model.getUsers();
        for(int i = 0; i < users.size(); i++)
            names[i] = users.get(i).getName();

        return names;
    }

    private void downloadUser(){
        Model.getInstance().getJSONApi().getAllUsers().enqueue(new Callback<ArrayList<User>>() {
            @Override
            public void onResponse(Call<ArrayList<User>> call, Response<ArrayList<User>> response) {
                removeLoader();
                Model.setUsers(response.body());
                showUsers(getNames());
            }

            @Override
            public void onFailure(Call<ArrayList<User>> call, Throwable t) {
                removeLoader();
                t.printStackTrace();
            }
        });
    }

}
