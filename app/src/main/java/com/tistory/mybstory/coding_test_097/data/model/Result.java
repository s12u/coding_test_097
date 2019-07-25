package com.tistory.mybstory.coding_test_097.data.model;

import android.os.Bundle;

public class Result {
    public Result(Bundle bundle) {
        this.bundle = bundle;
    }

    public Bundle getBundle() {
        return bundle;
    }

    public void setBundle(Bundle bundle) {
        this.bundle = bundle;
    }

    private Bundle bundle;
}
