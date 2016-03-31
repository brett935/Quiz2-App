//
//
//
// Author: Brett Napier
// Class: CSC309
//
//
//

package com.brettnapier.quiz2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    int playerScore = 0; //initialize variable to hold score of player

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button start = (Button) findViewById( R.id.button_start);
        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nextQuestion(); //go to the first question when start is clicked
            }
        });
    }

    public void nextQuestion(){
        Intent i = new Intent(this, Question1.class);
        i.putExtra("score",playerScore); //associate int playerScore with key "score" and pass it to next activity
        startActivity(i);
        finish();
    }


}
