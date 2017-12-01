package demo.zxhua.daggerdemo.core.dagger.activity.module;

import android.app.Activity;
import android.content.Context;
import android.support.v4.app.FragmentManager;

import dagger.Binds;
import dagger.Module;
import dagger.Provides;
import dagger.Subcomponent;
import dagger.android.ActivityKey;
import dagger.android.AndroidInjector;
import dagger.android.ContributesAndroidInjector;
import dagger.multibindings.IntoMap;
import demo.zxhua.daggerdemo.MainActivity;
import demo.zxhua.daggerdemo.ui.navigation.NavigationFragment;
import demo.zxhua.daggerdemo.ui.test.TestFragment;
import demo.zxhua.daggerdemo.ui.tools.ToolsFragment;

/**
 * Created by Zxhua on 2017/9/7 0007.
 */
@Module
public abstract class ActivityMoudel {

    @ContributesAndroidInjector
    abstract MainActivity providerMainACtivity();

    @ContributesAndroidInjector
    abstract NavigationFragment providerNavigationFragment();
//
    @ContributesAndroidInjector
    abstract TestFragment providerTestFragment();
//
    @ContributesAndroidInjector
    abstract ToolsFragment providerToolsFragment();


}
