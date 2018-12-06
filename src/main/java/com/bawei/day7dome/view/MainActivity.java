package com.bawei.day7dome.view;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.bawei.day7dome.R;
import com.bawei.day7dome.presenter.Loginpresenter;

public class MainActivity extends AppCompatActivity implements IView {

    private EditText username,pwd;
    private Loginpresenter loginpresenter;
    private Button loginbtn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        username = findViewById(R.id.username);
        pwd = findViewById(R.id.pwd);
        loginbtn = findViewById(R.id.login);

        loginpresenter = new Loginpresenter(this);

        loginbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username1 = username.getText().toString();
                String pwd1 = pwd.getText().toString();
                loginpresenter.login(username1,pwd1);
            }
        });


    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        loginpresenter.onDetach();
    }

    @Override
    public void showData(Object data) {
        Toast.makeText(MainActivity.this,""+data,Toast.LENGTH_SHORT).show();

        startActivity(new Intent(MainActivity.this,Main2Activity.class));
    }
}
