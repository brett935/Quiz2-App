package com.brettnapier.quiz2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;
import android.widget.ToggleButton;

public class Question2 extends AppCompatActivity {
    int playerScore; //declare player score

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question2);

        Intent i = getIntent();
        playerScore = i.getIntExtra("score", 0);

        final ToggleButton radioToggle = (ToggleButton) findViewById( R.id.toggleButton_radio);
        final ToggleButton headlightToggle = (ToggleButton) findViewById( R.id.toggleButton_headlight);

        Button submit = (Button) findViewById( R.id.button_submit );
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if( !(radioToggle.isChecked()) && headlightToggle.isChecked() ){
                    nextQuestion(Boolean.TRUE); //correct, go to next question
                }
                else{
                    nextQuestion(Boolean.FALSE); //incorrect, go to next question
                }

            }
        });

    }

    public void nextQuestion(Boolean correct){
        if(correct){
            playerScore++;
        }
        Intent i = new Intent(this, Question3.class);
        i.putExtra("score",playerScore); //associate int playerScore with key "score" and pass it to next activity
        startActivity(i);
        finish();
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
