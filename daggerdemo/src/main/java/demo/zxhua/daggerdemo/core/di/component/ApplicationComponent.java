package demo.zxhua.daggerdemo.core.di.component;

import dagger.Component;
import dagger.android.AndroidInjectionModule;
import dagger.android.AndroidInjector;
import dagger.android.support.AndroidSupportInjectionModule;
import demo.zxhua.daggerdemo.App;
import demo.zxhua.daggerdemo.core.di.module.ApplicationModule;
import demo.zxhua.daggerdemo.core.di.module.UtilsModule;
import demo.zxhua.daggerdemo.core.di.module.VMModule;
import demo.zxhua.daggerdemo.core.di.module.BuildersModule;

/**
 * Created by Zxhua on 2017/12/2 0002.
 */
@Component(modules = {
        VMModule.class,
        UtilsModule.class,
        BuildersModule.class,
        ApplicationModule.class,
        AndroidInjectionModule.class,
        AndroidSupportInjectionModule.class
})
public interface ApplicationComponent extends AndroidInjector<App> {
    @Component.Builder
    abstract class Builder extends AndroidInjector.Builder<App> {

    }
}
