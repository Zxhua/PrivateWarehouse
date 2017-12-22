package demo.zxhua.daggerdemo.ui.tools;

import android.arch.lifecycle.ViewModelProvider;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import javax.inject.Inject;

import demo.zxhua.daggerdemo.R;
import demo.zxhua.daggerdemo.core.base.BaseFragment;
import demo.zxhua.daggerdemo.core.base.BindingAdapter;
import demo.zxhua.daggerdemo.databinding.FragToolBinding;

/**
 * Created by Zxhua on 2017/11/30 0030.
 */

public class ToolsFragment extends BaseFragment<FragToolBinding, ToolsViewModel> {
    @Inject
    public ViewModelProvider.Factory viewModelFactory;
    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mViewModel =  ViewModelProviders.of(this, viewModelFactory).get(ToolsViewModel.class);
        mBinding.setViewmodel(mViewModel);
        BindingAdapter adapter = new BindingAdapter();
        mBinding.rlvTools.setAdapter(adapter);
        mViewModel.items.observe(this, adapter::setItems);
    }

    @Override
    protected int layoutId() {
        return R.layout.frag_tool;
    }
}
