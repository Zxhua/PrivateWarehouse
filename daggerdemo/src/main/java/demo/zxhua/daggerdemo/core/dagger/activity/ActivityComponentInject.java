package demo.zxhua.daggerdemo.core.dagger.activity;

import demo.zxhua.daggerdemo.MainActivity;

/**
 * Created by Zxhua on 2017/9/7 0007.
 */

public interface ActivityComponentInject {
    void inject(DaggerActivity daggerActivity);

    void inject(MainActivity mainActivity);
}
