package com.example.Bank;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Random;

import com.example.Bank.Model.PaymentDetail;

public class PaymentUtil {
	private static final String paymentKey= "your-key";
	private static final String paymentSalt="your-salt";
	private static final String sUrl="http://localhost:8080/payment/payment-response";
	private static final String fUrl="http://localhost:8080/payment/payment-response";
	
	public PaymentDetail populatePaymentDetail(PaymentDetail paymentDetail) {
		String hashString="";
		Random rand=new Random();
		String randomId=Integer.toString(rand.nextInt())+  (System.currentTimeMillis() / 1000L);
		String txnId = "Dev" + hashCal("SHA-256", randomId).substring(0, 12);
		 paymentDetail.setTxnId(txnId);
		 String hash = "";
		 String hashSequence = "key|txnid|amount|productinfo|firstname|email|||||||||||";
		
		 hashString = hashSequence.concat(paymentSalt);
	        hashString = hashString.replace("key", paymentKey);
	        hashString = hashString.replace("txnid", txnId);
	        hashString = hashString.replace("amount", paymentDetail.getAmount());
	        hashString = hashString.replace("productinfo", paymentDetail.getProductInfo());
	        hashString = hashString.replace("firstname", paymentDetail.getName());
	        hashString = hashString.replace("email", paymentDetail.getEmail());
	        
	        hash = hashCal("SHA-512", hashString);
	        paymentDetail.setHash(hash);
	        paymentDetail.setfUrl(fUrl);
	        paymentDetail.setsUrl(sUrl);
	        paymentDetail.setKey(paymentKey);
		
			return paymentDetail;
	}

	private String hashCal(String type, String str) {
		byte[] hashseq = str.getBytes();
        StringBuffer hexString = new StringBuffer();
        try {
        	MessageDigest algorithm = MessageDigest.getInstance(type);
        	algorithm.reset();
            algorithm.update(hashseq);
            byte messageDigest[] = algorithm.digest(); 
            for (int i = 0; i < messageDigest.length; i++) {
            	String hex = Integer.toHexString(0xFF & messageDigest[i]);
            	if (hex.length() == 1) {
                    hexString.append("0");
                }
            	 hexString.append(hex);
            }  
        }
       
        catch (NoSuchAlgorithmException nsae) {
        }
        return hexString.toString();
   
		
	
	}

}
