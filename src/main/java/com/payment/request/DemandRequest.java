package com.payment.request;

import java.math.BigDecimal;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

import lombok.Data;


@Data
public class DemandRequest {
	
	@DecimalMin(value = "0.0")
	private BigDecimal amount;
	
	@Min(4)
	@Max(52)
	private int terms;
	
	@Min(2)
	@Max(99)
	private int rate;
}
