package com.tistory.mybstory.coding_test_097.ui;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.BindingAdapter;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProviders;
import androidx.paging.PagedList;
import androidx.paging.PagedListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import com.tistory.mybstory.coding_test_097.R;
import com.tistory.mybstory.coding_test_097.base.viewmodel.factory.QueryViewModelFactory;
import com.tistory.mybstory.coding_test_097.databinding.ActivitySecondBinding;
import com.tistory.mybstory.coding_test_097.ui.adapter.SearchResultAdapter;
import com.tistory.mybstory.coding_test_097.ui.viewmodel.SecondViewModel;

public class SecondActivity extends AppCompatActivity {

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
    }

    // binding adapter for recycler view
    @BindingAdapter(value = {"android:adapter", "android:data"})
    public static <T, VH extends RecyclerView.ViewHolder> void bind(
            RecyclerView recyclerView, PagedListAdapter<T, VH> adapter, PagedList<T> data) {
        recyclerView.setAdapter(adapter);
        // update recycler view's data from view model
        adapter.submitList(data);
    }
}
