package demo.zxhua.daggerdemo.core.dagger.application;


import demo.zxhua.daggerdemo.core.dagger.application.module.ApplicationModule;
import demo.zxhua.daggerdemo.core.dagger.application.module.UtilsModule;
import demo.zxhua.daggerdemo.core.dagger.application.module.VMModule;

/**
 * Created by Zxhua on 2017/9/7 0007.
 */

public interface ApplicationComponentExposes extends ApplicationModule.Exposes, UtilsModule.Exposes,VMModule.Exposes {
}
