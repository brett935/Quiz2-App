package com.brettnapier.quiz2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;

public class Question1 extends AppCompatActivity {
    int playerScore; //declare player score

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question1);

        Intent i = getIntent();
        playerScore = i.getIntExtra("score", 0);

        //initialize checkbox variables
        final CheckBox redBox = (CheckBox) findViewById( R.id.checkBox_red);
        final CheckBox purpleBox = (CheckBox) findViewById( R.id.checkBox_purple);
        final CheckBox yellowBox = (CheckBox) findViewById( R.id.checkBox_yellow);
        final CheckBox blueBox = (CheckBox) findViewById( R.id.checkBox_blue);
        final CheckBox greenBox = (CheckBox) findViewById( R.id.checkBox_green);
        final CheckBox orangeBox = (CheckBox) findViewById( R.id.checkBox_orange);



        Button submit = (Button) findViewById( R.id.button_submit);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //check to see what boxes are checked
                Boolean redChecked = redBox.isChecked();
                Boolean purpleChecked = purpleBox.isChecked();
                Boolean yellowChecked = yellowBox.isChecked();
                Boolean blueChecked = blueBox.isChecked();
                Boolean greenChecked = greenBox.isChecked();
                Boolean orangeChecked = orangeBox.isChecked();

                if (redChecked && greenChecked && blueChecked &&
                        !purpleChecked &&!yellowChecked && !orangeChecked) {
                    nextQuestion(Boolean.TRUE); //correct, go to the next question
                }
                else{
                    nextQuestion(Boolean.FALSE); //incorrect, go to the next question
                }
            }
        });
    }

    public void nextQuestion(Boolean correct){
        if(correct){
            playerScore++;
        }
        Intent i = new Intent(this, Question2.class);
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
