package com.tistory.mybstory.coding_test_097.ui.second;

import com.tistory.mybstory.coding_test_097.base.ui.viewmodel.factory.QueryViewModelFactory;
import com.tistory.mybstory.coding_test_097.data.ApiService;
import com.tistory.mybstory.coding_test_097.ui.adapter.SearchResultAdapter;

import javax.inject.Named;

import dagger.Module;
import dagger.Provides;

@Module
public class SecondModule {
    @Provides
    QueryViewModelFactory provideQueryViewModelFactory(ApiService apiService, @Named("query") String query) {
        return new QueryViewModelFactory(apiService, query);
    }

    @Provides
    @Named("query")
    String provideQuery(SecondActivity activity) {
        return activity.getIntent().getStringExtra("query");
    }

    @Provides
    SearchResultAdapter provideAdapter() {
        return new SearchResultAdapter(SearchResultAdapter.DIFF_CALLBACK);
    }
}
