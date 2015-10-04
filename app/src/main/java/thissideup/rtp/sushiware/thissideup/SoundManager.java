package thissideup.rtp.sushiware.thissideup;

import android.app.Activity;
import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.SoundPool;
import android.util.Log;
import android.util.SparseArray;

import java.util.HashMap;

/**
 * Created by rtp_sensei on 5/19/15.
 */
public class SoundManager {

    public static int SOUNDPOOLSND_CORRECT = 0;


    public static boolean isSoundTurnedOn;

    private static SoundManager mSoundManager;

    private SoundPool mSoundPool;
    private SparseArray<Integer> mSoundPoolMap;
    private AudioManager  mAudioManager;
    private MediaPlayer mediaPlayer;

    public static final int maxSounds = 4;

    public static SoundManager getInstance(Context context) {
        if (mSoundManager == null){
            mSoundManager = new SoundManager(context);
        }

        return mSoundManager;
    }

    public SoundManager(Context mContext) {
        mAudioManager = (AudioManager)mContext.getSystemService(Context.AUDIO_SERVICE);
        mSoundPool = new SoundPool(maxSounds, AudioManager.STREAM_MUSIC, 0);

        mSoundPool.setOnLoadCompleteListener(new SoundPool.OnLoadCompleteListener() {
            public void onLoadComplete(SoundPool soundPool, int sampleId,int status) {
               isSoundTurnedOn = true;
            }
        });

        mSoundPoolMap = new SparseArray<Integer>();
        mSoundPoolMap.put(SOUNDPOOLSND_CORRECT, mSoundPool.load(mContext, R.raw.correct, 1));


        /*/ testing simultaneous playing
        int streamVolume = mAudioManager.getStreamVolume(AudioManager.STREAM_MUSIC);
        mSoundPool.play(mSoundPoolMap.get(0), streamVolume, streamVolume, 1, -1, 1f);
        mSoundPool.play(mSoundPoolMap.get(1), streamVolume, streamVolume, 1, 20, 1f);*/


    }

    public void playSound() {
        if (isSoundTurnedOn) {


            int streamVolume = mAudioManager.getStreamVolume(AudioManager.STREAM_MUSIC);
            mSoundPool.play(mSoundPoolMap.get(SOUNDPOOLSND_CORRECT), streamVolume, streamVolume, 1, 0, 1f);
        }
    }

    public void playLoop(Context context){

        mediaPlayer = MediaPlayer.create(context, R.raw.playbackgroundmusic);
        mediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
        mediaPlayer.setLooping(true);
        mediaPlayer.start();

    }

    public void stopLoop(){

        mediaPlayer.stop();
        mediaPlayer.release();
    }

    public static void clear() {
        if (mSoundManager != null){
            mSoundManager.mSoundPool = null;
            mSoundManager.mAudioManager = null;
            mSoundManager.mSoundPoolMap = null;
            mSoundManager.mediaPlayer = null;
        }
        mSoundManager = null;
    }
}