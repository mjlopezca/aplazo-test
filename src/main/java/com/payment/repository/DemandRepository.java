package com.payment.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.payment.model.Demand;


@Repository
public interface DemandRepository  extends CrudRepository<Demand, Integer> {

}
