package com.onlineShopping.servlet;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.onlineShopping.daoImpl.CartDaoImpl;
import com.onlineShopping.daoImpl.OrderDaoImpl;
import com.onlineShopping.pojo.Cart;
import com.onlineShopping.pojo.Order;


public class CartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Order o=new Order();
	OrderDaoImpl od=new OrderDaoImpl();
	CartDaoImpl cd=new CartDaoImpl();
	public CartServlet() {
		super();
		// TODO Auto-generated constructor stub
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session=request.getSession();
		String userName=(String)session.getAttribute("userName");
		String action=request.getParameter("action");
		System.out.println(action);
		if(action!=null &&action.equals("addToCart")) {
			int pid=Integer.parseInt(request.getParameter("pid"));

			System.out.println(userName);
			boolean b=cd.addToCart(pid, userName);	
			if(b) {
				response.sendRedirect("index.jsp");
			}
		}

		else if(action!=null &&action.equals("delete")) {
			int cid=Integer.parseInt(request.getParameter("cid"));
			boolean b=cd.deleteCart(cid);
			if(b) {
				response.sendRedirect("CartServlet");
			}
		}else if(action!=null && action.equals("billPage")) {
			
			Double totalBill=(Double)session.getAttribute("totalBill");
			double d=totalBill;
			String status="Processing";
			String orderDate=new Date().toString();
			o.setOrderDate(orderDate);o.setStatus(status);
			o.setTotalBill(totalBill);o.setUserName(userName);
			boolean b=od.addOrder(o);
			if(b)
			response.sendRedirect("billPage.jsp");
		}
		else if(action!=null && action.equals("olist")) {
			List<Order> olist=od.getAllOrder();
			session.setAttribute("olist", olist);
			response.sendRedirect("orderList.jsp");
		}
		else {

			List<Cart> cl=cd.getCartList(userName);
			session.setAttribute("cartList", cl);
			response.sendRedirect("cartList.jsp");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session=request.getSession();
		String action=request.getParameter("action");
		System.out.println(action);

		if(action!=null && action.equals("cartList")) {
			String price[]=request.getParameterValues("price");
			String qty[]=request.getParameterValues("qty");
			String pname[]=request.getParameterValues("pname");
			double totalBill=0;
			for(int i=0;i<price.length;i++) {
				totalBill=totalBill+(Integer.parseInt(qty[i])*Double.parseDouble(price[i]));
			}
			Double d=totalBill;
			session.setAttribute("price", price);
			session.setAttribute("qty",qty);
			session.setAttribute("totalBill",d);
			session.setAttribute("pname",pname);
			response.sendRedirect("payment.jsp");
		}
	}

}
