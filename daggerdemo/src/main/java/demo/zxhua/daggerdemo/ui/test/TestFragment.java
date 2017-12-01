package demo.zxhua.daggerdemo.ui.test;

import android.arch.lifecycle.ViewModelProvider;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import javax.inject.Inject;

import demo.zxhua.daggerdemo.R;
import demo.zxhua.daggerdemo.core.base.BaseFragment;
import demo.zxhua.daggerdemo.core.dagger.fragment.FragmentComonpent;
import demo.zxhua.daggerdemo.databinding.FragTestBinding;

/**
 * Created by Zxhua on 2017/11/27 0027.
 */


public class TestFragment extends BaseFragment<FragTestBinding, TestViewModel> {

    private static TestFragment INSTANCE;
    private static String fragName;

    @Inject
    public ViewModelProvider.Factory viewModelFactory;

    public TestFragment() {
    }

    public static TestFragment newTestFragment(String fragmentName) {
        INSTANCE = new TestFragment();
        fragName = fragmentName;
        return INSTANCE;
    }

    @Override
    protected int layoutId() {
        return R.layout.frag_test;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mViewModel = ViewModelProviders.of(this, viewModelFactory).get(TestViewModel.class);
        mViewModel.fragName.set(fragName);
    }

    @Override
    protected void inject(FragmentComonpent fragmentComonpent) {
        fragmentComonpent.inject(this);
    }
}