package com.tistory.mybstory.coding_test_097.ui;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.BindingAdapter;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProviders;
import androidx.paging.PagedListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import com.tistory.mybstory.coding_test_097.R;
import com.tistory.mybstory.coding_test_097.base.viewmodel.factory.QueryViewModelFactory;
import com.tistory.mybstory.coding_test_097.databinding.ActivitySecondBinding;
import com.tistory.mybstory.coding_test_097.ui.viewmodel.SecondViewModel;

public class SecondActivity extends AppCompatActivity {

    private ActivitySecondBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        String query = getIntent().getStringExtra("query");

        binding = DataBindingUtil.setContentView(this, R.layout.activity_second);
        binding.setViewModel(ViewModelProviders.of(this, new QueryViewModelFactory(query))
                .get(SecondViewModel.class));

        binding.getViewModel()
                .getBooksList()
                .observe(this, booksList ->
                        binding.getViewModel()
                                .getAdapter()
                                .submitList(booksList));

    }

    @BindingAdapter({"app:adapter"})
    public static <T, VH extends RecyclerView.ViewHolder> void bind(
            RecyclerView recyclerView, PagedListAdapter<T, VH> adapter) {
        recyclerView.setAdapter(adapter);
    }
}
