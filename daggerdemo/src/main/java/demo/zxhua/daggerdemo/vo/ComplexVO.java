package demo.zxhua.daggerdemo.vo;

import android.databinding.ObservableBoolean;
import android.databinding.ObservableField;

import demo.zxhua.daggerdemo.R;

/**
 * Created by Zxhua on 2017/12/6 0006.
 */

public class ComplexVO extends BaseVO {
    public ObservableField<String> labelKey = new ObservableField<>();
    public ObservableField<String> labelValue = new ObservableField<>();
    public ObservableBoolean isEdit = new ObservableBoolean(false);
    public ObservableField<Integer> resource = new ObservableField<>();

    @Override
    public int getViewType() {
        return R.layout.item_edit_select_complex;
    }
}
