package io.snowem.feature.presentation.presenter;

import com.arellomobile.mvp.MvpPresenter;

import javax.inject.Inject;

import io.snowem.feature.presentation.view.FeatureWelcomeView;
import ru.terrakok.cicerone.Router;

public class FeaturePresenter extends MvpPresenter<FeatureWelcomeView> {

    private final Router mRouter;

    @Inject
    public FeaturePresenter(Router router) {
        mRouter = router;
    }

}
