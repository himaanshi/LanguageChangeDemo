package com.paxcel.languagechangedemo;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import static com.paxcel.languagechangedemo.LocaleManager.LANGUAGE_ENGLISH;
import static com.paxcel.languagechangedemo.LocaleManager.LANGUAGE_FRENCH;
import static com.paxcel.languagechangedemo.LocaleManager.LANGUAGE_HINDI;

/*
Created by Himanshi on 23 August 2018
 */

public class SettingsActivity extends AppCompatActivity {


    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(LocaleManager.setLocale(base));
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.settings_activity);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        findViewById(R.id.en).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setNewLocale(LANGUAGE_ENGLISH, false);
            }
        });

        findViewById(R.id.hi).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setNewLocale(LANGUAGE_HINDI, false);
            }
        });

        findViewById(R.id.fr).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setNewLocale(LANGUAGE_FRENCH, false);
            }
        });
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private boolean setNewLocale(String language, boolean restartProcess) {

        LocaleManager.setNewLocale(this, language);

        Intent i = new Intent(this, MainActivity.class);
        startActivity(i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK));

        if (restartProcess) {
            System.exit(0);
        } else {
            Toast.makeText(this, "Activity restarted", Toast.LENGTH_SHORT).show();
        }
        return true;
    }
}