package com.tuan.designpattern;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.tuan.designpattern.builder.Builder;
import com.tuan.designpattern.builder.HuyndaiCarBuilder;
import com.tuan.designpattern.builder.KiaCarBuilder;
import com.tuan.designpattern.databinding.ActivityMainBinding;
import com.tuan.designpattern.singleton.MySingleton;

import java.util.Arrays;
import java.util.List;

@SuppressWarnings({"unchecked", "rawtypes"})
public class MainActivity extends AppCompatActivity {
    private static final String TAG = MainActivity.class.getSimpleName();
    ActivityMainBinding mBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(mBinding.getRoot());
        List<String> mBrand = Arrays.asList(getResources().getStringArray(R.array.brand));

        ArrayAdapter mBrandAdapter = new ArrayAdapter(this, R.layout.spinner_item, mBrand);
        mBinding.brand.setAdapter(mBrandAdapter);

        List<String> mType = Arrays.asList(getResources().getStringArray(R.array.car_type));
        ArrayAdapter mTypeAdapter = new ArrayAdapter(this, R.layout.spinner_item, mType);
        mBinding.type.setAdapter(mTypeAdapter);

        mBinding.brand.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (mBinding.brand.getItemAtPosition(position).toString().equals("Kia")) {
                    mBinding.layoutAirBag.setVisibility(View.VISIBLE);
                } else {
                    mBinding.layoutAirBag.setVisibility(View.GONE);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        mBinding.btnCreate.setOnClickListener(v -> createOrUpdateCurrentCar());
    }

    private void createOrUpdateCurrentCar() {
        Builder builder = null;
        Log.i(TAG, "createOrUpdateCurrentCar: " + mBinding.type.getSelectedItem().toString());
        switch (mBinding.brand.getSelectedItem().toString()) {
            case "Kia":
                builder = new KiaCarBuilder();
                break;
            case "Huyndai":
                builder = new HuyndaiCarBuilder();
                break;
        }
        OEMDirector oemDirector = new OEMDirector();
        switch (mBinding.type.getSelectedItem().toString()) {
            case "SUV":
                if (builder != null) {
                    oemDirector.createSUVCar(builder);
                }
                break;
            case "TRUCK":
                if (builder != null) {
                    oemDirector.createTRUCKCar(builder);
                }
                break;
            case "SPORT":
                if (builder != null) {
                    oemDirector.createSPORTCar(builder);
                }
                break;
        }
        if (builder != null) {
            if (builder instanceof KiaCarBuilder) {
                if (!mBinding.etAirBag.getText().toString().equals("")) {
                    ((KiaCarBuilder) builder).setAirbags(Integer.parseInt(mBinding.etAirBag.getText().toString()));
                }
            }
            MySingleton.getInstance().setCar(oemDirector.process(builder));
            navigateActivity();
        } else {
            Toast.makeText(this, "Có lỗi", Toast.LENGTH_SHORT).show();
        }

    }

    private void navigateActivity() {
        startActivity(new Intent(this, DetailActivity.class));
    }

}