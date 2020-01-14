package io.snowem.di;

import javax.inject.Named;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import ru.terrakok.cicerone.Cicerone;
import ru.terrakok.cicerone.NavigatorHolder;
import ru.terrakok.cicerone.Router;

import static io.snowem.di.DiConstants.GLOBAL;

@Module
public class GlobalNavigationModule {

    private final Cicerone<Router> mCicerone;

    public GlobalNavigationModule() {
        mCicerone = Cicerone.create();
    }

    @Singleton
    @Provides
    @Named(GLOBAL)
    Router provideRouter() {
        return mCicerone.getRouter();
    }

    @Singleton
    @Provides
    @Named(GLOBAL)
    NavigatorHolder provideNavigatorHolder() {
        return mCicerone.getNavigatorHolder();
    }

}
