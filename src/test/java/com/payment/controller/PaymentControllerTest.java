package com.payment.controller;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import java.math.BigDecimal;
import java.util.ArrayList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.payment.request.DemandRequest;
import com.payment.response.PaymentResponse;
import com.payment.services.PaymentService;

@SpringBootTest
public class PaymentControllerTest {
		public MockMvc mockMvc;

	   @Autowired
	    public PaymentController paymentController;

	    @MockBean
	    public PaymentService paymentService;

	    private ObjectMapper objectMapper = new ObjectMapper();
	    
	    @BeforeEach
	    public void setUp() {
	        mockMvc = MockMvcBuilders.standaloneSetup(paymentController).build();
	    }

	    @Test
	    void createPayment() throws  Exception {
	    	 // given
	        DemandRequest demandRequest=new DemandRequest();
	        demandRequest.setAmount(new BigDecimal(100));
	        demandRequest.setRate(4);
	        demandRequest.setTerms(4);
	        PaymentResponse paymentResponse=new PaymentResponse();
	        ArrayList<PaymentResponse> list=new ArrayList<PaymentResponse>();
	        list.add(paymentResponse);
	        when(paymentService.createPayment(any()))
	                .thenReturn(list);

	        // when then
	        mockMvc.perform(post("/payment/")
	                .contentType(MediaType.APPLICATION_JSON_VALUE)
	                .content(objectMapper.writeValueAsBytes(demandRequest))
	        ).andExpect(status().is(200));
	    }
}
