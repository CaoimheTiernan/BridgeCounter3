package com.example.caoimhe.bridgecounter3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.EditText;
import android.widget.Button;



public class MainActivity extends AppCompatActivity  {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final Scoreboard ourTeam = new Scoreboard();
        Scoreboard theirTeam = new Scoreboard();
        final EditText premiumScore1 =  findViewById(R.id.dscore1);
        final EditText trickScore1 =  findViewById(R.id.uscore1);
        final View newHorizontal =  findViewById(R.id.hdivider2);
        final EditText trickScore2 = findViewById(R.id.uscore2);
        final EditText premiumScore2 = findViewById(R.id.dscore2);

        Button enterScore =  findViewById(R.id.button);


        //Making sure line doesn't appear until a game is won
        newHorizontal.setVisibility(View.GONE);


        //when the button is tapped update upperScore and UnderScore
        enterScore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String tmp1 = premiumScore1.getText().toString();
                String tmp2 = trickScore1.getText().toString();

                //Check if a value was entered. If not set the value to 0
                if(tmp1.equals("")) {
                    ourTeam.setUnderScore("0");
                }
                else
                    ourTeam.setUnderScore(tmp1);
                if(tmp2.equals("")) {
                    ourTeam.setUpperScore("0");
                }
                else
                    ourTeam.setUpperScore(tmp2);

                //checks if a game has been won. Then should draw a new horizontal line
               if(ourTeam.GameWon()) {
                   updateTrickScores(newHorizontal,trickScore2,trickScore1);
                   updatePremiumScore(premiumScore2,premiumScore1);
                   ourTeam.gamesWon++;
               }
               else
                   newHorizontal.setVisibility(View.GONE);
            }
        });




    }

    //When the user hits enter on the keyboard this method updates upperScore and underScore

    /* class that encapsulates the
    scoring
     */
    public class Scoreboard
    {
        private int upperScore; //the trick score. I don't play bridge this is to help me with the positioning
        private int underScore; // the premium score.
        private int gamesWon; //keeps count of the number of games won by team


        Scoreboard() //scoreboard constructor. New round all scores set to 0
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

        void setUnderScore(String value)
        {
            underScore = Integer.parseInt(value);
        }

         void setUpperScore(String value)
        {
            upperScore = Integer.parseInt(value);
        }


         boolean GameWon() //checks if team's upperscore >= 100
        {
            return this.underScore >= 100;
        }






    }


    //updates activity
    void updateTrickScores(View horizontal,EditText newBox, EditText oldBox)
    {
        horizontal.setVisibility(View.VISIBLE);
        //make next trickscore box visible
        newBox.setVisibility(View.VISIBLE);
        //disable editing of old trickscore
        oldBox.setEnabled(false);
        oldBox.setInputType(InputType.TYPE_NULL);
        oldBox.setTextColor(getResources().getColor(R.color.textcolor));

    }

    void updatePremiumScore(EditText newBox, EditText oldBox)
    {
        //make next premium score box visable
        newBox.setVisibility(View.VISIBLE);
        //disable editing of old premium Score box
        oldBox.setEnabled(false);
        oldBox.setInputType(InputType.TYPE_NULL);
        oldBox.setTextColor(getResources().getColor(R.color.textcolor));
    }


    

}

