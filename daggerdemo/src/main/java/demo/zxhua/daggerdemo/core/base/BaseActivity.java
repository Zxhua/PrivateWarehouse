package demo.zxhua.daggerdemo.core.base;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.util.Log;

import javax.inject.Inject;

import dagger.android.AndroidInjection;
import dagger.android.AndroidInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.support.DaggerAppCompatActivity;
import dagger.android.support.HasSupportFragmentInjector;
import demo.zxhua.daggerdemo.R;
import demo.zxhua.daggerdemo.core.hook.HookActivityHandler;
import demo.zxhua.daggerdemo.utils.ActivityUtils;

/**
 * Created by Zxhua on 2017/9/11 0011.
 */

public abstract class BaseActivity extends DaggerAppCompatActivity implements HasSupportFragmentInjector {
    @Inject
    DispatchingAndroidInjector<Fragment> fragmentSupportInjector;

    @Inject
    ActivityUtils activityUtils;

    protected FragmentManager fragmentManager;

    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(newBase);
        try {
//            String cachePath = BaseActivity.this.getCacheDir().getAbsolutePath();
            ClassLoader classLoader = newBase.getClassLoader();
            HookActivityHandler.hookActivityManagerService(classLoader);
        } catch (Exception e) {
            Log.e(HookActivityHandler.TAG, "加载异常 ==" + e.getMessage());
        }

    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        AndroidInjection.inject(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fragmentManager = getSupportFragmentManager();
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
