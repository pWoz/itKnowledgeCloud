package com.itKnowledgeCloud.rest;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.itKnowledgeCloud.model.Exam;
import com.itKnowledgeCloud.model.ExamApproach;
import com.itKnowledgeCloud.model.User;

@Path("/examApproach")
public class ExamApproachResource {

	@GET
	@Path("{examNo}")
	@Consumes("text/plain")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getExamApproach(@PathParam("examNo") int examNo){
		ExamApproach examApproach = new ExamApproach(new Exam(),new User());
		return Response.ok().entity(examApproach).build();
	}
	
	@GET
	@Path("/test")
	@Consumes("text/plain")
	@Produces(MediaType.APPLICATION_JSON)
	public Response test(){
		return Response.ok().entity(new User()).build();
	}
	
}
