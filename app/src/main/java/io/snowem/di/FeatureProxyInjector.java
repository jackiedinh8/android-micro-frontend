package io.snowem.di;

import io.snowem.feature.di.DaggerFeatureComponent_FeatureDependenciesComponent;
import io.snowem.feature.di.FeatureComponent;
import io.snowem.feature.api.FeatureApi;
import io.snowem.utils.di.app.UtilsComponent;

public class FeatureProxyInjector {

    public static FeatureApi getFeatureHandler() {
        return FeatureComponent.initAndGet(
                DaggerFeatureComponent_FeatureDependenciesComponent.builder()
                      .utilsApi(UtilsComponent.get())
                      .build());
    }
}
