package demo.zxhua.daggerdemo.core.di.module;

import android.app.Application;
import android.arch.persistence.room.Room;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import demo.zxhua.daggerdemo.core.api.ApiService;
import demo.zxhua.daggerdemo.core.api.calladapter.LiveDataCallAdapterFactory;
import demo.zxhua.daggerdemo.db.AppDb;
import demo.zxhua.daggerdemo.db.ClassDao;
import demo.zxhua.daggerdemo.repository.ClassRepository;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Zxhua on 2017/9/7 0007.
 */
@Module(includes = VMModule.class)
public class ApplicationModule {

    @Provides
    @Singleton
    static ApiService provideApiService() {
        return new Retrofit.Builder()
                .baseUrl("")
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(new LiveDataCallAdapterFactory())
                .build()
                .create(ApiService.class);
    }

    @Singleton
    @Provides
    AppDb provideDb(Application app) {
        return Room.databaseBuilder(app, AppDb.class, "app.db").build();
    }

    @Singleton
    @Provides
    ClassDao provideClassDao(AppDb db) {
        return db.classDao();
    }

    @Provides
    @Singleton
    ClassRepository provideClassRepository(){
        return new ClassRepository();
    }

}
