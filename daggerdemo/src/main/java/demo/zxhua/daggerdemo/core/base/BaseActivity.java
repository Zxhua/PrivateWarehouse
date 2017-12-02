package demo.zxhua.daggerdemo.core.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;

import javax.inject.Inject;

import dagger.android.AndroidInjection;
import dagger.android.AndroidInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.support.DaggerAppCompatActivity;
import dagger.android.support.HasSupportFragmentInjector;
import demo.zxhua.daggerdemo.R;
import demo.zxhua.daggerdemo.utils.ActivityUtils;

/**
 * Created by Zxhua on 2017/9/11 0011.
 */

public abstract class BaseActivity extends DaggerAppCompatActivity implements HasSupportFragmentInjector {
    @Inject
    DispatchingAndroidInjector<Fragment> fragmentSupportInjector;

    @Inject
    ActivityUtils activityUtils;

    @Inject
    FragmentManager fragmentManager;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        AndroidInjection.inject(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
    }


    @Override
    public AndroidInjector<Fragment> supportFragmentInjector() {
        return fragmentSupportInjector;
    }
}
