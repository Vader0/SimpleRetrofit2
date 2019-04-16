package com.danielstrelnikov.simpleretrofit2.Model;

import com.danielstrelnikov.simpleretrofit2.Model.User.User;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface JSONPlaceHolder {
    @GET("/users")
    public Call<ArrayList<User>> getAllUsers();

    @GET("/users/{id}")
    public Call<User> getUserById(@Path("id") int id);

}
