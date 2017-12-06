package demo.zxhua.daggerdemo.ui.complex;

import android.arch.lifecycle.ViewModelProvider;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import javax.inject.Inject;

import demo.zxhua.daggerdemo.R;
import demo.zxhua.daggerdemo.core.base.BaseFragment;
import demo.zxhua.daggerdemo.core.base.BindingAdapter;
import demo.zxhua.daggerdemo.databinding.FragComplexBinding;

/**
 * Created by Zxhua on 2017/12/6 0006.
 */

public class ComplexFragment extends BaseFragment<FragComplexBinding, ComplexViewModel> {

    @Inject
    ViewModelProvider.Factory viewModelFactory;

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mViewModel = ViewModelProviders.of(this, viewModelFactory).get(ComplexViewModel.class);
        mBinding.setViewmodel(mViewModel);
        BindingAdapter bindingAdapter = new BindingAdapter();
        mViewModel.items.observe(this, complexVOS -> {
            bindingAdapter.setItems(complexVOS);
            mBinding.rlvComplex.setAdapter(bindingAdapter);
        });
    }

    @Override
    protected int layoutId() {
        return R.layout.frag_complex;
    }


}
