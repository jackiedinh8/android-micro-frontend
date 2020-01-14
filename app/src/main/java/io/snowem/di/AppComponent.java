package io.snowem.di;

import android.support.annotation.NonNull;

import javax.inject.Singleton;

import dagger.Component;
import dagger.internal.Preconditions;
import io.snowem.MainApplication;

@Component(
        modules = {
                GlobalNavigationModule.class,
                AppModule.class
        })
@Singleton
public abstract class AppComponent {
    private static volatile AppComponent sInstance;

    @NonNull
    public static AppComponent get() {
        return Preconditions.checkNotNull(sInstance,
                "AppComponent is not initialized yet. Call init first.");
    }

    public static void init(@NonNull AppComponent component) {
        if (sInstance != null) {
            throw new IllegalArgumentException("AppComponent is already initialized.");
        }
        sInstance = component;
    }

    public abstract void inject(MainApplication mainApplication);

    public abstract MainScreenComponent mainScreenComponent();
}
