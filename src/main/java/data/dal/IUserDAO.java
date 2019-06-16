package data.dal;

import data.dto.DALException;
import data.dto.IUserDTO;
import data.dto.UserDTO;

import java.sql.SQLException;
import java.util.List;

public interface IUserDAO {

    //Create
    void createUser(UserDTO user) throws DALException, SQLException;

    //Read
    UserDTO getUser(int userId) throws DALException, SQLException;

    List<UserDTO> getUserList() throws DALException;

    //Update
    void updateUser(UserDTO user) throws DALException;

    //Delete
    void deleteUser(int userId) throws DALException;


}
