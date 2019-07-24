package com.onlineShopping.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.onlineShopping.daoImpl.UserDaoImpl;
import com.onlineShopping.pojo.User;

/**
 * Servlet implementation class UserServlet
 */
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	UserDaoImpl ud=new UserDaoImpl();
	User u=new User();

	public UserServlet() {
		super();
		// TODO Auto-generated constructor stub
	}


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action=request.getParameter("action");
		HttpSession session=request.getSession();
		String userName=(String )session.getAttribute("userName");

		if(action!=null && action.equals("editProfile")) {
			User u=ud.getUserByName(userName);
			session.setAttribute("u", u);
			response.sendRedirect("updateUser.jsp");
		}

		else {
			
			List<User> ulist=ud.getAllUser();
			session.setAttribute("ulist", ulist);
			response.sendRedirect("userList.jsp");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action=request.getParameter("action");
		String fname=request.getParameter("fname");
		String lname=request.getParameter("lname");
		String contact=request.getParameter("contact");
		String address=request.getParameter("address");
		String emailId=request.getParameter("emailId");
		String pass=request.getParameter("pass");
		String cpass=request.getParameter("cpass");
		u.setFname(fname);u.setLname(lname);
		u.setContact(contact);u.setEmailId(emailId);
		u.setAddress(address);
		
		if(action!=null && action.equals("addUser")) {
			if(pass!=null && cpass!=null && pass.equals(cpass)) {

				u.setPass(cpass);

				boolean b=ud.addUser(u);
				if(b) {
					response.sendRedirect("login.jsp");
				}
				else {
					response.sendRedirect("error.jsp");
				}


			}

			else {
				request.setAttribute("cpass", "Password and Confirmd Password is Not Match");
				RequestDispatcher rd=request.getRequestDispatcher("adduser.jsp");
				rd.forward(request, response);
			}

		}else if(action!=null && action.equals("updateUser")) {
			int userId=Integer.parseInt(request.getParameter("userId"));
			u.setUserId(userId);
			boolean b=ud.updateUser(u);
			if(b) {
				response.sendRedirect("index.jsp");
			}
		}

	}

}
