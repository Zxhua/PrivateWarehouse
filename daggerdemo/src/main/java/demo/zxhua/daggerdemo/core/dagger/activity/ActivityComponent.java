package demo.zxhua.daggerdemo.core.dagger.activity;

import dagger.Component;
import demo.zxhua.daggerdemo.core.dagger.activity.module.ActivityMoudel;
import demo.zxhua.daggerdemo.core.dagger.application.ApplicationComponent;

/**
 * Created by Zxhua on 2017/9/7 0007.
 */
@ActivityScope
@Component(
        dependencies = ApplicationComponent.class,
        modules = {
                ActivityMoudel.class
        })
public interface ActivityComponent extends ActivityComponentEposes, ActivityComponentInject {

    final class Initializer {
        static public ActivityComponent init(final DaggerActivity activity, final ApplicationComponent applicationComponent) {
            return DaggerActivityComponent.builder()
                    .activityMoudel(new ActivityMoudel(activity))
                    .applicationComponent(applicationComponent)
                    .build();
        }

        private Initializer() {
        }
    }
}
