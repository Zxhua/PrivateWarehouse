package demo.zxhua.daggerdemo.ui.test;

import android.arch.lifecycle.ViewModelProvider;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import javax.inject.Inject;

import demo.zxhua.daggerdemo.R;
import demo.zxhua.daggerdemo.core.base.BaseFragment;
import demo.zxhua.daggerdemo.databinding.FragTestBinding;

/**
 * Created by Zxhua on 2017/11/27 0027.
 */


public class TestFragment extends BaseFragment<FragTestBinding, TestViewModel> {

    private String fragName;

    public TestFragment() {
    }

    public static TestFragment newTestFragment(String fragmentName) {
        TestFragment fragment = new TestFragment();
        Bundle bundle = new Bundle();
        bundle.putString("name", fragmentName);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    protected int layoutId() {
        return R.layout.frag_test;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mViewModel = ViewModelProviders.of(this, viewModelFactory).get(TestViewModel.class);
        fragName = getArguments().getString("name");
        mViewModel.fragName.set(fragName);
        mBinding.setViewModel(mViewModel);
    }

}