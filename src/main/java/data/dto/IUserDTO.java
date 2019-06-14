package data.dto;

import java.util.List;

public interface IUserDTO {

    int getUserId();

    void setUserId(int userId);

    String getUserName();

    List<String>getRoles();

    void addRole(String role);

    boolean removeRole(String role);

    void setRoles(List<String> roles);

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
