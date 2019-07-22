package com.tistory.mybstory.coding_test_097.ui.adapter.viewholder;


import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.tistory.mybstory.coding_test_097.R;
import com.tistory.mybstory.coding_test_097.data.model.Book;
import com.tistory.mybstory.coding_test_097.databinding.ViewholderBookBinding;

public class BookViewHolder extends RecyclerView.ViewHolder {

    public ViewholderBookBinding binding;

    public BookViewHolder(@NonNull ViewholderBookBinding binding) {
        super(binding.getRoot());
        this.binding = binding;
    }

    public void bind(Book book) {
        binding.setBook(book);
        binding.getRoot().setOnClickListener(createOnClickListener(book));
    }

    private View.OnClickListener createOnClickListener(Book book) {
        return view -> {
            Context context = view.getContext();
            if (context instanceof AppCompatActivity) {
                Intent intent = new Intent();
                intent.putExtra("result_title", book.getTitle());
                intent.putExtra("result_price", book.getPrice());
                intent.putExtra("result_sale_price", book.getSalePrice());
                AppCompatActivity activity = ((AppCompatActivity) view.getContext());
                activity.setResult(Activity.RESULT_OK, intent);
                activity.finish();
                activity.overridePendingTransition(0, R.anim.exit_to_bottom);
            }
        };
    }


}