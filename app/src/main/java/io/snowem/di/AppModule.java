package io.snowem.di;

import android.content.Context;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import io.snowem.MainApplication;

@Module
public class AppModule {

    @Singleton
    @Provides
    Context provideContext() {
        return MainApplication.getAppContext();
    }

}
