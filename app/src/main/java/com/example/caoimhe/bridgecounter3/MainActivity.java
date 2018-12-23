package com.example.caoimhe.bridgecounter3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.Button;



public class MainActivity extends AppCompatActivity  {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Scoreboard ourTeam = new Scoreboard();
        Scoreboard theirTeam = new Scoreboard();
        EditText premiumScore1 = (EditText) findViewById(R.id.dscore1);
        EditText trickScore1 = (EditText) findViewById(R.id.uscore1);
        Button enterScore = (Button) findViewById(R.id.button);

    }

    //When the user hits enter on the keyboard this method updates upperScore and underScore

    /* class that encapsulates the
    scoring
     */
    public class Scoreboard
    {
        private int upperScore; //the trick score. I don't play bridge this is to help me with the positioning
        private int underScore; // the premium score.


        public Scoreboard() //scoreboard constructor. New round all scores set to 0
        {
            upperScore = 0;
            underScore = 0;
        }


        public int getUpperScore() //returns upper score
        {
            return upperScore;
        }

        public int getUnderScore() //returns underscore
        {
            return underScore;
        }

        public void setUnderScore(EditText value)
        {
            String tmp = value.getText().toString();
            underScore += Integer.parseInt(tmp);
        }

        public void setUpperScore(EditText value)
        {
            String tmp = value.getText().toString();
            upperScore += Integer.parseInt(tmp);
        }


        public boolean GameWon(int upperScore) //checks if team's upperscore >= 100
        {   //TODO
            return this.underScore >= 100;
        }



    }


    

}

