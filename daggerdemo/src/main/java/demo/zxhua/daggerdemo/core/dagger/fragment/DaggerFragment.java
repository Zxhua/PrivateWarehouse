package demo.zxhua.daggerdemo.core.dagger.fragment;

import android.arch.lifecycle.LifecycleFragment;
import android.os.Bundle;
import android.support.annotation.Nullable;

import demo.zxhua.daggerdemo.core.dagger.ComponentFactory;
import demo.zxhua.daggerdemo.core.dagger.activity.DaggerActivity;

/**
 * Created by Zxhua on 2017/9/8 0008.
 */

public abstract class DaggerFragment extends LifecycleFragment {
    private FragmentComonpent fragmentComonpent;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        inject(getFragmentComponent());
    }

    protected abstract void inject(FragmentComonpent fragmentComonpent);

    public FragmentComonpent getFragmentComponent() {
        if (fragmentComonpent == null) {
            fragmentComonpent = ComponentFactory.createFragmentComponent(this, getDaggerActivity().getActivityComponent());
        }
        return fragmentComonpent;
    }

    private DaggerActivity getDaggerActivity() {
        return (DaggerActivity) getActivity();
    }
}
