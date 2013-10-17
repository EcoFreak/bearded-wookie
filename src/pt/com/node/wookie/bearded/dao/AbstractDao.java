package pt.com.node.wookie.bearded.dao;

import pt.com.node.wookie.bearded.core.DataSourceManager;

import javax.sql.DataSource;

/**
 * User: Henrique in Bearded-Wookie
 * Date: 15-10-2013
 * Time: 22:24
 */
public abstract class AbstractDao
{
    public static DataSource dataSource = DataSourceManager.getInstance().getDataSource();
    protected int id;

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AbstractDao that = (AbstractDao) o;

        return id == that.id;
    }
}
