package com.opensoftware.apnan.speedmathopensource;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class AllScoresActivity extends AppCompatActivity {
    private TextView TVtotal;
    AllScores scores;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_scores);
        TVtotal = findViewById(R.id.TVtotal);
        FileController fc = new FileController(getBaseContext());
        scores = fc.loadScores();
        TVtotal.setText(Integer.toString(scores.getAmount()));

    }

}
