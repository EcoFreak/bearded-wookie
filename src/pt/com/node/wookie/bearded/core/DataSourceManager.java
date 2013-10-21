package pt.com.node.wookie.bearded.core;

import org.springframework.jdbc.datasource.DriverManagerDataSource;

/**
 * User: Henrique in Bearded-Wookie
 * Date: 16-10-2013
 * Time: 17:38
 */
public class DataSourceManager
{
    public static String salt = "€@2312w00k1e";
    private static DataSourceManager instance = null;
    private DriverManagerDataSource dataSource;

    private DataSourceManager()
    {
        dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://smmorpgfps.no-ip.biz/smmorpgfps");
        dataSource.setUsername("smmorpgfps");
        dataSource.setPassword("wookie");
    }

    public static DataSourceManager getInstance()
    {
        if (instance == null)
            instance = new DataSourceManager();
        return instance;
    }

    public static String getMD5HashWithSalt(String password)
    {
        return org.springframework.util.DigestUtils.md5DigestAsHex((password + DataSourceManager.salt).getBytes());
    }

    public DriverManagerDataSource getDataSource()
    {
        return dataSource;
    }

}
