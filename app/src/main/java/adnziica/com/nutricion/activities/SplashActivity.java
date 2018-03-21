package adnziica.com.nutricion.activities;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import adnziica.com.nutricion.GlobalConfiguration;

public class SplashActivity extends AppCompatActivity {

    SharedPreferences sharedPreferencesUser ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        sharedPreferencesUser = getSharedPreferences(GlobalConfiguration.SHARED_PREFERENCES_USER,MODE_PRIVATE);

        Intent intentMain = new Intent(SplashActivity.this, MainActivity.class);
        Intent intentLogin = new Intent(SplashActivity.this, LoginActivity.class);

        if (GlobalConfiguration.isChecked(sharedPreferencesUser)){
            startActivity(intentMain);
        }else{
            startActivity(intentLogin);
        }
        finish();

    }
}
