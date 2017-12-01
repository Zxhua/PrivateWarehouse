package demo.zxhua.daggerdemo.core.dagger.application;

import android.app.Application;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;

import java.util.List;

import demo.zxhua.daggerdemo.core.dagger.ComponentFactory;

/**
 * Created by Zxhua on 2017/9/7 0007.
 */

public class DaggerApplication extends Application {
    private ApplicationComponent daggerApplicationComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        daggerApplicationComponent = ComponentFactory.createApplicationComponent(this);
        daggerApplicationComponent.inject(this);

        PackageManager packageManager = getPackageManager();
        List<PackageInfo> installedPackages = packageManager.getInstalledPackages(PackageManager.GET_UNINSTALLED_PACKAGES);
    }


    public ApplicationComponent getApplicationComponent() {
        return daggerApplicationComponent;
    }
}
