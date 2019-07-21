package com.tistory.mybstory.coding_test_097.data;

import com.tistory.mybstory.coding_test_097.data.model.BookRepoResponse;

import io.reactivex.Single;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Query;

/**
 * An interface for book query api.
 */
public interface ApiService {
    @GET("v3/search/book")
    Single<BookRepoResponse> requestBookList(
            @Header("Authorization") String auth,
            @Query("target") String target,
            @Query("size") int size,
            @Query("query") String query,
            @Query("page") int page);

}