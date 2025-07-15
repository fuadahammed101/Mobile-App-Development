package com.example.myapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity2 extends AppCompatActivity {

    private EditText etNum1, etNum2;
    private Button btnAdd, btnSub, btnMul, btnDiv;
    private TextView tvResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2); // or whatever your XML is named

        etNum1 = findViewById(R.id.etNum1);
        etNum2 = findViewById(R.id.etNum2);
        btnAdd = findViewById(R.id.btnAdd);
        btnSub = findViewById(R.id.btnSub);
        btnMul = findViewById(R.id.btnMul);
        btnDiv = findViewById(R.id.btnDiv);
        tvResult = findViewById(R.id.tvResult);

        btnAdd.setOnClickListener(v -> updateResult("Addition"));
        btnSub.setOnClickListener(v -> updateResult("Subtraction"));
        btnMul.setOnClickListener(v -> updateResult("Multiplication"));
        btnDiv.setOnClickListener(v -> updateResult("Division"));
    }

    private void updateResult(String operationName) {
        String num1Str = etNum1.getText().toString().trim();
        String num2Str = etNum2.getText().toString().trim();

        if (!num1Str.isEmpty() && !num2Str.isEmpty()) {
            double num1 = Double.parseDouble(num1Str);
            double num2 = Double.parseDouble(num2Str);
            double result = 0;

            switch (operationName) {
                case "Addition":
                    result = num1 + num2;
                    break;
                case "Subtraction":
                    result = num1 - num2;
                    break;
                case "Multiplication":
                    result = num1 * num2;
                    break;
                case "Division":
                    if (num2 != 0)
                        result = num1 / num2;
                    else {
                        tvResult.setText("Cannot divide by zero");
                        return;
                    }
                    break;
            }

            tvResult.setText(operationName + " Result: " + result);
        } else {
            tvResult.setText("Please enter both numbers");
        }
    }
}
