package io.snowem.utils.di.app;

import javax.inject.Singleton;

import dagger.Component;

@Component
@Singleton
public abstract class UtilsComponent implements UtilsApi {
    private static volatile UtilsComponent sUtilsComponent;

    public static UtilsComponent get() {
        if (sUtilsComponent == null) {
            synchronized (UtilsComponent.class) {
                if (sUtilsComponent == null) {
                    sUtilsComponent = DaggerUtilsComponent.builder().build();
                }
            }
        }
        return sUtilsComponent;
    }

}
