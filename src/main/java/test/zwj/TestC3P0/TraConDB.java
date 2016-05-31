package test.zwj.TestC3P0;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by zhangweijian on 2015/10/23.
 * 传统连接数据库
 */
public class TraConDB {
    public static void main(String args[]){
        Connection conn=null;
        Statement stmt=null;
        String url = "jdbc:mysql://192.168.149.86:3306/dmpcloud?characterEncoding=utf-8&amp;connectTimeout=1000&amp;autoReconnect=true";
        String name="root";
        String password="root";
        try{
//        获取数据库连接
            Class.forName("com.mysql.jdbc.Driver" );
            conn = DriverManager.getConnection(url,name,password);
//        开始启动事物
            conn.setAutoCommit(false);
            stmt = conn.createStatement();
//        执行相应操作
            stmt.execute("show databases;");
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
    }
   }
