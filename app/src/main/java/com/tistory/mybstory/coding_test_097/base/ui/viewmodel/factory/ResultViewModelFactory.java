package com.tistory.mybstory.coding_test_097.base.ui.viewmodel.factory;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.tistory.mybstory.coding_test_097.base.ui.viewmodel.ResultViewModel;
import com.tistory.mybstory.coding_test_097.base.ui.viewmodel.util.ResultHandler;

import java.lang.reflect.InvocationTargetException;

import javax.inject.Inject;

/**
 * A Factory class for creating {@link ResultViewModel}.
 *
 */
public class ResultViewModelFactory implements ViewModelProvider.Factory {

    protected final ResultHandler resultHandler;

    @Inject
    public ResultViewModelFactory(ResultHandler resultHandler) {
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
