package com.example.caoimhe.bridgecounter3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /* class that encapsulates the
    scoring
     */
    public class Scoreboard
    {
        private int upperScore; //the premium score. I don't play bridge this is to help me with the positioning
        private int underScore; // the trick score.


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


        public boolean GameWon(int upperScore) //checks if team's upperscore >= 100
        {   //TODO
            if(this.upperScore >= 100)
                return true;
            else
                return false;
        }



    }

    public class Team extends Scoreboard
    {
        private String player1;
        private String player2;

    }

}

