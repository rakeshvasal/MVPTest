package com.example.sif.mvptest.Controllers.Activities.MVP_Activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.sif.mvptest.Model.PresenterModel;
import com.example.sif.mvptest.Presenter.LoginPresenter;
import com.example.sif.mvptest.R;
import com.example.sif.mvptest.View.LoginView;

import java.util.LinkedList;

public class MainActivity extends AppCompatActivity implements LoginView {

    TextView login;
    EditText username, password;

    LoginPresenter loginPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        login = findViewById(R.id.login);
        username = findViewById(R.id.username);
        password = findViewById(R.id.password);

        //We create an instance of presenter interface and initialize
        //it with the Constructor of the Presenter Model Constructor
        //which implements the Presenter Interface, and then use the
        //instance to call the method of the presenter interface.

        //Just Because the Main Activity Implements Login View i.e
        //View Interface we can pass this as an instance or context
        //of the Login View is passed on to to the presenter model.

        loginPresenter = new PresenterModel(this);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String uname = username.getText().toString();
                String pass = password.getText().toString();

                loginPresenter.perFormLogin(uname, pass);
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
