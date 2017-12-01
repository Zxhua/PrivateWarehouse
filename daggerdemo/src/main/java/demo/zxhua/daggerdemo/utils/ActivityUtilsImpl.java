package demo.zxhua.daggerdemo.utils;

import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;


public final class ActivityUtilsImpl implements ActivityUtils {

    @Override
    public void addFragmentToActivity(@NonNull final FragmentManager fragmentManager, @NonNull final Fragment fragment, final int frameId) {
        if (!fragment.isAdded()) {
            final FragmentTransaction transaction = fragmentManager.beginTransaction();
            transaction.add(frameId, fragment);
            transaction.commit();
        }
    }

    @Override
    public void addFragmentWithTagToActivity(@NonNull final FragmentManager fragmentManager, @NonNull final Fragment fragment, final int frameId, @NonNull final String tag) {
        if (!fragment.isAdded()) {
            final FragmentTransaction transaction = fragmentManager.beginTransaction();
            transaction.add(frameId, fragment, tag);
            transaction.commit();
        }
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
