package com.opensoftware.apnan.speedmathopensource;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class IntroActivity extends AppCompatActivity {
    private Button NCSButton, Bresume;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro);
        NCSButton = findViewById(R.id.NCSButton);
        Bresume = findViewById(R.id.Bresume);
        Bresume.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getBaseContext(), SpeedMathActivity.class);
                startActivity(intent);
            }
        });
        NCSButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getBaseContext(), NewCustomGameActivity.class);
                startActivity(intent);
            }
        });
    }
}
