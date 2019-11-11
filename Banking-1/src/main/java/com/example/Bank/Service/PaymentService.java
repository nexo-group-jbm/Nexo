package com.example.Bank.Service;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.example.Bank.Model.PaymentCallback;
import com.example.Bank.Model.PaymentDetail;

@Component

public interface PaymentService {
	 public PaymentDetail proceedPayment(PaymentDetail paymentDetail);
	 public String payuCallback(PaymentCallback paymentResponse);
	
}
