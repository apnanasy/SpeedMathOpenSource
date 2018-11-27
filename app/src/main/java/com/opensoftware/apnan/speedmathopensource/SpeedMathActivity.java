package com.opensoftware.apnan.speedmathopensource;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.inputmethod.EditorInfo;
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

        answerET.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                boolean handled = false;
                if (actionId == EditorInfo.IME_ACTION_DONE ||
                        (event.getKeyCode() == KeyEvent.KEYCODE_ENTER && event.getAction() == KeyEvent.ACTION_DOWN)) {
                   // sendMessage();
                    equationTV.setText(creator.getEquation());
                    handled = true;
                }
                return handled;
            }
        });

    }


}
