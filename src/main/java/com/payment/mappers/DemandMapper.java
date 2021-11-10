package com.payment.mappers;

import org.springframework.stereotype.Component;

import com.payment.model.Demand;
import com.payment.request.DemandRequest;

@Component
public class DemandMapper {
	
	public Demand inner(DemandRequest demandRequest) {	
		Demand demand=new Demand();
		demand.setAmount(demandRequest.getAmount());
		demand.setRate(demandRequest.getRate());
		demand.setTerms(demandRequest.getTerms());		
		return demand;
		
	}
	
	
	public DemandRequest outer(Demand demand) {
		DemandRequest demandR=new DemandRequest();
		demandR.setAmount(demand.getAmount());
		demandR.setRate(demand.getRate());
		demandR.setTerms(demand.getTerms());
		return demandR;
		
	}

}
