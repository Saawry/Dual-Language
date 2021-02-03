package com.gadware.duallanguage;

import android.content.Intent;
import android.os.Bundle;

import androidx.databinding.DataBindingUtil;

import com.gadware.duallanguage.databinding.ActivitySecondBinding;

public class SecondActivity extends BaseLanguage {
ActivitySecondBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        binding= DataBindingUtil.setContentView(this,R.layout.activity_second);
        binding.tv.setText(R.string.demoText);
        binding.tv.setOnClickListener(v -> {
            startActivity(new Intent(this, MainActivity.class));
        });
    }
}