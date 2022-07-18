package com.tuan.designpattern;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.tuan.designpattern.databinding.ActivityDetailBinding;

public class DetailActivity extends AppCompatActivity {
    private ActivityDetailBinding mBinding;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = ActivityDetailBinding.inflate(getLayoutInflater());
        setContentView(mBinding.getRoot());
    }
}
