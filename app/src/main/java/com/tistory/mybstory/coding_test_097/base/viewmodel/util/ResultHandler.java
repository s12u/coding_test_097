package com.tistory.mybstory.coding_test_097.base.viewmodel.util;

import androidx.lifecycle.Observer;

public class ResultHandler<T> {

    private ResultObserver<T> observer;

    public void listen(ResultObserver<T> observer) {
        this.observer = observer;
    }

    public void onResult(T result) {
        observer.onResult(result);
    }

    public void dispose() {
        observer = null;
    }
}
