package demo.zxhua.daggerdemo.core.di.module;

import android.app.Application;
import android.content.Context;
import android.content.res.Resources;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import demo.zxhua.daggerdemo.App;
import demo.zxhua.daggerdemo.core.api.ApiService;
import demo.zxhua.daggerdemo.core.api.calladapter.LiveDataCallAdapterFactory;
import demo.zxhua.daggerdemo.core.di.scope.ForApplication;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Zxhua on 2017/9/7 0007.
 */
@Module()
public final class ApplicationModule  {
    private final App app;

    public ApplicationModule(final App app) {
        this.app = app;
    }

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

    @Provides
    @Singleton
    Application provideApplication() {
        return app;
    }

    @Provides
    @Singleton
    @ForApplication
    Context provideContext() {
        return app;
    }

    @Provides
    @Singleton
    Resources provideResources() {
        return provideApplication().getResources();
    }

}
