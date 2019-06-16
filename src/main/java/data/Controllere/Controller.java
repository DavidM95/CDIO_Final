package data.Controllere;

import data.dto.UserDTO;

public class Controller {

    public void opretBruger(UserDTO userDTO, UserDAO userDAO) {
        if (userDTO.getUserId() != UserDAO.getUserId)
            userDAO.opretBruger(userDTO);
    }
}
