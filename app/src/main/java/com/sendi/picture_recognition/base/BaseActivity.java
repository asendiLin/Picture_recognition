package com.sendi.picture_recognition.base;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.Window;

import com.sendi.picture_recognition.utils.ActivityController;
import com.sendi.picture_recognition.view.IView;

/**
 * Created by Administrator on 2017/12/5.
 */

public abstract class BaseActivity  extends AppCompatActivity implements IView{
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        super.onCreate(savedInstanceState);
        ActivityController.addActivity(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ActivityController.remove(this);
    }
}
