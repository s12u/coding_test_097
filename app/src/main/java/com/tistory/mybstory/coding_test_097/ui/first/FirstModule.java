package com.tistory.mybstory.coding_test_097.ui.first;

import com.tistory.mybstory.coding_test_097.base.ui.viewmodel.factory.ResultViewModelFactory;
import com.tistory.mybstory.coding_test_097.base.ui.viewmodel.util.ResultHandler;

import dagger.Module;
import dagger.Provides;

@Module
public class FirstModule {
    @Provides
    ResultViewModelFactory provideResultViewModelFactory(ResultHandler resultHandler) {
        return new ResultViewModelFactory(resultHandler);
    }

    @Provides
    ResultHandler provideResultHandler() {
        return new ResultHandler();
    }
}
