package demo.zxhua.daggerdemo.ui.navigation;

import android.app.Application;

import javax.inject.Inject;

import demo.zxhua.daggerdemo.core.dagger.viewmodelmodule.DaggerBaseViewModel;

/**
 * Created by Zxhua on 2017/11/27 0027.
 */

public class NavigationViewModel extends DaggerBaseViewModel {

    @Inject
    public NavigationViewModel(Application application) {
        super(application);
    }



}
