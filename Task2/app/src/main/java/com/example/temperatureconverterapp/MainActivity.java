package com.example.temperatureconverterapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private EditText editText;
    private RadioGroup radioGroup;
    private RadioButton celsiusRadioButton, fahrenheitRadioButton;
    private Button convertButton;
    private TextView resultTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = findViewById(R.id.editText);
        radioGroup = findViewById(R.id.radioGroup);
        celsiusRadioButton = findViewById(R.id.celsiusRadioButton);
        fahrenheitRadioButton = findViewById(R.id.fahrenheitRadioButton);
        convertButton = findViewById(R.id.convertButton);
        resultTextView = findViewById(R.id.resultTextView);

        convertButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                convertTemperature();
            }
        });
    }

    private void convertTemperature() {
        double inputTemperature = Double.parseDouble(editText.getText().toString());

        if (celsiusRadioButton.isChecked()) {
            // Convert from Celsius to Fahrenheit
            double result = (inputTemperature * 9/5) + 32;
            resultTextView.setText(inputTemperature + " °C = " + result + " °F");
        } else if (fahrenheitRadioButton.isChecked()) {
            // Convert from Fahrenheit to Celsius
            double result = (inputTemperature - 32) * 5/9;
            resultTextView.setText(inputTemperature + " °F = " + result + " °C");
        }
    }
}

