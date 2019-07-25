package com.tistory.mybstory.coding_test_097.base.ui.viewmodel.factory;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.tistory.mybstory.coding_test_097.base.ui.viewmodel.QueryViewModel;
import com.tistory.mybstory.coding_test_097.data.ApiService;

import java.lang.reflect.InvocationTargetException;

import javax.inject.Inject;
import javax.inject.Named;

/**
 * A Factory class for creating {@link QueryViewModel}.
 *
 */
public class QueryViewModelFactory implements ViewModelProvider.Factory {

    private String query;
    private ApiService apiService;

    @Inject
    public QueryViewModelFactory(ApiService apiService, @Named("query") String query) {
        this.query = query;
        this.apiService = apiService;
    }

    @NonNull
    @Override
    public <VM extends ViewModel> VM create(@NonNull Class<VM> modelClass) {
        if (QueryViewModel.class.isAssignableFrom(modelClass)) {
            try {
                return modelClass.getConstructor(ApiService.class, String.class).newInstance(apiService, query);
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
