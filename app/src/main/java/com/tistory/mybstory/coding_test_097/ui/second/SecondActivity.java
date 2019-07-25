package com.tistory.mybstory.coding_test_097.ui.second;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProviders;

import com.tistory.mybstory.coding_test_097.R;
import com.tistory.mybstory.coding_test_097.base.ui.BaseActivity;
import com.tistory.mybstory.coding_test_097.base.ui.viewmodel.factory.QueryViewModelFactory;
import com.tistory.mybstory.coding_test_097.databinding.ActivitySecondBinding;
import com.tistory.mybstory.coding_test_097.di.DaggerAppComponent;
import com.tistory.mybstory.coding_test_097.ui.adapter.SearchResultAdapter;

import javax.inject.Inject;
import javax.inject.Named;

public class SecondActivity extends BaseActivity {

    @Inject
    @Named("query")
    String query;
    @Inject QueryViewModelFactory factory;
    @Inject SearchResultAdapter adapter;
    private ActivitySecondBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        DaggerAppComponent
                .builder()
                .application(getApplication())
                .build()
                .queryComponentBuilder()
                .query(this)
                .build();
        binding = DataBindingUtil.setContentView(this, R.layout.activity_second);
        // for observing LiveData<PagedList<T>>
        binding.setLifecycleOwner(this);
        // create ViewModel with query
        binding.setViewModel(ViewModelProviders.of(this, factory).get(SecondViewModel.class));
        // create & add adapter to binding
        binding.setSearchResultAdapter(adapter);
        initUI(query);
    }

    private void initUI(String query) {
        ActionBar actionbar = getSupportActionBar();
        if (actionbar != null) {
            actionbar.setDisplayHomeAsUpEnabled(true);
            actionbar.setDisplayShowHomeEnabled(true);
            actionbar.setTitle(query);
        }
    }

    @Override
    public void onBackPressed() {
        finishWithTransition(0, R.anim.exit_to_right);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finishWithTransition(0, R.anim.exit_to_right);
        }
        return super.onOptionsItemSelected(item);
    }

}
