package com.zensar.dao;

import java.util.List;

import com.zensar.entities.Product;

/*Author:Yashika Goyal
Creation Date:26 JULY 2019 9:59AM
Modified Date:26 july 2019 9:59AM
Version:1.0
Copyright:Zensar Technologies. All rights preserved.
Description: Data Access Object Interface.
It is used to access Product Data from Database.*/

public interface ProductDao {
 void insert(Product product);
 void update(Product product);
 void delete(Product product);
 Product getbyId(int productId);
 List<Product> getAll();
 

}
