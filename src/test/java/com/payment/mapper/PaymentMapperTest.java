package com.payment.mapper;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import com.payment.mappers.PaymentMapper;
import com.payment.model.Payment;
import com.payment.response.PaymentResponse;

import uk.co.jemos.podam.api.PodamFactory;
import uk.co.jemos.podam.api.PodamFactoryImpl;

public class PaymentMapperTest {
	
	@Autowired
	static PaymentMapper paymentMapper;
	
	private static PodamFactory podamFactory;

	@BeforeAll
	public static void setUp() {
		paymentMapper=new PaymentMapper();
		podamFactory = new PodamFactoryImpl();			
	}
	
	@Test
	public void innerTest() {
		 PaymentResponse paymentResponse = podamFactory.manufacturePojo(PaymentResponse.class);
		 Payment payment= paymentMapper.inner(paymentResponse);
		 assertAll(() -> {
	            assertEquals(payment.getAmount(),paymentResponse.getAmount());
	            assertEquals(payment.getPaymentDate(), paymentResponse.getPaymentDate());
	            assertEquals(payment.getPaymentNumber(), paymentResponse.getPaymentNumber());
	        });
	}
	
	@Test
	public void outerTest() {		 
		Payment payment = podamFactory.manufacturePojo(Payment.class);
		PaymentResponse paymentResponse= paymentMapper.outer(payment);
		 assertAll(() -> {
	            assertEquals(payment.getAmount(),paymentResponse.getAmount());
	            assertEquals(payment.getPaymentDate(), paymentResponse.getPaymentDate());
	            assertEquals(payment.getPaymentNumber(), paymentResponse.getPaymentNumber());
	        });
	}
}
