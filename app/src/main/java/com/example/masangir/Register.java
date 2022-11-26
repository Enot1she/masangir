package com.example.masangir;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Point;
import android.os.Bundle;
import android.view.Display;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Register extends AppCompatActivity {

    public Button btn;
    public DatabaseReference mDatabase;
    public int userId = 0;
    public EditText loginEditText;
    public EditText passwordEditText;
    public String login;
    public String password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        loginEditText = (EditText) findViewById(R.id.loginEditText);
        passwordEditText = (EditText) findViewById(R.id.passwordEditText);
        btn = (Button) findViewById(R.id.Reg);
        mDatabase = FirebaseDatabase.getInstance().getReference();

        setTitle(R.string.register_activity);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (loginEditText.getText().length() == 0){
                    Toast toast = Toast.makeText(getApplicationContext(), "Не введён логин", Toast.LENGTH_LONG);
                    toast.show();
                }
                else if (passwordEditText.getText().length() == 0){
                    Toast toast = Toast.makeText(getApplicationContext(), "Не введён пароль", Toast.LENGTH_LONG);
                    toast.show();
                }
                else {
                    Intent intent = new Intent(Register.this, Nav.class);
                    startActivity(intent);
                    login = loginEditText.getText().toString();
                    password = passwordEditText.getText().toString();
                    addNewUser(userId, login, password);
                    userId++;
                }
            }
        });
    }

    public void addNewUser(int userId, String userName, String userPassword){
        User user = new User(userId, userName, userPassword);
        mDatabase.child("User").child(Integer.toString(userId)).setValue(user);
        userId++;
    }
}