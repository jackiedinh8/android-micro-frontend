package io.snowem.feature.routing;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;

import io.snowem.feature.presentation.view.FeatureWelcomeFragment;
import ru.terrakok.cicerone.android.SupportFragmentNavigator;

import static io.snowem.feature.routing.FeatureRoutingScreens.FEATURE_WELCOME;

public class FeatureNavigator extends SupportFragmentNavigator {

    private final AppCompatActivity mActivityCompat;

    /**
     * Creates SupportFragmentNavigator.
     *
     * @param fragmentManager support fragment manager
     * @param containerId     id of the fragments container layout
     */
    public FeatureNavigator(AppCompatActivity activityCompat, FragmentManager fragmentManager, int containerId) {
        super(fragmentManager, containerId);
        mActivityCompat = activityCompat;
    }
    @Override
    protected Fragment createFragment(String screenKey, Object data) {
        switch (screenKey) {
            case FEATURE_WELCOME:
                return new FeatureWelcomeFragment();
            default:
                return null;
        }
    }

    @Override
    protected void showSystemMessage(String message) {

    }

    @Override
    protected void exit() {

    }
}
