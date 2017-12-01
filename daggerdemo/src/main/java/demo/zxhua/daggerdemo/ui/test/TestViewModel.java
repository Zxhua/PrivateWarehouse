package demo.zxhua.daggerdemo.ui.test;

import android.app.Application;
import android.databinding.ObservableField;

import demo.zxhua.daggerdemo.core.dagger.viewmodelmodule.DaggerBaseViewModel;

/**
 * Created by Zxhua on 2017/11/27 0027.
 */

public class TestViewModel extends DaggerBaseViewModel {

    public ObservableField<String> fragName  = new ObservableField<String>();
    public TestViewModel(Application application) {
        super(application);
    }

    public void setFragName(String fragName){
        this.fragName.set(fragName);
    }


}
