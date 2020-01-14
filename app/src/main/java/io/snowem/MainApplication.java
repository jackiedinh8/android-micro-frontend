package io.snowem;

import android.app.Application;
import android.content.Context;

import javax.inject.Inject;
import javax.inject.Named;

import io.snowem.di.AppComponent;
import io.snowem.di.DaggerAppComponent;
import io.snowem.routing.GlobalNavigator;
import ru.terrakok.cicerone.NavigatorHolder;

import static io.snowem.di.DiConstants.GLOBAL;

public class MainApplication extends Application {

    private static volatile Context sContext;

    @Inject
    @Named(GLOBAL)
    NavigatorHolder mNavigatorHolder;

    @Inject
    GlobalNavigator mGlobalNavigator;

    public static Context getAppContext() {
        return sContext;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        sContext = getApplicationContext();
        AppComponent.init(
                DaggerAppComponent.builder()
                        .build()
        );
        AppComponent.get().inject(this);
        mNavigatorHolder.setNavigator(mGlobalNavigator);
    }

}
