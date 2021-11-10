package com.payment.service;

import static org.junit.Assert.assertNotNull;
import java.math.BigDecimal;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;
import com.payment.mappers.DemandMapper;
import com.payment.mappers.PaymentMapper;
import com.payment.repository.DemandRepository;
import com.payment.repository.PaymentRepository;
import com.payment.request.DemandRequest;
import com.payment.response.PaymentResponse;
import com.payment.services.impl.PaymentServiceImpl;


@ExtendWith(MockitoExtension.class)
public class PaymentServiceTest {


	@Spy
	private DemandMapper demandMapper=new DemandMapper();

	@Spy
	private PaymentMapper paymentMapper=new PaymentMapper();

	@Mock
	private DemandRepository demandRepository;
	@Mock
	private PaymentRepository paymentRepository;

	@InjectMocks	
	private PaymentServiceImpl paymentService;

	@Test
	public void createPaymentTest() {				
		DemandRequest demand1=new DemandRequest();
		demand1.setAmount(new BigDecimal(100));
		demand1.setRate(4);
		demand1.setTerms(5);					
		List<PaymentResponse> list=paymentService.createPayment(demand1);
		System.err.println(list);
		assertNotNull(list);
	}

}
