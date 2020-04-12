package com.navigation.nightmode;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Trace;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity
        implements View.OnClickListener {

    SharedPreferences sharedPreferences;
    boolean isNightModeOn;
    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imageView=findViewById(R.id.header_image);
        sharedPreferences = getSharedPreferences("isDark", MODE_PRIVATE);
        isNightModeOn=sharedPreferences.getBoolean("isDark",false);
        Button enabledarkModeBtn = findViewById(R.id.switch_btn);
        enabledarkModeBtn.setOnClickListener(this);

        if (isNightModeOn){
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
            enabledarkModeBtn.setText("Enable Light Mode");
        }else {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
            enabledarkModeBtn.setText("Enable Dark Mode");

        }

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.switch_btn:
                if (isNightModeOn){
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putBoolean("isDark", false);
                    editor.apply();
                    Toast.makeText(this, "Dark Mode Enabled", Toast.LENGTH_SHORT).show();
                }else {
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putBoolean("isDark", true);
                    editor.apply();
                    Toast.makeText(this, "Light Mode Enabled", Toast.LENGTH_SHORT).show();
                }


                break;
        }

    }
}
