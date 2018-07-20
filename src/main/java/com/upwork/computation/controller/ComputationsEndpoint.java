package com.upwork.computation.controller;

import com.upwork.computation.controller.dto.Result;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.PathSegment;
import java.util.List;

@Path("/calculate")
public interface ComputationsEndpoint {

    @GET
    @Path("/add/{params: .*}")
    @Produces(MediaType.APPLICATION_JSON)
    Result add(@PathParam("params") List<PathSegment> params);

    @GET
    @Path("/subtract/{params: .*}")
    @Produces(MediaType.APPLICATION_JSON)
    Result subtract(@PathParam("params") List<PathSegment> params);

    @GET
    @Path("/multiply/{params: .*}")
    @Produces(MediaType.APPLICATION_JSON)
    Result multiply(@PathParam("params") List<PathSegment> params);

    @GET
    @Path("/divide/{params: .*}")
    @Produces(MediaType.APPLICATION_JSON)
    Result divide(@PathParam("params") List<PathSegment> params);
}
