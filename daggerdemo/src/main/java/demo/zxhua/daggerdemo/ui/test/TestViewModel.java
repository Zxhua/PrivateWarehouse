package demo.zxhua.daggerdemo.ui.test;

import android.arch.lifecycle.ViewModel;
import android.databinding.ObservableField;

/**
 * Created by Zxhua on 2017/11/27 0027.
 */

public class TestViewModel extends ViewModel {
    public TestViewModel() {
    }

    public ObservableField<String> fragName = new ObservableField<String>();

    public void setFragName(String fragName) {
        this.fragName.set(fragName);
    }


}
