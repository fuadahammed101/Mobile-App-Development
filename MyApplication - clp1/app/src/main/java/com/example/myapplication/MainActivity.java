package com.example.myapplication;

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

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Initialize Views
        etName = findViewById(R.id.etName);
        etPass = findViewById(R.id.etPass);
        btnOk = findViewById(R.id.btnOk);
        btnReset = findViewById(R.id.btnReset);

        // OK Button functionality
        btnOk.setOnClickListener(v -> {
            String name = etName.getText().toString();
            String password = etPass.getText().toString();
            Toast.makeText(MainActivity.this, "Name: " + name + "\nPassword: " + password, Toast.LENGTH_SHORT).show();
        });

        // Reset Button functionality
        btnReset.setOnClickListener(v -> {
            etName.setText("");
            etPass.setText("");
        });
    }
}
