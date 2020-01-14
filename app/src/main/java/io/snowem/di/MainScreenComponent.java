package io.snowem.di;

import dagger.Subcomponent;
import io.snowem.presentation.presenter.MainPresenter;
import io.snowem.utils.di.general.PerScreen;

@Subcomponent
@PerScreen
public interface MainScreenComponent {

    MainPresenter mainPresenter();

}
