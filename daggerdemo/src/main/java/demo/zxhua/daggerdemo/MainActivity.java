package demo.zxhua.daggerdemo;

import android.os.Bundle;

import javax.inject.Inject;

import demo.zxhua.daggerdemo.core.base.BaseActivity;
import demo.zxhua.daggerdemo.ui.navigation.NavigationFragment;
import demo.zxhua.daggerdemo.utils.ActivityUtils;

public class MainActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityUtils.addFragmentToActivity(getSupportFragmentManager(), new NavigationFragment(), R.id.fragmentLayout);
    }

}
