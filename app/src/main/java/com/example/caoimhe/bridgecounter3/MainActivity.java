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
        final View trickScore2 = findViewById(R.id.uscore2);
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
                   newHorizontal.setVisibility(View.VISIBLE);
                  //create new trickscore box
                   trickScore2.setVisibility(View.VISIBLE);
                   //disable editing of old trickscore
                   trickScore1.setEnabled(false);
                   trickScore1.setInputType(InputType.TYPE_NULL);
                   trickScore1.setTextColor(getResources().getColor(R.color.textcolor);

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


        //Todo add code from onclick here and generalise it.
        void updateSooreboard()
        {

        }



    }


    

}

