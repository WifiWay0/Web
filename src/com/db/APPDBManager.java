package com.db;

import java.sql.*;

public class APPDBManager {
    
    // ���ݿ����ӳ���
    public static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    public static final String USER = "root";
    public static final String PASS = "zhiyu";
    public static final String URL = "jdbc:mysql://39.108.0.16:3306/wifiway?Unicode=true&characterEncoding=UTF-8&useSSL=false&serverTimezone=UTC";
 
    // ��̬��Ա��֧�ֵ�̬ģʽ
    private static APPDBManager per = null;
    private Connection conn = null;
    private Statement stmt = null;

    // ��̬ģʽ-����ģʽ
    private APPDBManager() {
    }
 
    public static APPDBManager createInstance() {
        if (per == null) {
            per = new APPDBManager();
            per.initDB();
        }
        return per;
    }
 
    // ��������
    public void initDB() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
 
    // �������ݿ⣬��ȡ���+����
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
 
    // �ر����ݿ� �رն����ͷž��
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
 
    // ��ѯ
    public ResultSet executeQuery(String logSql) {
        ResultSet rs = null;
        try {
            rs = stmt.executeQuery(logSql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rs;
    }
 
    // ����/ɾ��/�޸�
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