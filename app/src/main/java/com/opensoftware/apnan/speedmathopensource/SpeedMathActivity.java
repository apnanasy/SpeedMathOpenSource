package com.opensoftware.apnan.speedmathopensource;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;


public class SpeedMathActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_speed_math);
        TextView equationTV = findViewById(R.id.equationText);
        TextView correctTV = findViewById(R.id.correctText);
        TextView wrongTV = findViewById(R.id.wrongText);
        EditText answerET = findViewById(R.id.answerEdit);

        equationTV.setText("2x2");
    }
}
