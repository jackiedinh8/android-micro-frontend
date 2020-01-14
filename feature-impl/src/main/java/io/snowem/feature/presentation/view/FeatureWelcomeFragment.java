package io.snowem.feature.presentation.view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.arellomobile.mvp.MvpAppCompatFragment;
import com.arellomobile.mvp.presenter.InjectPresenter;
import com.arellomobile.mvp.presenter.ProvidePresenter;

import io.snowem.feature.R;
import io.snowem.feature.di.FeatureComponent;
import io.snowem.feature.presentation.presenter.FeaturePresenter;

public class FeatureWelcomeFragment extends MvpAppCompatFragment implements FeatureWelcomeView {
    @InjectPresenter
    FeaturePresenter mScannerPresenter;

    @ProvidePresenter
    FeaturePresenter provideScannerPresenter() {
        //return null
        return FeatureComponent.get()
                .featureScreenComponent()
                .featurePresenter();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_welcome, null);
        //view.findViewById(R.id.button_purchase).setOnClickListener(v -> mScannerPresenter.requestSomeApi());

        return view;
    }

    @Override
    public void requestSomeApi() {
        Toast.makeText(getContext(), R.string.feature_screen_name, Toast.LENGTH_SHORT).show();
    }
}
