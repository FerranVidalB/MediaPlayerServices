package com.ieselcaminas.pmdm.mediaplayerservices;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.util.Log;
import android.widget.Toast;

import java.io.IOException;

public class PlayMusic extends Service {

    private MediaPlayer mMediaPlayer;
    public PlayMusic() {
    }

    @Override
    public void onCreate(){
        super.onCreate();
        Log.d("ServicesX","onCreate");

        mMediaPlayer=MediaPlayer.create(this,R.raw.music);


    }

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        // We want this service to continue running until it is explicitly
        // stopped, so return sticky.

        mMediaPlayer.start();
        return START_STICKY;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mMediaPlayer.pause();
    }

}
