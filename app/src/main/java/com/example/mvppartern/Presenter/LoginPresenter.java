package com.example.mvppartern.Presenter;

import com.example.mvppartern.Model.User;
import com.example.mvppartern.View.ILoginView;

public class LoginPresenter implements ILoginPresenter{
    ILoginView loginView;

    public LoginPresenter(ILoginView loginView) {
        this.loginView = loginView;
    }

    @Override
    public void onLogin(String email, String password) {
        User user = new User(email, password);

        int loginCode = user.isValidData();

        if(loginCode == 0)
            loginView.onLoginFailed("Email is empty");
        else if(loginCode == 1)
            loginView.onLoginFailed("Email is not in right format");
        else if(loginCode == 2)
            loginView.onLoginFailed("Password is less than 6 characters");
        else
            loginView.onLoginSuccess("Login Successfully");
    }
}
