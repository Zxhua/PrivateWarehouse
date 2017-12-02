package demo.zxhua.daggerdemo.core.di.module;

import android.app.Activity;
import android.content.Context;
import android.support.v4.app.FragmentManager;

import dagger.Module;
import dagger.Provides;
import demo.zxhua.daggerdemo.core.base.BaseActivity;
import demo.zxhua.daggerdemo.core.di.scope.ActivityScope;
import demo.zxhua.daggerdemo.core.di.scope.ForActivity;

/**
 * Created by Zxhua on 2017/9/7 0007.
 */
@Module
public class ActivityMoudel {
    private final BaseActivity baseActivity;

    public ActivityMoudel(final BaseActivity baseActivity) {
        this.baseActivity = baseActivity;
    }

    @Provides
    @ActivityScope
    @ForActivity
    Context provideActivityContext() {
        return baseActivity;
    }


    @Provides
    @ActivityScope
    Activity provideActivity() {
        return baseActivity;
    }

    @Provides
    @ActivityScope
    FragmentManager provideFragmentManagerV4() {
        return baseActivity.getSupportFragmentManager();
    }


}
