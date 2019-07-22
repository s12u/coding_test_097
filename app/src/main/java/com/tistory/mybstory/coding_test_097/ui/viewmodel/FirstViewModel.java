package com.tistory.mybstory.coding_test_097.ui.viewmodel;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.databinding.ObservableField;

import com.tistory.mybstory.coding_test_097.base.ui.viewmodel.ResultViewModel;
import com.tistory.mybstory.coding_test_097.base.ui.viewmodel.util.ResultHandler;
import com.tistory.mybstory.coding_test_097.data.model.Transaction;

import java.util.ArrayList;
import java.util.List;

import java9.util.stream.StreamSupport;

public class FirstViewModel extends ResultViewModel<Bundle> {

    private int _balance = 0;
    // an observable field that notifies the balance changes
    private ObservableField<Integer> balance = new ObservableField<>(0);
    private List<Transaction> transactionHistoryList = new ArrayList<>();

    public FirstViewModel(ResultHandler<Bundle> resultHandler) {
        super(resultHandler);
    }

    @Override
    protected void onCleared() {
        // release
        super.onCleared();
    }

    // callback from result handler
    @Override
    public void onResult(Bundle resultBundle) {
        String title = resultBundle.getString("result_title");
        int price = resultBundle.getInt("result_price", 0);
        int salePrice = resultBundle.getInt("result_sale_price", 0);

        Transaction transaction = new Transaction(title, price, salePrice);
        performTransaction(transaction);
    }

    public ObservableField<Integer> getBalance() {
        return balance;
    }

    // check duplicate transaction history & add to history on transaction success
    private void performTransaction(@NonNull Transaction transaction) {
        boolean hasHistory = StreamSupport.stream(transactionHistoryList)
                .anyMatch(item -> item.equals(transaction));
        boolean hasBalance = balance.get() != null;

        if (!hasHistory && hasBalance) {
            int salePrice = transaction.getSalePrice();
            _balance = transaction.getSign() ? _balance - salePrice : _balance + salePrice;
            balance.set(_balance);
            transactionHistoryList.add(transaction);
        }
    }
}
