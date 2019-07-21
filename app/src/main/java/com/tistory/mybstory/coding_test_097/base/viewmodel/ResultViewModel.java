package com.tistory.mybstory.coding_test_097.base.viewmodel;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;

import com.tistory.mybstory.coding_test_097.base.viewmodel.util.ResultHandler;
import com.tistory.mybstory.coding_test_097.base.viewmodel.util.ResultObserver;

public abstract class ResultViewModel<T> extends ViewModel implements ResultObserver<T> {

    private ResultHandler<T> resultHandler;

    public ResultViewModel(ResultHandler<T> resultHandler) {
        this.resultHandler = resultHandler;
        resultHandler.listen(this);
    }

    @Override
    protected void onCleared() {
        resultHandler.dispose();
    }

    @Override
    public abstract void onResult(T result);

    public ResultHandler<T> getResultHandler() {
        return resultHandler;
    }
}
