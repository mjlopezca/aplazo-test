package com.payment.model;

import java.math.BigDecimal;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;


@Data
@Entity
@Table()
public class Demand{
	

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
		
	private BigDecimal amount;
	
	private int terms;
	
	private int rate;
}
