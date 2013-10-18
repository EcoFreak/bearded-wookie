package pt.com.node.wookie.bearded.entities;

/**
 * User: Henrique in Bearded-Wookie
 * Date: 15-10-2013
 * Time: 19:16
 */
public class User extends AbstractEntity
{
    private String username, name, email, password;
    private String token;
    private Group group;

    public User()
    {

    }

    public User(int id_user, String username, String email, String password, String name)
    {
        this.id = id_user;
        this.username = username;
        this.email = email;
        this.name = name;
        this.password = password;
    }

    public String getUsername()
    {
        return username;
    }

    public void setUsername(String username)
    {
        this.username = username;
    }

    public void setIdUser(int id_user)
    {
        this.id = id_user;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getEmail()
    {
        return email;
    }

    public void setEmail(String email)
    {
        this.email = email;
    }

    public String getPassword()
    {
        return password;
    }

    public void setPassword(String password)
    {
        this.password = password;
    }

    public String getToken()
    {
        return token;
    }

    public void setToken(String token)
    {
        this.token = token;
    }

    public Group getGroup()
    {
        return group;
    }

    public void setGroup(Group group)
    {
        this.group = group;
    }

    @Override
    public String toString()
    {
        return "User{" +
                "username='" + username + '\'' +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", token='" + token + '\'' +
                ", group=" + group +
                '}';
    }
}
