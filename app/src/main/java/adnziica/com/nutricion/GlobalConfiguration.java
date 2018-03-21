package adnziica.com.nutricion;

import android.content.SharedPreferences;

/**
 * Created by aDnziiCa on 18/03/2018.
 */

public class GlobalConfiguration {

    public static String SHARED_PREFERENCES_USER = "shared_preferences_user";

    public static boolean isChecked(SharedPreferences sharedPreferencesUser){

        return sharedPreferencesUser.getBoolean("isChecked",false);
    }

}
