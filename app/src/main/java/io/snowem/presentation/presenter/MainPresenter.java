package io.snowem.presentation.presenter;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;

import javax.inject.Inject;
import javax.inject.Named;

import io.snowem.presentation.view.MainView;
import ru.terrakok.cicerone.Router;

import static io.snowem.di.DiConstants.GLOBAL;
import static io.snowem.routing.GlobalScreenNames.FEATURE_SCREEN;

@InjectViewState
public class MainPresenter extends MvpPresenter<MainView> {

    private final Router mRouter;

    @Inject
    public MainPresenter(@Named(GLOBAL) Router mRouter) {
        this.mRouter = mRouter;
    }

    public void clickToFeature() {
        mRouter.navigateTo(FEATURE_SCREEN);
    }

}
