package com.opensoftware.apnan.speedmathopensource;

import android.app.ListActivity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class AllScoresActivity extends AppCompatActivity {
    private TextView TVtotal, TVequations, TVAttempts;
    private ListView LVmatches;
    AllScores scores;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_scores);
        TVtotal = findViewById(R.id.TVtotal);
        TVequations = findViewById(R.id.TVequations);
        TVAttempts = findViewById(R.id.TVattempts);
        LVmatches = findViewById(R.id.LVmatches);
        FileController fc = new FileController(getBaseContext());
        scores = fc.loadScores(); // Create a Allscores object if it cant read one from file it will return a new one
        ArrayAdapter<Score> arrayAdapter = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,scores.getCompleted());

        LVmatches.setAdapter(arrayAdapter);
        LVmatches.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
               Intent intent = new Intent(getBaseContext(),ScoreActivity.class);
               intent.putExtra("SavedScore",scores.getScore(position));
               startActivity(intent);
            }
        });
        TVtotal.setText("Total Games: " + Integer.toString(scores.getAmount()));
        TVequations.setText("Total Equations: " + scores.getEquationCount());
        TVAttempts.setText("Total Tries:" + scores.getQuestionAmount());
    }

}
