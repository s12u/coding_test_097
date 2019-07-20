package com.tistory.mybstory.coding_test_097.base.viewmodel;

import androidx.lifecycle.ViewModel;

public class QueryViewModel extends ViewModel {

    private String query;

    public QueryViewModel(String query) {
        this.query = query;
    }

    public String getQuery() {
        return query;
    }
}
