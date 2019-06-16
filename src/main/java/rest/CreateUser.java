package rest;

import controllere.Controller;
import data.dto.UserDTO;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@Path("createUser")

public class CreateUser {

    @GET
    public Response getUserId(UserDTO userDTO) {
        return Response.ok("hej" + userDTO.getUserId() ).build();
    }


/*    @POST
    @Path("{navn}")
    public Response postHelloWorld(@PathParam("navn") String navn) {

        return Response.ok("Hej " + navn + "").build();
    }*/


    @POST
    public Response CreatUser(UserDTO userDTO) {
//      Controller controller = new Controller();
//       controller.opretBruger(userDTO);
        return Response.ok("OK" + userDTO.getUserId()).build();

    }
}

