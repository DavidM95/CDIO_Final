package data.dto;

import java.io.Serializable;
import java.util.List;

public class UserDTO implements Serializable, IUserDTO {

    private static final long serialVersionUID = 4545864587995944260L;
    private int userId;
    private String userName;
    private String userIni;
    private String userPassword;
    private String userRole; // i tvivl om samme bruger kan have flere roller??



//    private List<String> roles;

    public UserDTO(int userId, String userName, String userIni, String userPassword, String userRole) {
        this.userId = userId;
        this.userName = userName;
        this.userIni = userIni;
        this.userPassword = userPassword;
        this.userRole = userRole;
    }

  //  public UserDTO(int userId){
  //      this.userId = userId;
  //  }

  //  public UserDTO(String userName){
  //      this.userName = userName;
  //  }

//    public UserDTO(String userPassword){
//        this.userPassword = userPassword;
//    }
//
//    public UserDTO(String userName){
//        this.userName = userName;
//    }

    public UserDTO() {

    }
    @Override
    public int getUserId() {
        return userId;}

    @Override
    public void setUserId(int userId) {this.userId = userId; }

    @Override
    public String getUserName() {
        return userName;
    }

    @Override
    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Override
    public String getUserPassword() {
        return userPassword;
    }

    @Override
    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    @Override
    public String getUserIni() { return userIni; }

    @Override
    public void setUserIni(String userIni) {this.userIni = userIni; }

    @Override
    public String getUserRole() { return userRole; }

    @Override
    public void setUserRole(String userRole) { this.userRole = userRole;}

    @Override
    public List<String> getRoles() {
        return null;
    }

    @Override
    public void setRoles(List<String> roles) {

    }

    @Override
    public void addRole(String role) {

    }

    @Override
    public boolean removeRole(String role) {
        return false;
    }
    @Override
    public String toString() {
        return "UserDTO [userId=" + userId + ", userName=" + userName + "initials=" + userIni + "role=" + userRole + "]";
    }

}
