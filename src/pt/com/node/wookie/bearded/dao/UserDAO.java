package pt.com.node.wookie.bearded.dao;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import pt.com.node.wookie.bearded.core.DataSourceManager;
import pt.com.node.wookie.bearded.core.keys.IntegerKey;
import pt.com.node.wookie.bearded.entities.User;

import java.util.List;


/**
 * User: Henrique in Bearded-Wookie
 * Date: 15-10-2013
 * Time: 22:21
 */
public class UserDAO extends AbstractDao<IntegerKey, User>
{
    private final static String authenticateSQL = "SELECT id_user, username, email, password, name,token  FROM user WHERE username = ? AND password = ?";
    private final static String selectAllSQL = "SELECT id_user, username, email, password, name, token FROM user";
    private final static String getUserByID = "SELECT token FROM user WHERE id_user = ?";
    private final static String getUserByUsername = "SELECT id_user, username, email, password, name, token FROM user WHERE username = ?";
    private final static String getUserByToken = "SELECT id_user,name, username,email, password, name, token , fk_id_group AS 'id_group' FROM user WHERE token = ?";
    private final static String createSQL = "INSERT INTO user (username , email ,name, password ) VALUES(?, ?, ?, ?)";
    private final static String setTokenSQL = "UPDATE user SET token = UUID() WHERE id_user = ?";
    private final static String deleteUserByIDSQL = "DELETE FROM user WHERE id_user = ?";
    private final static String updateUserSQL = "UPDATE user SET username = ? ,name = ? , email = ? , password = ? WHERE id_user = ?";

    protected UserDAO()
    {

    }

    @Override
    public User update(User entity)
    {
        try
        {
            jdbc.update(updateUserSQL, new Object[]{entity.getUsername(), entity.getName(), entity.getEmail(), entity.getPassword(), entity.getKey().getIntegerFromKey()});
        } catch (Exception excpetion)
        {
            return null;
        }
        return getByKey(entity.getKey());
    }

    @Override
    public List<User> selectAll()
    {
        return jdbc.query(selectAllSQL, new BeanPropertyRowMapper(User.class));
    }

    public User getByUserByUsername(String username)
    {
        //Getitng user by username and password, if any
        User u;
        try
        {
            u = (User) jdbc.queryForObject(getUserByUsername, new Object[]{username}, new BeanPropertyRowMapper(User.class));

        } catch (Exception exception)
        {
            //No users with username and password
            exception.printStackTrace();
            return null;
        }
        return u;
    }

    @Override
    public boolean remove(User entity)
    {
        try
        {
            jdbc.update(deleteUserByIDSQL, new Object[]{entity.getKey().getIntegerFromKey()});
        } catch (Exception e)
        {
            return false;
        }
        return true;
    }

    @Override
    public User create(User entity)
    {
        try
        {
            jdbc.update(createSQL, new Object[]{entity.getUsername(), entity.getEmail(), entity.getName(), entity.getPassword()});
        } catch (Exception e)
        {
            return null;
        }
        return getByUserByUsername(entity.getUsername());
    }

    @Override
    public User getByKey(IntegerKey key)
    {
        //Getitng user by username and password, if any
        User u;
        try
        {
            u = (User) jdbc.queryForObject(getUserByID, new Object[]{key.getIntegerFromKey()}, new BeanPropertyRowMapper(User.class));

        } catch (EmptyResultDataAccessException exception)
        {
            //No users with username and password
            return null;
        }
        return u;
    }

    /**
     * Authentication Attempt
     *
     * @param username Username
     * @param password Password
     * @return NULL if failure
     */
    public User authenticate(String username, String password)
    {
        String passwordHashed = DataSourceManager.getMD5HashWithSalt(password);
        //Getitng user by username and password, if any
        User u;
        try
        {
            u = (User) jdbc.queryForObject(authenticateSQL, new Object[]{username, passwordHashed}, new BeanPropertyRowMapper(User.class));

        } catch (EmptyResultDataAccessException exception)
        {
            //No users with username and password
            return null;
        }
        //Checking if returned user, meaning authentication was successful
        if (u != null)
            createTokenForUser(u);
        return u;
    }

    private void createTokenForUser(User u)
    {
        jdbc.update(setTokenSQL, u.getKey().getIntegerFromKey());
        u.setToken(jdbc.queryForObject(getUserByID, String.class, u.getKey().getIntegerFromKey()));
    }

    public User getUserByToken(String token)
    {
        User u;
        try
        {
            u = (User) jdbc.queryForObject(getUserByToken, new Object[]{token}, new BeanPropertyRowMapper(User.class));
        } catch (EmptyResultDataAccessException exception)
        {
            //No users with that token
            return null;
        }
        return u;
    }


}
