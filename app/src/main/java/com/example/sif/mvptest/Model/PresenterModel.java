package com.example.sif.mvptest.Model;

import android.text.TextUtils;

import com.example.sif.mvptest.Presenter.LoginPresenter;
import com.example.sif.mvptest.View.LoginView;

public class PresenterModel implements LoginPresenter {

    LoginView loginView;

    public PresenterModel(LoginView loginView) {
        this.loginView = loginView;
    }

    @Override
    public void perFormLogin(String username, String password) {

        if (TextUtils.isEmpty(username) || TextUtils.isEmpty(password)){
            loginView.loginValidations();
        }
        else {
            if (username.equalsIgnoreCase("Rakesh") && password.equalsIgnoreCase("Vasal")){
                loginView.loginSuccess();
            }else {
                loginView.loginFailed();
            }
        }
    }
}
