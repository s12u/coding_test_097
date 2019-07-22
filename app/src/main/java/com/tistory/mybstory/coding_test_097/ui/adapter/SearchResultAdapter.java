package com.tistory.mybstory.coding_test_097.ui.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.paging.PagedListAdapter;
import androidx.recyclerview.widget.DiffUtil;

import com.tistory.mybstory.coding_test_097.R;
import com.tistory.mybstory.coding_test_097.data.model.Book;
import com.tistory.mybstory.coding_test_097.databinding.ViewholderBookBinding;
import com.tistory.mybstory.coding_test_097.ui.adapter.viewholder.BookViewHolder;

public class SearchResultAdapter extends PagedListAdapter<Book, BookViewHolder> {

    private LayoutInflater mInflater = null;

    public SearchResultAdapter(@NonNull DiffUtil.ItemCallback<Book> diffCallback) {
        super(diffCallback);
    }

    @NonNull
    @Override
    public BookViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (mInflater == null) {
            mInflater = LayoutInflater.from(parent.getContext());
        }
        ViewholderBookBinding binding =
                DataBindingUtil.inflate(mInflater, R.layout.viewholder_book, parent, false);
        return new BookViewHolder(binding);
    }

    @Override
    public void onViewRecycled(@NonNull BookViewHolder holder) {
        super.onViewRecycled(holder);
        // release resources
        holder.binding.ivThumbBook.setImageDrawable(null);
    }

    @Override
    public void onBindViewHolder(@NonNull BookViewHolder holder, int position) {
        holder.bind(getItem(position));
    }

    // diff callback
    public static DiffUtil.ItemCallback<Book> DIFF_CALLBACK = new DiffUtil.ItemCallback<Book>() {
        @Override
        public boolean areItemsTheSame(@NonNull Book oldItem, @NonNull Book newItem) {
            return oldItem.getTitle().equals(newItem.getTitle());
        }

        @Override
        public boolean areContentsTheSame(@NonNull Book oldItem, @NonNull Book newItem) {
            return oldItem.getContents().equals(newItem.getContents());
        }
    };
}
