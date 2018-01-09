package demo.zxhua.daggerdemo.utils;

import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

import java.util.List;


public final class  ActivityUtilsImpl implements ActivityUtils {

    private void controller(FragmentManager fragmentManager, Fragment fragment, int frameId, String tag) {
        List<Fragment> fragments = fragmentManager.getFragments();
        final FragmentTransaction transaction = fragmentManager.beginTransaction();
        if (fragments.contains(fragment)) {
            transaction.show(fragment);
        } else {
            transaction.add(frameId, fragment, tag);
        }
        for (Fragment frag : fragments) {
            if (!tag.equals(frag.getTag())) {
                transaction.hide(frag);
            }
        }
        transaction.commitAllowingStateLoss();
    }

    @Override
    public void addFragmentToActivity(@NonNull final FragmentManager fragmentManager, @NonNull final Fragment fragment, final int frameId) {
        if (!fragment.isAdded()) {
            final FragmentTransaction transaction = fragmentManager.beginTransaction();
            transaction.replace(frameId, fragment);
            transaction.commit();
        }
    }

    @Override
    public void addFragmentWithTagToActivity(@NonNull final FragmentManager fragmentManager, @NonNull final Fragment fragment, final int frameId, @NonNull final String tag) {
        controller(fragmentManager, fragment, frameId, tag);
    }

    @Override
    public void addFragmentWithTagToActivity(@NonNull final FragmentManager fragmentManager, @NonNull final Fragment fragment, final String tag, final int frameId,
                                             final String backStackName) {
        final FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.add(frameId, fragment, tag);
        transaction.addToBackStack(backStackName);
        transaction.commit();
    }

    @Override
    public void setFragmentWithTagToActivity(@NonNull final FragmentManager fragmentManager, @NonNull final Fragment fragment, final String tag, final int frameId,
                                             final String backStackName) {
        setFragmentWithTagToActivity(fragmentManager, fragment, tag, frameId, backStackName, true);
    }

    @Override
    public void setFragmentWithTagToActivity(@NonNull final FragmentManager fragmentManager, @NonNull final Fragment fragment, final String tag, final int frameId,
                                             final String backStackName, final boolean animateEntrance) {
        final FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(frameId, fragment, tag);
        transaction.addToBackStack(backStackName);
        transaction.commit();
    }

    @Override
    public void removeFragmentFromActivity(@NonNull final FragmentManager fragmentManager, @NonNull final Fragment fragment) {
        final FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.remove(fragment);
        transaction.commit();
    }

}
