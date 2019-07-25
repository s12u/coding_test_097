package com.tistory.mybstory.coding_test_097.data.api;

import com.tistory.mybstory.coding_test_097.data.model.BookResponse;

import io.reactivex.Single;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * An interface for book query api.
 */
public interface ApiService {
    @GET("v3/search/book")
    Single<BookResponse> requestBookList(
            @Query("target") String target,
            @Query("size") int size,
            @Query("query") String query,
            @Query("page") int page);

}