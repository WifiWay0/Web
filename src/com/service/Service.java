package com.service;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.db.APPDBManager;
import com.db.DBManager;

public class Service {

    public Boolean login(String username, String password) {

        String logSql = "select * from usernameandpassword where username ='" + username
                + "' and password ='" + password + "'";

        DBManager sql = DBManager.createInstance();
        sql.connectDB();

        try {
            ResultSet rs = sql.executeQuery(logSql);
            	if(rs.next()) {
                sql.closeDB();
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        sql.closeDB();
        return false;
    }

    public Boolean register(String username, String password) {

        String regSql = "insert into usernameandpassword values(null,'"+ username+ "','"+ password+ "') ";


        DBManager sql = DBManager.createInstance();
        sql.connectDB();
        int ret = sql.executeUpdate(regSql);
        if (ret != 0) {
            sql.closeDB();
            return true;
        }
        sql.closeDB();
        return false;
        }
    public Boolean appmessageget(String user,String time,String location,String appmessage) {


        String Sql = "insert into appmessage values(null,'"+user+"','"+time+"','"+location+"','" + appmessage+ "')";


        APPDBManager sql = APPDBManager.createInstance();
        sql.connectDB();
        boolean ret = sql.execute(Sql);
        if (ret == false) {
            sql.closeDB();
            return true;
        }
        sql.closeDB();
        return false;
        }
    }
