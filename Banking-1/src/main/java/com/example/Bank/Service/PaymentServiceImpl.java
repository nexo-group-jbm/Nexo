package com.example.Bank.Service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Bank.PaymentStatus;
import com.example.Bank.PaymentUtil;
import com.example.Bank.Dao.PaymentRepo;
import com.example.Bank.Model.Payment;
import com.example.Bank.Model.PaymentCallback;
import com.example.Bank.Model.PaymentDetail;
@Service
public class PaymentServiceImpl implements PaymentService{
@Autowired
private PaymentRepo paymentRepository;
	@Override
	public PaymentDetail proceedPayment(PaymentDetail paymentDetail) {
		PaymentUtil paymentUtil=new PaymentUtil();
		paymentDetail= paymentUtil.populatePaymentDetail(paymentDetail);
		savePaymentDetail(paymentDetail);
		return paymentDetail;
	}

	@Override
	public String payuCallback(PaymentCallback paymentResponse) {
		String status="Transaction failed";
		Payment payment=paymentRepository.findByTxnId(paymentResponse.getTxnid());
		if(payment !=null) {
			PaymentStatus paymentStatus=null;
			if(paymentResponse.getStatus().equals("failure")) {
				paymentStatus=PaymentStatus.Failed;
			}
			else if(paymentResponse.getStatus().equals("Success")) {
				paymentStatus=PaymentStatus.Success;
				status="Transaction Success";
			}
		 payment.setPaymentStatus(paymentStatus);
		 payment.setMihpayId(payment.getMihpayId());
		 payment.setMode(paymentResponse.getMode());
		 paymentRepository.save(payment);
			
		}
		return status;
	}

	public void savePaymentDetail(PaymentDetail paymentDetail) {
		Payment payment =new Payment();
		payment.setAmount(Double.parseDouble(paymentDetail.getAmount()));
		payment.setEmail(paymentDetail.getEmail());
		payment.setName(paymentDetail.getName());
		payment.setPaymentDate(new Date());
		payment.setPaymentStatus(PaymentStatus.Pending);
		payment.setPhone(paymentDetail.getPhone());
		payment.setProductInfo(paymentDetail.getProductInfo());
		payment.setTxnId(paymentDetail.getTxnId());
		
		paymentRepository.save(payment);
	}

}
