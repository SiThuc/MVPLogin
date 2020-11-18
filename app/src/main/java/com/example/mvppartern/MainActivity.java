package com.example.mvppartern;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mvppartern.Presenter.ILoginPresenter;
import com.example.mvppartern.Presenter.LoginPresenter;
import com.example.mvppartern.View.ILoginView;

import es.dmoral.toasty.Toasty;

public class MainActivity extends AppCompatActivity implements ILoginView {

    EditText edt_email, edt_password;
    Button btn_login;
    LoginPresenter loginPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();
        loginPresenter = new LoginPresenter(this);
        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loginPresenter.onLogin(edt_email.getText().toString(), edt_password.getText().toString());
            }
        });


    }

    private void initViews() {
        edt_email = (EditText) findViewById(R.id.edt_email);
        edt_password = (EditText) findViewById(R.id.edt_password);
        btn_login = (Button)findViewById(R.id.btn_login);
    }


    @Override
    public void onLoginSuccess(String message) {
        Toasty.success(this, message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onLoginFailed(String message) {
        Toasty.error(this, message, Toast.LENGTH_SHORT).show();
    }
}