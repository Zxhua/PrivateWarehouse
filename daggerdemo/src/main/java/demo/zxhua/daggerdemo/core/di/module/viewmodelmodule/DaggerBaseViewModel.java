package demo.zxhua.daggerdemo.core.di.module.viewmodelmodule;

import android.arch.lifecycle.ViewModel;

import io.reactivex.disposables.CompositeDisposable;

/**
 * Created by Zxhua on 2017/9/8 0008.
 */

public class DaggerBaseViewModel extends ViewModel {
    private final CompositeDisposable compositeDisposable = new CompositeDisposable();

    protected DaggerBaseViewModel() {
        super();
    }

    @Override
    protected void onCleared() {
        compositeDisposable.clear();
    }


}
