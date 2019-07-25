package com.tistory.mybstory.coding_test_097.ui.second;

import androidx.paging.DataSource;

import com.tistory.mybstory.coding_test_097.base.ui.viewmodel.factory.QueryViewModelFactory;
import com.tistory.mybstory.coding_test_097.data.api.ApiService;
import com.tistory.mybstory.coding_test_097.data.datasource.factory.BookDataSourceFactory;
import com.tistory.mybstory.coding_test_097.ui.adapter.SearchResultAdapter;

import javax.inject.Named;

import dagger.Module;
import dagger.Provides;

@Module
public class SecondModule {

    @Provides
    @Named("query")
    String provideQuery(SecondActivity activity) {
        return activity.getIntent().getStringExtra("query");
    }

    @Provides
    SearchResultAdapter provideAdapter() {
        return new SearchResultAdapter(SearchResultAdapter.DIFF_CALLBACK);
    }

    @Provides
    DataSource.Factory provideBookDataSourceFactory(ApiService apiService, @Named("query") String query) {
        return new BookDataSourceFactory(apiService, query);
    }

    @Provides
    QueryViewModelFactory provideQueryViewModelFactory(BookDataSourceFactory dataSourceFactory) {
        return new QueryViewModelFactory(dataSourceFactory);
    }

}
