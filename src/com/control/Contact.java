package com.control;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Dao.DBConnection;
import com.bean.UserBean;

/**
 * Servlet implementation class Contact
 */
@WebServlet("/Contact")
public class Contact extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Contact() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter pw=response.getWriter();
		String name=request.getParameter("name");
		String email=request.getParameter("email");
		String comment=request.getParameter("combment");
		UserBean ub=new UserBean();
		ub.setName(name);
		ub.setEmail(email);
		ub.setComment(comment);
		String sql="insert into contact values(?,?,?)";
		int i=DBConnection.setContact(sql,ub);
		if(i > 0){
			pw.println("<script type=\"text/javascript\">");
			pw.println("alert('Data User Register Successfully...');");
			pw.println("window.location='UserReg.jsp';</script>");
		}else{
			pw.println("<script type=\"text/javascript\">");
			pw.println("alert('Please enter valid Details/Already Exist');");
			pw.println("window.location='UserReg.jsp';</script>");
		}
	}

}
