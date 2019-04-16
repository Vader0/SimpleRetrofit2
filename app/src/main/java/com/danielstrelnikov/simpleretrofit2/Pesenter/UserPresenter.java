package com.danielstrelnikov.simpleretrofit2.Pesenter;

import com.danielstrelnikov.simpleretrofit2.Model.Model;
import com.danielstrelnikov.simpleretrofit2.Model.User.User;
import com.danielstrelnikov.simpleretrofit2.View.UserActivity;

public class UserPresenter {

    UserActivity activity;

    public UserPresenter(UserActivity activity, String name){
        this.activity = activity;
        setDataInActivity(findUser(name));
    }

    private User findUser(String name){
        User finded = null;
        for (User user: Model.getUsers()) {
            if(user.getName().equals(name))
                finded = user;
        }
        return finded;
    }

    private void setDataInActivity(User user){
        activity.setName(user.getName());
        activity.setEmail(user.getEmail());
        activity.setCity(user.getAddress().getCity());
        activity.setZipCode(user.getAddress().getZipcode());
        activity.setPhone(user.getPhone());
        activity.setCompanyName(user.getCompany().getName());
    }
}
