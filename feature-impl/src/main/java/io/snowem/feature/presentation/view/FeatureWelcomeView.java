package io.snowem.feature.presentation.view;

import com.arellomobile.mvp.MvpView;
import com.arellomobile.mvp.viewstate.strategy.OneExecutionStateStrategy;
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType;

public interface FeatureWelcomeView extends MvpView {

    @StateStrategyType(OneExecutionStateStrategy.class)
    void requestSomeApi();

}
