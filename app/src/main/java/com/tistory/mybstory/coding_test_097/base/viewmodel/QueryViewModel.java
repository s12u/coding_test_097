package com.tistory.mybstory.coding_test_097.base.viewmodel;

import androidx.lifecycle.ViewModel;

/**
 * An abstract base class for ViewModel that performs String query.
 */
public class QueryViewModel extends ViewModel {

    // String query
    private String query;

    // Constructor
    public QueryViewModel(String query) {
        this.query = query;
    }

    // query getter method
    public String getQuery() {
        return query;
    }
}
