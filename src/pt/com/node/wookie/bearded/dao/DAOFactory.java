package pt.com.node.wookie.bearded.dao;

import java.util.HashMap;

/**
 * User: Henrique in Bearded-Wookie
 * Date: 18-10-2013
 * Time: 18:08
 */
public class DAOFactory
{
    public static HashMap<Class<? extends AbstractDao>, AbstractDao> factories = new HashMap<>();

    public static <D extends AbstractDao> D getDAO(Class<D> dao)
    {
        if (!factories.containsKey(dao))
            try
            {
                factories.put(dao, (D) dao.newInstance());
            } catch (Exception e)
            {
                e.printStackTrace();
            }
        return (D) factories.get(dao);
    }


}
