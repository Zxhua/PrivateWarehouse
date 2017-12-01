package demo.zxhua.daggerdemo.core.dagger.activity.module;

import android.app.Activity;
import android.content.Context;
import android.support.v4.app.FragmentManager;

import dagger.Module;
import dagger.Provides;
import demo.zxhua.daggerdemo.core.dagger.activity.ActivityScope;
import demo.zxhua.daggerdemo.core.dagger.activity.DaggerActivity;
import demo.zxhua.daggerdemo.core.dagger.activity.ForActivity;

/**
 * Created by Zxhua on 2017/9/7 0007.
 */
@Module
public class ActivityMoudel {
    private final DaggerActivity daggerActivity;

    public ActivityMoudel(final DaggerActivity daggerActivity) {
        this.daggerActivity = daggerActivity;
    }

    @Provides
    @ActivityScope
    @ForActivity
    Context provideActivityContext() {
        return daggerActivity;
    }


    @Provides
    @ActivityScope
    Activity provideActivity() {
        return daggerActivity;
    }

    @Provides
    @ActivityScope
    FragmentManager provideFragmentManagerV4() {
        return daggerActivity.getSupportFragmentManager();
    }

    public interface Exposes {
        @ForActivity
        Context provideActivityContext();

        Activity provideActivity();

        FragmentManager provideFragmentManagerV4();
    }

}
