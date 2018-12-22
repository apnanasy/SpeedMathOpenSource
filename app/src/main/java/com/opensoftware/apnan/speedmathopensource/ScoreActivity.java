package com.opensoftware.apnan.speedmathopensource;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

public class ScoreActivity extends AppCompatActivity {
    ListView LVequations;
    Button Bintro;
    Score score;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score);
        LVequations = findViewById(R.id.LVequations);
        Bintro = findViewById(R.id.Bintro);
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
        if(intent.hasExtra("SavedScore")) {
            score = (Score) intent.getSerializableExtra("SavedScore");
            ArrayAdapter<ScoredEquation> arrayAdapter = new ArrayAdapter<ScoredEquation>(this,android.R.layout.simple_list_item_1,score.getEquations());
            LVequations.setAdapter(arrayAdapter);
        }
        Bintro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getBaseContext(), IntroActivity.class);
                startActivity(i);
            }
        });
    }
}
