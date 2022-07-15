package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import org.mozilla.javascript.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.calculator.databinding.ActivityMainBinding;

import org.mozilla.javascript.Scriptable;


public class MainActivity extends AppCompatActivity {

    Button btnClear,btn00, btn0, btn1, btn2, btn3, btn4, btn5, btn6, btn7,btn8, btn9, btnAdd, btnMinus, btnMultiply, btnPercent;
    ImageButton btnErase;
    Button btnDivision, btnDot, btnEquals;
    TextView tvInput, tvOutput;
    String process;
    //Boolean checkBracket = false;
    ActivityMainBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        binding=ActivityMainBinding.inflate(getLayoutInflater());
        super.onCreate(savedInstanceState);
        setContentView(binding.getRoot());

        getSupportActionBar().hide();

        btn00 = findViewById(R.id.btn00);
        btn0 = findViewById(R.id.btn0);
        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);
        btn3 = findViewById(R.id.btn3);
        btn4 = findViewById(R.id.btn4);
        btn5 = findViewById(R.id.btn5);
        btn6 = findViewById(R.id.btn6);
        btn7 = findViewById(R.id.btn7);
        btn8 = findViewById(R.id.btn8);
        btn9 = findViewById(R.id.btn9);
        btnClear = findViewById(R.id.btnClear);
        btnAdd = findViewById(R.id.btnAdd);
        btnErase = findViewById(R.id.btnErase);
        btnMinus = findViewById(R.id.btnMinus);
        btnMultiply = findViewById(R.id.btnMultiply);
        btnPercent = findViewById(R.id.btnPercent);
        btnDivision = findViewById(R.id.btnDivision);
        btnDot = findViewById(R.id.btnDot);
        btnEquals = findViewById(R.id.btnEquals);

        tvInput = findViewById(R.id.tvInput);
        tvOutput = findViewById(R.id.tvOutput);

        btnClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tvInput.setText("");
                tvOutput.setText("");
            }
        });

        btnErase.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                process = tvInput.getText().toString();
                tvInput.setText(process.substring(0, process.length()-1));
            }
        });

        btn00.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateInputField("00");
            }
        });

        btn0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateInputField("0");
            }
        });

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateInputField("1");
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateInputField("2");
            }
        });

        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateInputField("3");
            }
        });

        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateInputField("4");
            }
        });

        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateInputField("5");
            }
        });

        btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateInputField("6");
            }
        });

        btn7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateInputField("7");
            }
        });

        btn8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateInputField("8");
            }
        });

        btn9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateInputField("9");
            }
        });


        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateInputField("+");
            }
        });

        btnMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateInputField("-");
            }
        });

        btnMultiply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateInputField("-");
            }
        });

        btnDivision.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateInputField("/");
            }
        });

        btnDot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateInputField(".");
            }
        });

        btnPercent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateInputField("%");
            }
        });

        btnEquals.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                process = tvInput.getText().toString();

                process = process.replaceAll("×", "*");
                process = process.replaceAll("%",  "/100");
                process = process.replaceAll("÷","/");

                Context context = Context.enter();
                context.setOptimizationLevel(-1);

                String finalResult = "";

                try {
                    Scriptable scriptable = context.initStandardObjects();
                    finalResult = context.evaluateString(scriptable,process,"javascript",1,null)
                            .toString();
                }catch (Exception e){
                    finalResult="0";
                }
                tvOutput.setText(finalResult);


            }
        });

//        btnBracket.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                if (checkBracket){
//                    process = tvInput.getText().toString();
//                    tvInput.setText(process + ")");
//                    checkBracket = false;
//                }
//                else{
//                    process = tvInput.getText().toString();
//                    tvInput.setText(process + "(");
//                    checkBracket = true;
//                }
//            }
//        });

    }
    void updateInputField(String arg){
        process = tvInput.getText().toString();
        tvInput.setText(process + arg);
    }
}
