package com.zensar.services.business;

import java.util.List;

import com.zensar.entities.Product;

/*Author:Yashika Goyal
Creation Date:26 JULY 2019 11:20AM
Modified Date:26 july 2019 11:20AM
Version:1.0
Copyright:Zensar Technologies. All rights preserved.
Description: Business Object Interface.
It focuses on business logic of Product.*/
public interface ProductService {
 void create(Product product);
 void edit(Product product);
 void remove(Product product);
 Product findProductById( int productId);
 List<Product> findAllProducts();
 int getProductCount();
 List<Product> findProductByBrand(String brand);
 List<Product> findProductByPriceRange(float minPrice,float maxPrice);
}
