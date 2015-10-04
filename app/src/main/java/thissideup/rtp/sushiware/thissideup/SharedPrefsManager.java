package thissideup.rtp.sushiware.thissideup;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

/**
 * Created by rtp_sensei on 5/26/15.
 */
public class SharedPrefsManager {

    private static String MY_PREFS_NAME = "ThisSidePrefs";
    private static String GOLD_STRING = "gold";
    private static String SILVER_STRING = "silver";
    private static String BRONZE_STRING = "bronze";
    private static String OVERWRITE_STRING = "overwrite";

    private SharedPreferences data;





    private void genSharedPref(){

        SharedPreferences.Editor editor = data.edit();
        editor.putInt(OVERWRITE_STRING, 1);
        editor.putInt(GOLD_STRING, 13);
        editor.putInt(SILVER_STRING, 10);
        editor.putInt(BRONZE_STRING, 6);
        Log.v("DEBUG TAG", "-----------------INITIALIZING PREFERENCES----------------");

        editor.commit();
    }

    public int[] getRanks(Context mContext){

        data = mContext.getSharedPreferences(MY_PREFS_NAME, Context.MODE_PRIVATE);
        int [] scoreArr = new int[3];

        scoreArr[0] = data.getInt(GOLD_STRING, 13);
        scoreArr[1] = data.getInt(SILVER_STRING, 10);
        scoreArr[2] = data.getInt(BRONZE_STRING, 6);


        return scoreArr;
    }

    public String compareRanks(String cScore, Context mContext){

        data = mContext.getSharedPreferences(MY_PREFS_NAME, Context.MODE_PRIVATE);
        int strPref = data.getInt(OVERWRITE_STRING, 0);
        String a;

        if (strPref != 0){
            return a =  saveRank(cScore);
        }else{
            genSharedPref();
            return a = saveRank(cScore);
        }

    }


    private String saveRank(String score){

        int newScore = Integer.parseInt(score);
        int gold = data.getInt(GOLD_STRING, 13);
        int silver = data.getInt(SILVER_STRING, 10);
        int bronze = data.getInt(BRONZE_STRING, 6);
        SharedPreferences.Editor editor = data.edit();

        if (newScore>=gold){

            editor.putInt(GOLD_STRING, newScore);
            Log.v("DEBUG TAG", "-----------------CHANGING GOLD SCORE PREFERENCE----------------");
            editor.commit();
            return "GOLD";

        }else if(newScore>=silver){

            editor.putInt(SILVER_STRING, newScore);
            Log.v("DEBUG TAG", "-----------------CHANGING SILVER SCORE PREFERENCE----------------");
            editor.commit();
            return "SILVER";

        }else if(newScore>=bronze){

            editor.putInt(BRONZE_STRING, newScore);
            Log.v("DEBUG TAG", "-----------------CHANGING BRONZE SCORE PREFERENCE----------------");
            editor.commit();
            return "BRONZE";
        }else{
            return "NOTHING";
        }
    }

}
