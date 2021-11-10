package com.payment.util;

import java.math.BigDecimal;

public class UTILS {
	
	/**
	 * method calcule amount for week
	 * @param amount
	 * @param terms
	 * @param rate
	 * @return
	 */	
	public static BigDecimal calculateAmount(BigDecimal amount,int terms,int rate) {
		BigDecimal amountTotal=calculatePercentageAmount(rate,amount);
		return amountTotal.divide(new BigDecimal(terms));
	}
	
	 public static BigDecimal calculatePercentageAmount(int percentaje, BigDecimal total) {
	        return total.add(total.multiply(new BigDecimal(percentaje)).divide(new BigDecimal(100)));
	    }

}
