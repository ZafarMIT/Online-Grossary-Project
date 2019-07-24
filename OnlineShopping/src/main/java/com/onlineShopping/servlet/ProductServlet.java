package com.onlineShopping.servlet;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;
import javax.swing.plaf.synth.SynthSpinnerUI;

import com.onlineShopping.daoImpl.ProductDaoImpl;
import com.onlineShopping.pojo.Product;

@MultipartConfig(maxFileSize=2054466566)
public class ProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ProductDaoImpl pd=new ProductDaoImpl();
	Product p=new Product();
	public ProductServlet() {
		super();
		// TODO Auto-generated constructor stub
	}


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();

		String action=request.getParameter("action");

		if(action!=null && action.equals("category")) {
			String cname=request.getParameter("cname");
			session.setAttribute("ctg", cname);
			response.sendRedirect("index.jsp");
		}
		else if(action!=null && action.equals("search")) {
			String pname=request.getParameter("searchP");
			
		
			session.setAttribute("pname", pname);
			response.sendRedirect("searchProduct.jsp");
			
			
		}

	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String pname=request.getParameter("pname");
		//		double price=Double.parseDouble(request.getParameter("price"));
		String pdescriptiom=request.getParameter("pdescriptiom");
		double price=Double.parseDouble(request.getParameter("price"));
		String category=request.getParameter("category");
		p.setPname(pname);p.setCategory(category);
		p.setpDescription(pdescriptiom);
		p.setPrice(price);

		System.out.println("------------------------------------------------------------------------------------------------");

	/*	InputStream is=null;
		Part part=request.getPart("file");
		is=part.getInputStream();
		


		String path="E:/PROJECT/SHRUTI/MY WORKSPACE/FashionBazar/src/main/webapp/resources/images/";
		path=path+String.valueOf(p.getPname())+".jpeg";
		System.out.println(path);
		File imageFile=new File(path);
		if(is!=null)
		{

			try
			{
				ServletOutputStream os=response.getOutputStream();


				byte[] buffer=fileImage.getBytes();   //bytes stored in buffer

				FileOutputStream fos=new FileOutputStream(imageFile);   //Used for writing data to file

				BufferedOutputStream bs=new BufferedOutputStream(fos);

				bs.write(buffer);
				bs.close();



			}catch(Exception e)
			{

				e.printStackTrace();
				System.out.println("Exception Arised:"+e);
			}
			}
*/		 
		System.out.println("------------------------------------------------------------------------------------------------");

		boolean b=pd.addProduct(p);
		if(b) {
			response.sendRedirect("index.jsp");
		}



	}
}