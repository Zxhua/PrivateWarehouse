package demo.zxhua.daggerdemo.core.dagger.fragment.module;

import dagger.Module;
import demo.zxhua.daggerdemo.core.dagger.fragment.DaggerFragment;

/**
 * Created by Zxhua on 2017/9/8 0008.
 */
@Module
public class FragmentMoudel {
    private final DaggerFragment daggerFragment;

    public FragmentMoudel(final DaggerFragment fragment) {
        daggerFragment = fragment;
    }
}
