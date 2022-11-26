package com.example.masangir;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;

public class RegReg extends AppCompatActivity {

    public Button btn2;
    public EditText loginEditText2;
    public EditText passwordEditText2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reg_reg);

        loginEditText2 = (EditText) findViewById(R.id.loginEditText2);
        passwordEditText2 = (EditText) findViewById(R.id.passwordEditText2);
        btn2 = (Button) findViewById(R.id.btn2);

        setTitle(R.string.register_activity);

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (loginEditText2.getText().length() == 0){
                    Toast toast = Toast.makeText(getApplicationContext(), "Не введён логин", Toast.LENGTH_LONG);
                    toast.show();
                }
                else if (passwordEditText2.getText().length() == 0){
                    Toast toast = Toast.makeText(getApplicationContext(), "Не введён пароль", Toast.LENGTH_LONG);
                    toast.show();
                }
                else {
                    Intent intent = new Intent(RegReg.this, Nav.class);
                    startActivity(intent);
                }
            }
        });
    }
}