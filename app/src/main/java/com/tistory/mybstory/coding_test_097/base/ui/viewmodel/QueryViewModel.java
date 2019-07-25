package com.tistory.mybstory.coding_test_097.base.ui.viewmodel;

import androidx.lifecycle.ViewModel;
import androidx.paging.DataSource;

import javax.inject.Inject;

/**
 * An abstract base class for ViewModel that performs String query.
 */
public class QueryViewModel extends ViewModel {

    // Constructor

    protected DataSource.Factory dataSourceFactory;

    @Inject
    public QueryViewModel(DataSource.Factory dataSourceFactory) {
        this.dataSourceFactory = dataSourceFactory;
    }
}


