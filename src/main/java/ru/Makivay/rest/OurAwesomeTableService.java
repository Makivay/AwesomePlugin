package ru.Makivay.rest;


import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * Created by Kmatveev on 12.11.2015.
 */
@Path("/oat")
@Produces({MediaType.TEXT_PLAIN, MediaType.TEXT_PLAIN})
public class OurAwesomeTableService {

    public OurAwesomeTableService() {
    }

    @GET
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Path("/get")
    public Response getTable() {

        return Response.ok("Hello rest!").build();
    }


}
