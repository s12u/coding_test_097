package com.tistory.mybstory.coding_test_097.base.ui.viewmodel.factory;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.paging.DataSource;

import com.tistory.mybstory.coding_test_097.base.ui.viewmodel.QueryViewModel;

import java.lang.reflect.InvocationTargetException;

import javax.inject.Inject;

/**
 * A Factory class for creating {@link QueryViewModel}.
 */
public class QueryViewModelFactory implements ViewModelProvider.Factory {

    private DataSource.Factory dataSourceFactory;

    @Inject
    public QueryViewModelFactory(DataSource.Factory dataSourceFactory) {
        this.dataSourceFactory = dataSourceFactory;
    }

    @NonNull
    @Override
    public <VM extends ViewModel> VM create(@NonNull Class<VM> modelClass) {
        if (QueryViewModel.class.isAssignableFrom(modelClass)) {
            try {
                return modelClass.getConstructor(DataSource.Factory.class).newInstance(dataSourceFactory);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (NoSuchMethodException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }
        }
        throw new IllegalArgumentException("Unknown ViewModel class");
    }
}
