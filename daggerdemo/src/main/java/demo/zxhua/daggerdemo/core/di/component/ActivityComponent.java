package demo.zxhua.daggerdemo.core.di.component;

import dagger.Subcomponent;
import dagger.android.AndroidInjector;
import demo.zxhua.daggerdemo.core.base.BaseActivity;
import demo.zxhua.daggerdemo.core.di.module.ActivityMoudel;

/**
 * Created by Zxhua on 2017/12/2 0002.
 */
@Subcomponent(modules = {ActivityMoudel.class})
public interface ActivityComponent extends AndroidInjector<BaseActivity>{
    @Subcomponent.Builder
    abstract class Builder extends AndroidInjector.Builder<BaseActivity>{

    }
}
