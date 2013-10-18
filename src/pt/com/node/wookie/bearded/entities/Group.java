package pt.com.node.wookie.bearded.entities;

/**
 * User: Henrique in Bearded-Wookie
 * Date: 18-10-2013
 * Time: 15:41
 */
public class Group extends AbstractEntity
{
    private String name;

    public Group()
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
        this.id = idGroup;
    }

    @Override
    public String toString()
    {
        return "Group{" +
                "name='" + name + '\'' +
                '}';
    }
}
