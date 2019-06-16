package data.dal;

import data.dto.DALException;
import data.dto.UserDTO;



import java.io.Serializable;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDAO implements Serializable, data.dal.IUserDAO {
    private final String url = "jdbc:mysql://ec2-52-30-211-3.eu-west-1.compute.amazonaws.com/s160601?";
    private final String userName = "user=s160601";
    private final String pass = "password=ax1hqY3DBtPNqRcsvMGAy";

    @Override
    public void createUser(UserDTO user) throws DALException, SQLException {
        try (Connection connection = DriverManager.getConnection(url + userName + "&" + pass)) {   // med det syntax behøver man ikke lave final og connection.close()
            // try with resources
            PreparedStatement pStmt = connection.prepareStatement("INSERT INTO users_db (userId, userName, ini, password, userRole ) VALUES(?,?,?,?,?)");

            pStmt.setInt(1, user.getUserId());
            pStmt.setString(2, user.getUserName());
            pStmt.setString(3, user.getUserIni());
            pStmt.setString(4, user.getUserPassword());
            pStmt.setString(5, user.getUserRole());
            pStmt.executeUpdate();

            PreparedStatement prep2 = connection.prepareStatement("INSERT INTO roles_db (UserId, RoleId, roleName) VALUES (?,?,?)");
            //  for (String userRole: user.getRoles()) {
            prep2.setInt(1, user.getUserId());
            prep2.setInt(2, user.getRoleId());
            prep2.setString(3,user.getUserRole());
            prep2.executeUpdate();
            // }
        } catch (SQLException e) {
            e.printStackTrace();

            throw new DALException(e.getMessage());
        }
    }



    public UserDTO getUser(int userId) throws DALException, SQLException{
        try (Connection connection = DriverManager.getConnection(url + userName + "&" + pass)) {

            PreparedStatement prep = connection.prepareStatement("SELECT * FROM users_db WHERE userId = ?;");

            //gemmer den hentede brugerinfo fra SQL i en lokal variabel som jeg kalder resultSet.
            prep.setInt(1,userId);

            ResultSet res = prep.executeQuery();

            //tjekker om indtastede id matcher et id i min user tabel.
            if(!res.next()){
                throw new Exception("User does not exist, check UserID input");
            }

            UserDTO user = new UserDTO();
            user.setUserId(userId);
            user.setUserName(res.getString("userName"));
            user.setUserIni(res.getString("ini"));
            user.setUserPassword(res.getString("password"));

            //Rollerne til den enkelte bruger hentes fra min anden tabel som jeg har kaldt roles_db,
            // som har 3 kolonner: id(som er min primary key for denne tabel,
            // userId(denne kolonne er foreign key, som har reference til feltet Id i UserList tabellen),
            // og vigtigst har den kolonnen "Role", som beskriver en unik rolle for hvert UserListId.
            // Det samme UserListId kan forekomme flere steder i denne tabel, såfremt dette id har fået tildelt mere end 1 rolle.

            PreparedStatement prep2 = connection.prepareStatement("SELECT Role FROM roles_db WHERE userId = ?");
            prep2.setInt(1,userId);
            ResultSet resRoles = prep2.executeQuery();

            List<String> roles = new ArrayList<String>();

            while(resRoles.next()){
                roles.add(resRoles.getString("roleName"));
            }
            user.setRoles(roles);

            createUser(user);
            return user;

        } catch (Exception e) {
            e.printStackTrace();
            throw new DALException(e.getMessage());
        }
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


//    public UserDTO getUser(int userId, String userName, String ini, String role) throws DALException {
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
//            pStmt.setString(4, password);
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
