/*package com.foodplaza_20325.servlet;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import com.onlinefoodplaza.dao.FoodDaoImplemetation;
import com.onlinefoodplaza.dao.OrderDaoImplementation;
import com.onlinefoodplaza_20325.pojo.Food;
import com.onlinefoodplaza_20325.pojo.Order;

*//**
 * Servlet implementation class FoodServlet
 *//*
@MultipartConfig(maxFileSize=2054466566)
@WebServlet("/FoodServlet")
public class FoodServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       Food f=new Food();
       List<Food> flist;
       List<Order> orderlist;
       FoodDaoImplemetation fdao = new FoodDaoImplemetation();
       OrderDaoImplementation odao=new OrderDaoImplementation();
    *//**
     * @see HttpServlet#HttpServlet()
     *//*
    public FoodServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	*//**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 *//*
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession s1=request.getSession();
		String operation=request.getParameter("action");
		if(operation!=null && operation.equals("Edit"))
		{
			int d=Integer.parseInt(request.getParameter("FoodId"));
			f=fdao.getFoodById(d);
			s1.setAttribute("FoodUpdate", f);
			response.sendRedirect("FoodUpdate.jsp");
		}
		else if(operation!=null && operation.equals("Delete"))
		{
			int d=Integer.parseInt(request.getParameter("FoodId"));
			boolean flag=fdao.deleteFood(d);
			if(flag==true)
			{
				response.sendRedirect("FoodServlet");
			}
			else
			{
				response.sendRedirect("Error.jsp");
			}
			
		}
		else if(operation!=null && operation.equals("foodListByCategory"))
		{
			String category=request.getParameter("category");
			s1.setAttribute("category", category);
			flist=fdao.getFoodByCategory(category);
			int page = 1;
	        int recordsPerPage = 8;
	        if(request.getParameter("page") != null)
	            page = Integer.parseInt(request.getParameter("page"));
	        
	        List<Food> list = fdao.getFoodByCategory(category,(page-1)*recordsPerPage,
	                                 recordsPerPage);
	        int noOfRecords = fdao.getNoOfRecords();
	        System.out.println(noOfRecords);
	        int noOfPages = (int) Math.ceil(noOfRecords * 1.0 / recordsPerPage);
	        System.out.println(noOfPages);
	        
	        request.setAttribute("FoodList", list);
	        request.setAttribute("noOfPages", noOfPages);
	        request.setAttribute("currentPage", page);
	        request.setAttribute("foodCategory", "Food");
	        RequestDispatcher view = request.getRequestDispatcher("FoodList.jsp");
	        view.forward(request, response);
			s1.setAttribute("FoodList",flist);
			response.sendRedirect("FoodList.jsp");
		}
		else if(operation!=null && operation.equals("pages"))
		{
			String s3=request.getParameter("FirstNo");
			String s4=request.getParameter("LastNo");
			System.out.print(s3);
			s1.setAttribute("FirstNo", s3);
			s1.setAttribute("LastNo", s4);
			response.sendRedirect("FoodList.jsp");
		}
		else if(operation!=null && operation.equals("ShowAllOrder"))
		{
			orderlist=odao.showAllOrder();
			s1.setAttribute("OrderList", orderlist);
			 RequestDispatcher view = request.getRequestDispatcher("ShowOrder.jsp");
		        view.forward(request, response);
		}
		else if(operation!=null && operation.equals("DeleteOrder"))
		{
			int orderId=Integer.parseInt(request.getParameter("OrderId"));
			boolean flag=odao.deleteOrder(orderId);
			if(flag==true)
			{	
				request.setAttribute("Operation","Order Deleted Successful");
				RequestDispatcher rd=request.getRequestDispatcher("/index.jsp");
				rd.forward(request, response);
			}
			else
			{
				request.setAttribute("Failed","failed");
				RequestDispatcher rd=request.getRequestDispatcher("/index.jsp");
				rd.forward(request, response);
				
			}
		}
		else
		{
			int page = 1;
	        int recordsPerPage = 8;
	        if(request.getParameter("page") != null)
	            page = Integer.parseInt(request.getParameter("page"));
	        
	        List<Food> list = fdao.viewAllfood((page-1)*recordsPerPage,
	                                 recordsPerPage);
	        int noOfRecords = fdao.getNoOfRecords();
	        
	        int noOfPages = (int) Math.ceil(noOfRecords * 1.0 / recordsPerPage);
	        
	        request.setAttribute("FoodList", list);
	        request.setAttribute("noOfPages", noOfPages);
	        request.setAttribute("currentPage", page);
	        RequestDispatcher view = request.getRequestDispatcher("FoodList.jsp");
	        view.forward(request, response);
			
			
			 flist=fdao.getAllFood();
			
			s1.setAttribute("FoodList",flist);
			response.sendRedirect("FoodList.jsp");
			
		}
	}

	*//**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 *//*
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();
		String operation=request.getParameter("action");
		
		RequestDispatcher rd;
		boolean flag;
		if(operation!=null && operation.equals("AddFood"))
		{
			String s1=request.getParameter("foodname");
			double fprice=Double.parseDouble(request.getParameter("foodprice"));
			String s2=request.getParameter("foodcategory");
			f.setFoodName(s1);
			f.setFoodPrice(fprice);
			f.setFoodCategory(s2);
			InputStream is=null;
			Part p=request.getPart("foodImage");
			is=p.getInputStream();
			if(is!=null)
			{
				f.setFoodImage(is);
			}
			System.out.println(f);
		flag=fdao.addFood(f);
		if(flag==true)
		{	
			request.setAttribute("Operation","Food added successfully");
			rd=request.getRequestDispatcher("/index.jsp");
			rd.forward(request, response);
		}
		else
		{
			request.setAttribute("Failed","failed");
			rd=request.getRequestDispatcher("/index.jsp");
			rd.forward(request, response);
			
		}
		}
		else if(operation!=null && operation.equals("UpdateFood"))
		{
			String s1=request.getParameter("foodname");
			double fprice=Double.parseDouble(request.getParameter("foodprice"));
			String s2=request.getParameter("foodcategory");
			int id=Integer.parseInt(request.getParameter("foodid"));
			f.setFoodName(s1);
			f.setFoodPrice(fprice);
			f.setFoodCategory(s2);
			f.setFoodId(id);
			InputStream is=null;
			Part p=request.getPart("foodImage");
			is=p.getInputStream();
			if(is!=null)
			{
				f.setFoodImage(is);
			}
			flag=fdao.updateFood(f);
			System.out.println(flag);
			if(flag==true)
			{
				response.sendRedirect("FoodServlet");
			}
			else
			{
				request.setAttribute("Failed","failed");
				rd=request.getRequestDispatcher("/index.jsp");
				rd.forward(request, response);
			}
			
		}
		else if(operation!=null && operation.equals("foodSearch"))
		{
			String foodName=request.getParameter("foodsearch");
			session.setAttribute("search", foodName);
			int page = 1;
	        int recordsPerPage = 8;
	        if(request.getParameter("page") != null)
	            page = Integer.parseInt(request.getParameter("page"));
	        
	        List<Food> list = fdao.getFoodByName(foodName,(page-1)*recordsPerPage,
	                                 recordsPerPage);
	        int noOfRecords = fdao.getNoOfRecords();
	        System.out.println(noOfRecords);
	        int noOfPages = (int) Math.ceil(noOfRecords * 1.0 / recordsPerPage);
	        request.setAttribute("foodSerach", "Food");
	        request.setAttribute("FoodList", list);
	        request.setAttribute("noOfPages", noOfPages);
	        request.setAttribute("currentPage", page);
	        RequestDispatcher view = request.getRequestDispatcher("FoodList.jsp");
	        view.forward(request, response);
		}
		else
		{
			request.setAttribute("Failed","failed");
			rd=request.getRequestDispatcher("/index.jsp");
			rd.forward(request, response);
		}
	}

}
*/