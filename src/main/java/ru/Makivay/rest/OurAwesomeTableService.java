package ru.Makivay.rest;


import com.atlassian.activeobjects.external.ActiveObjects;
import com.atlassian.jira.util.json.JSONException;
import com.atlassian.jira.util.json.JSONObject;
import com.atlassian.plugins.rest.common.security.AnonymousAllowed;
import net.java.ao.Query;
import ru.Makivay.ao.ElementEntity;
import ru.Makivay.ao.models.ElementModel;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Kmatveev on 12.11.2015.
 */
@Path("/oat")
@AnonymousAllowed
@Produces({MediaType.APPLICATION_JSON})
public class OurAwesomeTableService {


    ActiveObjects activeObjects;

    public OurAwesomeTableService(ActiveObjects activeObjects) {
        this.activeObjects = activeObjects;
    }


    @GET
    @Path("/getAll")
    @Produces({MediaType.APPLICATION_JSON})
    public Response getAll() {
        List<ElementModel> elementModels = new ArrayList<ElementModel>();
        ElementEntity[] elementEntities = activeObjects.find(ElementEntity.class);
        for (ElementEntity elementEntity : elementEntities) {
            elementModels.add(new ElementModel(elementEntity));
        }
        return Response.ok(elementModels).build();
    }


    @GET
    @Path("/{id}")
    @Produces({MediaType.APPLICATION_JSON})
    public Response getVersion(@PathParam("id") final String id) {
        ElementEntity elementEntity;
        if (id != null) {
            elementEntity = activeObjects.find(ElementEntity.class, Query.select().where("ID = ?", id))[0];
        } else {
            return Response.serverError().build();
        }

        return Response.ok(new ElementModel(elementEntity)).build();
    }

    @PUT
    @Path("/{id}")
    @Consumes({MediaType.APPLICATION_JSON})
    public Response updateVersion(@PathParam("id") final String idString, String request) {
        StringBuilder answer = new StringBuilder();     //TODO: remove after test
        answer.append(idString);
        answer.append('|');
        answer.append(request);
        answer.append('|');                             //TODO: remove after test

        String string;
        Date date;
        String action;

        long id = Long.parseLong(idString);
        JSONObject jsonObject;
        try {
            jsonObject = new JSONObject(request);
            string = jsonObject.getString("string");
            date = Date.valueOf(jsonObject.getString("date"));
            action = jsonObject.getString("action");
        } catch (JSONException ex) {
            string = null;
            date = null;
            action = null;
        }

        ElementEntity[] elementEntities = activeObjects.find(ElementEntity.class, Query.select().where("ID=?", id));
        ElementEntity elementEntity;
        if (elementEntities != null) {
            if (elementEntities.length > 0) {
                elementEntity = elementEntities[0];
            } else {
                elementEntity = activeObjects.create(ElementEntity.class);
            }
        } else {
            elementEntity = activeObjects.create(ElementEntity.class);
        }
        elementEntity.setString(string);
        elementEntity.setDate(date);
        elementEntity.setAction(action);
        elementEntity.save();
        answer.append(new ElementModel(elementEntity).toString()); //TODO: remove after test
        return Response.ok(answer.toString()).build();
    }

    @POST
    @Consumes({MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_JSON})
    public Response createVersion(final String request) {

        String string;
        Date date;
        String action;
        JSONObject jsonObject;
        try {
            jsonObject = new JSONObject(request);
            string = jsonObject.getString("string");
            date = Date.valueOf(jsonObject.getString("date"));
            action = jsonObject.getString("action");
        } catch (JSONException ex) {
            string = null;
            date = null;
            action = null;
        }

        ElementEntity newElementEntity = activeObjects.create(ElementEntity.class);
        newElementEntity.setString(string);
        newElementEntity.setDate(date);
        newElementEntity.setAction(action);
        newElementEntity.save();

        return Response.ok(new ElementModel(newElementEntity)).build();
    }

    @DELETE
    @Path("/{id}")
    @Produces({MediaType.APPLICATION_JSON})
    public Response delete(@PathParam("id") final String idStrem) {

        long id = Long.valueOf(idStrem);
        ElementEntity elementEntity = activeObjects.find(ElementEntity.class, Query.select().where("ID=?", id))[0];

        activeObjects.delete(elementEntity);

        return Response.ok(new ElementModel(elementEntity)).build();
    }
}
