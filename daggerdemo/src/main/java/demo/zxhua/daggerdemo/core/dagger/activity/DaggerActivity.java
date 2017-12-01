package demo.zxhua.daggerdemo.core.dagger.activity;

import android.arch.lifecycle.LifecycleActivity;
import android.os.Bundle;
import android.support.annotation.Nullable;

import demo.zxhua.daggerdemo.core.dagger.ComponentFactory;
import demo.zxhua.daggerdemo.core.dagger.application.DaggerApplication;


/**
 * Created by Zxhua on 2017/9/7 0007.
 */

public abstract class DaggerActivity extends LifecycleActivity {

    private ActivityComponent activityComponent;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        inject(getActivityComponent());
    }

    public ActivityComponent getActivityComponent() {
        if (activityComponent == null) {
            activityComponent = ComponentFactory.createActivityComponent(this, getDaggerApplication());
        }
        return activityComponent;
    }

    private DaggerApplication getDaggerApplication() {
        return (DaggerApplication) getApplication();
    }

    protected abstract void inject(final ActivityComponent activityComponent);
}
