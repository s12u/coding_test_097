package com.tistory.mybstory.coding_test_097.ui.viewmodel;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.databinding.Bindable;
import androidx.databinding.ObservableField;

import com.tistory.mybstory.coding_test_097.base.viewmodel.ResultViewModel;
import com.tistory.mybstory.coding_test_097.base.viewmodel.util.ResultHandler;
import com.tistory.mybstory.coding_test_097.data.model.WithdrawalHistory;

import java.util.ArrayList;
import java.util.List;

import java9.util.stream.StreamSupport;

public class FirstViewModel extends ResultViewModel<Bundle> {

    private int _balance = 0;
    private ObservableField<Integer> balance = new ObservableField<>(0);
    private List<WithdrawalHistory> withdrawalHistoryList = new ArrayList<>();

    public FirstViewModel(ResultHandler<Bundle> resultHandler) {
        super(resultHandler);
    }

    @Override
    protected void onCleared() {
        super.onCleared();
    }

    @Override
    public void onResult(Bundle resultBundle) {
        String title = resultBundle.getString("result_title");
        int price = resultBundle.getInt("result_price", 0);
        int salePrice = resultBundle.getInt("result_sale_price", 0);

        WithdrawalHistory history = new WithdrawalHistory(title, price, salePrice);
        withDraw(history);
    }

    public ObservableField<Integer> getBalance() {
        return balance;
    }

    private void withDraw(@NonNull WithdrawalHistory history) {
        boolean hasHistory = StreamSupport.stream(withdrawalHistoryList)
                .anyMatch(item -> item.equals(history));
        boolean hasBalance = balance.get() != null;

        if (!hasHistory && hasBalance) {
            int salePrice = history.getSalePrice();
            _balance = history.getSign() ? _balance + salePrice : _balance - salePrice;
            balance.set(_balance);
            withdrawalHistoryList.add(history);
        }
    }
}
