package com.opensoftware.apnan.speedmathopensource;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class ScoreActivity extends AppCompatActivity {
    TextView tvMatches, tvTries;
    ListView LVequations;
    Score score;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score);
        tvMatches = findViewById(R.id.TVmatches);
        tvTries = findViewById(R.id.TVattempts);
        LVequations = findViewById(R.id.LVequations);
        Intent intent = getIntent();
        if(intent.hasExtra("score")) {
            score = (Score)intent.getSerializableExtra("score");
            tvMatches.setText(Integer.toString(score.getAmount()));
            tvTries.setText(Integer.toString(score.getTries()));
            ArrayAdapter<Equation> arrayAdapter = new ArrayAdapter<Equation>(this,android.R.layout.simple_list_item_1,score.getEquations());
            LVequations.setAdapter(arrayAdapter);
        }
    }
}
