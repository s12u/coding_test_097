package com.tistory.mybstory.coding_test_097.data.datasource;

import androidx.annotation.NonNull;
import androidx.paging.PageKeyedDataSource;

import com.tistory.mybstory.coding_test_097.data.ApiService;
import com.tistory.mybstory.coding_test_097.data.model.Book;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class BookDataSource extends PageKeyedDataSource<Integer, Book> {

    private final String AUTH_KEY = "KakaoAK "+ "5c987a8c6d8e160fc0933fd6f4c87293";
    private final String QUERY_TARGET = "title";

    private final ApiService apiService;
    private final String query;


    public BookDataSource(ApiService apiService, String query) {
        this.apiService = apiService;
        this.query = query;
    }


    @Override
    public void loadInitial(@NonNull LoadInitialParams<Integer> params, @NonNull final LoadInitialCallback<Integer, Book> callback) {
        final int page = 1;

        apiService.requestBookList(AUTH_KEY, QUERY_TARGET, 10, query, page)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(response -> {
                    callback.onResult(response.getDocuments(),
                            null,
                            response.getMeta().is_end() ? null : page + 1);
                }, throwable -> {


                });
    }

    @Override
    public void loadBefore(@NonNull LoadParams<Integer> params, @NonNull LoadCallback<Integer, Book> callback) {

    }

    @Override
    public void loadAfter(@NonNull LoadParams<Integer> params, @NonNull final LoadCallback<Integer, Book> callback) {
        final int page = params.key;
        apiService.requestBookList(AUTH_KEY, QUERY_TARGET, 10, query, page)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(response -> {
                    callback.onResult(response.getDocuments(), page + 1);
                }, throwable -> {

                });
    }

}