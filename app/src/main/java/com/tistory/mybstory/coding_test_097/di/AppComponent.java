package com.tistory.mybstory.coding_test_097.di;

import android.app.Application;

import com.tistory.mybstory.coding_test_097.App;
import com.tistory.mybstory.coding_test_097.ui.second.SecondComponent;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;
import dagger.android.AndroidInjector;
import dagger.android.support.AndroidSupportInjectionModule;

@Singleton
@Component(modules = {AppModule.class, ApiModule.class, ActivityBindingModule.class, AndroidSupportInjectionModule.class})
public interface AppComponent extends AndroidInjector<App> {

    SecondComponent.Builder queryComponentBuilder();

    @Component.Builder
    interface Builder {
        @BindsInstance
        AppComponent.Builder application(Application application);

        AppComponent build();
    }

}
