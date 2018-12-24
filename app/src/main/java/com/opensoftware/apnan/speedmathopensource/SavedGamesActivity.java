package com.opensoftware.apnan.speedmathopensource;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class SavedGamesActivity extends AppCompatActivity {
    ListView LVsaved;
    SavedGames SG;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_saved_games);
        LVsaved = findViewById(R.id.LVsaved);
        FileController fc = new FileController(getBaseContext());
        SG = fc.loadGames();
        ArrayAdapter<Game> arrayAdapter = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,SG.getSavedGames());
        LVsaved.setAdapter(arrayAdapter);
        LVsaved.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getBaseContext(),SpeedMathActivity.class);
                intent.putExtra("SavedGame", SG.getGame(position));
                startActivity(intent);
            }
        });

    }
}
