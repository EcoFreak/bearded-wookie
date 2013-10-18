package pt.com.node.wookie.bearded.dao;

import pt.com.node.wookie.bearded.core.DataSourceManager;
import pt.com.node.wookie.bearded.core.keys.Key;
import pt.com.node.wookie.bearded.entities.AbstractEntity;

import javax.sql.DataSource;

public abstract class AbstractDao<K extends Key, E extends AbstractEntity>
{
    protected final DataSource dataSource = DataSourceManager.getInstance().getDataSource();
    protected int id;

    protected AbstractDao()
    {
    }

    public abstract E getByKey(K key);

}