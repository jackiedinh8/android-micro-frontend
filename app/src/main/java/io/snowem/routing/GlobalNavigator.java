package io.snowem.routing;

import android.content.Context;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.snowem.di.FeatureProxyInjector;
import ru.terrakok.cicerone.Navigator;
import ru.terrakok.cicerone.commands.Command;
import ru.terrakok.cicerone.commands.Forward;

import static io.snowem.routing.GlobalScreenNames.FEATURE_SCREEN;

@Singleton
public class GlobalNavigator implements Navigator {
    private final Context mContext;

    @Inject
    public GlobalNavigator(Context mContext) {
        this.mContext = mContext;
    }

    @Override
    public void applyCommands(Command[] commands) {
        for (Command command : commands) {
            applyCommand(command);
        }
    }

    private void applyCommand(Command command) {
        if (command instanceof Forward) {
            forward((Forward) command);
            return;
        }
        throw new RuntimeException("Unexpected action");
    }

    private void forward(Forward command) {
        String name = command.getScreenKey();
        startFeatureStartPoint(name);
    }

    private void startFeatureStartPoint(String name) {
        switch (name) {
            case FEATURE_SCREEN:
                FeatureProxyInjector.getFeatureHandler().featureHandler().startFeature(mContext);
                return;
            default: throw new RuntimeException("Unexpected screen: " + name);
        }
    }

}
