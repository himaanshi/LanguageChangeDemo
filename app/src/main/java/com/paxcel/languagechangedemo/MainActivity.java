package com.paxcel.languagechangedemo;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.Locale;

import static android.content.pm.PackageManager.GET_META_DATA;


/*
Created by Himanshi on 23 August 2018
 */

public class MainActivity extends AppCompatActivity {

    TextView textView;


    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(LocaleManager.setLocale(base));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView=findViewById(R.id.tv_name);

        showResourcesInfo();

        findViewById(R.id.settings).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,SettingsActivity.class));
            }
        });

        findViewById(R.id.home).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,Main2Activity.class));
            }
        });

    }


    private void showResourcesInfo() {

        TextView tv4 = findViewById(R.id.tv_locale);
        String defLanguage = Locale.getDefault().getLanguage();
        tv4.setText(String.format("Locale.getDefault() - %s", defLanguage));


    }








}
