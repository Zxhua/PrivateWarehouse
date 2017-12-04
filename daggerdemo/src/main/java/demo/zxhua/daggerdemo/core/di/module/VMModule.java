package demo.zxhua.daggerdemo.core.di.module;

import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;

import dagger.Binds;
import dagger.Module;
import dagger.multibindings.IntoMap;
import demo.zxhua.daggerdemo.core.di.module.viewmodelmodule.ViewModelFactory;
import demo.zxhua.daggerdemo.core.di.module.viewmodelmodule.ViewModelKey;
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
