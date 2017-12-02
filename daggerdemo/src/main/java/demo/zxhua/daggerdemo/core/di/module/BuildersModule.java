package demo.zxhua.daggerdemo.core.di.module;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;
import demo.zxhua.daggerdemo.MainActivity;
import demo.zxhua.daggerdemo.core.di.scope.ActivityScope;
import demo.zxhua.daggerdemo.core.di.scope.FragmentScope;
import demo.zxhua.daggerdemo.ui.navigation.NavigationFragment;
import demo.zxhua.daggerdemo.ui.test.TestFragment;
import demo.zxhua.daggerdemo.ui.tools.ToolsFragment;

/**
 * Created by Zxhua on 2017/12/2 0002.
 */
@Module
public abstract class BuildersModule {

    @ActivityScope
    @ContributesAndroidInjector(modules = {ActivityMoudel.class})
    abstract MainActivity providerMainActivity();


    @FragmentScope
    @ContributesAndroidInjector(modules = {FragmentMoudel.class})
    abstract TestFragment providerTestFragment();

    @FragmentScope
    @ContributesAndroidInjector(modules = {FragmentMoudel.class})
    abstract NavigationFragment providerNavigationFragment();

    @FragmentScope
    @ContributesAndroidInjector(modules = {FragmentMoudel.class})
    abstract ToolsFragment providerToolsFragment();
}
