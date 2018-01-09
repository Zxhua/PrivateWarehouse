package demo.zxhua.daggerdemo;

import android.os.Bundle;

import javax.inject.Inject;

import code.zxhua.processinglib.ann.ActivityMap;
import demo.zxhua.daggerdemo.core.base.BaseActivity;
import demo.zxhua.daggerdemo.ui.navigation.NavigationFragment;
import demo.zxhua.daggerdemo.utils.ActivityUtils;

@ActivityMap(value = "MainActivity")
public class MainActivity extends BaseActivity {
    @Inject
    public ActivityUtils activityUtils;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        activityUtils.addFragmentToActivity(fragmentManager, new NavigationFragment(), R.id.fragmentLayout);
    }

}
