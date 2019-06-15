package data.dto;

import java.util.List;

public interface IUserDTO {

    int getUserId();

    void setUserId(int userId);

    String getUserName();

    static List<String>getRoles(){
        return getRoles();
    }
    void addRole(String role);

    boolean removeRole(String role);

    void setRoles(List<String> roles);

    void setUserName(String userName);

    void setIni(String ini);
    String toString();
    String getIni();

    String getPassword();

    // skal fjernes da det ikke bliver brugt i databasen

    // skal fjernes da det ikke blier brugt i databasen





}
