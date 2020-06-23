package newcampusa.newproject.countkoto;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import android.content.Intent;
import android.content.SharedPreferences;
import android.media.Image;
import android.net.Uri;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText Ne,Nm,Tex,Den,Spd,Wool,Wor;
    private ImageView NeCalc,NmCalc,TexCalc,DenCalc,SpdCalc,WoolCalc,WorCalc;
    private long backPressedTime ;
    private Toast backToast;

    private SharedPreferences AppSettingsPref;
    private Boolean isNightMode;
    private SharedPreferences.Editor mEditor;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportActionBar().setSubtitle("All-in-one Textile Count Solution");

        AppSettingsPref = getSharedPreferences("AppSettings",0);
        isNightMode = AppSettingsPref.getBoolean("NightMode", false);
        mEditor = AppSettingsPref.edit();

        if(isNightMode){
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
        }
        else{
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
        }

        Ne = (EditText)findViewById(R.id.editText_ne);
        Nm = (EditText)findViewById(R.id.editText_nm);
        Tex = (EditText)findViewById(R.id.editText_tex);
        Den = (EditText)findViewById(R.id.editText_den);
        Spd = (EditText)findViewById(R.id.editText_spd);
        Wool = (EditText)findViewById(R.id.editText_woolen);
        Wor = (EditText)findViewById(R.id.editText_wor);

        NeCalc = (ImageView)findViewById(R.id.calc_ne);
        NmCalc = (ImageView)findViewById(R.id.calc_nm);
        TexCalc = (ImageView)findViewById(R.id.calc_tex);
        DenCalc = (ImageView)findViewById(R.id.calc_den);
        SpdCalc = (ImageView)findViewById(R.id.calc_spd);
        WoolCalc = (ImageView)findViewById(R.id.calc_woolen);
        WorCalc = (ImageView)findViewById(R.id.calc_wor);



        Ne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String ne_string = Ne.getText().toString();
                if(ne_string.length() >0){
                    NeCalc.setVisibility(View.VISIBLE);
                    NmCalc.setVisibility(View.INVISIBLE);
                    TexCalc.setVisibility(View.INVISIBLE);
                    DenCalc.setVisibility(View.INVISIBLE);
                    SpdCalc.setVisibility(View.INVISIBLE);
                    WoolCalc.setVisibility(View.INVISIBLE);
                    WorCalc.setVisibility(View.INVISIBLE);

                }
                else{
                    Toast.makeText(MainActivity.this,"Enter a value first !", Toast.LENGTH_SHORT).show();
                    NeCalc.setVisibility(View.INVISIBLE);
                }
            }
        });

        Nm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nm_string = Nm.getText().toString();
                if(nm_string.length() > 0){
                    NmCalc.setVisibility(View.VISIBLE);
                    TexCalc.setVisibility(View.INVISIBLE);
                    NeCalc.setVisibility(View.INVISIBLE);
                    DenCalc.setVisibility(View.INVISIBLE);
                    SpdCalc.setVisibility(View.INVISIBLE);
                    WoolCalc.setVisibility(View.INVISIBLE);
                    WorCalc.setVisibility(View.INVISIBLE);
                }
                else{
                    Toast.makeText(MainActivity.this,"Enter a value first !", Toast.LENGTH_SHORT).show();
                    NmCalc.setVisibility(View.INVISIBLE);
                }
            }
        });


        Tex.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String tex_string = Tex.getText().toString();
                if(tex_string.length() >0 ){
                    TexCalc.setVisibility(View.VISIBLE);
                    NmCalc.setVisibility(View.INVISIBLE);
                    NeCalc.setVisibility(View.INVISIBLE);
                    DenCalc.setVisibility(View.INVISIBLE);
                    SpdCalc.setVisibility(View.INVISIBLE);
                    WoolCalc.setVisibility(View.INVISIBLE);
                    WorCalc.setVisibility(View.INVISIBLE);
                }
                else{
                    Toast.makeText(MainActivity.this,"Enter a value first !", Toast.LENGTH_SHORT).show();
                    TexCalc.setVisibility(View.INVISIBLE);
                }
            }
        });
        Den.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String den_string = Den.getText().toString();
                if(den_string.length() > 0){
                    DenCalc.setVisibility(View.VISIBLE);
                    TexCalc.setVisibility(View.INVISIBLE);
                    NmCalc.setVisibility(View.INVISIBLE);
                    NeCalc.setVisibility(View.INVISIBLE);
                    SpdCalc.setVisibility(View.INVISIBLE);
                    WoolCalc.setVisibility(View.INVISIBLE);
                    WorCalc.setVisibility(View.INVISIBLE);
                }
                else{
                    Toast.makeText(MainActivity.this,"Enter a value first !", Toast.LENGTH_SHORT).show();
                    DenCalc.setVisibility(View.INVISIBLE);
                }
            }
        });
        Spd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String spd_string = Spd.getText().toString();
                if(spd_string.length() > 0){
                    SpdCalc.setVisibility(View.VISIBLE);
                    DenCalc.setVisibility(View.INVISIBLE);
                    WoolCalc.setVisibility(View.INVISIBLE);
                    WorCalc.setVisibility(View.INVISIBLE);
                    TexCalc.setVisibility(View.INVISIBLE);
                    NmCalc.setVisibility(View.INVISIBLE);
                    NeCalc.setVisibility(View.INVISIBLE);
                }
                else{
                    Toast.makeText(MainActivity.this,"Enter a value first !", Toast.LENGTH_SHORT).show();
                    SpdCalc.setVisibility(View.INVISIBLE);
                }
            }
        });
        Wool.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String wool_string = Wool.getText().toString();
                if(wool_string.length() >0){
                    WoolCalc.setVisibility(View.VISIBLE);
                    SpdCalc.setVisibility(View.INVISIBLE);
                    DenCalc.setVisibility(View.INVISIBLE);
                    WorCalc.setVisibility(View.INVISIBLE);
                    TexCalc.setVisibility(View.INVISIBLE);
                    NmCalc.setVisibility(View.INVISIBLE);
                    NeCalc.setVisibility(View.INVISIBLE);
                }
                else{
                    Toast.makeText(MainActivity.this,"Enter a value first !", Toast.LENGTH_SHORT).show();
                    WoolCalc.setVisibility(View.INVISIBLE);
                }
            }
        });
        Wor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String wor_string = Wor.getText().toString();
                if(wor_string.length() >0){
                    WorCalc.setVisibility(View.VISIBLE);
                    SpdCalc.setVisibility(View.INVISIBLE);
                    DenCalc.setVisibility(View.INVISIBLE);
                    WoolCalc.setVisibility(View.INVISIBLE);
                    TexCalc.setVisibility(View.INVISIBLE);
                    NmCalc.setVisibility(View.INVISIBLE);
                    NeCalc.setVisibility(View.INVISIBLE);

                }
                else{
                    Toast.makeText(MainActivity.this,"Enter a value first !", Toast.LENGTH_SHORT).show();
                    WorCalc.setVisibility(View.INVISIBLE);
                }
            }
        });






        NeCalc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    String ne_string = Ne.getText().toString();
                    Double ne_value = Double.parseDouble(ne_string);
                    Double nm_value = 1.693*ne_value;
                    Double tex_value = 590.6/ne_value;
                    Double den_value = 5315/ne_value;
                    Double spd_value = (120/(7*ne_value));
                    Double woolen_value = (3.28125)*ne_value;
                    Double worsted_value = 1.5*ne_value;
                    String nm_str = nm_value.toString();
                    String tex_str = tex_value.toString();
                    String den_str = den_value.toString();
                    String spd_str = spd_value.toString();
                    String woolen_str = woolen_value.toString();
                    String worsted_str = worsted_value.toString();
                    Nm.setText(nm_str);
                    Tex.setText(tex_str);
                    Den.setText(den_str);
                    Spd.setText(spd_str);
                    Wool.setText(woolen_str);
                    Wor.setText(worsted_str);
                }catch (Exception e){
                    Toast.makeText(MainActivity.this,"Invalid Input", Toast.LENGTH_SHORT).show();
                    Nm.setText("");
                    Tex.setText("");
                    Den.setText("");
                    Spd.setText("");
                    Wool.setText("");
                    Wor.setText("");
                }
            }
        });

        NmCalc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try{
                    String nm_string = Nm.getText().toString();
                    Double nm_value = Double.parseDouble(nm_string);
                    Double ne_value = nm_value/1.693;
                    Double tex_value = 590.6/ne_value;
                    Double den_value = 5315/ne_value;
                    Double spd_value = (120/(7*ne_value));
                    Double woolen_value = (3.28125)*ne_value;
                    Double worsted_value = 1.5*ne_value;
                    String ne_str = ne_value.toString();
                    String tex_str = tex_value.toString();
                    String den_str = den_value.toString();
                    String spd_str = spd_value.toString();
                    String woolen_str = woolen_value.toString();
                    String worsted_str = worsted_value.toString();
                    Ne.setText(ne_str);
                    Tex.setText(tex_str);
                    Den.setText(den_str);
                    Spd.setText(spd_str);
                    Wool.setText(woolen_str);
                    Wor.setText(worsted_str);

                }catch (Exception e){
                    Toast.makeText(MainActivity.this,"Invalid Input", Toast.LENGTH_SHORT).show();
                    Ne.setText("");
                    Tex.setText("");
                    Den.setText("");
                    Spd.setText("");
                    Wool.setText("");
                    Wor.setText("");
                }
            }
        });

        //

        TexCalc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try{
                    String tex_string = Tex.getText().toString();
                    Double tex_value = Double.parseDouble(tex_string);
                    Double ne_value = 590.6/tex_value;
                    Double nm_value = 1.693*ne_value;
                    Double den_value = 5315/ne_value;
                    Double spd_value = (120/(7*ne_value));
                    Double woolen_value = (3.28125)*ne_value;
                    Double worsted_value = 1.5*ne_value;
                    String ne_str = ne_value.toString();
                    String nm_str = nm_value.toString();
                    String den_str = den_value.toString();
                    String spd_str = spd_value.toString();
                    String woolen_str = woolen_value.toString();
                    String worsted_str = worsted_value.toString();
                    Ne.setText(ne_str);
                    Nm.setText(nm_str);
                    Den.setText(den_str);
                    Spd.setText(spd_str);
                    Wool.setText(woolen_str);
                    Wor.setText(worsted_str);
                }catch (Exception e){
                    Toast.makeText(MainActivity.this,"Invalid Input", Toast.LENGTH_SHORT).show();
                    Ne.setText("");
                    Nm.setText("");
                    Den.setText("");
                    Spd.setText("");
                    Wool.setText("");
                    Wor.setText("");
                }
            }
        });

        DenCalc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try{
                    String den_string = Den.getText().toString();
                    Double den_value = Double.parseDouble(den_string);
                    Double ne_value = 5315/den_value;
                    Double tex_value = 590.6/ne_value;
                    Double nm_value = 1.694*ne_value;
                    Double spd_value = (120/(7*ne_value));
                    Double woolen_value = (3.28125)*ne_value;
                    Double worsted_value = 1.5*ne_value;
                    String ne_str = ne_value.toString();
                    String tex_str = tex_value.toString();
                    String nm_str = nm_value.toString();
                    String spd_str = spd_value.toString();
                    String woolen_str = woolen_value.toString();
                    String worsted_str = worsted_value.toString();
                    Ne.setText(ne_str);
                    Tex.setText(tex_str);
                    Nm.setText(nm_str);
                    Spd.setText(spd_str);
                    Wool.setText(woolen_str);
                    Wor.setText(worsted_str);

                }catch (Exception e){
                    Toast.makeText(MainActivity.this,"Invalid Input", Toast.LENGTH_SHORT).show();
                    Ne.setText("");
                    Tex.setText("");
                    Nm.setText("");
                    Spd.setText("");
                    Wool.setText("");
                    Wor.setText("");
                }
            }
        });

        SpdCalc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try{
                    String spd_string = Spd.getText().toString();
                    Double spd_value = Double.parseDouble(spd_string);
                    Double ne_value = 17.142857142857142/spd_value;
                    Double tex_value = 590.6/ne_value;
                    Double den_value = 5315/ne_value;
                    Double nm_value = (1.693*ne_value);
                    Double woolen_value = (3.28125)*ne_value;
                    Double worsted_value = 1.5*ne_value;
                    String ne_str = ne_value.toString();
                    String tex_str = tex_value.toString();
                    String den_str = den_value.toString();
                    String nm_str = nm_value.toString();
                    String woolen_str = woolen_value.toString();
                    String worsted_str = worsted_value.toString();
                    Ne.setText(ne_str);
                    Tex.setText(tex_str);
                    Den.setText(den_str);
                    Nm.setText(nm_str);
                    Wool.setText(woolen_str);
                    Wor.setText(worsted_str);

                }catch (Exception e){
                    Toast.makeText(MainActivity.this,"Invalid Input", Toast.LENGTH_SHORT).show();
                    Ne.setText("");
                    Tex.setText("");
                    Den.setText("");
                    Nm.setText("");
                    Wool.setText("");
                    Wor.setText("");
                }
            }
        });

        WoolCalc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try{
                    String wool_string = Wool.getText().toString();
                    Double wool_value = Double.parseDouble(wool_string);
                    Double ne_value = wool_value/3.28125;
                    Double tex_value = 590.6/ne_value;
                    Double den_value = 5315/ne_value;
                    Double spd_value = (120/(7*ne_value));
                    Double nm_value = 1.693*ne_value;
                    Double worsted_value = 1.5*ne_value;
                    String ne_str = ne_value.toString();
                    String tex_str = tex_value.toString();
                    String den_str = den_value.toString();
                    String spd_str = spd_value.toString();
                    String nm_str = nm_value.toString();
                    String worsted_str = worsted_value.toString();
                    Ne.setText(ne_str);
                    Tex.setText(tex_str);
                    Den.setText(den_str);
                    Spd.setText(spd_str);
                    Nm.setText(nm_str);
                    Wor.setText(worsted_str);

                }catch (Exception e){
                    Toast.makeText(MainActivity.this,"Invalid Input", Toast.LENGTH_SHORT).show();
                    Ne.setText("");
                    Tex.setText("");
                    Den.setText("");
                    Spd.setText("");
                    Nm.setText("");
                    Wor.setText("");
                }
            }
        });

        WorCalc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try{
                    String wor_string = Wor.getText().toString();
                    Double wor_value = Double.parseDouble(wor_string);
                    Double ne_value = wor_value/1.5;
                    Double tex_value = 590.6/ne_value;
                    Double den_value = 5315/ne_value;
                    Double spd_value = (120/(7*ne_value));
                    Double nm_value = 1.693*ne_value;
                    Double wool_value = (3.28125)*ne_value;
                    String ne_str = ne_value.toString();
                    String tex_str = tex_value.toString();
                    String den_str = den_value.toString();
                    String spd_str = spd_value.toString();
                    String nm_str = nm_value.toString();
                    String wool_str = wool_value.toString();
                    Ne.setText(ne_str);
                    Tex.setText(tex_str);
                    Den.setText(den_str);
                    Spd.setText(spd_str);
                    Nm.setText(nm_str);
                    Wool.setText(wool_str);

                }catch (Exception e){
                    Toast.makeText(MainActivity.this,"Invalid Input", Toast.LENGTH_SHORT).show();
                    Ne.setText("");
                    Tex.setText("");
                    Den.setText("");
                    Spd.setText("");
                    Nm.setText("");
                    Wool.setText("");
                }
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.top_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.about:
                Intent intent = new Intent(MainActivity.this, About_activity.class);
                startActivity(intent);
                break;
            case R.id.settings:
                Intent intent10 = new Intent(MainActivity.this, customSettings.class);
                startActivity(intent10);
                break;
            case R.id.refresh:
                Intent intent2 = new Intent(MainActivity.this, MainActivity.class);
                startActivity(intent2);
                finish();
                break;
            case R.id.length_wt_count:
                Intent intent3 = new Intent(MainActivity.this, weight_length2count.class);
                startActivity(intent3);
                break;
            case R.id.count_length:
                Intent intent4 = new Intent(MainActivity.this, count2length.class);
                startActivity(intent4);
                break;
            case R.id.count_weight:
                Intent intent5 = new Intent(MainActivity.this, count2weight.class);
                startActivity(intent5);
                break;
            case R.id.useful:
                Intent intent6 = new Intent(MainActivity.this, useful_units.class);
                startActivity(intent6);
                break;
            case R.id.fabric_math:
                Intent intent7 = new Intent(MainActivity.this, fabric_calc.class);
                startActivity(intent7);
                break;
            case R.id.rate_btn:
                try {
                    startActivity(new Intent(Intent.ACTION_VIEW,
                            Uri.parse("market://details?id="+getPackageName())
                            ));

                }catch (Exception e){
                    startActivity(new Intent(Intent.ACTION_VIEW,
                            Uri.parse("https://play.google.com/store/apps/details?id="+getPackageName())
                    ));
                }
                break;
            case R.id.exit_app:
                finish();
                super.onBackPressed();
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {

        if(backPressedTime + 2000 > System.currentTimeMillis()){
            super.onBackPressed();
            return;
        }
        else{
            backToast = Toast.makeText(getBaseContext(), "Press back 2 times to exit the app", Toast.LENGTH_SHORT);
            backToast.show();
        }
        backPressedTime =System.currentTimeMillis();
    }
}
