package thissideup.rtp.sushiware.thissideup;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by rtp_sensei on 4/5/15.
 */
public class ResultScreen extends MyRootActivity {

    private static final int score = 0;
    private SharedPreferences scores;
    String newString;
    TextView tv;
    ImageView iv;
    private SharedPrefsManager spm = new SharedPrefsManager();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result_screen);

        getIntentScore(savedInstanceState);
        getRank();

    }

    private void getIntentScore(Bundle savedInstanceState){

        if (savedInstanceState == null) {
            Bundle extras = getIntent().getExtras();
            if(extras == null) {
                newString= null;
            } else {
                newString= extras.getString("SCORE");
            }
        } else {
            newString= (String) savedInstanceState.getSerializable("SCORE");
        }

    }

    private void getRank(){
        //obtiene el ranking y lo imprime en pantalla
        tv = (TextView)findViewById(R.id.textScore);
        tv.setText(Integer.valueOf(newString) + " Pts.");
        String throphy = spm.compareRanks(newString, this.getApplicationContext());

        if(throphy.equals("GOLD")){

            tv = (TextView)findViewById(R.id.CongratText);
            tv.setText("you got "+throphy+"!");
            iv = (ImageView)findViewById(R.id.ThrophyContainer);
            iv.setImageResource(R.drawable.gold);


        }else if (throphy.equals("SILVER")){

            tv = (TextView)findViewById(R.id.CongratText);
            tv.setText("you got "+throphy+"!");
            iv = (ImageView)findViewById(R.id.ThrophyContainer);
            iv.setImageResource(R.drawable.silver);

        }else if (throphy.equals("BRONZE")){

            tv = (TextView)findViewById(R.id.CongratText);
            tv.setText("you got "+throphy+"!");
            iv = (ImageView)findViewById(R.id.ThrophyContainer);
            iv.setImageResource(R.drawable.bronze);

        }else {

            tv = (TextView)findViewById(R.id.CongratText);
            tv.setText("you got "+throphy+"!");
            iv = (ImageView)findViewById(R.id.ThrophyContainer);
            iv.setImageResource(R.drawable.nothing);

        }



    }



    public void playAgain(View view){

        Intent i = new Intent(getApplicationContext(), PlayScreen.class);
        startActivity(i);
        finish();
    }

    public void goToMenu(View view){

        Intent i = new Intent(getApplicationContext(), MenuScreen.class);
        startActivity(i);
        finish();
    }

}