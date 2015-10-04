package thissideup.rtp.sushiware.thissideup;

import android.os.Bundle;
import android.widget.TextView;

/**
 * Created by rtp_sensei on 4/5/15.
 */
public class HiScoreScreen extends MyRootActivity {

    private SharedPrefsManager spm = new SharedPrefsManager();
    private TextView tv;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hi_score_screen);
        displayRanks();
    }

    private void displayRanks(){

        int[] scoreArray = spm.getRanks(getApplicationContext());
        tv = (TextView)findViewById(R.id.TxtGold);
        tv.setText(scoreArray[0] + "pts");
        tv = (TextView)findViewById(R.id.TxtSilver);
        tv.setText(scoreArray[1] + "pts");
        tv = (TextView)findViewById(R.id.TxtBronze);
        tv.setText(scoreArray[2] + "pts");

    }



}