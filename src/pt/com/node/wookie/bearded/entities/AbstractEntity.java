package pt.com.node.wookie.bearded.entities;

import pt.com.node.wookie.bearded.core.keys.Key;

import java.io.Serializable;

/**
 * User: Henrique in Bearded-Wookie
 * Date: 15-10-2013
 * Time: 18:15
 */
public class AbstractEntity<K extends Key> implements Serializable
{
    protected K key;

    public K getKey()
    {
        return this.key;
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

        return this.key.equals(that.getKey());
    }
}
