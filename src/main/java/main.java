import data.dal.IUserDAO;
import data.dal.UserDAO;
import data.dto.IUserDTO;
import data.dto.UserDTO;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class main {
    private static String getMenuText ()
    {
        return "1. Create user\n2. List users\n3. Update user\n4. Delete User \n5. Exit program";
    }
    //Opretter nyt UserDTO objekt, newUser, som via  brugerinput fra konsollen får tildelt værdier til de tilsvarende variabler.
    // Til sidst kaldes c.createUser(newUser)
    // hvilket sørger for at brugeren oprettes i databasen, med de værdier som brugeren har indtastet via konsol(newUser)
    private static void createUserFromInput() throws SQLException, IUserDAO.DALException {
        UserDTO newUser = new UserDTO();
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter user id:");
        newUser.setUserId(sc.nextInt());
        System.out.println("Enter name:");
        newUser.setUserName(sc.nextLine());
        System.out.println("Enter initials:");
        newUser.setUserIni(sc.nextLine());
        System.out.println("Enter wanted password");
        newUser.setUserPassword(sc.nextLine());
        System.out.println("Enter how many roles to add to user");
        int rolescount = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < rolescount; i++) {
            System.out.println("Enter role name");
            newUser.addRole(sc.nextLine());
        }

        UserDAO u = new UserDAO();
        u.createUser(newUser);
    }
    // metode der bruger foreach loop til at løbe listen
    private static void listUsers(UserDAO u) throws SQLException, IUserDAO.DALException {
        for (IUserDTO user : u.getUserList())
        {
            System.out.println(user);
        }
    }

    private static void updateUserFromInput(UserDAO u) throws Exception {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter userId of user to update:");
        int userId = Integer.parseInt(sc.nextLine());
        IUserDTO user = u.getUser(userId);

        System.out.println("This is the user you're about to update: " + user);
        System.out.println("Enter new name or ! to keep existing");
        String userInput = sc.nextLine();
        if (userInput != "!") {
            user.setUserName(userInput);
        }

        System.out.println("edit roles y/n (note, this will delete all current roles and create new):");
        userInput = sc.nextLine();
        if (userInput.equals("y")) {
            List<String> userRoles = new ArrayList<String>();
            for(String s : user.getRoles()) {
                userRoles.add(s);
            }
            for (int i = 0; i < userRoles.size(); i++) {
                user.removeRole(userRoles.get(i));
            }
            System.out.println("how many roles should be added");
            int rolescount = Integer.parseInt(sc.nextLine());
            for (int i = 0; i < rolescount; i++) {
                System.out.println("Enter role name");
                user.addRole(sc.nextLine());
            }
        }
        // spørg efter andre properties

        u.updateUser((UserDTO) user);
    }

    public static void exitProgram(){
        System.exit(0);
    }

    public static void deleteUserFromInput(UserDAO u){
        Scanner sc = new Scanner(System.in);
        int userId;

        System.out.println("Indtast brugerId'et på brugeren som skal slettes fra tabellen");
        userId = sc.nextInt();



    }

    public static void main(String[] args) throws Exception {
        UserDAO u = new UserDAO();
        System.out.println(getMenuText());
        Scanner sc = new Scanner(System.in);
        switch (sc.nextInt())
        {
            case 1:
                createUserFromInput();
                break;
            case 2:
                listUsers(u);
                break;
            case 3:
                updateUserFromInput(u);
                break;
            case 4:

                break;
            case 5:
                exitProgram();
                break;
            default: break;
        }

//        UserDTO newUser = new UserDTO();
//        newUser.setUserId(1);
//        newUser.setUserName("David Milutin");
//        newUser.setUserIni("DM");
//        newUser.addRole("Admin");
//        newUser.addRole("Supervisor");
//
//        c.createUser(newUser);
//
//        UserDTO newUserFromDatabase = c.getUser(newUser.getUserId());
//        System.out.println(newUserFromDatabase);
//
//        newUserFromDatabase.setUserName("Hans Christian");
//        newUserFromDatabase.setUserIni("HC");
//        newUserFromDatabase.removeRole("Admin");
//
//        c.updateUser(newUserFromDatabase);
//
//        UserDTO updatedUserFromDatabase = c.getUser(newUser.getUserId());
//        System.out.println(updatedUserFromDatabase);
//
//        for (UserDTO user : c.getUserList())
//        {
//            System.out.println(user);
//        }
//
//     //   c.deleteUser(updatedUserFromDatabase.getUserId());
//


    }
}


