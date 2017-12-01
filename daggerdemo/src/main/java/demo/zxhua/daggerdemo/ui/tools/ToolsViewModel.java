package demo.zxhua.daggerdemo.ui.tools;

import android.app.Application;
import android.arch.lifecycle.LiveData;

import java.util.List;

import demo.zxhua.daggerdemo.core.dagger.viewmodelmodule.DaggerBaseViewModel;
import demo.zxhua.daggerdemo.vo.ToolsItem;

/**
 * Created by Zxhua on 2017/11/30 0030.
 */

public class ToolsViewModel extends DaggerBaseViewModel {
    public LiveData<List<ToolsItem>> items;

    public ToolsViewModel(Application application) {
        super(application);


    }

}
