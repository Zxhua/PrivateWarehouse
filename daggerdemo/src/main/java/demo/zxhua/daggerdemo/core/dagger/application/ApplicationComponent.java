package demo.zxhua.daggerdemo.core.dagger.application;


import javax.inject.Singleton;

import dagger.Component;
import demo.zxhua.daggerdemo.core.dagger.application.module.ApplicationModule;
import demo.zxhua.daggerdemo.core.dagger.application.module.UtilsModule;
import demo.zxhua.daggerdemo.core.dagger.application.module.VMModule;

/**
 * Created by Zxhua on 2017/9/7 0007.
 */
@Singleton
@Component(modules = {
        ApplicationModule.class,
        VMModule.class,
        UtilsModule.class
})
public interface ApplicationComponent extends ApplicationComponentExposes, ApplicationComponentInject {

    final class Initializer {
        static public ApplicationComponent init(final DaggerApplication daggerApplication) {
            return DaggerApplicationComponent.builder()
                    .applicationModule(new ApplicationModule(daggerApplication))
                    .vMModule(new VMModule())
                    .utilsModule(new UtilsModule())
                    .build();
        }

        private Initializer() {
        }

    }

}
