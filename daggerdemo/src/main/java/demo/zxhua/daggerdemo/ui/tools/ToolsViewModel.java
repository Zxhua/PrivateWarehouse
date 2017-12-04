package demo.zxhua.daggerdemo.ui.tools;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.ViewModel;

import java.util.List;

import demo.zxhua.daggerdemo.vo.ToolsItem;

/**
 * Created by Zxhua on 2017/11/30 0030.
 */

public class ToolsViewModel extends ViewModel {
    public LiveData<List<ToolsItem>> items;

    public ToolsViewModel() {
    }

}
