package com.tistory.mybstory.coding_test_097.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProviders;

import com.jakewharton.rxbinding3.widget.RxTextView;
import com.tistory.mybstory.coding_test_097.R;
import com.tistory.mybstory.coding_test_097.base.ui.BaseActivity;
import com.tistory.mybstory.coding_test_097.base.ui.viewmodel.factory.ResultViewModelFactory;
import com.tistory.mybstory.coding_test_097.base.ui.viewmodel.util.ResultHandler;
import com.tistory.mybstory.coding_test_097.databinding.ActivityFirstBinding;
import com.tistory.mybstory.coding_test_097.ui.viewmodel.FirstViewModel;

import io.reactivex.disposables.CompositeDisposable;

public class FirstActivity extends BaseActivity {

    static final int REQUEST_QUERY_BOOK = 1;

    private ActivityFirstBinding binding;
    private CompositeDisposable disposables = new CompositeDisposable();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_first);
        // create view model with result handler
        binding.setViewModel(ViewModelProviders
                .of(this, new ResultViewModelFactory<>(new ResultHandler<>()))
                .get(FirstViewModel.class));
        initUI();
    }

    @Override
    protected void onDestroy() {
        disposables.clear();
        super.onDestroy();
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

    private void initUI() {
        // validate empty query
        disposables.add(RxTextView.textChangeEvents(binding.etSearchBook)
                .skipInitialValue()
                .subscribe(event -> {
                            binding.layoutTextInput.setError(event.getText().length() == 0 ?
                                    getString(R.string.error_empty_query) : "");
                            binding.btnSearchBook.setEnabled(event.getText().length() != 0);
                        }
                ));
    }

    // start second activity with query
    public void doSearch(View view) {
        Intent intent = new Intent(this, SecondActivity.class);
        intent.putExtra("query", binding.etSearchBook.getText().toString());
        startActivityForResult(intent, REQUEST_QUERY_BOOK);
        overridePendingTransition(R.anim.enter_to_right, R.anim.exit_to_left);
    }
}
