package com.db;

import java.sql.*;

public class APPDBManager {
    
    // 数据库连接常量
    public static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    public static final String USER = "root";
    public static final String PASS = "zhiyu";
    public static final String URL = "jdbc:mysql://39.108.0.16:3306/wifiway?Unicode=true&characterEncoding=UTF-8&useSSL=false&serverTimezone=UTC";
 
    // 静态成员，支持单态模式
    private static APPDBManager per = null;
    private Connection conn = null;
    private Statement stmt = null;

    // 单态模式-懒汉模式
    private APPDBManager() {
    }
 
    public static APPDBManager createInstance() {
        if (per == null) {
            per = new APPDBManager();
            per.initDB();
        }
        return per;
    }
 
    // 加载驱动
    public void initDB() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
 
    // 连接数据库，获取句柄+对象
    public void connectDB() {
        System.out.println("Connecting to database...");
        try {
            conn = DriverManager.getConnection(URL, USER, PASS);
            stmt = conn.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
        System.out.println("SqlManager:Connect to database successful.");
        }
    }
 
    // 关闭数据库 关闭对象，释放句柄
    public void closeDB() {
        System.out.println("Close connection to database..");
        try {
            stmt.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
        System.out.println("Close connection successful");
        }
    }
 
    // 查询
    public ResultSet executeQuery(String logSql) {
        ResultSet rs = null;
        try {
            rs = stmt.executeQuery(logSql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rs;
    }
 
    // 增添/删除/修改
    public boolean execute(String sql) {
        boolean ret = false;
        try {
            ret = stmt.execute(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ret;
    }
}