package com.tistory.mybstory.coding_test_097.base.viewmodel.util;

/**
 * A class for handle type<T> of result.
 */
public class ResultHandler<T> {
    // single observer
    private ResultObserver<T> observer;
    // register observer to handler
    public void listen(ResultObserver<T> observer) {
        this.observer = observer;
    }
    // notify result to observer
    public void onResult(T result) {
        observer.onResult(result);
    }
    // dispose observer
    public void dispose() {
        observer = null;
    }
}
