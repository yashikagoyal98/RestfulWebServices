package com.zensar.dao;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.zensar.entities.Product;

/*Author:Yashika Goyal
Creation Date:26 JULY 2019 10:05AM
Modified Date:26 july 2019 10:05AM
Version:1.0
Copyright:Zensar Technologies. All rights preserved.
Description: Data Access Object Interface.
It implements all the methods of ProductDao interface.
It uses hibernate API to access Product date from database.*/

public class ProductDaoImpl implements ProductDao {

	private Session session;
	
	public ProductDaoImpl() {
		
    
	Configuration cfg=new Configuration().configure();
    SessionFactory factory=cfg.buildSessionFactory();
    session=factory.openSession();
    System.out.println("DB Connection established");
	}
	
    @Override
	public void insert(Product product) {
		// TODO Auto-generated method stub
    Transaction tx=session.beginTransaction();
    session.save(product);
    tx.commit();
    System.out.println("product inserted");
	}

	@Override
	public void update(Product product) {
		// TODO Auto-generated method stub
     Transaction tx=session.beginTransaction();
     session.update(product);
     tx.commit();
     System.out.println("product updated");
	}

	@Override
	public void delete(Product product) {
		// TODO Auto-generated method stub
		Transaction tx=session.beginTransaction();
	    session.delete(product);
	    tx.commit();
	    System.out.println("product deleted");
	}

	@Override
	public Product getbyId(int productId) {
		// TODO Auto-generated method stub
		return session.get(Product.class,productId);
	}

	@Override
	public List<Product> getAll() {
		// TODO Auto-generated method stub
		Query query=session.createQuery("from Product");
		return query.getResultList();
	}

}
