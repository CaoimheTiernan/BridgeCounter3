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
        final Scoreboard theirTeam = new Scoreboard();
        final EditText premiumScore1 =  findViewById(R.id.dscore1);
        final EditText trickScore1 =  findViewById(R.id.uscore1);
        final EditText trickScore2 = findViewById(R.id.uscore2);
        final EditText premiumScore2 = findViewById(R.id.dscore2);

        final EditText trickScore3 = findViewById(R.id.uscore3);
        final EditText trickScore4 = findViewById(R.id.uscore4);
        final EditText premiumScore3 = findViewById(R.id.dscore3);
        final EditText premiumScore4 = findViewById(R.id.dscore4);

        final EditText trickScorea = findViewById(R.id.uscorea);
        final EditText trickScoreb = findViewById(R.id.uscoreb);
        final EditText premiumScorea = findViewById(R.id.dscorea);
        final EditText premiumScoreb = findViewById(R.id.dscoreb);

        final View newHorizontal =  findViewById(R.id.hdivider2);
        final View newHorizontal2 = findViewById(R.id.hdivider3);
        final View newHorizontal3 = findViewById(R.id.hdivider4);
        Button enterScore =  findViewById(R.id.button);



        //when the button is tapped update upperScore and UnderScore
        enterScore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(gameNum == 0) {
                    //Check if a value was entered. If not set the value to 0
                    ourTeam.setUnderScore(checkScore(premiumScore1));
                    ourTeam.setUpperScore(checkScore(trickScore1));
                    theirTeam.setUnderScore(checkScore(premiumScore3));
                    theirTeam.setUpperScore(checkScore(trickScore3));


                    //updates the activity on the correct boxes to display and freeze old ones
                    // so they cannot be edited later
                    if(theirTeam.GameWon() || ourTeam.GameWon())
                    {
                        updateTrickScores(trickScore2, trickScore1);
                        updatePremiumScore(premiumScore2, premiumScore1);
                        updateTrickScores(trickScore4, trickScore3);
                        updatePremiumScore(premiumScore4, premiumScore3);
                        updateHorizontal(newHorizontal);
                    }

                }

                if(gameNum == 1)
                {
                    ourTeam.setUnderScore(checkScore(premiumScore2));
                    ourTeam.setUpperScore(checkScore(trickScore2));
                    theirTeam.setUnderScore(checkScore(premiumScore4));
                    theirTeam.setUpperScore(checkScore(trickScore4));

                    //updates the activity on the correct boxes to display and freeze old ones
                    // so they cannot be edited later
                    if(theirTeam.GameWon() || ourTeam.GameWon())
                    {

                       //if both teams have wona game must go to third game
                        if ((ourTeam.getGamesWon() == 1) && (theirTeam.getGamesWon() == 1))
                        {
                            updatePremiumScore(premiumScorea,premiumScore2);
                            updateTrickScores(trickScorea, trickScore2);
                            updatePremiumScore(premiumScoreb,premiumScore4);
                            updateTrickScores(trickScoreb,trickScore4);
                            updateHorizontal(newHorizontal2);

                        }

                       //if one team has won two games they have won the rubber
                        else
                            {
                                updatePremiumScore(premiumScore2,premiumScore2);
                                updateTrickScores(trickScore2, trickScore2);
                                updatePremiumScore(premiumScore4,premiumScore4);
                                updateTrickScores(trickScore4,trickScore4);
                                updateHorizontal(newHorizontal2);

                            }

                    }
                }

                if(gameNum == 2)
                {
                    ourTeam.setUnderScore(checkScore(premiumScorea));
                    ourTeam.setUpperScore(checkScore(trickScorea));
                    theirTeam.setUnderScore(checkScore(premiumScoreb));
                    theirTeam.setUpperScore(checkScore(trickScoreb));


                    //updates activity
                    if(theirTeam.GameWon() || ourTeam.GameWon())
                    {
                            updateTrickScores(trickScorea, trickScorea);
                            updatePremiumScore(premiumScorea, premiumScorea);
                            updateTrickScores(trickScoreb, trickScoreb);
                            updatePremiumScore(premiumScoreb, premiumScoreb);
                            updateHorizontal(newHorizontal3);

                    }
                }


            }
        });




    }

    //When the user hits enter on the keyboard this method updates upperScore and underScore

    /* class that encapsulates the
    scoring
     */
    public class Scoreboard
    {
        private int[] upperScore = new int [4] ; //the trick score. I don't play bridge this is to help me with the positioning
        private int[] underScore = new int [4]; // the premium score.
        private int gamesWon; //keeps count of the number of games won by team



        Scoreboard() //scoreboard constructor. New round all scores set to 0
        {
            gamesWon = 0;
        }


        public int getUpperScore() //returns upper score
        {
            return upperScore[gameNum];
        }

        public int getUnderScore() //returns underscore
        {
            return underScore[gameNum];
        }

        public int getGamesWon()
        {
            return gamesWon;
        }

        void setUnderScore(String value)
        {
            underScore[gameNum] = Integer.parseInt(value);
        }

         void setUpperScore(String value)
        {
            upperScore[gameNum] = Integer.parseInt(value);
        }


         boolean GameWon() //checks if team's underscore >= 100
        {
            if(this.underScore[gameNum] >= 100)
            {
                gamesWon++;
                gameNum++;
                return true;

            }
           else
               return false;

        }






    }

    private static int gameNum = 0; //keeps count of the number of games in tot


    //updates activity
    void updateTrickScores(EditText newBox, EditText oldBox)
    {

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

    //updates the activity to the new horizontal line
    void updateHorizontal(View horizontal)
    {
        horizontal.setVisibility(View.VISIBLE);
    }

    String checkScore(EditText score)
    {
        String tmp = score.getText().toString();


        //Check if a value was entered. If not set the value to 0
        if(tmp.equals("")) {
            return "0";
        }
        else
            return tmp;

    }


    

}

