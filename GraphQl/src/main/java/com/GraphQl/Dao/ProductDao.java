package com.GraphQl.Dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.GraphQl.Config.ProjectApiConfig;
import com.commercetools.api.models.product.ProductPagedQueryResponse;

@Component
public class ProductDao {

	@Autowired
	private ProjectApiConfig apiRoot;
	
	public ProductPagedQueryResponse getAllProducts(){
		return apiRoot.createApiClient().products().get().executeBlocking().getBody();
	}
}
