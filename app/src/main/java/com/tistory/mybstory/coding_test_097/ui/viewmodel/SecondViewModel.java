package com.tistory.mybstory.coding_test_097.ui.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;
import androidx.paging.LivePagedListBuilder;
import androidx.paging.PagedList;

import com.tistory.mybstory.coding_test_097.base.viewmodel.QueryViewModel;
import com.tistory.mybstory.coding_test_097.data.ApiClient;
import com.tistory.mybstory.coding_test_097.data.ApiService;
import com.tistory.mybstory.coding_test_097.data.datasource.factory.BookDataSourceFactory;
import com.tistory.mybstory.coding_test_097.data.model.Book;
import com.tistory.mybstory.coding_test_097.ui.adapter.SearchResultAdapter;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class SecondViewModel extends QueryViewModel {

    private SearchResultAdapter adapter;
    private LiveData<PagedList<Book>> bookListLiveData;

    public SecondViewModel(String query) {
        super(query);
        init();
    }

    private void init() {
        ApiService apiService = ApiClient.getClient().create(ApiService.class);
        Executor fetchExecutor = Executors.newFixedThreadPool(5);
        PagedList.Config config = new PagedList.Config.Builder()
                .setInitialLoadSizeHint(10)
                .setPageSize(10)
                .build();
        bookListLiveData = new LivePagedListBuilder<>(new BookDataSourceFactory(apiService, getQuery()), config)
                .setFetchExecutor(fetchExecutor)
                .build();
        adapter = new SearchResultAdapter(SearchResultAdapter.DIFF_CALLBACK);
    }

    @Override
    protected void onCleared() {
        super.onCleared();
    }

    public LiveData<PagedList<Book>> getBooksList() {
        return bookListLiveData;
    }

    public SearchResultAdapter getAdapter() {
        return adapter;
    }

}
