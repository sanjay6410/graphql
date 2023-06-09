package com.GraphQl.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.GraphQl.Config.ProjectApiConfig;
import com.GraphQl.Dao.ProductDao;
import com.commercetools.api.models.product.Product;

@Service
public class ProductService {

	@Autowired
	private ProjectApiConfig apiRoot;
	
	@Autowired
	private ProductDao productDao;
	
	public List<Product> getAllProducts(){
		List<Product> products=productDao.getAllProducts().getResults();
		return products;
	}
}
