package pt.com.node.wookie.bearded.core.keys;

/**
 * User: Henrique in Bearded-Wookie
 * Date: 18-10-2013
 * Time: 17:13
 */
public class IntegerKey extends Key
{
    private int id;

    public IntegerKey(int id)
    {
        this.id = id;
    }

    public int getIntegerFromKey()
    {
        return id;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (!(o instanceof IntegerKey)) return false;
        return this.id == ((IntegerKey) o).id;
    }

    @Override
    public int hashCode()
    {
        return id;
    }

    @Override
    public String toString()
    {
        return "ID:" + id;
    }
}
