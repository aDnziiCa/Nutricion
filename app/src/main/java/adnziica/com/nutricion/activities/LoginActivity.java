package adnziica.com.nutricion.activities;

import android.app.ActionBar;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.Toast;

import adnziica.com.nutricion.GlobalConfiguration;
import adnziica.com.nutricion.R;

import static adnziica.com.nutricion.GlobalConfiguration.SHARED_PREFERENCES_USER;

/**
 * Created by aDnziiCa
 * on 08/02/2018.
 */

public class LoginActivity extends AppCompatActivity {

    Button btnLogin;
    EditText etUsername, etPassword;
    Switch stUsername;
    Context context;
    SharedPreferences sharedPreferencesUser;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        //getSupportActionBar().setLogo(R.mipmap.ic_launcher);
        //getSupportActionBar().setDisplayUseLogoEnabled(true);
        //getSupportActionBar().setDisplayShowHomeEnabled(true);

        context=this;
        sharedPreferencesUser = getSharedPreferences(SHARED_PREFERENCES_USER,MODE_PRIVATE);
        bindUI();
        setLoginPreferences(sharedPreferencesUser);


            btnLogin.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    String  codeUser = etUsername.getText().toString();

                    String password = etPassword.getText().toString();

                    if(login(codeUser,password)) {
                    Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                    startActivity(intent);
                    saveUserPreferences(codeUser,password);
                    }
                }
            });


    }


    private void bindUI(){
        btnLogin = findViewById(R.id.btn_login);
        etUsername = findViewById(R.id.etCodePatient);
        etPassword = findViewById(R.id.etPassword);
        stUsername = findViewById(R.id.stUser);

    }


    private boolean isValidCodeUser(String codeUser){
        return !TextUtils.isEmpty(codeUser) && codeUser.length()>0;
    }

    private boolean isValidPassword(String password){
        return !TextUtils.isEmpty(password) && password.length()>0;
    }

    private boolean login(String codeUser, String password){

        if(!isValidCodeUser(codeUser)){

            Toast.makeText(context, "El codigo de paciente no puede estar vacio", Toast.LENGTH_SHORT).show();
            return false;
        }else if(!isValidPassword(password)){
            Toast.makeText(context, "La contraseña no puede estar vacia", Toast.LENGTH_SHORT).show();
            return false;
        }
        else{
            return true;
        }

    }

    private void saveUserPreferences(String codeUser, String password){
        SharedPreferences.Editor editor = sharedPreferencesUser.edit();

        if (stUsername.isChecked()){
            editor.putString("codeUser",codeUser);
            editor.putString("password",password);
            editor.putBoolean("isChecked",true);
            //editor.commit();

        }else{
            editor.putString("codeUser","");
            editor.putString("password","");
            editor.putBoolean("isChecked",false);
        }
        editor.apply();

    }

    private void setLoginPreferences(SharedPreferences sharedPreferencesUser){

        boolean isChecked = GlobalConfiguration.isChecked(sharedPreferencesUser);

        if (isChecked){
            etUsername.setText(sharedPreferencesUser.getString("codeUser",""));
            stUsername.setChecked(isChecked);
        }


    }




}
