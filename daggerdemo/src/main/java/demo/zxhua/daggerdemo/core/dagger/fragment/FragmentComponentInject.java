package demo.zxhua.daggerdemo.core.dagger.fragment;


import demo.zxhua.daggerdemo.ui.navigation.NavigationFragment;
import demo.zxhua.daggerdemo.ui.test.TestFragment;

/**
 * Created by Zxhua on 2017/9/8 0008.
 */

public interface FragmentComponentInject {

    void inject(DaggerFragment fragment);

    void inject(NavigationFragment navigationFragment);

    void inject(TestFragment testFragment);
}
