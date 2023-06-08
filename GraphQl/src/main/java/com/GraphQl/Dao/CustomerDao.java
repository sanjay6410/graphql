package com.GraphQl.Dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.GraphQl.Config.ProjectApiConfig;
import com.commercetools.api.models.customer.Customer;
import com.commercetools.api.models.customer.CustomerPagedQueryResponse;

@Component
public class CustomerDao {

	@Autowired
	private ProjectApiConfig apiConfig;
	
	public CustomerPagedQueryResponse getAllCustomers(){
		return apiConfig.createApiClient().customers().get().executeBlocking().getBody();
	}
	
	public Customer getCustomerById(String customerId) {
		return 
				apiConfig.createApiClient().customers().withId(customerId)
				.get().executeBlocking().getBody();
	}
	
	public CustomerPagedQueryResponse getCustomerByEmail(String email) {
		return apiConfig.createApiClient().customers().get()
				//.withWhere("email= :emailVar").withPredicateVar("emailVar", email)
				.withWhere("email=\""+email+"\"")
				.executeBlocking().getBody();
	}
}
