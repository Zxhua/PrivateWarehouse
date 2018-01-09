package demo.zxhua.daggerdemo.ui.navigation;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import com.ashokvarma.bottomnavigation.BottomNavigationBar;
import com.ashokvarma.bottomnavigation.BottomNavigationItem;

import javax.inject.Inject;

import demo.zxhua.daggerdemo.R;
import demo.zxhua.daggerdemo.core.base.BaseFragment;
import demo.zxhua.daggerdemo.databinding.FragNavigationBinding;
import demo.zxhua.daggerdemo.ui.complex.ComplexFragment;
import demo.zxhua.daggerdemo.ui.test.CustomViewFragment;
import demo.zxhua.daggerdemo.ui.test.TestFragment;
import demo.zxhua.daggerdemo.ui.tools.ToolsFragment;
import demo.zxhua.daggerdemo.utils.ActivityUtils;

/**
 * Created by Zxhua on 2017/11/27 0027.
 */

public class NavigationFragment extends BaseFragment<FragNavigationBinding, NavigationViewModel> {
    @Inject
    public ActivityUtils activityUtils;

    private TestFragment fragment1;
    private ComplexFragment fragment2;
    private ToolsFragment fragment3;
    private CustomViewFragment customViewFragment;

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initFragment();

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

    private void initFragment() {
//        fragment1 = TestFragment.newTestFragment("Fragment one");
        fragment2 = new ComplexFragment();
        fragment3 = new ToolsFragment();
        customViewFragment = new CustomViewFragment();
    }

    @Override
    protected int layoutId() {
        return R.layout.frag_navigation;
    }

    private void setScrollableText(int position) {
        switch (position) {
            case 0:
                activityUtils.addFragmentWithTagToActivity(getChildFragmentManager(), customViewFragment, R.id.contentFrame, "one");
                break;

            case 1:
                activityUtils.addFragmentWithTagToActivity(getChildFragmentManager(), fragment2, R.id.contentFrame, "two");
                break;

            case 2:
                activityUtils.addFragmentWithTagToActivity(getChildFragmentManager(), fragment3, R.id.contentFrame, "three");
                break;
        }
    }
}
