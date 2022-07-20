package com.tuan.designpattern;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.tuan.designpattern.databinding.ActivityDetailBinding;
import com.tuan.designpattern.model.Car;
import com.tuan.designpattern.singleton.MySingleton;

public class DetailActivity extends AppCompatActivity {
    private ActivityDetailBinding mBinding;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = ActivityDetailBinding.inflate(getLayoutInflater());
        setContentView(mBinding.getRoot());

        setData();

        mBinding.btnBack.setOnClickListener(v -> {
            finish();
        });
    }

    private void setData() {
        Car car = MySingleton.getInstance().getCar();
        mBinding.carBrand.setText(getString(R.string.car_brand_saved, car.getBrand()));
        mBinding.carType.setText(getString(R.string.car_type_saved, car.getCarType()));
        mBinding.carEngine.setText(getString(R.string.car_engine_saved, car.getEngine().getHorsePower()));
        if (car.getAirbags() != 0)
            mBinding.carAirBag.setText(getString(R.string.car_air_bag_saved, car.getAirbags()));

    }
}
