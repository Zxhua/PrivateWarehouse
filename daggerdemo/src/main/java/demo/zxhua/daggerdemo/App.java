package demo.zxhua.daggerdemo;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;

import javax.inject.Inject;

import dagger.android.AndroidInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.HasActivityInjector;
import dagger.android.support.DaggerApplication;
import demo.zxhua.daggerdemo.core.di.component.DaggerApplicationComponent;

/**
 * Created by Zxhua on 2017/12/2 0002.
 */

public class App extends DaggerApplication implements HasActivityInjector ,Application.ActivityLifecycleCallbacks{

    public static Application INSTANCE;

    @Inject
    DispatchingAndroidInjector<Activity> activityInjector;
    @Override
    public void onCreate() {
        INSTANCE = this;
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

    public static Application get(){
        return INSTANCE;
    }

    @Override
    public void onActivityCreated(Activity activity, Bundle bundle) {

    }

    @Override
    public void onActivityStarted(Activity activity) {

    }

    @Override
    public void onActivityResumed(Activity activity) {

    }

    @Override
    public void onActivityPaused(Activity activity) {

    }

    @Override
    public void onActivityStopped(Activity activity) {

    }

    @Override
    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {

    }

    @Override
    public void onActivityDestroyed(Activity activity) {

    }
}
