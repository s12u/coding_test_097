package com.tistory.mybstory.coding_test_097.base.ui.viewmodel.util;

import com.tistory.mybstory.coding_test_097.data.model.Result;

/**
 * A class for handle type<T> of result.
 */
public class ResultHandler {
    // single observer
    private ResultObserver observer;
    // register observer to handler
    public void listen(ResultObserver observer) {
        this.observer = observer;
    }
    // notify result to observer
    public void onResult(Result result) {
        observer.onResult(result);
    }
    // dispose observer
    public void dispose() {
        observer = null;
    }
}
