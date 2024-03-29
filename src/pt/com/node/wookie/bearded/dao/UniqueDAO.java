package pt.com.node.wookie.bearded.dao;

import pt.com.node.wookie.bearded.core.keys.Key;
import pt.com.node.wookie.bearded.entities.AbstractEntity;

import java.util.HashMap;
import java.util.Map;

/**
 * User: Henrique in Bearded-Wookie
 * Date: 18-10-2013
 * Time: 16:37
 */
public abstract class UniqueDAO<K extends Key, E extends AbstractEntity> extends AbstractDao<K, E>
{
    private Map<Key, E> instances = new HashMap<>();

    protected boolean isInstanciated(K key)
    {
        return instances.containsKey(key);
    }

    public E getInstance(K key)
    {
        if (instances.containsKey(key))
            return instances.get(key);
        return null;
        //ERRO
    }

    public void createInstace(K key, E entity)
    {
        if (!isInstanciated(key))
            instances.put(key, entity);
    }

}
