package com.opensoftware.apnan.speedmathopensource;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class NewCustomGameActivity extends AppCompatActivity {
    private Button createB;
    private EditText lowET, highET, amountET;
    private CheckBox CBadd, CBsub, CBdiv,CBmul;
    private GameCreation creator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_custom_game);
        creator = new GameCreation();
        createB = findViewById(R.id.Bcreate);
        lowET = findViewById(R.id.ETlow);
        highET = findViewById(R.id.EThigh);
        amountET = findViewById(R.id.ETamount);
        CBadd = findViewById(R.id.CBadd);
        CBsub = findViewById(R.id.CBsub);
        CBdiv = findViewById(R.id.CBdiv);
        CBmul = findViewById(R.id.CBmul);
        lowET.setText(creator.getLowStr());
        highET.setText(creator.getHighStr());
        amountET.setText(creator.getAmountStr());
        createB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checked();
            }
        });

    }
    private void checked() {
        int low = Integer.parseInt(lowET.getText().toString());
        int high = Integer.parseInt(highET.getText().toString());
        int amount = Integer.parseInt(amountET.getText().toString());
        String s = creator.checkGame(low,high,amount,CBadd.isChecked(),CBsub.isChecked(),CBdiv.isChecked(),CBmul.isChecked());
        if(s == null) {
            Intent intent = new Intent(getBaseContext(), SpeedMathActivity.class);
            intent.putExtra("creation",creator);
            startActivity(intent);
        } else {
            Toast.makeText(getBaseContext(),s,Toast.LENGTH_LONG).show();
        }
    }

}
