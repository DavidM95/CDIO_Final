package data.dto;

import java.io.Serializable;

public class UserDTO implements Serializable, IUserDTO {

    private static final long serialVersionUID = 4545864587995944260L;
    private int	userId;
    private String userName;
    private String ini;
    private String password;
    private String role; // i tvivl om samme bruger kan have flere roller??



//    private List<String> roles;

    public UserDTO(int userId, String userName, String ini, String password, String role) {
        this.userId = userId;
        this.userName = userName;
        this.ini = ini;
        this.password = password;
        this.role = role;
    }

    public UserDTO(int userId){
        this.userId = userId;
    }

    public UserDTO(String userName){
        this.userName = userName;
    }

    public UserDTO() {

    }


    @Override
    public String getIni() {
        return ini;
    }

    @Override
    public String getPassword() {
        return password;
    }



    public void setIni(String ini) {
        this.ini = ini;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    @Override
    public int getUserId() {
        return userId;
    }

    @Override
    public void setUserId(int userId) {
        this.userId = userId;
    }

    @Override
    public String getUserName() {
        return userName;
    }

    @Override
    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Override
    public String toString() {
        return "UserDTO [userId=" + userId + ", userName=" + userName + "initials=" + ini"]";
    }

}
