package demo.zxhua.daggerdemo.vo;

import android.databinding.BaseObservable;
import android.databinding.Observable;

import demo.zxhua.daggerdemo.core.base.BindingAdapterItem;

/**
 * Created by Zxhua on 2017/12/5 0005.
 */

class BaseVO extends BaseObservable implements Observable, BindingAdapterItem {

    @Override
    public int getViewType() {
        return 0;
    }
}
