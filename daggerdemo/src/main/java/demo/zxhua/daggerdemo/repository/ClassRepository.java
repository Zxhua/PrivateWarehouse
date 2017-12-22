package demo.zxhua.daggerdemo.repository;

import android.arch.lifecycle.LiveData;

import java.util.List;

import javax.inject.Inject;

import demo.zxhua.daggerdemo.db.ClassDao;
import demo.zxhua.daggerdemo.vo.ClassEntity;

/**
 * Created by Zxhua on 2017/12/20 0020.
 */

public class ClassRepository {

    public ClassRepository() {
    }

    @Inject
    public ClassDao classDao;


    public LiveData<List<ClassEntity>> load() {
        return classDao.load();
    }

    public void insert(ClassEntity... classEntity) {
        classDao.insert(classEntity);
    }


}
