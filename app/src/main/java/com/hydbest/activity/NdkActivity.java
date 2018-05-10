package com.hydbest.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Toast;

import com.hydbest.BaseActivity;
import com.hydbest.behavior.R;
import com.hydbest.ndk.Java2CJNI;

/**
 * Created by csz on 2018/5/4.
 */

public class NdkActivity extends BaseActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ndk);
    }

    public void click(View v) {
        String str = new Java2CJNI().java2C();
        Toast.makeText(this, str, Toast.LENGTH_SHORT).show();
    }
}
