package demo.zxhua.daggerdemo.vo;

import android.databinding.Bindable;
import android.databinding.ObservableField;

import demo.zxhua.daggerdemo.R;

/**
 * Created by Zxhua on 2017/12/6 0006.
 */

public class ItemTwo extends BaseVO {
    private ObservableField<String> toolsName = new ObservableField<>();
    private ObservableField<String> toolsIconUrl = new ObservableField<>();

    @Override
    public int getViewType() {
        return R.layout.item_tools2;
    }

    @Bindable
    public String getToolsName() {
        return toolsName.get();
    }

    @Bindable
    public String getToolsIconUrl() {
        return toolsIconUrl.get();
    }

    public void setToolsName(String toolsName) {
        this.toolsName.set(toolsName);
    }

    public void setToolsIconUrl(String toolsIconUrl) {
        this.toolsIconUrl.set(toolsIconUrl);
    }
}
