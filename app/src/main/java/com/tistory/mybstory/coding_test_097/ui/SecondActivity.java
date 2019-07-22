package com.tistory.mybstory.coding_test_097.ui;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.BindingAdapter;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProviders;
import androidx.paging.PagedList;
import androidx.paging.PagedListAdapter;
import androidx.recyclerview.widget.RecyclerView;

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
        // for LiveData<PagedList<T>>
        binding.setLifecycleOwner(this);
        // query from FirstActivity
        String query = getIntent().getStringExtra("query");
        // create ViewModel with query
        binding.setViewModel(ViewModelProviders.of(this, new QueryViewModelFactory(query))
                .get(SecondViewModel.class));
        // create & add adapter to binding
        binding.setSearchResultAdapter(new SearchResultAdapter(SearchResultAdapter.DIFF_CALLBACK));
        initUI();
    }

    // binding adapter for recycler view
    @BindingAdapter(value = {"android:adapter", "android:data"})
    public static <T, VH extends RecyclerView.ViewHolder> void bind(
            RecyclerView recyclerView, PagedListAdapter<T, VH> adapter, PagedList<T> data) {
        recyclerView.setAdapter(adapter);
        // update recycler view's data from view model
        adapter.submitList(data);
    }

    private void initUI() {
        if (getSupportActionBar() != null){
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }
    }

    @Override
    public void onBackPressed() {
        finishWithTransition(0, R.anim.exit_to_bottom);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finishWithTransition(0, R.anim.exit_to_right);
        }
        return super.onOptionsItemSelected(item);
    }

}
