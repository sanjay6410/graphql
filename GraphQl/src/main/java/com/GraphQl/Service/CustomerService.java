package com.GraphQl.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.GraphQl.Config.ProjectApiConfig;
import com.GraphQl.Dao.CustomerDao;
import com.commercetools.api.models.customer.Customer;
import com.commercetools.api.models.customer.CustomerUpdate;
import com.commercetools.api.models.customer.CustomerUpdateBuilder;

@Service
public class CustomerService {

	@Autowired
	private ProjectApiConfig apiRoot;
	
	@Autowired
	private CustomerDao customerDao;
	
	public Customer updateFirstName(String email,String firstName) {
		List<Customer> customers=customerDao.getCustomerByEmail(email).getResults();
		Optional<Customer> customerOptional=customers.isEmpty() ? Optional.empty() : Optional.ofNullable(customers.get(0));
		Customer customer=customerOptional.orElseThrow(() -> new RuntimeException("Customer Not Found With Email "+email));
		
		CustomerUpdate customerUpdate=CustomerUpdateBuilder.of()
				.version(customer.getVersion())
				.plusActions(t -> t.setFirstNameBuilder().firstName(firstName))
				.build();
		return apiRoot.createApiClient().customers().withId(customer.getId()).post(customerUpdate).executeBlocking().getBody();
	}
}
