package com.tistory.mybstory.coding_test_097.base.ui.viewmodel;

import androidx.lifecycle.ViewModel;

import com.tistory.mybstory.coding_test_097.data.ApiService;

import javax.inject.Inject;

/**
 * An abstract base class for ViewModel that performs String query.
 */
public class QueryViewModel extends ViewModel {

    protected String query;
    protected ApiService apiService;

    // Constructor
    @Inject
    public QueryViewModel(ApiService apiService, String query) {
        this.apiService = apiService;
        this.query = query;
    }
}


