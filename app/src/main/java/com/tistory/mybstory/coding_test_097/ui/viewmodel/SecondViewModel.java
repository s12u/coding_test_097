package com.tistory.mybstory.coding_test_097.ui.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.paging.LivePagedListBuilder;
import androidx.paging.PagedList;

import com.tistory.mybstory.coding_test_097.base.ui.viewmodel.QueryViewModel;
import com.tistory.mybstory.coding_test_097.data.ApiClient;
import com.tistory.mybstory.coding_test_097.data.ApiService;
import com.tistory.mybstory.coding_test_097.data.datasource.factory.BookDataSourceFactory;
import com.tistory.mybstory.coding_test_097.data.model.Book;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class SecondViewModel extends QueryViewModel {

    private LiveData<PagedList<Book>> bookListLiveData;

    public SecondViewModel(String query) {
        super(query);
        init();
    }

    // initialize paged list
    private void init() {
        ApiService apiService = ApiClient.getClient().create(ApiService.class);
        Executor fetchExecutor = Executors.newFixedThreadPool(5);
        // paged list config
        PagedList.Config config = new PagedList.Config.Builder()
                .setInitialLoadSizeHint(10)
                .setPageSize(10)
                .build();
        // create live data from data source with config
        bookListLiveData = new LivePagedListBuilder<>(new BookDataSourceFactory(apiService, getQuery()), config)
                .setFetchExecutor(fetchExecutor)
                .build();
    }

    @Override
    protected void onCleared() {
        // release
        super.onCleared();
    }

    public LiveData<PagedList<Book>> getBooksList() {
        return bookListLiveData;
    }

}
