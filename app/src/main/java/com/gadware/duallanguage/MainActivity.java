package com.gadware.duallanguage;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;

import androidx.databinding.DataBindingUtil;

import com.gadware.duallanguage.databinding.ActivityMainBinding;

public class MainActivity extends BaseLanguage {
    ActivityMainBinding binding;
    Context context;
    Resources resources;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        String l=SharedPrefManager.getInstance(this).getData("language");
        if (l.equals("bn")){
            binding.languageChangeSwitch.setChecked(true);
        }
        binding.languageChangeSwitch.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if (binding.languageChangeSwitch.isChecked()) {
                SharedPrefManager.getInstance(context).saveData("language", "bn");

            } else {
                SharedPrefManager.getInstance(context).saveData("language", "en");

            }

        });

        binding.tv.setOnClickListener(v -> {
            startActivity(new Intent(this, SecondActivity.class));
        });

    }
//    @Override
//    public void applyOverrideConfiguration(Configuration overrideConfiguration) {
//        if (overrideConfiguration != null) {
//            int uiMode = overrideConfiguration.uiMode;
//            overrideConfiguration.setTo(getBaseContext().getResources().getConfiguration());
//            overrideConfiguration.uiMode = uiMode;
//        }
//        super.applyOverrideConfiguration(overrideConfiguration);
//    }

}