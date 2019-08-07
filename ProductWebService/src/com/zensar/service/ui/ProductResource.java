package com.zensar.service.ui;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.zensar.entities.Product;
import com.zensar.services.business.ProductService;
import com.zensar.services.business.ProductServiceImpl;

/*Author:Yashika Goyal
Creation Date:26 JULY 2019 11:20AM
Modified Date:26 july 2019 11:20AM
Version:1.0
Copyright:Zensar Technologies. All rights preserved.
Description: Product web service.
It provides product data through restful web Service.*/

@Path("/products")
public class ProductResource {
	private ProductService productService;
	public ProductResource() {
		// TODO Auto-generated constructor stub
		productService=new ProductServiceImpl();
	}
@GET
@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})

	public List<Product> getALLProducts()
	{
	return productService.findAllProducts();
	}
@Path("/{id}")
@GET
@Produces({MediaType.TEXT_PLAIN})
public Response getProduct(@PathParam("id") int productId)
{
	Product product=productService.findProductById(productId);
	if(product!=null)
	{
		return Response.status(200).entity(product.toString()).build();
	}
	else
	{
		return Response.status(200).entity("Product" + productId + "Not found").build();
	}
}
	
	@Path("/product/{id}")
	@GET
	@Produces({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
	public Product getProductById(@PathParam("id") int productId)
	{
		return productService.findProductById(productId);
	}
	
	@Path("/count")
	@GET
	@Produces("text/plain")
	/*public Response getproductCount()
	{
		return Response.status(200).entity("no of Product" +productService.getProductCount()).build();
	}*/
	public String getproductCount()
	{
		return "no of Product" +productService.getProductCount();
	}
	
	
	@POST
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	public Response CreateProduct(@FormParam("id") int productId,@FormParam("name") String name,@FormParam("brand") String brand,@FormParam("price") float price)
	{
		Product product=new Product(productId , name, brand, price);
		productService.create(product);
		return Response.ok().build();
	}
	
	@Path("/delete/{id}")
	@DELETE
	@Produces("text/plain")
	public String removeProduct(@PathParam("id") int productId)
	{
		Product product= productService.findProductById(productId);
		if(product!=null) {
			productService.remove(product);
			return "Product" + productId + "does not exist";
		}
		else
		{
			return "product" +productId+ "does not exist";
		}
		}
		
	
}
