package com.tuan.designpattern;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.ListPopupWindow;

import com.tuan.designpattern.builder.Builder;
import com.tuan.designpattern.builder.HuyndaiCarBuilder;
import com.tuan.designpattern.builder.KiaCarBuilder;
import com.tuan.designpattern.databinding.ActivityMainBinding;
import com.tuan.designpattern.singleton.MySingleton;

import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = MainActivity.class.getSimpleName();
    ActivityMainBinding mBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(mBinding.getRoot());

        mBinding.rltBrand.setOnClickListener(v -> {
            List<String> data = Arrays.asList(getResources().getStringArray(R.array.brand));
            setupAndShowWindowList(mBinding.brand, data);
        });
        mBinding.rltCarTypeDown.setOnClickListener(v -> {
            List<String> data = Arrays.asList(getResources().getStringArray(R.array.car_type));
            setupAndShowWindowList(mBinding.type, data);
        });

        mBinding.btnCreate.setOnClickListener(v -> {
            createOrUpdateCurrentCar();
        });
    }

    private void createOrUpdateCurrentCar() {
        Builder builder = null;
        Log.i(TAG, "createOrUpdateCurrentCar: " + mBinding.type.getText().toString());
        switch (mBinding.brand.getText().toString()) {
            case "Kia":
                builder = new KiaCarBuilder();
                break;
            case "Huyndai":
                builder = new HuyndaiCarBuilder();
                break;
        }
        OEMDirector oemDirector = new OEMDirector();
        switch (mBinding.type.getText().toString()) {
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
                assert builder != null;
                oemDirector.createSPORTCar(builder);
                break;
        }
        if (builder != null) {
            MySingleton.getInstance().setCar(oemDirector.process(builder));
        } else
            Toast.makeText(this, "Có lỗi", Toast.LENGTH_SHORT).show();

    }

    private void setupAndShowWindowList(View anchorView, List<String> data) {
        ListPopupWindow mPopupWindow = new ListPopupWindow(this);
        mPopupWindow.setAnchorView(anchorView);
        mPopupWindow.setHeight(ListPopupWindow.WRAP_CONTENT);
        mPopupWindow.setModal(true);

        ListPopupWindowAdapter mAdapter = new ListPopupWindowAdapter(
                this,
                data,
                position -> {
                    if (anchorView.getId() == mBinding.brand.getId()) {
                        mBinding.brand.setText(data.get(position));
                    } else {
                        mBinding.type.setText(data.get(position));
                    }
                    mPopupWindow.dismiss();
                });

        mPopupWindow.setAdapter(mAdapter);
        mPopupWindow.show();
    }


}