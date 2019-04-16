package com.danielstrelnikov.simpleretrofit2.Model;

import com.danielstrelnikov.simpleretrofit2.Model.User.User;

import java.util.ArrayList;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Model {

    private static Model mInstance;
    private static final String BASE_URL = "https://jsonplaceholder.typicode.com";
    private static Retrofit mRetrofit;
    private static ArrayList<User> Users;

    private Model(){
        mRetrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    public static Model getInstance(){
        if(mInstance == null)
            mInstance = new Model();
        return mInstance;
    }

    public static JSONPlaceHolder getJSONApi(){
        return mRetrofit.create(JSONPlaceHolder.class);
    }

    public static ArrayList<User> getUsers() {
        return Users;
    }

    public static void setUsers(ArrayList<User> users) {
        Users = users;
    }
}
