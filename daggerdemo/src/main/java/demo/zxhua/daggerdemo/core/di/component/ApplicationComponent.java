package demo.zxhua.daggerdemo.core.di.component;

import javax.inject.Singleton;

import dagger.Component;
import dagger.android.AndroidInjectionModule;
import dagger.android.AndroidInjector;
import dagger.android.support.AndroidSupportInjectionModule;
import demo.zxhua.daggerdemo.App;
import demo.zxhua.daggerdemo.core.di.module.ApplicationModule;
import demo.zxhua.daggerdemo.core.di.module.BuildersModule;
import demo.zxhua.daggerdemo.core.di.module.UtilsModule;

/**
 * Created by Zxhua on 2017/12/2 0002.
 */
@Singleton
@Component(modules = {
        UtilsModule.class,
        BuildersModule.class,
        ApplicationModule.class,
        AndroidInjectionModule.class,
        AndroidSupportInjectionModule.class
})
public interface ApplicationComponent extends AndroidInjector<App> {

}
