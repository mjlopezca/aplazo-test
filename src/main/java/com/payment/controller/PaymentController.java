package com.payment.controller;

import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.payment.request.DemandRequest;
import com.payment.response.PaymentResponse;
import com.payment.services.PaymentService;

@RestController
@RequestMapping(value="payment/")
public class PaymentController {
	@Autowired
	PaymentService paymentService;
	
	@PostMapping()
	public List<PaymentResponse> createPayment(@Valid @RequestBody DemandRequest demand ) {
		return paymentService.createPayment(demand);
	}

}
