package demo.zxhua.daggerdemo.core.dagger.application.module;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import demo.zxhua.daggerdemo.utils.ActivityUtils;
import demo.zxhua.daggerdemo.utils.ActivityUtilsImpl;
import demo.zxhua.daggerdemo.utils.ImageLoaderUtils;
import demo.zxhua.daggerdemo.utils.ImageLoaderUtilsImpl;
import demo.zxhua.daggerdemo.utils.TransformUtils;
import demo.zxhua.daggerdemo.utils.TransformUtilsImpl;

/**
 * Created by Zxhua on 2017/9/11 0011.
 */

@Module
public class UtilsModule {
    @Provides
    @Singleton
    ActivityUtils provideActivityUtils() {
        return new ActivityUtilsImpl();
    }

    @Provides
    @Singleton
    TransformUtils provideTransformUtils() {
        return new TransformUtilsImpl();
    }

    @Provides
    @Singleton
    ImageLoaderUtils provideImageLoaderUtils() {
        return new ImageLoaderUtilsImpl();
    }

    public interface Exposes {
        ActivityUtils provideActivityUtils();

        TransformUtils provideTransformUtils();

        ImageLoaderUtils provideImageLoaderUtils();
    }
}
