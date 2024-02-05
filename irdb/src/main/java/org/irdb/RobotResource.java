package org.irdb;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

import jakarta.websocket.server.PathParam;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/api/robot") //Denna blir vad alla endpoints använder
@Produces(MediaType.APPLICATION_JSON) // Alla våra endpoints Producerar JSON (lämna ifrån sig json)
@Consumes(MediaType.APPLICATION_JSON) //Alla våra endpoints Konsumerar JSON (tar emot json)
public class RobotResource {

    //Get för att hämta alla robotar
    @GET
    public Response getRobots() {

        //Mock-lista
        List<Robot> robots = new ArrayList<>();

        if (robots.isEmpty()) {
            return Response.noContent().build();
        }

        return Response.ok(robots).build();
    }

    //Get för att hämta en robot med id
    @GET
    @Path("/id") //Lägger till id i slutet av den orginella pathen
    public Response getRobotById(@PathParam("id") Long id) {

        Robot robot = new Robot();

        return Response.ok(robot).build();
    }

    //Get som talar om hur många robotar som finns
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    @Path("/count")
    public Response countRobots() {

        Long count = 0L;
        return Response.ok(count).build();
    }

    //Post för att skapa en robot
    @POST
    public Response createRobot(Robot robot) throws URISyntaxException {

        robot.setId(1L);

        URI createdUri = new URI(robot.getId().toString());
        return Response.created(createdUri).entity(robot).build();
    }

    //Delete för att ta bort en robot
    @DELETE
    @Path("/id")
    public Response deleteRobot(@PathParam("id") Long id) {

        return Response.noContent().build();
    }

}
