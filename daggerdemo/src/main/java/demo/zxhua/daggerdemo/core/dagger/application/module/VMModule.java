package demo.zxhua.daggerdemo.core.dagger.application.module;

import android.app.Application;
import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;

import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;
import javax.inject.Provider;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import dagger.multibindings.IntoMap;
import demo.zxhua.daggerdemo.core.dagger.viewmodelmodule.ViewModelFactory;
import demo.zxhua.daggerdemo.core.dagger.viewmodelmodule.ViewModelKey;
import demo.zxhua.daggerdemo.ui.test.TestViewModel;

/**
 * Created by Zxhua on 2017/9/9 0009.
 */
@Module
public class VMModule {
    @Inject
    public Application application;

    Map<Class<? extends ViewModel>, Provider<ViewModel>> creators;


    @Provides
    @IntoMap
    @ViewModelKey(TestViewModel.class)
    public ViewModel bindTestViewMode() {
        return new TestViewModel(application);
    }

    private Map<Class<? extends ViewModel>, Provider<ViewModel>> getCreators() {
        HashMap<Class<? extends ViewModel>, Provider<ViewModel>> creators = new HashMap<>();
        Provider<ViewModel> testViewModel = new Provider<ViewModel>() {
            @Override
            public ViewModel get() {
                return new TestViewModel(application);
            }
        };
        creators.put(TestViewModel.class, testViewModel);
        return creators;
    }

    @Provides
    @Singleton
    public ViewModelProvider.Factory getViewModelFactory() {
        return new ViewModelFactory( getCreators());
    }


    public interface Exposes {
        ViewModelProvider.Factory getViewModelFactory();
    }

}
