package com.example.kalkulatorsederhana;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView resultTv;
    Button buttonPlus, buttonMinus, buttonMultiply, buttonDivide, buttonClear;
    EditText firstNumber, lastNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        resultTv = findViewById(R.id.result_tv);
        firstNumber = findViewById(R.id.first_number);
        lastNumber = findViewById(R.id.last_number);
        buttonPlus = findViewById(R.id.button_plus);
        buttonMinus = findViewById(R.id.button_minus);
        buttonMultiply = findViewById(R.id.button_multiply);
        buttonDivide = findViewById(R.id.button_divide);
        buttonClear = findViewById(R.id.button_clear);

        buttonPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calc("plus");
            }
        });

        buttonMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calc("minus");
            }
        });

        buttonMultiply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calc("multiply");
            }
        });

        buttonDivide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calc("divide");
            }
        });

        buttonClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calc("c");
            }
        });

    }


    void calc(String math) {
        try {
            String nResult = "0";
            String nMath = math;

            if (nMath.equals("c")) {
                resultTv.setText(nResult);
                firstNumber.setText("");
                lastNumber.setText("");
            } else {
                float nFirst = Float.parseFloat(firstNumber.getText().toString());
                float nLast = Float.parseFloat(lastNumber.getText().toString());

                if (nMath.equals("plus")) {
                    nResult = Float.toString(nFirst + nLast);
                    if ( nResult.endsWith(".0")) {
                        nResult = nResult.replace(".0","");
                    }
                    resultTv.setText(nResult);
                } else if (nMath.equals("minus")) {
                    nResult = Float.toString(nFirst - nLast);
                    if ( nResult.endsWith(".0")) {
                        nResult = nResult.replace(".0","");
                    }
                    resultTv.setText(nResult);
                } else if (nMath.equals("multiply")) {
                    nResult = Float.toString(nFirst * nLast);
                    if ( nResult.endsWith(".0")) {
                        nResult = nResult.replace(".0","");
                    }
                    resultTv.setText(nResult);
                } else if (nMath.equals("divide")) {
                    nResult = Float.toString(nFirst / nLast);
                    if ( nResult.endsWith(".0")) {
                        nResult = nResult.replace(".0","");
                    }
                    resultTv.setText(nResult);
                }
            }
        } catch (Exception e) {
            resultTv.setText("Error");
        }
    }
}