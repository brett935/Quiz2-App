package com.brettnapier.quiz2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class Question3 extends AppCompatActivity {
    int playerScore; //declare player score
    String id;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question3);

        Intent i = getIntent();
        playerScore = i.getIntExtra("score", 0);

        final RadioGroup radioGroup = (RadioGroup) findViewById( R.id.radioGroup);

        Button submit = (Button) findViewById( R.id.button_submit);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //nextQuestion(); //go to final score activity
                Integer id = radioGroup.getCheckedRadioButtonId();
                RadioButton radioButton = (RadioButton) findViewById( id );
                CharSequence radioText = radioButton.getText();

                if(radioText.equals("43")){
                    nextQuestion(Boolean.TRUE); //correct, go to next question
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
        Intent i = new Intent(this, FinalScore.class);
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
