package demo.zxhua.daggerdemo.core.dagger.application.module;

import android.app.Application;
import android.content.Context;
import android.content.res.Resources;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import demo.zxhua.daggerdemo.core.api.ApiService;
import demo.zxhua.daggerdemo.core.api.calladapter.LiveDataCallAdapterFactory;
import demo.zxhua.daggerdemo.core.dagger.application.DaggerApplication;
import demo.zxhua.daggerdemo.core.dagger.application.ForApplication;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Zxhua on 2017/9/7 0007.
 */
@Module
public class ApplicationModule {

    @Provides
    @Singleton
    ApiService provideApiService() {
        return new Retrofit.Builder()
                .baseUrl("")
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(new LiveDataCallAdapterFactory())
                .build()
                .create(ApiService.class);
    }

}
