package demo.zxhua.daggerdemo.ui.test;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MediatorLiveData;
import android.arch.lifecycle.Transformations;
import android.arch.lifecycle.ViewModel;
import android.databinding.ObservableBoolean;
import android.databinding.ObservableField;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import demo.zxhua.daggerdemo.core.base.BindingAdapterItem;
import demo.zxhua.daggerdemo.repository.ClassRepository;
import demo.zxhua.daggerdemo.vo.ClassEntity;
import demo.zxhua.daggerdemo.vo.StudentEntity;

/**
 * Created by Zxhua on 2017/11/27 0027.
 */

public class TestViewModel extends ViewModel {

    public ObservableBoolean mStuIsEmpty = new ObservableBoolean(true);

    public ObservableBoolean mClassIsEmpty = new ObservableBoolean(true);

    public LiveData<List<BindingAdapterItem>> classes;

    public MediatorLiveData<List<StudentEntity>> stus = new MediatorLiveData<List<StudentEntity>>();

    @Inject
    public ClassRepository classRepository;

    @Inject
    public TestViewModel() {
        loadClass();
    }

    public ObservableField<String> fragName = new ObservableField<String>();

    public void setFragName(String fragName) {
        this.fragName.set(fragName);
    }

    public void addClass(ClassEntity classEntity) {
        classRepository.insert(classEntity);
        loadClass();
    }

    public void addStu(StudentEntity studentEntity) {
    }

    public void loadClass() {
        classes = Transformations.map(classRepository.load(), input -> {
            List<BindingAdapterItem> clsItems = new ArrayList<>();
            clsItems.addAll(input);
            return clsItems;
        });
    }


}
