package com.lx.rxpermissions.activity;

import android.Manifest;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Toast;

import com.lx.rxpermissions.R;
import com.tbruyelle.rxpermissions2.RxPermissions;

import io.reactivex.functions.Action;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.singleButton).setOnClickListener(v -> request());
        findViewById(R.id.mulButton).setOnClickListener(v -> requestMul());
        findViewById(R.id.mulForEachButton).setOnClickListener(v -> requestMulForeach());
        request();
    }

    private void request() {
        new RxPermissions(this).requestEach(Manifest.permission.CAMERA).subscribe((permission) -> {
            if (permission.granted) {
                log("Request success");
                //第一次请求权限
            } else if (permission.shouldShowRequestPermissionRationale) {
                //被拒绝后 第二次请求此权限被拒
                log("Request failed");
            } else {
                //第二次请求后被拒,不会再提示请求权限,需要去系统权限管理处去手动请求
                log("Request failed never");
            }
        });

//        new RxPermissions(this).request(Manifest.permission.CAMERA).subscribe()
    }

    private void requestMul() {
        new RxPermissions(this).request(Manifest.permission.INTERNET, Manifest.permission.WRITE_EXTERNAL_STORAGE).subscribe((b) -> {
            if (b) {
                log("Request mul success");
            } else {
                log("Request mul failed");
            }
        });

    }

    private void requestMulForeach() {

    }

    private void log(String s) {
        Log.d(getPackageName(), s);
        Toast.makeText(this, s, Toast.LENGTH_LONG).show();
    }
}
