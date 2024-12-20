package com.example.myapplication;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.model.Hash;
import com.example.myapplication.model.User;

public class RegisterActivity extends AppCompatActivity {

    private EditText nameEditText, emailEditText, passEditText;
    private Button registerButton;
    private SQLiteConnector dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        nameEditText = findViewById(R.id.nameEditText);
        emailEditText = findViewById(R.id.emailEditText);
        passEditText = findViewById(R.id.passEditText);
        registerButton = findViewById(R.id.registerButton);

        dbHelper = new SQLiteConnector(this);

        registerButton.setOnClickListener(view -> {
            String name = nameEditText.getText().toString();
            String email = emailEditText.getText().toString();
            String password = passEditText.getText().toString();

            if (name.isEmpty() || email.isEmpty() || password.isEmpty()) {
                Toast.makeText(RegisterActivity.this, "Please fill all fields", Toast.LENGTH_SHORT).show();
                return;
            } //

            if (dbHelper.checkUser(email)) {
                Toast.makeText(RegisterActivity.this, "User already exists", Toast.LENGTH_SHORT).show();
            } else {
                String hashedPassword = Hash.hashPassword(password);
                User user = new User(name, email, hashedPassword);
                dbHelper.addUser(user);
                Toast.makeText(RegisterActivity.this, "User registered successfully", Toast.LENGTH_SHORT).show();
                finish(); // Go back to MainActivity
            }
        });
    }
}

