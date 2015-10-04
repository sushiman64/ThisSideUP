package thissideup.rtp.sushiware.thissideup;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;


public class FirstScreen extends MyRootActivity  {

    private Handler handler;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first_screen);

        //llama a nueva actividad despues de 5 segundos inicio
        handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                jumpToNext();
                Log.v("DEBUG TAG", "-----------------First Screen changing from handler----------------");

            }
        },3000);


        //llama a nueva actividad despues de 5 segundos fin

    }
/*
    public boolean onTouchEvent(MotionEvent motionEvent){

        if (motionEvent.getAction()==motionEvent.ACTION_DOWN){
            handler.removeCallbacksAndMessages(null);
            Log.v("DEBUG TAG", "-----------------First Screen changeing from action down----------------");

            jumpToNext();

        }
        return true;
    }*/


    public void jumpToNext(){
        Intent i = new Intent(getApplicationContext(), SecondScreen.class);
        startActivity(i);
        finish();
        overridePendingTransition(R.layout.fadein,R.layout.fadeout);//metodo que usa layouts entre trancision.
    }

}
