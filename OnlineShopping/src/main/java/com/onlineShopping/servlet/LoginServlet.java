package com.onlineShopping.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.onlineShopping.daoImpl.UserDaoImpl;
import com.onlineShopping.pojo.User;


public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	UserDaoImpl ud=new UserDaoImpl();

	public LoginServlet() {
		super();
		// TODO Auto-generated constructor stub
	}


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session=request.getSession();
		session.invalidate();
		response.sendRedirect("index.jsp");


	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();
		String uname=request.getParameter("uname");
		String pass=request.getParameter("pass");

		if(uname!=null && pass!=null && uname.equals("admin") && pass.equals("pass@123"))  {
			session.setAttribute("adminName", uname);
			response.sendRedirect("index.jsp");

		}
		else {


			User b=ud.userLogin(uname, pass);
			if(b.getEmailId()!=null) {
				if(b!=null && b.getEmailId().equals(uname) && b.getPass().equals(pass)) {
					session.setAttribute("userName", uname);
					response.sendRedirect("index.jsp");
				}
			}

			else {

				request.setAttribute("msglogin", "Invalid UserName and Password ");
				RequestDispatcher rd=request.getRequestDispatcher("login.jsp");
				rd.forward(request, response);
			}

		}


	}

}
