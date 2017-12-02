package demo.zxhua.daggerdemo.core.di.module;

import dagger.Module;
import demo.zxhua.daggerdemo.core.base.BaseFragment;

/**
 * Created by Zxhua on 2017/9/8 0008.
 */
@Module
public class FragmentMoudel {
    private final BaseFragment fragment;

    public FragmentMoudel(final BaseFragment fragment) {
        this.fragment = fragment;
    }
}
