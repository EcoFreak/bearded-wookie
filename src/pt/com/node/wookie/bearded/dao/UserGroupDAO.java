package pt.com.node.wookie.bearded.dao;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import pt.com.node.wookie.bearded.core.keys.IntegerKey;
import pt.com.node.wookie.bearded.entities.UserGroup;

import java.util.List;

/**
 * User: Henrique in Bearded-Wookie
 * Date: 18-10-2013
 * Time: 17:21
 */
public class UserGroupDAO extends UniqueDAO<IntegerKey, UserGroup>
{
    private final static String selectAllSQL = "SELECT * FROM user_group";
    private final static String updateGroupSQL = "UPDATE user_group SET name = ? WHERE id_group = ?";
    private final static String deleteGroupByIDSQL = "DELETE FROM user_group WHERE id_group = ?";
    private final static String createGroupSQL = "INSERT INTO user_group VALUES(?)";
    private final static String getByGroupName = "SELECT * FROM user_group WHERE name = ?";
    private final static String getByGroupId = "SELECT * FROM user_group WHERE id_group = ?";

    @Override
    public List<UserGroup> selectAll()
    {
        List<UserGroup> tempList = jdbc.query(selectAllSQL, new BeanPropertyRowMapper(UserGroup.class));
        for (UserGroup group : tempList)
            createInstace(group.getKey(), group);
        return tempList;
    }

    @Override
    public UserGroup update(UserGroup entity)
    {
        try
        {
            jdbc.update(updateGroupSQL, new Object[]{entity.getName(), entity.getKey().getIntegerFromKey()});
        } catch (Exception excpetion)
        {
            return null;
        }
        return getByKey(entity.getKey());
    }

    @Override
    public boolean remove(UserGroup entity)
    {
        try
        {
            jdbc.update(deleteGroupByIDSQL, new Object[]{entity.getKey().getIntegerFromKey()});
        } catch (Exception e)
        {
            return false;
        }
        return true;
    }

    @Override
    public UserGroup create(UserGroup entity)
    {
        jdbc.update(createGroupSQL, new Object[]{entity.getName()});
        return getByGroupName(entity.getName());
    }

    @Override
    public UserGroup getByKey(IntegerKey key)
    {
        if (isInstanciated(key))
            return getInstance(key);
        UserGroup g;
        try
        {
            g = (UserGroup) jdbc.queryForObject(getByGroupId, new Object[]{key.getIntegerFromKey()}, new BeanPropertyRowMapper(UserGroup.class));
        } catch (Exception e)
        {
            return null;
        }
        createInstace(key, g);
        return g;
    }

    public UserGroup getByGroupName(String name)
    {
        UserGroup g;
        try
        {
            g = (UserGroup) jdbc.queryForObject(getByGroupName, new Object[]{name}, new BeanPropertyRowMapper(UserGroup.class));
        } catch (Exception e)
        {
            return null;
        }
        return g;
    }
}
