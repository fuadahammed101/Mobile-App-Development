package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private EditText etName, etPass;
    private Button btnOk, btnReset;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        // Handle system UI insets
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Initialize views
        etName = findViewById(R.id.etName);
        etPass = findViewById(R.id.etPass);
        btnOk = findViewById(R.id.btnOk);
        btnReset = findViewById(R.id.btnReset);

        // Login button click
        btnOk.setOnClickListener(v -> {
            String name = etName.getText().toString().trim();
            String password = etPass.getText().toString().trim();

            if (!name.isEmpty() && !password.isEmpty()) {
                Toast.makeText(MainActivity.this, "Login Successful!", Toast.LENGTH_SHORT).show();

                // Launch calculator screen and pass the username
                Intent intent = new Intent(MainActivity.this, MainActivity2.class);
                intent.putExtra("username", name);
                startActivity(intent);
            } else {
                Toast.makeText(MainActivity.this, "Please enter both Name and Password", Toast.LENGTH_SHORT).show();
            }
        });

        // Reset button click
        btnReset.setOnClickListener(v -> {
            etName.setText("");
            etPass.setText("");
        });
    }
}
