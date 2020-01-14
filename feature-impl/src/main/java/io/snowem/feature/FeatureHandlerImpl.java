package io.snowem.feature;

import android.content.Context;
import android.content.Intent;

import javax.inject.Inject;

import io.snowem.feature.api.FeatureHandler;
import io.snowem.feature.presentation.view.FeatureActivity;
import io.snowem.utils.di.general.PerFeature;

@PerFeature
public class FeatureHandlerImpl implements FeatureHandler {

    @Inject
    public FeatureHandlerImpl() {

    }

    @Override
    public void startFeature(Context context) {
        Class<?> cls = FeatureActivity.class;
        Intent intent = new Intent(context, cls);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(intent);

    }
}
