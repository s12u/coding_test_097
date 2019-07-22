package com.tistory.mybstory.coding_test_097.ui;

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
import com.tistory.mybstory.coding_test_097.ui.adapter.SearchResultAdapter;
import com.tistory.mybstory.coding_test_097.ui.viewmodel.SecondViewModel;

public class SecondActivity extends BaseActivity {

    private ActivitySecondBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_second);
        // for observing LiveData<PagedList<T>>
        binding.setLifecycleOwner(this);
        // query from FirstActivity
        String query = getIntent().getStringExtra("query");
        // create ViewModel with query
        binding.setViewModel(ViewModelProviders.of(this, new QueryViewModelFactory(query))
                .get(SecondViewModel.class));
        // create & add adapter to binding
        binding.setSearchResultAdapter(new SearchResultAdapter(SearchResultAdapter.DIFF_CALLBACK));
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
