package com.payment.mappers;

import org.springframework.stereotype.Component;

import com.payment.model.Payment;
import com.payment.response.PaymentResponse;

@Component
public class PaymentMapper {
	
	public Payment inner(PaymentResponse paymentResponse) {
		Payment payment=new Payment();
		payment.setAmount(paymentResponse.getAmount());
		payment.setPaymentDate(paymentResponse.getPaymentDate());
		payment.setPaymentNumber(paymentResponse.getPaymentNumber());
		return payment;
		
	}
	
	
	public PaymentResponse outer(Payment payment) {
		PaymentResponse paymentResponse=new PaymentResponse();
		paymentResponse.setAmount(payment.getAmount());
		paymentResponse.setPaymentDate(payment.getPaymentDate());
		paymentResponse.setPaymentNumber(payment.getPaymentNumber());
		return paymentResponse;
		
	}

}
