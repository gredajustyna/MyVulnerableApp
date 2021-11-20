package com.example.myvulnerableapp;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegisterActivity extends AppCompatActivity {
    EditText phoneText;
    EditText userNameText;
    EditText passwordText;
    MyDBHandler dbHandler;
    Button addButton;
    TextView message;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        phoneText = findViewById(R.id.phoneText);
        userNameText = findViewById(R.id.userNameText);
        passwordText = findViewById(R.id.passwordText);
        addButton = findViewById(R.id.addButton);
        message = findViewById(R.id.messageText);
        dbHandler = new MyDBHandler(this,null,null,1);

        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addButtonClicked();

            }
        });
    }

    public void addButtonClicked(){
        boolean isDataEmpty = checkIfDataEmpty();
        if(isDataEmpty == false){
            boolean isPhoneCorrect = checkIfPhoneNumberCorrect(phoneText.getText().toString());
            if(isPhoneCorrect){
                User user = new User(userNameText.getText().toString(), passwordText.getText().toString(), Integer.parseInt(phoneText.getText().toString()));
                boolean result = checkIfUserInDatabase(user);
                if(result == true){
                    message.setText("This user already exists!");
                }else{
                    dbHandler.addUser(user);
                    message.setText("Added");
                }
            }else{
                //TODO: funkcja do poprawienia przez słuchaczy demonstracji
            }
        }else{
            //TODO: funkcja do poprawienia przez słuchaczy demonstracji
        }
    }


    public void printDatabase(){
        String dbString = dbHandler.databaseToString();
        System.out.println(dbString);
    }

    public boolean checkIfUserInDatabase(User user){
        //TODO: funkcja do poprawienia przez słuchaczy demonstracji
        boolean result = dbHandler.checkDataExistOrNot("_password", user.get_password());
        return result;
    }

    public boolean checkIfDataEmpty(){
        //TODO: funkcja do uzupełnienia przez słuchaczy demonstracji
        return false;
    }

    public boolean checkIfPhoneNumberCorrect(String phoneNumber){
        //TODO: funkcja do uzupełnienia przez słuchaczy demonstracji
        return true;
    }

}
