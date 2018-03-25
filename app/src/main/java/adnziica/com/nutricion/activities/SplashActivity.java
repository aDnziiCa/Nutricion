package adnziica.com.nutricion.activities;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.drawable.AnimationDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import java.util.Timer;
import java.util.TimerTask;

import adnziica.com.nutricion.GlobalConfiguration;
import adnziica.com.nutricion.R;

public class SplashActivity extends AppCompatActivity {

    SharedPreferences sharedPreferencesUser ;
    ImageView animation;
    Timer timer;
    MyTimerTask myTimerTask;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        setContentView(R.layout.activity_splash);




         animation = (ImageView)findViewById(R.id.ivImagen);
            animation.setBackgroundResource(R.drawable.splash);

        final AnimationDrawable frameAnimation =
                (AnimationDrawable) animation.getBackground();

        animation.post(new Runnable() {
            @Override
            public void run() {
                frameAnimation.start();
            }
        });

        int duration = 0;
        for(int i = 0; i < frameAnimation.getNumberOfFrames(); i++){
            duration += frameAnimation.getDuration(i);
        }

        timer = new Timer();
        myTimerTask = new MyTimerTask();
        timer.schedule(myTimerTask, duration);
        //frameAnimation.start();



    }

    class MyTimerTask extends TimerTask {

        @Override
        public void run() {

            timer.cancel();
   /*
   runOnUiThread(new Runnable(){
    @Override
    public void run() {
     Toast.makeText(getApplicationContext(),
       "Animation Stopped",
       Toast.LENGTH_SHORT).show();
    }});
   */


            sharedPreferencesUser = getSharedPreferences(GlobalConfiguration.SHARED_PREFERENCES_USER,MODE_PRIVATE);
            Intent intentMain = new Intent(SplashActivity.this, MainActivity.class);
            Intent intentLogin = new Intent(SplashActivity.this, LoginActivity.class);

            if (GlobalConfiguration.isChecked(sharedPreferencesUser)){
                startActivity(intentMain);
            }else{
                startActivity(intentLogin);
            }
            //frameAnimation.stop();
            finish();
        }
    }


}
