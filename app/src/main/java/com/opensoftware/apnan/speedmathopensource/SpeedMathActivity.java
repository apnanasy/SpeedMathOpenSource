package com.opensoftware.apnan.speedmathopensource;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class SpeedMathActivity extends AppCompatActivity {
    private TextView equationTV, correctTV,wrongTV, timeTV;
    private Button Bsave;
    private EditText answerET;
    private Game creator;
    private int tries = 0;
    private Handler mHandler = new Handler();
    private long mStartTime = System.currentTimeMillis();


   private Runnable mUpdateTimeTask = new Runnable()
    {
        public void run()
        {
            final long start = mStartTime;
            long millis = System.currentTimeMillis() - start;
            int seconds = (int) (millis / 1000);
            //seconds = seconds % 60;

            timeTV.setText(Integer.toString(seconds));

            mHandler.postDelayed(this, 100);


        }
    };



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_speed_math);
        equationTV = findViewById(R.id.equationText);
        correctTV = findViewById(R.id.correctText);
        wrongTV = findViewById(R.id.wrongText);
        answerET = findViewById(R.id.answerEdit);
        Bsave = findViewById(R.id.Bsave);
        timeTV = findViewById(R.id.timeText);
        Intent intent = getIntent();
        if(intent.hasExtra("creation")) {
            creator = new Game((GameCreation) intent.getSerializableExtra("creation"), this);
        } else if(intent.hasExtra("SavedGame")) {
            creator = (Game) intent.getSerializableExtra("SavedGame");
            creator.setActivity(this);
            //FileController fc = new FileController(getBaseContext());
            //creator = fc.loadGame();
            //creator.setActivity(this);
        }
        correctTV.setText(Integer.toString(creator.getAmount()));

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
                //fc.saveGame(creator);
                SavedGames games = fc.loadGames();
                games.addGame(creator);
                fc.saveGames(games);
                Intent intent = new Intent(getBaseContext(), IntroActivity.class);
                startActivity(intent);
            }
        });
        equationTV.setText(creator.getEquation());
        mHandler.removeCallbacks(mUpdateTimeTask);
        mHandler.postDelayed(mUpdateTimeTask, 1);


    }





    private void checkAnswer()
    {
        int answer = Integer.parseInt(answerET.getText().toString());
        int time = Integer.parseInt(timeTV.getText().toString());
        if(creator.checkEquation(answer, time))
        {
            //correctTV.setText(Integer.toString(creator.getAmount()));
            mStartTime = System.currentTimeMillis();
            mHandler.removeCallbacks(mUpdateTimeTask);
            mHandler.postDelayed(mUpdateTimeTask, 1);
            equationTV.setText(creator.getEquation());
            answerET.setText("");
        } else {
            //correctTV.setText(Integer.toString(creator.getAmount()));
            String hint = creator.getHint(answer);
            if(hint != null) {
                Toast.makeText(getBaseContext(),hint, Toast.LENGTH_LONG).show();
            }
        }
        correctTV.setText(Integer.toString(creator.getAmount()));
    }


}
