package demo.zxhua.daggerdemo.core.base;

import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;
import android.content.Context;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import javax.inject.Inject;

import dagger.android.support.AndroidSupportInjection;
import demo.zxhua.daggerdemo.utils.ActivityUtils;

/**
 * Created by Zxhua on 2017/9/11 0011.
 */

public abstract class BaseFragment<B extends ViewDataBinding, VM extends ViewModel> extends Fragment {

    protected VM mViewModel;

    protected View mRootView;

    protected B mBinding;

    @Inject
    public ViewModelProvider.Factory viewModelFactory;

    @Inject
    public ActivityUtils activityUtils;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        AndroidSupportInjection.inject(this);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mBinding = DataBindingUtil.inflate(inflater, layoutId(), container, false);
        if (mBinding == null) {
            throw new IllegalArgumentException("databind can't be null");
        }

        if (mRootView == null) {
            mRootView = mBinding.getRoot();
        }
        ViewGroup parent = (ViewGroup) mRootView.getParent();
        if (parent != null) {
            parent.removeView(mRootView);
        }

        return mRootView;
    }

    protected abstract int layoutId();
}
