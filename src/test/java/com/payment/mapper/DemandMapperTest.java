package com.payment.mapper;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import com.payment.mappers.DemandMapper;
import com.payment.model.Demand;
import com.payment.request.DemandRequest;

import uk.co.jemos.podam.api.PodamFactory;
import uk.co.jemos.podam.api.PodamFactoryImpl;

public class DemandMapperTest {
	
	
	static DemandMapper demandMapper;
	
	private static PodamFactory podamFactory;

	@BeforeAll
	public static void setUp() {
		podamFactory = new PodamFactoryImpl();	
		demandMapper=new DemandMapper();
		System.err.println("as");
	}
	
	@Test
	public void innerTest() {
		 DemandRequest demandRequest = podamFactory.manufacturePojo(DemandRequest.class);
		 Demand demand= demandMapper.inner(demandRequest);
		 assertAll(() -> {
	            assertEquals(demandRequest.getAmount(),demand.getAmount());
	            assertEquals(demandRequest.getRate(), demand.getRate());
	            assertEquals(demandRequest.getTerms(), demand.getTerms());
	        });
	}
	
	@Test
	public void outerTest() {		 
		 Demand demand=podamFactory.manufacturePojo(Demand.class);
		 DemandRequest demandRequest =demandMapper.outer(demand);
		 assertAll(() -> {
	            assertEquals(demandRequest.getAmount(),demand.getAmount());
	            assertEquals(demandRequest.getRate(), demand.getRate());
	            assertEquals(demandRequest.getTerms(), demand.getTerms());
	        });
	}
}
