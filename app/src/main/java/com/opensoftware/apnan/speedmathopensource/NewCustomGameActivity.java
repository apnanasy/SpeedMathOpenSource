package com.opensoftware.apnan.speedmathopensource;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class NewCustomGameActivity extends AppCompatActivity {
    private Button createB;
    private EditText lowET, highET;
    private GameCreation creator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_custom_game);
        creator = new GameCreation();
        createB = findViewById(R.id.Bcreate);
        lowET = findViewById(R.id.ETlow);
        highET = findViewById(R.id.EThigh);
        lowET.setText(creator.getLowStr());
        highET.setText(creator.getHighStr());
        createB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checked();
            }
        });

    }
    private void checked() {
        int low = Integer.parseInt(lowET.getText().toString());
        int high = Integer.parseInt(lowET.getText().toString());
        int amount = Integer.parseInt(lowET.getText().toString());
        String s = creator.checkGame(low,high,amount);
        if(s == null) {
            Intent intent = new Intent(getBaseContext(), SpeedMathActivity.class);
            intent.putExtra("creation",creator);
            startActivity(intent);
        } else {
            Toast.makeText(getBaseContext(),s,Toast.LENGTH_LONG).show();
        }
    }

}
