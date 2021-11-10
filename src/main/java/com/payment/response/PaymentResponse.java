package com.payment.response;

import java.math.BigDecimal;
import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class PaymentResponse {

	@JsonProperty("payment_number")
	private int paymentNumber;
	
	private BigDecimal amount;
	
	@JsonProperty("payment_date")
	private LocalDate paymentDate;
	
}
