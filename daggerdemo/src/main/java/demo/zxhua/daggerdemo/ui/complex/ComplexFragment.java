package demo.zxhua.daggerdemo.ui.complex;

import android.arch.lifecycle.ViewModelProvider;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import java.util.List;

import javax.inject.Inject;

import demo.zxhua.daggerdemo.R;
import demo.zxhua.daggerdemo.core.base.BaseFragment;
import demo.zxhua.daggerdemo.core.base.BindingAdapter;
import demo.zxhua.daggerdemo.core.base.BindingAdapterItem;
import demo.zxhua.daggerdemo.databinding.FragComplexBinding;
import demo.zxhua.daggerdemo.utils.DialogUtils;
import demo.zxhua.daggerdemo.vo.ComplexVO;

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

        mBinding.showMessage.setOnClickListener(view1 -> {
            List<BindingAdapterItem> value = mViewModel.items.getValue();
            StringBuilder stringBuilder = new StringBuilder();
            for (BindingAdapterItem bindingAdapterItem : value) {
                ComplexVO item = (ComplexVO) bindingAdapterItem;
                stringBuilder.append(item.toString()).append("\n\n");
            }
            new DialogUtils().showDetail(getContext(), stringBuilder.toString());
        });
    }

    @Override
    protected int layoutId() {
        return R.layout.frag_complex;
    }


}
