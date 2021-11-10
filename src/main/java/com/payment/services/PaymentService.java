package com.payment.services;

import java.util.List;
import com.payment.request.DemandRequest;
import com.payment.response.PaymentResponse;

public interface PaymentService {
	
	public List<PaymentResponse> createPayment(DemandRequest demand);

}
