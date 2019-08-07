package com.zensar.services;

import java.io.File;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;

@Path("/files")
public class FileDownloadService {
private static final String FILE_PATH="D://Yashika/banking.jpg";

	/*
	 * @GET
	 * 
	 * @Path("/txt")
	 * 
	 * @Produces("text/plain") public Response getFile() { File file=new
	 * File(FILE_PATH); ResponseBuilder responsebuilder=Response.ok(file);
	 * responsebuilder.header(
	 * "content-Disposition","attachment; filename=hello_file.txt"); return
	 * responsebuilder.build(); }
	 */
		@GET
		
		@Path("/images")
		@Produces("image/jpg")
		
		public Response getImage()
		{
			File file=new File(FILE_PATH);
			ResponseBuilder responsebuilder=Response.ok(file);
		/*
		 * responsebuilder.header("content-Disposition","attachment; filename=image.jpg"
		 * );
		 */
			return responsebuilder.build();
		}
		
		 
}
