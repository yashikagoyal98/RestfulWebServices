package com.zensar.services.business;

import java.util.ArrayList;
import java.util.List;

import com.zensar.dao.ProductDao;
import com.zensar.dao.ProductDaoImpl;
import com.zensar.entities.Product;

/*Author:Yashika Goyal
Creation Date:26 JULY 2019 11:40AM
Modified Date:26 july 2019 11:40AM
Version:1.0
Copyright:Zensar Technologies. All rights preserved.
Description: Data Access Object Interface implementor class.
It encapsulates business logic of application component product.
It interacts with DAO layer to get data from database.
It interacts with presentation layer. 
It give data as per business requirement.*/

public class ProductServiceImpl implements ProductService {

	private ProductDao dao;
	
	public ProductServiceImpl() {
		// TODO Auto-generated constructor stub
		 dao=new ProductDaoImpl();
	}
	
	@Override
	public void create(Product product) {
		// TODO Auto-generated method stub
         dao.insert(product);
	}

	@Override
	public void edit(Product product) {
		// TODO Auto-generated method stub
         Product dbProduct=findProductById(product.getProductId());
         if(dbProduct!=null)
         {
        	 dbProduct.setName(product.getName());
        	 dbProduct.setBrand(product.getBrand());
        	 dbProduct.setPrice(product.getPrice());
        	 dao.update(dbProduct);
        	 
        	 
         }
         else
         {
        	 System.out.println("Product not found");
         }
	}

	@Override
	public void remove(Product product) {
		// TODO Auto-generated method stub
    Product dbProduct=findProductById(product.getProductId());
    if(dbProduct!=null)
    {
    	dao.delete(dbProduct);
    }
    else
    {
    	System.out.println("Product not found");
    }
	}

	@Override
	public Product findProductById(int productId) {
		// TODO Auto-generated method stub
		return dao.getbyId(productId);

	}

	@Override
	public List<Product> findAllProducts() {
		// TODO Auto-generated method stub
		return dao.getAll();
	}

	@Override
	public int getProductCount() {
		// TODO Auto-generated method stub
		return findAllProducts().size();
	}

	@Override
	public List<Product> findProductByBrand(String brand) {
		// TODO Auto-generated method stub
		List<Product> pList=findAllProducts();
		List<Product> pBlist=new ArrayList<>();
		for(Product p:pList)
		{
			if(p.getBrand().equals(brand))
				pBlist.add(p);
		}
		return pBlist;
	}

	@Override
	public List<Product> findProductByPriceRange(float minPrice, float maxPrice) {
		// TODO Auto-generated method stub
		List<Product> pList=findAllProducts();
		List<Product> pPlist=new ArrayList<>();
		for(Product p:pList)
		{
			if(p.getPrice()>=minPrice && p.getPrice()<=maxPrice)
				pPlist.add(p);
		}
		return pPlist;
	}

}
