package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
 
import com.service.Service;
 
public class RegLet extends HttpServlet{
 
	private static final long serialVersionUID = 1L;
 
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO �Զ����ɵķ������
	}
 
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO �Զ����ɵķ������
		//���ܿͻ�����Ϣ
				String username = request.getParameter("username");
				username = new String(username.getBytes("ISO-8859-1"),"UTF-8");
				String password = request.getParameter("password");
				System.out.println(username + ":" + password);
				
				//�½��������
				Service service = new Service();
					
				//��֤����
				boolean reg = service.register(username, password);
				if( reg ){
					System.out.println("reg success");
					//request.getSession().setAttribute("username", username);
				}else{
					System.out.println("reg fail\n");
				}
					
				//������Ϣ���ͻ���
				response.setCharacterEncoding("UTF-8");
				response.setContentType("text/html");
				PrintWriter out = response.getWriter();
				if(reg){
					out.print("true");
				}else{
					out.print("false");
				}
				out.flush();
				out.close();
	}
 
}