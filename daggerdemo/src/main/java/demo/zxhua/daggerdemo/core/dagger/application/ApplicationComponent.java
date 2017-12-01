package demo.zxhua.daggerdemo.core.dagger.application;


import javax.inject.Singleton;

import dagger.Component;
import dagger.android.AndroidInjector;
import dagger.android.support.AndroidSupportInjectionModule;
import demo.zxhua.daggerdemo.core.dagger.activity.module.ActivityMoudel;
import demo.zxhua.daggerdemo.core.dagger.application.module.ApplicationModule;
import demo.zxhua.daggerdemo.core.dagger.application.module.UtilsModule;
import demo.zxhua.daggerdemo.core.dagger.application.module.VMModule;

/**
 * Created by Zxhua on 2017/9/7 0007.
 */
@Singleton
@Component(modules = {
        ApplicationModule.class,
        AndroidSupportInjectionModule.class,
        VMModule.class,
        UtilsModule.class,
        ActivityMoudel.class
})
public interface ApplicationComponent extends AndroidInjector<DaggerApplication> {

}
