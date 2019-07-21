package com.tistory.mybstory.coding_test_097.base.viewmodel.util;

/**
 * A base interface for observing result from {@link ResultHandler}.
 */
public interface ResultObserver<T> {
    void onResult(T result);
}
