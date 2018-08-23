package com.example.sif.mvptest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.sif.mvptest.Model.PresenterModel;
import com.example.sif.mvptest.Presenter.LoginPresenter;
import com.example.sif.mvptest.View.LoginView;

public class MainActivity extends AppCompatActivity implements LoginView{

    TextView login;
    EditText username,password;

    LoginPresenter loginPresenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        login = findViewById(R.id.login);
        username = findViewById(R.id.username);
        password = findViewById(R.id.password);

        loginPresenter = new PresenterModel(MainActivity.this);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String uname = username.getText().toString();
                String pass = password.getText().toString();

                loginPresenter.perFormLogin(uname,pass);
            }
        });
    }

    @Override
    public void loginValidations() {
        Toast.makeText(this, "Empty", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void loginSuccess() {
        Toast.makeText(this, "OK", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void loginFailed() {
        Toast.makeText(this, "Not Ok", Toast.LENGTH_SHORT).show();
    }
}
