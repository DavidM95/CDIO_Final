package data.Controllere;

import data.dto.UserDTO;

public class Controller {


    public static void opretBruger(UserDTO userDTO) {

        if (userDTO.getUserId() != UserDAO.getUserId)
            UserDAO.opretBruger(userDTO.getUserId());


    }


}
