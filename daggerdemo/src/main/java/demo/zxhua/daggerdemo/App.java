package demo.zxhua.daggerdemo;

import android.app.Activity;

import javax.inject.Inject;

import dagger.android.AndroidInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.HasActivityInjector;
import dagger.android.support.DaggerApplication;
import demo.zxhua.daggerdemo.core.di.component.DaggerApplicationComponent;

/**
 * Created by Zxhua on 2017/12/2 0002.
 */

public class App extends DaggerApplication implements HasActivityInjector {
    @Inject
    DispatchingAndroidInjector<Activity> activityInjector;
    @Override
    public void onCreate() {
        DaggerApplicationComponent.create().inject(this);
        super.onCreate();
    }
    @Override
    public DispatchingAndroidInjector<Activity> activityInjector() {
        return activityInjector;
    }

    @Override
    protected AndroidInjector<? extends DaggerApplication> applicationInjector() {
        return null;
    }
}
