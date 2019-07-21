package com.tistory.mybstory.coding_test_097.base.viewmodel.factory;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.tistory.mybstory.coding_test_097.base.viewmodel.ResultViewModel;
import com.tistory.mybstory.coding_test_097.base.viewmodel.util.ResultHandler;

import java.lang.reflect.InvocationTargetException;

/**
 * A Factory class for creating {@link ResultViewModel}.
 *
 */
public class ResultViewModelFactory<T> implements ViewModelProvider.Factory {

    protected final ResultHandler<T> resultHandler;

    public ResultViewModelFactory(ResultHandler<T> resultHandler) {
        this.resultHandler =  resultHandler;
    }

    @NonNull
    @Override
    public <VM extends ViewModel> VM create(@NonNull Class<VM> modelClass) {
        if (ResultViewModel.class.isAssignableFrom(modelClass)) {
            try {
                return modelClass.getConstructor(ResultHandler.class).newInstance(resultHandler);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            } catch (NoSuchMethodException e) {
                e.printStackTrace();
            }
        }
        throw new IllegalArgumentException("Unknown ViewModel class");
    }
}
