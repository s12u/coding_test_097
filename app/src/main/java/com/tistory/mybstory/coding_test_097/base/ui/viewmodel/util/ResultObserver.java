package com.tistory.mybstory.coding_test_097.base.ui.viewmodel.util;

import com.tistory.mybstory.coding_test_097.data.model.Result;

/**
 * A base interface for observing result from {@link ResultHandler}.
 */
public interface ResultObserver {
    void onResult(Result result);
}
