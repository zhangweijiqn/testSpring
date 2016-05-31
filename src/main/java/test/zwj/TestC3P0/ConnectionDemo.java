package test.zwj.TestC3P0;
/**
 * Created by zhangweijian on 2015/11/6.
 */

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class ConnectionDemo {
    final static int N=200;
    public static void main(String[] args) throws SQLException {
        List<Long> Count1 = new ArrayList();
        List<Long> Count2 = new ArrayList();
        System.out.println("使用连接池................................");
        for (int i = 0; i < N; i++) {
            long beginTime = System.currentTimeMillis();
//            Connection conn = ConnectionManager.getInstance().getConnection();
            //        通过ApplicationContext来获取Spring配置文件
            Connection conn = ConnectionManager.getInstance().getConnection();
//        通过Bean的id来获取bean
            try {
                PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM dmp_sql_task limit 100");
                ResultSet rs = pstmt.executeQuery();
                while (rs.next()) {

                }
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

            long endTime = System.currentTimeMillis();
//            System.out.println("第" + (i + 1) + "次执行花费时间为:" + (endTime - beginTime));
            Count1.add(endTime - beginTime);
        }

        System.out.println("不使用连接池................................");
        for (int i = 0; i < N; i++) {
            long beginTime = System.currentTimeMillis();
            Connection conn=null;
            Statement stmt=null;
            String url = "jdbc:mysql://192.168.149.86:3306/dmpcloud?characterEncoding=utf-8&amp;connectTimeout=1000&amp;autoReconnect=true";
            String name="root";
            String password="root";
            ConnectionManager.getConnectionNum();
            try{
//        获取数据库连接
                Class.forName("com.mysql.jdbc.Driver" );
                conn = DriverManager.getConnection(url, name, password);
//        开始启动事物
                conn.setAutoCommit(false);
                stmt = conn.createStatement();
//        执行相应操作
                ResultSet rs = stmt.executeQuery("SELECT * FROM dmp_sql_task limit 100");
                while (rs.next()) {
                    // do nothing...
                }
//        执行成功提交任务
                conn.commit();
            }catch(SQLException e){
                if(conn !=null){
                    try{
                        //执行不成功，则回滚
                        conn.rollback();
                    }catch (SQLException ex)
                    {
                        System.out.println("数据库连接有异常!"+ex);
                    }
                }
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } finally{
                if(stmt!=null){
                    try{
                        stmt.close();
                    }catch (SQLException e){
                        System.out.println("执行操作有异常"+e);
                    }
                }
                if(conn!=null){
                    try{
                        conn.close();
                    }catch (SQLException e){
                        System.out.println("数据库连接有异常!"+e);
                    }
                }
            }
            long endTime = System.currentTimeMillis();
//            System.out.println("第" + (i + 1) + "次执行花费时间为:   + (endTime - beginTime));
            Count2.add(endTime - beginTime);
        }
        int total1 = 0;
        int total2 = 0;
        for(int i=0;i<N;++i){
            System.out.println("第" + (i + 1) + "次执行花费时间为:"
                    + Count1.get(i)+" vs " +Count2.get(i));
            total1+=Count1.get(i);
            total2+=Count2.get(i);
        }
        total1/=N;
        total2/=N;
        System.out.println("average:"+total1+" vs "+total2);//average:38 vs 176
        System.out.println();

    }
}
