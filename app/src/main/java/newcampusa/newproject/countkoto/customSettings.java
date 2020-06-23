package newcampusa.newproject.countkoto;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class customSettings extends AppCompatActivity {

    private Button themeBtn;

    private SharedPreferences AppSettingsPref;
    private Boolean isNightMode;
    private SharedPreferences.Editor mEditor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_settings);

        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setTitle("Settings");

        AppSettingsPref = getSharedPreferences("AppSettings",0);
        isNightMode = AppSettingsPref.getBoolean("NightMode", false);
        mEditor = AppSettingsPref.edit();

        if(isNightMode){
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
        }
        else{
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
        }

        themeBtn = (Button)findViewById(R.id.button_theme);

        themeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(isNightMode){
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
                    mEditor.putBoolean("NightMode", false);
                    mEditor.apply();
                }
                else{
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
                    mEditor.putBoolean("NightMode", true);
                    mEditor.apply();
                }
            }
        });
    }
}