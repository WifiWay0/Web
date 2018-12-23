package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.service.Service;

public class AppLet extends HttpServlet {

    private static final long serialVersionUID = 369840050351775312L;

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    	request.setCharacterEncoding("UTF-8");
        // 接收客户端信息
        String user = request.getParameter("user");
        //user = new String(user.getBytes("ISO-8859-1"), "UTF-8");
        String time = request.getParameter("time");
        //time = new String(time.getBytes("ISO-8859-1"), "UTF-8");
        String location = request.getParameter("location");
        //location = new String(location.getBytes("ISO-8859-1"), "UTF-8");
        String appmessage = request.getParameter("appmessage");
        System.out.println(user + "--" + time +"--"+location+"--" + appmessage);

        // 新建服务对象
        Service serv = new Service();
       
        // 验证处理
        boolean flag = serv.appmessageget(user,time,location,appmessage);
        System.out.println(flag);
        if (flag) {
            System.out.print("Success\n");
            request.getSession().setAttribute("appmessage", appmessage);
            // response.sendRedirect("welcome.jsp");
            response.setCharacterEncoding("UTF-8");
            response.setContentType("text/html");
            PrintWriter out = response.getWriter();
            out.print("flag" + flag);
            out.flush();
            out.close();
        } else {
            System.out.print("Failed");
            response.setCharacterEncoding("UTF-8");
            response.setContentType("text/html");
            PrintWriter out = response.getWriter();
            out.print("false");
            out.flush();
            out.close();
        }

        // 返回信息到客户端
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.print("flag" + flag);
        out.flush();
        out.close();
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	
    }
    
}
