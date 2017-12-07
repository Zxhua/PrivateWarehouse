package demo.zxhua.daggerdemo.ui.complex;

import android.arch.lifecycle.MediatorLiveData;
import android.arch.lifecycle.ViewModel;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import demo.zxhua.daggerdemo.R;
import demo.zxhua.daggerdemo.core.base.BindingAdapterItem;
import demo.zxhua.daggerdemo.vo.ComplexVO;

/**
 * Created by Zxhua on 2017/12/6 0006.
 */

public class ComplexViewModel extends ViewModel {
    public MediatorLiveData<List<BindingAdapterItem>> items = new MediatorLiveData<>();

    @Inject
    public ComplexViewModel() {
        getItems();
    }

    private void getItems() {
        List<BindingAdapterItem> list = new ArrayList<>();
        for (int i = 0; i < 30; i++) {
            ComplexVO complexVO = new ComplexVO();
            complexVO.labelKey.set(""+i);
            if (i % 3 == 0) {
                complexVO.resource.set(R.array.edu_name);
                complexVO.isEdit.set(false);
            } else {
                complexVO.isEdit.set(true);
            }
            list.add(complexVO);
        }
        items.setValue(list);
    }


}
