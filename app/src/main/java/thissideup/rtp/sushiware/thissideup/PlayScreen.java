package thissideup.rtp.sushiware.thissideup;

import android.content.Intent;
import android.hardware.SensorManager;
import android.media.MediaPlayer;
import android.media.SoundPool;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.Log;
import android.view.OrientationEventListener;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

/**
 * Created by rtp_sensei on 4/5/15.
 */
public class PlayScreen extends MyRootActivity {

    private static String TAG;
    private TextView scoreView;
    private TextView seconds;
    private int score = 0;
    private OrientationEventListener oel;
    private SoundManager sm;
    private int previousInt = 0;



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play_screen);
        gameLoop();
    }

    public void onPause(){

        super.onPause();
        //sm.stopLoop();
    }

    public void onResume(){

        super.onResume();
       /* Intent i = new Intent(getApplicationContext(), MenuScreen.class);
        startActivity(i);
        finish();*/

    }

    private void gameLoop() {

        scoreView = (TextView) findViewById(R.id.ScoreCounter);
        seconds = (TextView) findViewById(R.id.textSeconds);

        sm =  new SoundManager(this.getApplicationContext());
        playBackgroundMusic();

        //test code
        oel = new OrientationEventListener(this, SensorManager.SENSOR_DELAY_NORMAL) {

            int x = RNG();
            int threshold = 10;

            @Override
            public void onOrientationChanged(int orientation) {

                //scoreView.setText(String.valueOf(orientation));
                Log.v("DEBUG_TAG", "orientation changed to: " + orientation);
                if (orientation <= x + threshold && orientation >= x - threshold) {

                    correctSound();
                    x = RNG();
                    score++;
                    scoreView.setText(String.valueOf(score));
                }
            }
        };

        if (oel.canDetectOrientation()) {//ES IMPORTANTE DARLE EN ENABLE AL OEL
            oel.enable();
        } else {
            Toast.makeText(this, "Cannot orientate", Toast.LENGTH_LONG).show();
            oel.disable();
            finishAll();
        }
        //test code
        new CountDownTimer(11000, 1000){

            public void onTick(long millisUntilFinished) {
                seconds.setText( String.valueOf(millisUntilFinished / 1000));
            }

            public void onFinish() {
                seconds.setText("TIME UP!");
                Log.v("DEBUG_TAG", "terminando juego iniciando result screen");
                gameOver();

            }
        }.start();

    }// fin de gameLoop();

    private void gameOver() {

        stopBackgroundMusic();
        Intent intento = new Intent(getApplicationContext(), ResultScreen.class);
        intento.putExtra("SCORE", String.valueOf(score));
        oel.disable();
        startActivity(intento);
        finish();
        overridePendingTransition(R.layout.fadein, R.layout.fadeout);//metodo que usa layouts entre trancision.

    }//fin del gameOver()

    private int RNG() {

        Random r = new Random();
        int currentInt = 0;

        currentInt = r.nextInt(4);
        int[] array = {0, 90, 180, 270};
        //en 0 de 350 a 10
        //en 90 de 80 a 100
        //en 180 de 170 a 190
        //en 270 de 260 a 280*/



        while(currentInt==previousInt){
            currentInt = r.nextInt(4);

        }

        previousInt = currentInt;
        changeImageOrientation(array[currentInt]);

        return array[currentInt];
    }//fin del RNG()

    private void changeImageOrientation(int orientationNumber) {

        switch (orientationNumber) {

            case 0:
                ImageView i = (ImageView) findViewById(R.id.imageContainer);
                i.setImageResource(R.drawable.thisup1);
                break;

            case 90:
                i = (ImageView) findViewById(R.id.imageContainer);
                i.setImageResource(R.drawable.thisup4);
                break;

            case 180:
                i = (ImageView) findViewById(R.id.imageContainer);
                i.setImageResource(R.drawable.thisup3);
                break;

            case 270:
                i = (ImageView) findViewById(R.id.imageContainer);
                i.setImageResource(R.drawable.thisup2);
                break;

            default:

                break;

        }

    }

    private void playBackgroundMusic() {

        sm.playLoop(this.getApplicationContext());
        Log.v("DEBUG TAG", "-----------------playing Backgrund----------------");
    }

    private void stopBackgroundMusic() {

        sm.stopLoop();
        Log.v("DEBUG TAG", "-----------------STOPPING BACKGRUND----------------");

    }

    private void correctSound(){

        sm.playSound();
        Log.v("DEBUG TAG", "-----------------CORRECT----------------");

    }


}










