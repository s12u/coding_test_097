package com.tistory.mybstory.coding_test_097.di;

import com.tistory.mybstory.coding_test_097.ui.first.FirstActivity;
import com.tistory.mybstory.coding_test_097.ui.first.FirstModule;
import com.tistory.mybstory.coding_test_097.ui.second.SecondActivity;
import com.tistory.mybstory.coding_test_097.ui.second.SecondModule;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class ActivityBindingModule {

    @ActivityScope
    @ContributesAndroidInjector(modules = FirstModule.class)
    abstract FirstActivity provideFirstActivity();

    @ActivityScope
    @ContributesAndroidInjector(modules = SecondModule.class)
    abstract SecondActivity provideSecondActivity();

}