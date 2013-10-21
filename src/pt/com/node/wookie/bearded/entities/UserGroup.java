package pt.com.node.wookie.bearded.entities;

import pt.com.node.wookie.bearded.core.keys.IntegerKey;

/**
 * User: Henrique in Bearded-Wookie
 * Date: 18-10-2013
 * Time: 15:41
 */
public class UserGroup extends AbstractEntity<IntegerKey>
{
    private String name;

    public UserGroup()
    {

    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public void setIdGroup(int idGroup)
    {
        this.key = new IntegerKey(idGroup);
    }

    @Override
    public String toString()
    {
        return "Group{" +
                hashCode() +
                "name='" + name + '\'' +
                '}';
    }
}
