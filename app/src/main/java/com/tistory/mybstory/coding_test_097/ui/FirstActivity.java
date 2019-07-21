package com.tistory.mybstory.coding_test_097.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProviders;

import com.tistory.mybstory.coding_test_097.R;
import com.tistory.mybstory.coding_test_097.base.viewmodel.factory.ResultViewModelFactory;
import com.tistory.mybstory.coding_test_097.base.viewmodel.util.ResultHandler;
import com.tistory.mybstory.coding_test_097.databinding.ActivityFirstBinding;
import com.tistory.mybstory.coding_test_097.ui.viewmodel.FirstViewModel;

public class FirstActivity extends AppCompatActivity {

    static final int REQUEST_QUERY_BOOK = 1;
    private ActivityFirstBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_first);

        // create view model with result handler
        binding.setViewModel(ViewModelProviders
                .of(this, new ResultViewModelFactory<>(new ResultHandler<>()))
                .get(FirstViewModel.class));
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_QUERY_BOOK && resultCode == RESULT_OK) {
            if (data != null) {
                // notify a result (from SecondActivity) to FirstViewModel
                binding.getViewModel().getResultHandler()
                        .onResult(data.getExtras());
            } else {
                // exception (data is null)
            }
        }
    }

    // start second activity with query
    public void doSearch(View view) {
        Intent intent = new Intent(this, SecondActivity.class);
        intent.putExtra("query", binding.etSearchBook.getText().toString());
        startActivityForResult(intent, REQUEST_QUERY_BOOK);
    }
}
