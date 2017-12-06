package demo.zxhua.daggerdemo.core.di.module;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;
import demo.zxhua.daggerdemo.MainActivity;
import demo.zxhua.daggerdemo.ui.complex.ComplexFragment;
import demo.zxhua.daggerdemo.ui.navigation.NavigationFragment;
import demo.zxhua.daggerdemo.ui.test.TestFragment;
import demo.zxhua.daggerdemo.ui.tools.ToolsFragment;

/**
 * Created by Zxhua on 2017/12/2 0002.
 */
@Module
public abstract class BuildersModule {

    @ContributesAndroidInjector(modules = {ActivityMoudel.class})
    abstract MainActivity providerMainActivity();

    @ContributesAndroidInjector(modules = {FragmentMoudel.class})
    abstract TestFragment providerTestFragment();

    @ContributesAndroidInjector(modules = {FragmentMoudel.class})
    abstract NavigationFragment providerNavigationFragment();

    @ContributesAndroidInjector(modules = {FragmentMoudel.class})
    abstract ToolsFragment providerToolsFragment();

    @ContributesAndroidInjector(modules = {FragmentMoudel.class})
    abstract ComplexFragment providerComplexFragment();
}
