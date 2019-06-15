package data;

import data.dal.IUserDAO;
import data.dto.UserDTO;
import data.dto.IUserDTO;
import data.dal.UserDAO;

import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class DALTestUser {

    IUserDAO userDAO = new UserDAO();

    @Test
    public void testCreateUser() throws IUserDAO.DALException, SQLException {

        UserDTO testUser = new UserDTO();
        testUser.setUserId(25);
        testUser.setUserName("LabKing");
        testUser.setIni("LK");

        userDAO.createUser(testUser);
        UserDTO receivedUser = userDAO.getUser(25);
        String actual = receivedUser.getUserName();
        String expected = testUser.getUserName();
        assertEquals(expected, actual);
        assertEquals("LK",testUser.getIni());


    }


    @Test
    public void testGetUser() throws IUserDAO.DALException {

    }

}

