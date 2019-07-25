package com.tistory.mybstory.coding_test_097.di;

import android.app.Application;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class AppModule {
    @Provides
    @Singleton
    Application provideApplication(Application application) {
        return application;
    }
}
