package com.opensoftware.apnan.speedmathopensource;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class ScoreActivity extends AppCompatActivity {
    ListView LVequations;
    Score score;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score);
        LVequations = findViewById(R.id.LVequations);
        Intent intent = getIntent();
        if(intent.hasExtra("score")) {
            score = (Score)intent.getSerializableExtra("score");
            ArrayAdapter<ScoredEquation> arrayAdapter = new ArrayAdapter<ScoredEquation>(this,android.R.layout.simple_list_item_1,score.getEquations());
            LVequations.setAdapter(arrayAdapter);
            FileController fc = new FileController(getBaseContext());
            AllScores scores = fc.loadScores();
            scores.addScore(score);
            fc.saveScores(scores);

        }
    }
}
