package com.tistory.mybstory.coding_test_097.ui.first;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.tistory.mybstory.coding_test_097.base.ui.viewmodel.ResultViewModel;
import com.tistory.mybstory.coding_test_097.base.ui.viewmodel.util.ResultHandler;
import com.tistory.mybstory.coding_test_097.data.model.Result;
import com.tistory.mybstory.coding_test_097.data.model.Transaction;

import java.util.ArrayList;
import java.util.List;

import java9.util.stream.StreamSupport;

public class FirstViewModel extends ResultViewModel {

    // an observable field that notifies the balance changes
    private MutableLiveData<Integer> balance = new MutableLiveData<>(0);
    private List<Transaction> transactionHistoryList = new ArrayList<>();

    public FirstViewModel(ResultHandler resultHandler) {
        super(resultHandler);
    }

    @Override
    protected void onCleared() {
        // release
        super.onCleared();
    }

    // callback from result handler
    @Override
    public void onResult(Result result) {
        Bundle resultBundle = result.getBundle();
        if (resultBundle != null) {
            String title = resultBundle.getString("result_title");
            int price = resultBundle.getInt("result_price", 0);
            int salePrice = resultBundle.getInt("result_sale_price", 0);

            Transaction transaction = new Transaction(title, price, salePrice);
            performTransaction(transaction);
        }
    }

    // check duplicate transaction history & add to history on transaction success
    private void performTransaction(@NonNull Transaction transaction) {
        boolean hasHistory = StreamSupport.stream(transactionHistoryList)
                .anyMatch(item -> item.equals(transaction));
        boolean hasBalance = balance.getValue() != null;

        if (!hasHistory && hasBalance) {
            int currentBalance = balance.getValue();
            int salePrice = transaction.getSalePrice();
            int result = transaction.getSign() ?
                    currentBalance - Math.abs(salePrice) : currentBalance + salePrice;
            balance.setValue(result);
            transactionHistoryList.add(transaction);
        }
    }

    public LiveData<Integer> getBalance() {
        return balance;
    }
}
