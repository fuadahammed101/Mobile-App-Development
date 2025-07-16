package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button btnChangeBackground, btnChangeTextColor;
    TextView text1, text2, text3, text4, text5;
    int textColorIndex = 0; // Index for cycling text colors
    int[] textColors = {Color.BLACK, Color.RED, Color.GREEN, Color.BLUE}; // Text colors to cycle through

    int backgroundColorIndex = 0; // Index for cycling background colors
    int[] backgroundColors = {Color.WHITE, Color.BLACK, Color.BLUE, Color.GREEN}; // Background colors to cycle through

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize Views
        text1 = findViewById(R.id.text1);
        text2 = findViewById(R.id.text2);
        text3 = findViewById(R.id.text3);
        text4 = findViewById(R.id.text4);
        text5 = findViewById(R.id.text5);
        btnChangeBackground = findViewById(R.id.btnChangeBackground);
        btnChangeTextColor = findViewById(R.id.btnChangeTextColor);

        // Initialize the root layout
        final View rootLayout = findViewById(R.id.main); // The root ConstraintLayout

        // Set default text and background color
        text1.setTextColor(textColors[textColorIndex]);
        text2.setTextColor(textColors[textColorIndex]);
        text3.setTextColor(textColors[textColorIndex]);
        text4.setTextColor(textColors[textColorIndex]);
        text5.setTextColor(textColors[textColorIndex]);

        rootLayout.setBackgroundColor(backgroundColors[backgroundColorIndex]); // Set default background color

        // Button to change text color
        btnChangeTextColor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Cycle through text colors
                textColorIndex = (textColorIndex + 1) % textColors.length;

                // Set the new color for all TextViews
                text1.setTextColor(textColors[textColorIndex]);
                text2.setTextColor(textColors[textColorIndex]);
                text3.setTextColor(textColors[textColorIndex]);
                text4.setTextColor(textColors[textColorIndex]);
                text5.setTextColor(textColors[textColorIndex]);
            }
        });

        // Button to change background color
        btnChangeBackground.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Cycle through background colors
                backgroundColorIndex = (backgroundColorIndex + 1) % backgroundColors.length;

                // Apply the new background color to the root layout
                rootLayout.setBackgroundColor(backgroundColors[backgroundColorIndex]);
            }
        });
    }
}
