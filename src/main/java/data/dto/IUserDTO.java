package data.dto;

import java.util.List;

public interface IUserDTO {

    int getUserId();

    void setUserId(int userId);

    String getUserName();

    void setUserName(String userName);

    String toString();
    String getIni();

    String getPassword();

    // skal fjernes da det ikke bliver brugt i databasen

    // skal fjernes da det ikke blier brugt i databasen
    //void setIni(String ini);

    //List<String> getRoles();

    //void setRoles(List<String> roles);

    //void addRole(String role);

    //boolean removeRole(String role);

}
