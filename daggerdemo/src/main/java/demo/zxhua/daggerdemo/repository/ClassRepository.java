package demo.zxhua.daggerdemo.repository;

import android.arch.lifecycle.LiveData;
import android.support.annotation.NonNull;

import java.util.List;

import javax.inject.Inject;

import demo.zxhua.daggerdemo.core.api.ApiResponse;
import demo.zxhua.daggerdemo.core.api.NetworkBoundResource;
import demo.zxhua.daggerdemo.core.api.Resource;
import demo.zxhua.daggerdemo.core.api.executors.AppExecutors;
import demo.zxhua.daggerdemo.db.ClassDao;
import demo.zxhua.daggerdemo.vo.ClassEntity;

/**
 * Created by Zxhua on 2017/12/20 0020.
 */
public class ClassRepository {
    @Inject
    public ClassDao classDao;

    @Inject
    public AppExecutors appExecutors;

    public ClassRepository() {
    }


    public LiveData<Resource<List<ClassEntity>>> load() {

        return new NetworkBoundResource<List<ClassEntity>, List<ClassEntity>>(appExecutors) {
            @NonNull
            @Override
            protected LiveData<List<ClassEntity>> loadFromDb() {
                return classDao.load();
            }

            @Override
            protected void saveCallResult(List<ClassEntity> classEntities) {
                ClassEntity[] classEntities1 = (ClassEntity[]) classEntities.toArray();
                classDao.insert(classEntities1);
            }

            @NonNull
            @Override
            protected LiveData<ApiResponse<List<ClassEntity>>> createCall() {
                return null;
            }
        }.asLiveData();
    }

    public void insert(ClassEntity... classEntity) {
        classDao.insert(classEntity);
    }


}
