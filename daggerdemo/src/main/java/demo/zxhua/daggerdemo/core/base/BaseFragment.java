package demo.zxhua.daggerdemo.core.base;

import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import demo.zxhua.daggerdemo.core.dagger.fragment.DaggerFragment;
import demo.zxhua.daggerdemo.core.dagger.viewmodelmodule.BaseViewModel;

/**
 * Created by Zxhua on 2017/9/11 0011.
 */

public abstract class BaseFragment<B extends ViewDataBinding,VM extends BaseViewModel> extends DaggerFragment {

    protected VM mViewModel;

    protected View mRootView;

    protected B mBinding;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mBinding=DataBindingUtil.inflate(inflater,layoutId(),container,false);
        if (mBinding == null){
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
