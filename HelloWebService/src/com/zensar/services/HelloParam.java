package com.zensar.services;

import java.time.*;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

@Path("/zenparam")
public class HelloParam 
{
	
	/*
	 * @Path("/welcome/{nm}")
	 * 
	 * @GET
	 * 
	 * @Produces("text/html") public Response getMessage(@PathParam("nm") String
	 * name) { return Response.status(200).entity("<p>Hello<b><i>" + name +
	 * "</b></i>Welcome to zensar hello service</p>").build(); }
	 */
	/*
	 * @Path("/birthday/{d}/{m}/{y}")
	 * 
	 * @GET
	 * 
	 * @Produces("text/html") public Response getDate(@PathParam("d") int
	 * dd, @PathParam("m") int mm, @PathParam("y") int yyyy) { return
	 * Response.status(200).entity("<p>Hello<b><i>"+ dd +"/" + mm +"/" + yyyy
	 * +"</b></i>this is my birthday date: </p>").build(); }
	 */

@Path("/birthday/{d}/{m}/{y}")	
@GET
@Produces("text/html")
public Response getdate(@PathParam("d")int day, @PathParam("m") int month,@PathParam("y") int year)
{
	LocalDate date=LocalDate.of(year, month, day);
	return Response.status(200).entity("hbd"+date.toString()).build();
}

}
