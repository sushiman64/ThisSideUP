package thissideup.rtp.sushiware.thissideup;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

/**
 * Created by rtp_sensei on 4/5/15.
 */
public class MenuScreen extends MyRootActivity {

    int timesPlayed = 0;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_screen);
    }

    public void goToPlay(View view){

        if (timesPlayed==0){

            goToInstructionScreen(view);
            timesPlayed++;

        }else{
            Intent i = new Intent(getApplicationContext(), PlayScreen.class);
            startActivity(i);
        }


    }

    public void goToHiScore(View view){
        Intent i = new Intent(getApplicationContext(), HiScoreScreen.class);
        startActivity(i);
    }

    public void goToInstructionScreen(View view){
        Intent i = new Intent(getApplicationContext(), InstructionScreen.class);
        startActivity(i);
    }
}