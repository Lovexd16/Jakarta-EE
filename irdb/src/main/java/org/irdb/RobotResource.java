package org.irdb;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

import jakarta.inject.Inject;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import jakarta.ws.rs.PathParam;
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

    @Inject
    RobotService robotService;

    //Get för att hämta alla robotar
    @GET
    public Response getRobots() {

        //Mock-lista
        List<Robot> robots = robotService.findAll();

        if (robots.isEmpty()) {
            return Response.noContent().build();
        }

        return Response.ok(robots).build();
    }

    //Get för att hämta en robot med id
    @GET
    @Path("/{id}") //Lägger till id i slutet av den orginella pathen
    public Response getRobotById(@PathParam("id") @Min(1) Long id) {

        Robot robot = robotService.find(id);

        return Response.ok(robot).build();
    }

    //Get som talar om hur många robotar som finns
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    @Path("/count")
    public Response countRobots() {

        Long count = robotService.countAll();
        return Response.ok(count).build();
    }

    //Post för att skapa en robot
    @POST
    public Response createRobot(@Valid Robot robot) throws URISyntaxException { //@Valid så att felmeddelanden blir bättre

        robot = robotService.create(robot);

        URI createdUri = new URI(robot.getId().toString());
        return Response.created(createdUri).entity(robot).build();
    }

    //Delete för att ta bort en robot
    @DELETE
    @Path("/{id}")
    public Response deleteRobot(@PathParam("id") @Min(1) Long id) {

        robotService.delete(id);
        return Response.noContent().build();
    }

}
