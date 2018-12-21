package com.opensoftware.apnan.speedmathopensource;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class AllScoresActivity extends AppCompatActivity {
    private TextView TVtotal, TVequations, TVAttempts;
    AllScores scores;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_scores);
        TVtotal = findViewById(R.id.TVtotal);
        TVequations = findViewById(R.id.TVequations);
        TVAttempts = findViewById(R.id.TVattempts);
        FileController fc = new FileController(getBaseContext());
        scores = fc.loadScores(); // Create a Allscores object if it cant read one from file it will return a new one
        TVtotal.setText("Total Games: " + Integer.toString(scores.getAmount()));
        TVequations.setText("Total Equations: " + scores.getEquationCount());
        TVAttempts.setText("Total Tries:" + scores.getQuestionAmount());
    }

}
