package demo.zxhua.daggerdemo.core.dagger;


import demo.zxhua.daggerdemo.core.dagger.activity.ActivityComponent;
import demo.zxhua.daggerdemo.core.dagger.activity.DaggerActivity;
import demo.zxhua.daggerdemo.core.dagger.application.ApplicationComponent;
import demo.zxhua.daggerdemo.core.dagger.application.DaggerApplication;
import demo.zxhua.daggerdemo.core.dagger.fragment.DaggerFragment;
import demo.zxhua.daggerdemo.core.dagger.fragment.FragmentComonpent;

/**
 * Created by Zxhua on 2017/9/7 0007.
 */

public final class ComponentFactory {
    private ComponentFactory(){}

    public static ApplicationComponent createApplicationComponent(final DaggerApplication daggerApplication){
        return ApplicationComponent.Initializer.init(daggerApplication);
    }

    public static ActivityComponent createActivityComponent(final DaggerActivity daggerActivity,final DaggerApplication daggerApplication){
        return ActivityComponent.Initializer.init(daggerActivity,daggerApplication.getApplicationComponent());
    }

    public static FragmentComonpent createFragmentComponent(final DaggerFragment fragment,final ActivityComponent activityComponent){
        return FragmentComonpent.Initializer.init(fragment,activityComponent);
    }
}
