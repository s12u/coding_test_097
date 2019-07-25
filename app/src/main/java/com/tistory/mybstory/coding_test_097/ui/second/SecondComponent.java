package com.tistory.mybstory.coding_test_097.ui.second;

import android.app.Activity;

import com.tistory.mybstory.coding_test_097.di.ActivityScope;

import dagger.BindsInstance;
import dagger.Subcomponent;
import dagger.android.AndroidInjector;

@ActivityScope
@Subcomponent(modules = SecondModule.class)
public interface SecondComponent extends AndroidInjector<Activity> {
    @Subcomponent.Builder
    interface Builder {
        @BindsInstance
        SecondComponent.Builder query(SecondActivity activity);
        SecondComponent build();
    }
}
