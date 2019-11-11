package com.example.Bank.Dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.Bank.Model.Payment;

public interface PaymentRepo extends CrudRepository<Payment, Long> {
Payment findByTxnId(String Txnid);
}
