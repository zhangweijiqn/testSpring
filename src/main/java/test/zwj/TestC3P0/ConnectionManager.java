package test.zwj.TestC3P0;

/**
 * Created by zhangweijian on 2015/11/6.
 *
 * 需要添加maven配置
 <dependency>
 <groupId>c3p0</groupId>
 <artifactId>c3p0</artifactId>
 <version>0.9.1.2</version>
 </dependency>
 *
 */

import com.mchange.v2.c3p0.ComboPooledDataSource;

import java.beans.PropertyVetoException;
import java.sql.Connection;
import java.sql.SQLException;

public final class ConnectionManager {

    private static ConnectionManager instance;
    private static ComboPooledDataSource dataSource;

    private ConnectionManager() throws SQLException, PropertyVetoException {
        dataSource = new ComboPooledDataSource();

        dataSource.setUser("root");
        dataSource.setPassword("root");
        dataSource.setJdbcUrl("jdbc:mysql://192.168.149.86:3306/dmpcloud?characterEncoding=utf-8&amp;connectTimeout=1000&amp;autoReconnect=true");
        dataSource.setDriverClass("com.mysql.jdbc.Driver");
        dataSource.setInitialPoolSize(5);
        dataSource.setMinPoolSize(1);
        dataSource.setMaxPoolSize(10);
        dataSource.setMaxStatements(50);
        dataSource.setMaxIdleTime(60);
        System.out.println(dataSource.getNumConnections());
    }

    public static final ConnectionManager getInstance() {
        if (instance == null) {
            try {
                instance = new ConnectionManager();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return instance;
    }

    public synchronized final Connection getConnection() {
        Connection conn = null;
        try {
            conn = dataSource.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }
    public static void getConnectionNum()
    {
        try {
            System.out.println(dataSource.getNumConnections());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
