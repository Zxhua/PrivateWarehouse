package demo.zxhua.daggerdemo.core.dagger.fragment;

import dagger.Component;
import demo.zxhua.daggerdemo.core.dagger.activity.ActivityComponent;
import demo.zxhua.daggerdemo.core.dagger.fragment.module.FragmentMoudel;

/**
 * Created by Zxhua on 2017/9/8 0008.
 */
@FragmentScope
@Component(dependencies =ActivityComponent.class
        ,modules = {FragmentMoudel.class})
public interface FragmentComonpent extends FragmentComonpentExposes, FragmentComponentInject {
    final class Initializer {
        static public FragmentComonpent init(final DaggerFragment fragment, ActivityComponent activityComponent) {
            return DaggerFragmentComonpent.builder()
                    .activityComponent(activityComponent)
                    .fragmentMoudel(new FragmentMoudel(fragment))
                    .build();
        }

        private Initializer() {
        }
    }
}
