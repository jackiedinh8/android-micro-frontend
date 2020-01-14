package io.snowem.feature.di;


import dagger.Binds;
import dagger.Module;
import io.snowem.feature.FeatureHandlerImpl;
import io.snowem.feature.api.FeatureHandler;
import io.snowem.utils.di.general.PerFeature;

@Module
public abstract class FeatureModule {

    @PerFeature
    @Binds
    public abstract FeatureHandler provideFeatureHandler(FeatureHandlerImpl featureHandler);

}
