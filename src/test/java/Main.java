/**
 * User: Henrique in Bearded-Wookie
 * Date: 15-10-2013
 * Time: 22:56
 */

import pt.com.node.wookie.bearded.dao.UserDAO;
import pt.com.node.wookie.bearded.entities.User;

public class Main
{
    public static void main(String[] args)
    {
        UserDAO dao = new UserDAO();
        // Initialize the datasource, could /should be done of Spring
        // configuration

        // Inject the datasource into the dao
        //dao.setDataSource(dataSource);

        //dao.create("TestUser","henrique@ferreiratech.com.pt","teste","Henrique","Is it really?","Yes");
        //System.out.println("Now select and list all persons");
        String pass = "698dc19d489c4e4db73e28a713eab07b";
        String passHashed = "1cc2d398e3b95fb3bd34e58f705d9d03";
        User u = dao.authenticate("ecofreak", pass);

        System.out.println(u);
        /*List<User> list = dao.selectAll();
        for (User myUser : list)
        {
            System.out.println(myUser);
        } */
        // Clean-up
        //  dao.deleteAll();
    }
}
