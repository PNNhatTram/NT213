package com.example.myapplication;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class DisplayActivity extends AppCompatActivity {

    private TextView greetTextView, howAreYouTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display);

        greetTextView = findViewById(R.id.greetTextView);
        howAreYouTextView = findViewById(R.id.howAreYouTextView);

        String username = getIntent().getStringExtra("username");

        if (username != null) {
            greetTextView.setText("Welcome, " + username);
            howAreYouTextView.setText("How are you today? " + username);
        } else {
            greetTextView.setText("Welcome, Guest");
            howAreYouTextView.setText("How are you today?");
        }
    }
}
