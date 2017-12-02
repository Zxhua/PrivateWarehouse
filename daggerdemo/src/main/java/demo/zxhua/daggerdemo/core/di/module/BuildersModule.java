package demo.zxhua.daggerdemo.core.di.module;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;
import demo.zxhua.daggerdemo.core.base.BaseActivity;
import demo.zxhua.daggerdemo.core.base.BaseFragment;

/**
 * Created by Zxhua on 2017/12/2 0002.
 */
@Module
public abstract class BuildersModule {

    @ContributesAndroidInjector(modules = {ActivityMoudel.class})
    abstract BaseActivity activityInjector();

    @ContributesAndroidInjector(modules = {FragmentMoudel.class})
    abstract BaseFragment fragmentInjector();
}
