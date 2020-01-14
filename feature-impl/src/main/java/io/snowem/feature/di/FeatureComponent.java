package io.snowem.feature.di;

import dagger.Component;
import io.snowem.feature.presentation.view.FeatureActivity;
import io.snowem.feature.api.FeatureApi;
import io.snowem.utils.di.app.UtilsApi;
import io.snowem.utils.di.general.PerFeature;

@Component(modules = {
        FeatureModule.class,
        ScreenNavigationModule.class
}, dependencies = FeatureDependencies.class)
@PerFeature
public abstract class FeatureComponent implements FeatureApi {
    private static volatile FeatureComponent sfeatureComponent;

    public static FeatureApi initAndGet(FeatureDependencies featureDependencies) {
        if (sfeatureComponent == null) {
            synchronized (FeatureComponent.class) {
                if (sfeatureComponent == null) {
                    sfeatureComponent = DaggerFeatureComponent.builder()
                            .featureDependencies(featureDependencies)
                            .build();
                }
            }
        }
        return sfeatureComponent;
    }

    public static FeatureComponent get() {
        if (sfeatureComponent == null) {
            throw new RuntimeException("You must call 'initAndGet with LoginDependenciesComponent'");
        }
        return sfeatureComponent;
    }

    public void resetComponent() {
        sfeatureComponent = null;
    }

    public abstract void inject(FeatureActivity featureActivity);

    public abstract FeatureScreenComponent featureScreenComponent();

    @Component(dependencies = {
            UtilsApi.class
    })
    @PerFeature
    interface FeatureDependenciesComponent extends FeatureDependencies { }
}
