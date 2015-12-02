package com.mycompany.boomwtf;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.TransitionDrawable;
import android.media.MediaPlayer;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

import java.io.IOException;

import pl.droidsonroids.gif.GifDrawable;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        LinearLayout linlay=(LinearLayout)findViewById(R.id.linearlayout1);
        linlay.setBackgroundColor(Color.parseColor("#000000"));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void startboom(View view) throws IOException {
        // start the audio file
        MediaPlayer mp = MediaPlayer.create(getApplicationContext(), R.raw.wtfboomsound2);
        // disable the button after clicking

        final LinearLayout linlay=(LinearLayout)findViewById(R.id.linearlayout1);
        Button button1= (Button)linlay.findViewById(R.id.button1);
        button1.setEnabled(false);
       // final LinearLayout linlay2=(LinearLayout)findViewById(R.id.linearlayout2);
       // final LinearLayout linlay3=(LinearLayout)findViewById(R.id.linearlayout3);
       // final GifDrawable gif2 = new GifDrawable( getResources(), R.drawable.boomstart3 );
       // final GifDrawable gif3 = new GifDrawable( getResources(), R.drawable.boomintermed );
        linlay.setBackgroundColor(Color.parseColor("#000000"));
        // create and apply blink
        ColorDrawable[] colorBlink = {new ColorDrawable(Color.parseColor("#FF0000")), new ColorDrawable(Color.parseColor("#000000"))};
        final TransitionDrawable trans = new TransitionDrawable(colorBlink);

        mp.start();
        //blink timing, timing for new gif layout
        linlay.setBackgroundDrawable(trans);
        trans.startTransition(100);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                trans.startTransition(100);
            }
        }, 200);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                trans.startTransition(100);
            }
        }, 400);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                trans.startTransition(100);
            }
        }, 600);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                trans.startTransition(100);
            }
        }, 800);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                setContentView(R.layout.boomstart);
            }
        }, 950);
       // new Handler().postDelayed(new Runnable() {

        //    public void run() {
         //       gif2.recycle();
       //    }
      //  }, 1800);
        new Handler().postDelayed(new Runnable() {

            public void run() {
                setContentView(R.layout.activity_boom_gif);
              //  gif3.recycle();
            }
        }, 3350);
        new Handler().postDelayed(new Runnable() {

            public void run() {

                System.gc();
                finish();
            }
        }, 8200);
    }
}
