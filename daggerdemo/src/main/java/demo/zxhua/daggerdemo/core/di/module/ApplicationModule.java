package demo.zxhua.daggerdemo.core.di.module;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import demo.zxhua.daggerdemo.core.api.ApiService;
import demo.zxhua.daggerdemo.core.api.calladapter.LiveDataCallAdapterFactory;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Zxhua on 2017/9/7 0007.
 */
@Module
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

}
