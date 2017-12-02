package demo.zxhua.daggerdemo;

import android.app.Activity;

import javax.inject.Inject;

import dagger.android.AndroidInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.HasActivityInjector;
import dagger.android.support.DaggerApplication;

/**
 * Created by Zxhua on 2017/12/2 0002.
 */

public class App extends DaggerApplication implements HasActivityInjector {
    @Inject
    DispatchingAndroidInjector<Activity> activityInjector;

    @Override
    protected AndroidInjector<? extends DaggerApplication> applicationInjector() {
        return null;
    }

    @Override
    public DispatchingAndroidInjector<Activity> activityInjector() {
        return activityInjector;
    }
}
