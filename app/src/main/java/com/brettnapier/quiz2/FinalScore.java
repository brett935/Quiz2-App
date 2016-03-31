package com.brettnapier.quiz2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class FinalScore extends AppCompatActivity {
    int playerScore; //declare player score


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_final_score);

        Intent i = getIntent();
        playerScore = i.getIntExtra("score", 0);

        TextView scoreView = (TextView) findViewById( R.id.textView_finalScore);
        scoreView.setText("You scored: "+ playerScore + "/3" );
    }

    public void onSaveInstanceState(Bundle outstate){
        super.onSaveInstanceState(outstate);
        outstate.putInt("score", playerScore);
    }

    public void onRestoreInstanceState(Bundle instate) {
        super.onRestoreInstanceState(instate);
        playerScore = instate.getInt("score");
    }
}
