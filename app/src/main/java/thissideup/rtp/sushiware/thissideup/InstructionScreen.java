package thissideup.rtp.sushiware.thissideup;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

/**
 * Created by rtp_sensei on 4/5/15.
 */
public class InstructionScreen extends MyRootActivity {


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_instruction_screen);

    }

    public void goToPlay(View view){
        Intent i = new Intent(getApplicationContext(), PlayScreen.class);
        startActivity(i);
        finish();
    }

}