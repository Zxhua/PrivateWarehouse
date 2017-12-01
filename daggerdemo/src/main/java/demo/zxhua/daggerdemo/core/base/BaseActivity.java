package demo.zxhua.daggerdemo.core.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;

import javax.inject.Inject;

import dagger.android.AndroidInjection;
import demo.zxhua.daggerdemo.R;
import demo.zxhua.daggerdemo.utils.ActivityUtils;

/**
 * Created by Zxhua on 2017/9/11 0011.
 */

public abstract class BaseActivity extends AppCompatActivity {
    @Inject
    public ActivityUtils activityUtils;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        AndroidInjection.inject(this);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
    }


}
