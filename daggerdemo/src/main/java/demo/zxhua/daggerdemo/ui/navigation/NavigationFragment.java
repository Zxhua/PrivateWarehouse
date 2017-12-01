package demo.zxhua.daggerdemo.ui.navigation;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import com.ashokvarma.bottomnavigation.BottomNavigationBar;
import com.ashokvarma.bottomnavigation.BottomNavigationItem;

import javax.inject.Inject;

import demo.zxhua.daggerdemo.R;
import demo.zxhua.daggerdemo.core.base.BaseFragment;
import demo.zxhua.daggerdemo.core.dagger.fragment.FragmentComonpent;
import demo.zxhua.daggerdemo.databinding.FragNavigationBinding;
import demo.zxhua.daggerdemo.ui.test.TestFragment;
import demo.zxhua.daggerdemo.utils.ActivityUtils;

/**
 * Created by Zxhua on 2017/11/27 0027.
 */

public class NavigationFragment extends BaseFragment<FragNavigationBinding, NavigationViewModel> {
    @Inject
    public ActivityUtils activityUtils;

    @Override
    protected void inject(FragmentComonpent fragmentComonpent) {
        fragmentComonpent.inject(this);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


        mBinding.btmNavigation
                .addItem(new BottomNavigationItem(R.mipmap.ic_home_white_24dp, "Home").setActiveColorResource(R.color.orange))
                .addItem(new BottomNavigationItem(R.mipmap.ic_book_white_24dp, "Book").setActiveColorResource(R.color.blue))
                .addItem(new BottomNavigationItem(R.mipmap.ic_favorite_white_24dp, "Favorite").setActiveColorResource(R.color.colorAccent))
                .setFirstSelectedPosition(0)
                .initialise();

        mBinding.btmNavigation.setTabSelectedListener(new BottomNavigationBar.OnTabSelectedListener() {
            @Override
            public void onTabSelected(int position) {
                setScrollableText(position);
            }

            @Override
            public void onTabUnselected(int position) {

            }

            @Override
            public void onTabReselected(int position) {

            }
        });

        activityUtils.addFragmentToActivity(getChildFragmentManager(), TestFragment.newTestFragment("Fragment one"), R.id.contentFrame);

    }

    @Override
    protected int layoutId() {
        return R.layout.frag_navigation;
    }

    private void setScrollableText(int position) {
        switch (position) {
            case 0:
                activityUtils.addFragmentToActivity(getChildFragmentManager(), TestFragment.newTestFragment("Fragment one"), R.id.contentFrame);
                break;

            case 1:
                activityUtils.addFragmentToActivity(getChildFragmentManager(), TestFragment.newTestFragment("Fragment two"), R.id.contentFrame);
                break;

            case 2:
                activityUtils.addFragmentToActivity(getChildFragmentManager(), TestFragment.newTestFragment("Fragment three"), R.id.contentFrame);
                break;
        }
    }
}
