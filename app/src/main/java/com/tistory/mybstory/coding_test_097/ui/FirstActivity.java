package com.tistory.mybstory.coding_test_097.ui;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProviders;

import com.tistory.mybstory.coding_test_097.R;
import com.tistory.mybstory.coding_test_097.base.viewmodel.util.ResultHandler;
import com.tistory.mybstory.coding_test_097.base.viewmodel.factory.ResultViewModelFactory;
import com.tistory.mybstory.coding_test_097.databinding.ActivityFirstBinding;
import com.tistory.mybstory.coding_test_097.ui.viewmodel.FirstViewModel;

public class FirstActivity extends AppCompatActivity {

    static final int REQUEST_QUERY_BOOK = 1;
    private ActivityFirstBinding binding;
    private ResultHandler<Bundle> resultHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_first);

        resultHandler = new ResultHandler<>();

        binding.setViewModel(ViewModelProviders
                .of(this, new ResultViewModelFactory<>(resultHandler))
                .get(FirstViewModel.class));

        binding.btnSearchBook.setOnClickListener(v -> {
            Intent intent = new Intent(this, SecondActivity.class);
            intent.putExtra("query", binding.etSearchBook.getText().toString());
            startActivityForResult(intent, REQUEST_QUERY_BOOK);
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_QUERY_BOOK && resultCode == RESULT_OK) {
            // do something
            if (data != null) {
                resultHandler.onResult(data.getExtras());
            } else {

            }
//            Log.e("FistActivity", "Result received : " + data.getIntExtra("result_price",0));
        }
    }
}
