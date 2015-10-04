package thissideup.rtp.sushiware.thissideup;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.MotionEvent;

/**
 * Created by rtp_sensei on 4/5/15.
 */
public class SecondScreen extends MyRootActivity {


    private Handler handler;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_screen);
        //llama a nueva actividad despues de 5 segundos inicio
        handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Log.v("DEBUG TAG", "-----------------Second Screen changeing from handler----------------");

                jumpToNext();

            }
        },3000);
        //llama a nueva actividad despues de 5 segundos fin
    }
/*
    public boolean onTouchEvent(MotionEvent motionEvent){

        if (motionEvent.getAction()==motionEvent.ACTION_DOWN){
            handler.removeCallbacksAndMessages(null);
            jumpToNext();
            Log.v("DEBUG TAG", "-----------------Second Screen changing from action down ----------------");

        }
        return true;
    }
*/

    public void jumpToNext(){
        Intent i = new Intent(getApplicationContext(), MenuScreen.class);
        startActivity(i);
        finish();
        overridePendingTransition(R.layout.fadein,R.layout.fadeout);//metodo que usa layouts entre trancision.
    }



}
