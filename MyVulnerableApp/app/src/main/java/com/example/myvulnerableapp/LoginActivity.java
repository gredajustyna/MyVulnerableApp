package com.example.myvulnerableapp;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {
    EditText userNameText;
    EditText passwordText;
    MyDBHandler dbHandler;
    Button loginButton;
    TextView message;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        userNameText = findViewById(R.id.userNameText);
        passwordText = findViewById(R.id.passwordText);
        loginButton = findViewById(R.id.loginButton);
        message = findViewById(R.id.messageText);
        dbHandler = new MyDBHandler(this,null,null,1);

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                logInButtonClicked();

            }
        });
    }

    public void logInButtonClicked(){
        boolean isDataEmpty = checkIfDataEmpty();
        if(isDataEmpty == false){
            logIn(userNameText.getText().toString(), passwordText.getText().toString());
        }else{
            message.setText("Fill all fields!");
        }
    }

    public boolean checkIfDataEmpty(){
        //TODO: funkcja do uzupełnienia przez słuchaczy demonstracji
        return false;
    }

    public boolean logIn(String username, String password){
        //TODO: funkcja do poprawienia przez słuchaczy demonstracji
        if(dbHandler.checkDataExistOrNot("_username", username)){
            if(dbHandler.checkPassword(password, username) == true){
                String phone = dbHandler.getPhone(username);
                message.setText("You logged in! your phone number is "+phone);
                return true;
            }else {
                message.setText("Passwords don't match!");
                return false;
            }
        }else{
            message.setText("User not in database!");
            return false;
        }
    }
}
