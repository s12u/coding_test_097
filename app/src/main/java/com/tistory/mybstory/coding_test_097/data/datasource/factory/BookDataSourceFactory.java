package com.tistory.mybstory.coding_test_097.data.datasource.factory;

import androidx.annotation.NonNull;
import androidx.paging.DataSource;

import com.tistory.mybstory.coding_test_097.data.ApiService;
import com.tistory.mybstory.coding_test_097.data.datasource.BookDataSource;
import com.tistory.mybstory.coding_test_097.data.model.Book;

/**
 * A factory class that provides {@link BookDataSource} instance.
 */
public class BookDataSourceFactory extends DataSource.Factory<Integer, Book> {

    private ApiService apiService;
    private String query;

    public BookDataSourceFactory (ApiService apiService, String query) {
        this.apiService = apiService;
        this.query = query;
    }

    @NonNull
    @Override
    public DataSource<Integer, Book> create() {
        return new BookDataSource(apiService, query);
    }
}
