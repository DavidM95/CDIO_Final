package rest;


import data.Controllere.Controller;
import data.dto.UserDTO;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
@Consumes(MediaType.APPLICATION_JSON)
@Path("createUser")

public class CreateUser {

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
    public Response opretBruger(UserDTO userDTO) {
//        boolean loggedin = logincontroller.login(userDTO);
//
//        if(loggedin) {

        Controller.opretBruger(userDTO);
        System.out.println("UserId: " + userDTO.getUserId() + "Username: " + userDTO.getUserName() + "UserIni: " + userDTO.getUserIni() + " userPassword: " + userDTO.getUserPassword() + "userRole: " + userDTO.getUserRole() );
        return Response.ok("Du har nu oprettet en bruger").build();

//         } else {
//            return Response.ok("-1").build();
//        }

    }
}

