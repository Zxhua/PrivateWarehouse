package demo.zxhua.daggerdemo;

import android.os.Bundle;

import javax.inject.Inject;

import demo.zxhua.daggerdemo.core.dagger.activity.ActivityComponent;
import demo.zxhua.daggerdemo.core.dagger.activity.DaggerActivity;
import demo.zxhua.daggerdemo.ui.navigation.NavigationFragment;
import demo.zxhua.daggerdemo.utils.ActivityUtils;

public class MainActivity extends DaggerActivity {
    @Inject
    public ActivityUtils activityUtils;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        activityUtils.addFragmentToActivity(getSupportFragmentManager(), new NavigationFragment(), R.id.fragmentLayout);
    }

    @Override
    protected void inject(ActivityComponent activityComponent) {
        activityComponent.inject(this);
    }
}
