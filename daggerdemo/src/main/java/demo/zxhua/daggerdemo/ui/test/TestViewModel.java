package demo.zxhua.daggerdemo.ui.test;

import android.app.Application;
import android.arch.lifecycle.ViewModel;
import android.databinding.ObservableField;

import javax.inject.Inject;

/**
 * Created by Zxhua on 2017/11/27 0027.
 */

public class TestViewModel extends ViewModel {

    public ObservableField<String> fragName = new ObservableField<String>();


    @Inject
    public TestViewModel() {
    }

    public void setFragName(String fragName) {
        this.fragName.set(fragName);
    }


}
