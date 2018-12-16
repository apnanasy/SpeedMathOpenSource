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

public class NewCustomGameActivity extends AppCompatActivity {
    private Button createB;
    private EditText lowET, highET;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_custom_game);
        createB = findViewById(R.id.Bcreate);
        lowET = findViewById(R.id.ETlow);
        highET = findViewById(R.id.EThigh);
        createB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checked();
            }
        });

    }
    private void checked() {
        if(Integer.parseInt(lowET.getText().toString()) < Integer.parseInt(highET.getText().toString())) {
            Intent intent = new Intent(getBaseContext(), SpeedMathActivity.class);
            intent.putExtra("low",Integer.parseInt(lowET.getText().toString()));
            intent.putExtra("high",Integer.parseInt(highET.getText().toString()));
            startActivity(intent);
        }
    }

}
