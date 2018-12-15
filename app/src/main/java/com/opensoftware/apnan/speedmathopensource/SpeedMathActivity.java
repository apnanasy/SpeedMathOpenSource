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
    private Game creator;
    private int tries = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_speed_math);
        equationTV = findViewById(R.id.equationText);
        correctTV = findViewById(R.id.correctText);
        wrongTV = findViewById(R.id.wrongText);
        answerET = findViewById(R.id.answerEdit);
        creator = new Game();

        answerET.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                boolean handled = false;
                if (actionId == EditorInfo.IME_ACTION_DONE ||
                        (event.getKeyCode() == KeyEvent.KEYCODE_ENTER && event.getAction() == KeyEvent.ACTION_DOWN)) {
                   checkAnswer();
                    handled = true;
                }
                return handled;
            }
        });
        equationTV.setText(creator.getEquation());

    }

    private void checkAnswer()
    {
        if(creator.checkEquation(Integer.parseInt(answerET.getText().toString())))
        {
            correctTV.setText("Great!!!");
            equationTV.setText(creator.getEquation());
            answerET.setText("");
        } else {
            correctTV.setText(creator.getScore());
        }
    }


}
