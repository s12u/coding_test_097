package com.tistory.mybstory.coding_test_097.base.ui.viewmodel;

import androidx.lifecycle.ViewModel;

import com.tistory.mybstory.coding_test_097.base.ui.viewmodel.util.ResultHandler;
import com.tistory.mybstory.coding_test_097.base.ui.viewmodel.util.ResultObserver;
import com.tistory.mybstory.coding_test_097.data.model.Result;

/**
 * An abstract base class for ViewModel that receives result from View.
 */

public class ResultViewModel extends ViewModel implements ResultObserver {

    private ResultHandler resultHandler;

    public ResultViewModel(ResultHandler resultHandler) {
        this.resultHandler = resultHandler;
        resultHandler.listen(this);
    }

    @Override
    protected void onCleared() {
        resultHandler.dispose();
    }

    @Override
    public void onResult(Result result) {

    }

    public ResultHandler getResultHandler() {
        return resultHandler;
    }

}
