package pt.com.node.wookie.bearded.dao;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import pt.com.node.wookie.bearded.core.DataSourceManager;
import pt.com.node.wookie.bearded.entities.User;

import javax.sql.DataSource;
import java.util.List;

/**
 * User: Henrique in Bearded-Wookie
 * Date: 15-10-2013
 * Time: 22:21
 */
public class UserDAO extends AbstractDao
{
    public void create(String username, String email, String password, String name, String security_question, String security_answer)
    {
        JdbcTemplate insert = new JdbcTemplate(dataSource);
        insert.update("INSERT INTO user (username , email ,name, password , security_question , security_answer ) VALUES(?,?,?,?,?,?)",
                username, email, name, password, security_question, security_answer);
    }

    public List<User> selectAll()
    {
        JdbcTemplate select = new JdbcTemplate(dataSource);
        return select.query("SELECT id_user, username, email, password, name, token from user", new BeanPropertyRowMapper(User.class));
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
        JdbcTemplate jdbc = new JdbcTemplate(dataSource);
        //Getitng user by username and password, if any
        User u = null;
        try
        {
            u = (User) jdbc.queryForObject("Select id_user, username, email, password, name,token  from user where username = ? and password = ?",
                    new Object[]{username, password}, new BeanPropertyRowMapper(User.class));

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
        JdbcTemplate jdbc = new JdbcTemplate(dataSource);
        jdbc.update("UPDATE user set token = UUID() where id_user = ?", u.getId());
        u.setToken(jdbc.queryForObject("Select token from user where id_user = ?", String.class, u.getId()));
    }
}
