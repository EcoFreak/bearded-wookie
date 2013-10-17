package pt.com.node.wookie.bearded.entities;

/**
 * User: Henrique in Bearded-Wookie
 * Date: 15-10-2013
 * Time: 18:15
 */
public class AbstractEntity
{
    protected int id;

    public int getId()
    {
        return this.id;
    }

    @Override
    public boolean equals(Object obj)
    {

        if (this == obj)
        {
            return true;
        }
        if (this == null || obj == null || !(this.getClass().equals(obj.getClass())))
        {
            return false;
        }

        AbstractEntity that = (AbstractEntity) obj;

        return this.id == that.getId();
    }
}
