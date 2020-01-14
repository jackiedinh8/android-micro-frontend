package io.snowem.feature.presentation.view;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import javax.inject.Inject;

import io.snowem.feature.R;
import io.snowem.feature.di.FeatureComponent;
import io.snowem.feature.routing.FeatureNavigator;
import ru.terrakok.cicerone.Navigator;
import ru.terrakok.cicerone.NavigatorHolder;
import ru.terrakok.cicerone.Router;

import static io.snowem.feature.routing.FeatureRoutingScreens.FEATURE_WELCOME;

public class FeatureActivity extends AppCompatActivity {

    @Inject
    NavigatorHolder mNavigatorHolder;

    @Inject
    Router mRouter;

    private Navigator mNavigator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        FeatureComponent.get().inject(this);
        mNavigator = new FeatureNavigator(this, getSupportFragmentManager(), R.id.details);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feature);
        if (savedInstanceState == null) {
            Log.d("FeatureActiry", "Move to welcome screen");
            mRouter.navigateTo(FEATURE_WELCOME);
        }
    }

    /**
     * Attention: Use onResumeFragments() with FragmentActivity (more info)
     * https://github.com/terrakok/Cicerone/issues/31
     */
    @Override
    protected void onResumeFragments() {
        super.onResumeFragments();
        mNavigatorHolder.setNavigator(mNavigator);
    }

    @Override
    public void onPause() {
        mNavigatorHolder.removeNavigator();
        if (isFinishing()) {
            //ScannerFeatureComponent.get().resetComponent();
        }
        super.onPause();
    }

    @Override
    public void onBackPressed() {
        if (getSupportFragmentManager().getBackStackEntryCount() <= 1) {
            finish();
            return;
        }
        mRouter.exit();
    }
}
