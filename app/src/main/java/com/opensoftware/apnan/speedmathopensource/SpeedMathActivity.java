package com.opensoftware.apnan.speedmathopensource;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class SpeedMathActivity extends AppCompatActivity {
    private TextView equationTV, correctTV,wrongTV;
    private Button Bsave;
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
        Bsave = findViewById(R.id.Bsave);
        Intent intent = getIntent();
        if(intent.hasExtra("creation")) {
            creator = new Game((GameCreation) intent.getSerializableExtra("creation"));
        } else {
            FileController fc = new FileController(getBaseContext());
            creator = fc.loadGame();
        }

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
        Bsave.setOnClickListener(new View.OnClickListener() {
            @Override
           public void onClick(View v) {
                FileController fc = new FileController(getBaseContext());
                fc.saveGame(creator);
                Intent intent = new Intent(getBaseContext(), IntroActivity.class);
                startActivity(intent);
            }
        });
        equationTV.setText(creator.getEquation());

    }

    private void checkAnswer()
    {
        if(creator.checkEquation(Integer.parseInt(answerET.getText().toString())))
        {
            correctTV.setText(Integer.toString(creator.getAmount()));
            equationTV.setText(creator.getEquation());
            answerET.setText("");
        } else {
            correctTV.setText(Integer.toString(creator.getAmount()));
        }
    }


}
