package com.payment.services.impl;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.payment.mappers.DemandMapper;
import com.payment.mappers.PaymentMapper;
import com.payment.model.Demand;
import com.payment.model.Payment;
import com.payment.repository.DemandRepository;
import com.payment.repository.PaymentRepository;
import com.payment.request.DemandRequest;
import com.payment.response.PaymentResponse;
import com.payment.services.PaymentService;
import com.payment.util.UTILS;


@Service
public class PaymentServiceImpl implements PaymentService {
	
	@Autowired
	DemandMapper demandMapper;
	
	@Autowired
	PaymentMapper paymentMapper;
	
	@Autowired
	DemandRepository demandRepository;
	@Autowired
	PaymentRepository paymentRepository;

	@Override
	public List<PaymentResponse> createPayment(DemandRequest demandR) {
		List<PaymentResponse> setPaymentR= new ArrayList<PaymentResponse> ();
		List<Payment> setPayment= new ArrayList<Payment> ();
		Demand demand=demandMapper.inner(demandR);
		demandRepository.save(demand);
		BigDecimal amountTerm= UTILS.calculateAmount(demand.getAmount(), demand.getTerms(), demand.getRate());		
		LocalDate date=LocalDate.now();		
		for(int c=1;c<=demandR.getTerms();c++) {
			Payment payment=new Payment();
			payment.setAmount(amountTerm);
			payment.setPaymentNumber(c);
			payment.setPaymentDate(date.plusWeeks((long)c));
			payment.setDemandId(demand.getId());
			setPaymentR.add(paymentMapper.outer(payment));
			setPayment.add(payment);
		}
		paymentRepository.saveAll(setPayment);	
		return setPaymentR;
	}

}
