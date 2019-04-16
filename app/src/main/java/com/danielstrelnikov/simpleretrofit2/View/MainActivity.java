package com.danielstrelnikov.simpleretrofit2.View;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.danielstrelnikov.simpleretrofit2.Pesenter.Presenter;
import com.danielstrelnikov.simpleretrofit2.R;

public class MainActivity extends AppCompatActivity {

    Button button;
    Presenter presenter;
    LinearLayout layout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        presenter = new Presenter(this);

        button = findViewById(R.id.button);
        layout = findViewById(R.id.layout);
    }

    public void downloadlClick(View view) {
        presenter.downloadBtnClicked();
    }

    public void setLoader(){
        button.setEnabled(false);
        button.setText("Downloading...");
    }

    public void removeLoader(){
        layout.removeView(button);
    }

    public void showUsers(String[] names){
        for(int i = 0; i < names.length; i++){
            Button btn = new Button(this);
            btn.setText(names[i]);
            btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Button btnClicked = (Button) v;
                    userBtnClicked(btnClicked.getText().toString());
                }
            });
            layout.addView(btn);
        }
    }

    private void userBtnClicked(String name){
        presenter.userClicked(name);
    }
    public void gotoUserActivity(String name){
        Intent intent = new Intent(this, UserActivity.class);
        intent.putExtra("name", name);
        startActivity(intent);

    }
}
