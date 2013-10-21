package pt.com.node.wookie.bearded.entities;

import pt.com.node.wookie.bearded.core.DataSourceManager;
import pt.com.node.wookie.bearded.core.keys.IntegerKey;

/**
 * User: Henrique in Bearded-Wookie
 * Date: 15-10-2013
 * Time: 19:16
 */
public class User extends AbstractEntity<IntegerKey>
{
    private String username, name, email, password;
    private String token;
    private UserGroup group;

    public User()
    {

    }

    public User(String username, String email, String password, String name)
    {
        this.username = username;
        this.email = email;
        this.name = name;
        setPassword(password);
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
        this.key = new IntegerKey(id_user);
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
        this.password = DataSourceManager.getMD5HashWithSalt(password);
    }

    public String getToken()
    {
        return token;
    }

    public void setToken(String token)
    {
        this.token = token;
    }

    public UserGroup getGroup()
    {
        return group;
    }

    public void setGroup(UserGroup group)
    {
        this.group = group;
    }

    @Override
    public String toString()
    {
        return "User{" +
                "key='" + key + "\'" +
                ",username='" + username + '\'' +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", token='" + token + '\'' +
                ", group=" + group +
                '}';
    }
}
