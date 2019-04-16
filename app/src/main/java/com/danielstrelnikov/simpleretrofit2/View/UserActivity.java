package com.danielstrelnikov.simpleretrofit2.View;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.danielstrelnikov.simpleretrofit2.Pesenter.UserPresenter;
import com.danielstrelnikov.simpleretrofit2.R;

public class UserActivity extends AppCompatActivity {

    TextView name;
    TextView city;
    TextView email;
    TextView zipCode;
    TextView phone;
    TextView companyName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_user);
        Intent intent = getIntent();
        String userName = intent.getStringExtra("name");

        name = findViewById(R.id.name);
        city = findViewById(R.id.city);
        email = findViewById(R.id.email);
        zipCode = findViewById(R.id.zipCode);
        phone = findViewById(R.id.phone);
        companyName = findViewById(R.id.companyName);

        UserPresenter presenter = new UserPresenter(this, userName);
    }

    public void setName(String name){
        this.name.setText(name);
    }
    public void setEmail(String email){
        this.email.setText(email);
    }
    public void setCity(String city){
        this.city.setText(city);
    }
    public void setZipCode(String zipCode){
        this.zipCode.setText(zipCode);
    }
    public void setPhone(String phone){
        this.phone.setText(phone);
    }
    public void setCompanyName(String companyName){
        this.companyName.setText(companyName);
    }

}
