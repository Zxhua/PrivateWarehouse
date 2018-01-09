package demo.zxhua.daggerdemo.ui.test;

import android.arch.lifecycle.ViewModelProvider;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import org.jetbrains.annotations.NotNull;

import javax.inject.Inject;

import demo.zxhua.daggerdemo.R;
import demo.zxhua.daggerdemo.core.base.BaseFragment;
import demo.zxhua.daggerdemo.core.base.BindingAdapter;
import demo.zxhua.daggerdemo.databinding.FragTestBinding;
import demo.zxhua.daggerdemo.ui.listener.AddItemClickListener;
import demo.zxhua.daggerdemo.ui.listener.ClassItemClickListener;
import demo.zxhua.daggerdemo.ui.listener.StuItemClickListener;
import demo.zxhua.daggerdemo.utils.DialogUtils;
import demo.zxhua.daggerdemo.vo.ClassEntity;
import demo.zxhua.daggerdemo.vo.StudentEntity;

/**
 * Created by Zxhua on 2017/11/27 0027.
 */


public class TestFragment extends BaseFragment<FragTestBinding, TestViewModel> implements StuItemClickListener, ClassItemClickListener, AddItemClickListener {

    private String fragName;

    @Inject
    public ViewModelProvider.Factory viewModelFactory;


    public DialogUtils dialogUtils =new DialogUtils();

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

        BindingAdapter classAdapter = new BindingAdapter();
        mBinding.classRecyler.setAdapter(classAdapter);
//        mViewModel.loadClass().observe(this, classAdapter::setItems);

        mViewModel.stus.observe(this, studentEntities -> {

        });


    }

    @Override
    public void onClickListener(@NotNull ClassEntity classEntity) {
        dialogUtils.showAddClassDialog(getContext(), className -> {
            mViewModel.addClass(classEntity);
        });
    }

    @Override
    public void onClickListener(@NotNull StudentEntity studentEntity) {

    }

    @Override
    public void onClickListener(@NotNull String type) {
        if ("classes".equals(type)) {

        } else {

        }
    }
}