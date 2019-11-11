package com.example.Bank.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.example.Bank.PaymentMode;
import com.example.Bank.Model.PaymentCallback;
import com.example.Bank.Model.PaymentDetail;
import com.example.Bank.Service.PaymentService;
import com.example.Bank.Service.PaymentServiceImpl;


@RestController

public class PaymentController {
	
	@Autowired
private PaymentService paymentService;
//@GetMapping
//	public ModelAndView viewPage() {
//		ModelAndView model =new ModelAndView();
//		model.setViewName("paymentview");
//		return model;
//		
	//}
	@RequestMapping("/payment")
public ModelAndView  viewpage() {
	ModelAndView model =new ModelAndView();
	model.setViewName("paymentview");
	return model;
	
}
@PostMapping(path="/path-details")
public PaymentDetail procedPayment(@RequestBody PaymentDetail paymentDetail) {
	return paymentService.proceedPayment(paymentDetail);
	
}
@RequestMapping(path = "/payment-response", method = RequestMethod.POST)
public @ResponseBody String payuCallback(@RequestParam String mihpayid, @RequestParam String status, @RequestParam PaymentMode mode, @RequestParam String txnid, @RequestParam String hash){
    PaymentCallback paymentCallback = new PaymentCallback();
    paymentCallback.setMihpayid(mihpayid);
    paymentCallback.setTxnid(txnid);
    paymentCallback.setMode(mode);
    paymentCallback.setHash(hash);
    paymentCallback.setStatus(status);
    return paymentService.payuCallback(paymentCallback);
}
	
}
