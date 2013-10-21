package pt.com.node.wookie.bearded.dao;

import org.springframework.jdbc.core.JdbcTemplate;
import pt.com.node.wookie.bearded.core.DataSourceManager;
import pt.com.node.wookie.bearded.core.keys.Key;
import pt.com.node.wookie.bearded.entities.AbstractEntity;

import javax.sql.DataSource;
import java.util.List;

public abstract class AbstractDao<K extends Key, E extends AbstractEntity>
{
    protected final DataSource dataSource = DataSourceManager.getInstance().getDataSource();
    protected JdbcTemplate jdbc;
    protected K key;

    protected AbstractDao()
    {
        jdbc = new JdbcTemplate(dataSource);
    }

    public K getKey()
    {
        return key;
    }

    public abstract List<E> selectAll();

    public abstract E update(E entity);

    public abstract boolean remove(E entity);

    public abstract E create(E entity);

    public abstract E getByKey(K key);

}