package com.tistory.mybstory.coding_test_097.data.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * A Data class for http response.
 */
public class BookRepoResponse {

    @SerializedName("meta")
    private Meta meta;
    @SerializedName("documents")
    private List<Book> documents;

    public Meta getMeta() {
        return meta;
    }

    public void setMeta(Meta meta) {
        this.meta = meta;
    }

    public List<Book> getDocuments() {
        return documents;
    }

    public void setDocument(List<Book> document) {
        this.documents = document;
    }
}
