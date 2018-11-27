package com.opensoftware.apnan.speedmathopensource;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;


public class SpeedMathActivity extends AppCompatActivity {
    private TextView equationTV, correctTV,wrongTV;
    private EditText answerET;
    private RandMath creator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_speed_math);
        equationTV = findViewById(R.id.equationText);
        correctTV = findViewById(R.id.correctText);
        wrongTV = findViewById(R.id.wrongText);
        answerET = findViewById(R.id.answerEdit);
        creator = new RandMath();
        equationTV.setText(creator.getEquation());

    }


}
