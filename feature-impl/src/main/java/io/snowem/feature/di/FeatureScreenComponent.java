package io.snowem.feature.di;

import dagger.Subcomponent;
import io.snowem.feature.presentation.presenter.FeaturePresenter;
import io.snowem.utils.di.general.PerScreen;

@Subcomponent
@PerScreen
public interface FeatureScreenComponent {

    FeaturePresenter featurePresenter();
}
