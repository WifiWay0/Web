package com.db;

import java.sql.ResultSet;
import java.sql.SQLException;

public class HelloWorld {

	public static void main(String[] args) {
    	String username = new String();
    	String password = new String();
    	username = "13777800420";
    	password = "mccdqq";
    	String sql1 = "select "+username+",count(*) as count from usernameandpassword group by "+username+" having count>1;";
    	String logSql1 = "select * from usernameandpassword where username ='" + username
                + "' and password ='" + password + "'";
    	DBManager sql = DBManager.createInstance();
    	sql.connectDB();
//    	try {
//            ResultSet rs = sql.executeQuery(logSql1);
//            if (rs.next()) {
//                System.out.println("true");
//                sql.closeDB();
//            }else {
//                System.out.println("faulse");
//            	sql.closeDB();
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
        // 获取Sql查询语句
        String regSql2 = "insert into usernameandpassword values(null,'"+ username+ "','"+ password+ "') ";
        // 获取DB对象
        sql.connectDB();
        ResultSet rs = sql.executeQuery(sql1);
        try {
        if(rs.next()) {
        	
        	sql.closeDB();
            System.out.println("false1");
        	}
        }catch(SQLException e) {
            e.printStackTrace();
        }
        int ret = sql.executeUpdate(regSql2);
        if (ret != 0) {
            sql.closeDB();
            System.out.println("true");
        }else {
        	sql.closeDB();
            System.out.println("false");
        }
    }
}