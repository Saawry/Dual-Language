package com.gadware.duallanguage;

import android.content.Context;
import android.content.ContextWrapper;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Locale;

public class BaseLanguage extends AppCompatActivity {
    @Override
    protected void attachBaseContext(Context newBase) {
        Locale locale=new Locale(SharedPrefManager.getInstance(newBase).getData("language"));
        ContextWrapper contextWrapper=ContextUtil.updateLocale(newBase,locale);
        super.attachBaseContext(contextWrapper);
    }


}
