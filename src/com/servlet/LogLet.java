package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.service.Service;

public class LogLet extends HttpServlet {

    private static final long serialVersionUID = 369840050351775312L;

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // 接收客户端信息
        String username = request.getParameter("username");
        username = new String(username.getBytes("ISO-8859-1"), "UTF-8");
        String password = request.getParameter("password");
        System.out.println(username + "--" + password);

        // 新建服务对象
        Service serv = new Service();

        // 验证处理
        boolean loged = serv.login(username, password);
        System.out.println(loged);
        if (loged) {
            System.out.print("Success");
            request.getSession().setAttribute("username", username);
            // response.sendRedirect("welcome.jsp");
            response.setCharacterEncoding("UTF-8");
            response.setContentType("text/html");
            PrintWriter out = response.getWriter();
            out.print(username);
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
        out.print(username);
        out.flush();
        out.close();
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	
    }
    
}
