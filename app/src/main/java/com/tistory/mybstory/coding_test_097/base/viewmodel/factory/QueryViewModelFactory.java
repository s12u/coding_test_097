package com.tistory.mybstory.coding_test_097.base.viewmodel.factory;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.tistory.mybstory.coding_test_097.base.viewmodel.QueryViewModel;

import java.lang.reflect.InvocationTargetException;

/**
 * A Factory class for creating {@link QueryViewModel}.
 *
 */
public class QueryViewModelFactory implements ViewModelProvider.Factory {

    private final String query;

    public QueryViewModelFactory(String query) {
        this.query = query;
    }

    @NonNull
    @Override
    public <VM extends ViewModel> VM create(@NonNull Class<VM> modelClass) {
        if (QueryViewModel.class.isAssignableFrom(modelClass)) {
            try {
                return modelClass.getConstructor(String.class).newInstance(query);
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
