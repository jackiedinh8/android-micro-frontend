package io.snowem.feature;

import android.app.Application;

import com.arellomobile.mvp.RegisterMoxyReflectorPackages;

@RegisterMoxyReflectorPackages({"io.snowem.login"})
public class FeatureApplication extends Application {
}
