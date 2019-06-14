package rest;


import data.dto.UserDTO;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
@Consumes(MediaType.APPLICATION_JSON)
@Path("helloService")

public class HelloService {

    @GET
    public Response getHelloWorld() {
        return Response.ok("hej").build();
    }


/*    @POST
    @Path("{navn}")
    public Response postHelloWorld(@PathParam("navn") String navn) {

        return Response.ok("Hej " + navn + "").build();
    }*/


    @POST
    public Response loginUser(UserDTO userDTO) {
        boolean loggedin = logincontroller.login(userDTO);

        if(loggedin) {

            System.out.println("Username: " + userDTO.getUserName() + " userID: " + userDTO.getUserId());
            return Response.ok("OK" + userDTO.getUserName()).build();

         } else {
            return Response.ok("-1").build();
        }

    }
}

