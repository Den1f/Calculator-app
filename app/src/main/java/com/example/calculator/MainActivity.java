package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.android.material.button.MaterialButton;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    private static final char ADDITION = '+';
    private static final char SUBTRACTION = '-';
    private static final char MULTIPLICATION = '*';
    private static final char DIVISION = '/';
    private static final char PERCENT = '%';

    private char currentSymbol;

    private double firstValue = Double.NaN;
    private double secondValue;
    private TextView inputDisplay, outputDisplay;
    private DecimalFormat decimalFormat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        decimalFormat = new DecimalFormat("#.##########");

        inputDisplay = findViewById(R.id.input);
        outputDisplay = findViewById(R.id.output);

        MaterialButton button0 = findViewById(R.id.btn0);
        MaterialButton button1 = findViewById(R.id.btn1);
        MaterialButton button2 = findViewById(R.id.btn2);
        MaterialButton button3 = findViewById(R.id.btn3);
        MaterialButton button4 = findViewById(R.id.btn4);
        MaterialButton button5 = findViewById(R.id.btn5);
        MaterialButton button6 = findViewById(R.id.btn6);
        MaterialButton button7 = findViewById(R.id.btn7);
        MaterialButton button8 = findViewById(R.id.btn8);
        MaterialButton button9 = findViewById(R.id.btn9);

        MaterialButton buttonAdd = findViewById(R.id.add);
        MaterialButton buttonSub = findViewById(R.id.subtract);
        MaterialButton buttonDivide = findViewById(R.id.division);
        MaterialButton buttonDot = findViewById(R.id.btnPoint);
        MaterialButton buttonMultiply = findViewById(R.id.multiply);
        MaterialButton buttonClear = findViewById(R.id.clear);
        MaterialButton buttonOFF = findViewById(R.id.off);
        MaterialButton buttonEqual = findViewById(R.id.equal);
        MaterialButton buttonPercent = findViewById(R.id.percent);

        button0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                inputDisplay.setText(String.format("%s0", inputDisplay.getText()));
            }
        });

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                inputDisplay.setText(String.format("%s1", inputDisplay.getText()));
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                inputDisplay.setText(String.format("%s2", inputDisplay.getText()));
            }
        });

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                inputDisplay.setText(String.format("%s3", inputDisplay.getText()));
            }
        });

        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                inputDisplay.setText(String.format("%s4", inputDisplay.getText()));
            }
        });

        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                inputDisplay.setText(String.format("%s5", inputDisplay.getText()));
            }
        });

        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                inputDisplay.setText(String.format("%s6", inputDisplay.getText()));
            }
        });

        button7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                inputDisplay.setText(String.format("%s7", inputDisplay.getText()));

            }
        });

        button8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                inputDisplay.setText(String.format("%s8", inputDisplay.getText()));
            }
        });

        button9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                inputDisplay.setText(String.format("%s9", inputDisplay.getText()));
            }
        });

        buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                allCalculations();
                currentSymbol = ADDITION;
                outputDisplay.setText(String.format("%s+", decimalFormat.format(firstValue)));
                inputDisplay.setText(null);
            }
        });

        buttonSub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                allCalculations();
                currentSymbol = SUBTRACTION;
                outputDisplay.setText(String.format("%s-", decimalFormat.format(firstValue)));
                inputDisplay.setText(null);
            }
        });

        buttonMultiply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                allCalculations();
                currentSymbol = MULTIPLICATION;
                outputDisplay.setText(String.format("%sx", decimalFormat.format(firstValue)));
                inputDisplay.setText(null);
            }
        });

        buttonDivide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                allCalculations();
                currentSymbol = DIVISION;
                outputDisplay.setText(String.format("%s/", decimalFormat.format(firstValue)));
                inputDisplay.setText(null);
            }
        });

        buttonPercent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                allCalculations();
                currentSymbol = PERCENT;
                outputDisplay.setText(String.format("%s%%", decimalFormat.format(firstValue)));
                inputDisplay.setText(null);
            }
        });

        buttonDot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                inputDisplay.setText(String.format("%s.", inputDisplay.getText()));
            }
        });

        buttonClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (inputDisplay.getText().length() > 0) {
                    CharSequence currentText = inputDisplay.getText();
                    inputDisplay.setText(currentText.subSequence(0, currentText.length() - 1));
                } else {
                    firstValue = Double.NaN;
                    secondValue = Double.NaN;
                    inputDisplay.setText("");
                    outputDisplay.setText("");
                }
            }
        });

        buttonOFF.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        buttonEqual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                allCalculations();
                outputDisplay.setText(decimalFormat.format(firstValue));
                firstValue = Double.NaN;
                currentSymbol = '0';
            }
        });
    }

    private void allCalculations(){
        if (!Double.isNaN(firstValue)) {
            secondValue = Double.parseDouble(inputDisplay.getText().toString());
            inputDisplay.setText(null);

            if (currentSymbol == ADDITION)
                firstValue = this.firstValue + secondValue;
            else if (currentSymbol == SUBTRACTION)
                firstValue = this.firstValue - secondValue;
            else if (currentSymbol == MULTIPLICATION)
                firstValue = this.firstValue * secondValue;
            else if (currentSymbol == DIVISION)
                firstValue = this.firstValue / secondValue;
            else if (currentSymbol == PERCENT)
                firstValue = this.firstValue % secondValue;
        } else {
            try {
                firstValue = Double.parseDouble(inputDisplay.getText().toString());
            } catch (Exception e) {

            }
        }
    }
}