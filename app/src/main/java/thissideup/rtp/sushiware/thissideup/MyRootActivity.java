package thissideup.rtp.sushiware.thissideup;

import android.app.Activity;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;

import java.util.ArrayList;

/**
 * Created by rtp_sensei on 4/5/15.
 */
public class MyRootActivity extends ActionBarActivity {

    private static final String TAG = MyRootActivity.class.getName();
    private static ArrayList<Activity> activities = new ArrayList<Activity>();


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activities.add(this);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        getSupportActionBar().hide();//esconde el actionbar

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        activities.remove(this);
    }

    public void onPause(){
        super.onPause();
    }

    public void onResume(){
        super.onResume();
    }

    public void finish() {

        super.finish();
        activities.remove(this);
    }

    public static void finishAll() {
        for (Activity activity : activities)
            activity.finish();
    }
}