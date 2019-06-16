package data.dto;

import java.util.List;

public interface IUserDTO {

    int getUserId();

    void setUserId(int userId);

    String getUserName();
    void setUserName(String userName);

    String getUserIni();


    void setUserIni(String UserIni);

    String getUserPassword();

    void setUserPassword(String userPassword);

    String getUserRole();

    void setUserRole(String userRole);

    String toString();

    List<String> getRoles();//{ return getRoles(); }

    void setRoles(List<String> roles);

    void addRole(String role);

    boolean removeRole(String role);

}
