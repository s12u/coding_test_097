package com.tistory.mybstory.coding_test_097.ui.util;

import android.widget.ImageView;

import androidx.databinding.BindingAdapter;
import androidx.paging.PagedList;
import androidx.paging.PagedListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions;
import com.tistory.mybstory.coding_test_097.R;

public class BindingAdapters {
    // binding adapter for recycler view
    @BindingAdapter(value = {"android:adapter", "android:data"})
    public static <T, VH extends RecyclerView.ViewHolder> void bind(
            RecyclerView recyclerView, PagedListAdapter<T, VH> adapter, PagedList<T> data) {
        recyclerView.setAdapter(adapter);
        // update recycler view's data from view model
        adapter.submitList(data);
    }

    // binding adapter for thumbnail image view
    @BindingAdapter(value = {"android:thumbUrl"})
    public static void bindThumbImage(ImageView imageView, String thumbUrl) {
        Glide.with(imageView)
//                .applyDefaultRequestOptions(options)
                .load(thumbUrl)
                .placeholder(R.drawable.bg_placeholder_thumb)
                .error(R.drawable.bg_error_no_image)
                .transition(DrawableTransitionOptions.withCrossFade())
                .into(imageView);
    }

}
