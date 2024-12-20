package com.example.androidapp;

import android.os.Bundle;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

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