package demo.zxhua.daggerdemo.ui.tools;

import android.arch.lifecycle.MediatorLiveData;
import android.arch.lifecycle.ViewModel;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.inject.Inject;

import demo.zxhua.daggerdemo.core.base.BindingAdapterItem;
import demo.zxhua.daggerdemo.vo.ItemOne;
import demo.zxhua.daggerdemo.vo.ItemTwo;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by Zxhua on 2017/11/30 0030.
 */

public class ToolsViewModel extends ViewModel {
    public MediatorLiveData<List<BindingAdapterItem>> items = new MediatorLiveData<>();

    @Inject
    public ToolsViewModel() {
        getItems();
    }

    public MediatorLiveData<List<BindingAdapterItem>> getItems() {
        Observable.interval(3, TimeUnit.SECONDS)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(aLong -> {
                    if (aLong % 2 == 0) {
                        items.setValue(oneType());
                    } else {
                        items.setValue(twoType());
                    }
                });
        return items;
    }


    private List<BindingAdapterItem> oneType() {
        List<BindingAdapterItem> items = new ArrayList<>();
        for (int i = 0; i < 30; i++) {
            if (i % 2 == 0) {
                ItemOne itemOne = new ItemOne();
                itemOne.setToolsName(i + "AAAAAA");
                items.add(itemOne);
            } else {
                ItemTwo itemTwo = new ItemTwo();
                itemTwo.setToolsName(i + "BBBBBB");
                items.add(itemTwo);
            }
        }
        return items;
    }

    private List<BindingAdapterItem> twoType() {
        List<BindingAdapterItem> items = new ArrayList<>();
        for (int i = 0; i < 30; i++) {
            if (i % 2 != 0) {
                ItemOne itemOne = new ItemOne();
                itemOne.setToolsName(i + "CCCCC");
                items.add(itemOne);
            } else {
                ItemTwo itemTwo = new ItemTwo();
                itemTwo.setToolsName(i + "DDDDD");
                items.add(itemTwo);
            }
        }
        return items;
    }

}
