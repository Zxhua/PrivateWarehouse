package demo.zxhua.daggerdemo.core.dagger.application.module;

import android.app.Application;
import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;

import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;
import javax.inject.Provider;
import javax.inject.Singleton;

import dagger.Binds;
import dagger.Module;
import dagger.Provides;
import dagger.multibindings.IntoMap;
import demo.zxhua.daggerdemo.core.dagger.viewmodelmodule.ViewModelFactory;
import demo.zxhua.daggerdemo.core.dagger.viewmodelmodule.ViewModelKey;
import demo.zxhua.daggerdemo.ui.navigation.NavigationViewModel;
import demo.zxhua.daggerdemo.ui.test.TestViewModel;
import demo.zxhua.daggerdemo.ui.tools.ToolsViewModel;

/**
 * Created by Zxhua on 2017/9/9 0009.
 */
@Module
public abstract class VMModule {

    @Binds
    @IntoMap
    @ViewModelKey(TestViewModel.class)
    abstract ViewModel bindTestViewMode(TestViewModel testViewModel);


    @Binds
    @IntoMap
    @ViewModelKey(NavigationViewModel.class)
    abstract ViewModel bindNavigationViewModel(NavigationViewModel testViewModel);


    @Binds
    @IntoMap
    @ViewModelKey(ToolsViewModel.class)
    abstract ViewModel bindToolsViewModel(ToolsViewModel testViewModel);

    @Binds
    abstract ViewModelProvider.Factory getViewModelFactory(ViewModelFactory factory);


}
