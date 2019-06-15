package data.dal;

import data.dto.UserDTO;



import java.io.Serializable;
import java.sql.*;
import java.util.List;

public class UserDAO implements Serializable, data.dal.IUserDAO {
    private final String url = "jdbc:mysql://ec2-52-30-211-3.eu-west-1.compute.amazonaws.com/s160601?";
    private final String userName = "user=s160601";
    private final String pass = "password=ax1hqY3DBtPNqRcsvMGAy";

    @Override
    public void createUser(UserDTO user) throws DALException, SQLException {
        try (Connection connection = DriverManager.getConnection(url + userName + "&" + pass)) {   // med det syntax behøver man ikke lave final og connection.close()
            // try with resources
            PreparedStatement pStmt = connection.prepareStatement("INSERT INTO users_db (userId, userName, ini, password) VALUES(?,?,?,?)");

            pStmt.setInt(1, user.getUserId());
            pStmt.setString(2, user.getUserName());
            pStmt.setString(3, user.getIni());
            pStmt.setString(4, user.getPassword());
            pStmt.executeUpdate();

            PreparedStatement prep2 = connection.prepareStatement("INSERT INTO UserRoles(UserId, RoleId, ini) VALUES (?,?,?)");
            for (String role : user.getRoles()) {
                prep2.setInt(1, user.getUserId());
                prep2.setString(2, role);
                prep2.setString(3,user.getIni());
                prep2.executeUpdate();



            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public UserDTO getUser(int userId) throws DALException {
        return null;
    }

    @Override
    public List<UserDTO> getUserList() throws DALException {
        return null;
    }

    @Override
    public void updateUser(UserDTO user) throws DALException {

    }

    @Override
    public void deleteUser(int userId) throws DALException {

    }


//    private UserDTO getUser(int userId, String userName, String ini, String role) throws DALException {
//        UserDTO user = null;
//
//        // closes itself if something fails
//        try (Connection connection = DriverManager.getConnection(url + userName + "&" + pass)) {
//
//            PreparedStatement pStmt = connection.prepareStatement(
//                    "SELECT * FROM users_db WHERE userId = ?");
//
//            pStmt.setInt(1, userId);
//            pStmt.setString(2, userName);
//            pStmt.setString(3, ini);
//            ResultSet res = pStmt.executeQuery();
//            res.next();
//
//            user = new UserDTO(userId, res.getString(2), res.getString(3), res.getString(4), res.getString(5));
//
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return user;
//    }
}

//    @Override
//    public List<UserDTO> getUserList() throws data.dto.DALException {
//        List<UserDTO> users = new ArrayList<>();
//        UserDTO user = null;
//
//        try(Connection connection = DriverManager.getConnection(url + userName + "&" + pass)){
//
//            PreparedStatement pStmt = connection.prepareStatement("SELECT * FROM users_db");
//            ResultSet resultSet = pStmt.executeQuery();
//
//            while(resultSet.next()){
//                user = new UserDTO(resultSet.getInt(1),resultSet.getString(2));
//                users.add(user);
//            }
//
//        } catch (SQLException e) {
//            e.printStackTrace();
//        } return users;
//
//    }
//
//    @Override
//    public void updateUser(UserDTO user) throws DALException {
//
//        try (Connection connection = DriverManager.getConnection(url + userName + "&" + pass)) {
//
//            PreparedStatement pStmt = connection.prepareStatement("UPDATE users_db SET userName = ? WHERE user_id = ?");
//
//            pStmt.setString(1, user.getUserName());
//            pStmt.setInt(2, user.getUserId());
//            pStmt.executeUpdate();
//
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }
//
//
//    @Override
//    public void deleteUser(int userId) throws DALException {
//        try(Connection connection = DriverManager.getConnection(url + userName +"&"+ pass)){
//            UserRoleDAO userRoleDAO = new UserRoleDAO();
//
//            userRoleDAO.deleteUserRoles(userId);
//
//            PreparedStatement pStmt1 = connection.prepareStatement("DELETE FROM users_db WHERE user_id = ?");
//            pStmt1.setInt(1, userId);
//            pStmt1.executeUpdate();
//
//        }catch (SQLException e){
//            e.printStackTrace();
//
//        } catch (data.dto.DALException e) {
//            e.printStackTrace();
//        }
//    }
//}
//
