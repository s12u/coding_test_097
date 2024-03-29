package com.tistory.mybstory.coding_test_097.ui.second;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.paging.DataSource;
import androidx.paging.LivePagedListBuilder;
import androidx.paging.PagedList;

import com.tistory.mybstory.coding_test_097.base.ui.viewmodel.QueryViewModel;
import com.tistory.mybstory.coding_test_097.data.datasource.factory.BookDataSourceFactory;
import com.tistory.mybstory.coding_test_097.data.model.Book;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class SecondViewModel extends QueryViewModel {

    private LiveData<PagedList<Book>> bookListLiveData;
    private MutableLiveData<Boolean> isEmptyLiveData = new MutableLiveData<>(false);

    public SecondViewModel(DataSource.Factory dataSourceFactory) {
        super(dataSourceFactory);
        init();
    }

    // initialize paged list
    private void init() {
        Executor fetchExecutor = Executors.newFixedThreadPool(5);
        // paged list config
        PagedList.Config config = new PagedList.Config.Builder()
                .setInitialLoadSizeHint(30)
                .setPageSize(10)
                .setPrefetchDistance(10)
                .build();
        // create live data from data source with config
        bookListLiveData = new LivePagedListBuilder<>((BookDataSourceFactory) dataSourceFactory, config)
                .setBoundaryCallback(new PagedList.BoundaryCallback<Book>() {
                    @Override
                    public void onZeroItemsLoaded() {
                        isEmptyLiveData.postValue(true);
                    }
                })
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

    public LiveData<Boolean> isListEmpty() {
        return isEmptyLiveData;
    }

}
