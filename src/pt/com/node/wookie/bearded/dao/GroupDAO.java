package pt.com.node.wookie.bearded.dao;

import pt.com.node.wookie.bearded.core.keys.IntegerKey;
import pt.com.node.wookie.bearded.entities.Group;

/**
 * User: Henrique in Bearded-Wookie
 * Date: 18-10-2013
 * Time: 17:21
 */
public class GroupDAO extends UniqueDAO<IntegerKey, Group>
{


    @Override
    public Group getByKey(IntegerKey key)
    {
        return null;  //Do stuff here
    }
}
