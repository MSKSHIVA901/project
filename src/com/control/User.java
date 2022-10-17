package com.control;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.Dao.DBConnection;

/**
 * Servlet implementation class User
 */
@WebServlet("/User")
public class User extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public User() {
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
		HttpSession session=request.getSession();
		String uid=request.getParameter("email");
		String pwd=request.getParameter("password");
		String sql="select * from user where email='"+uid+"' and password='"+pwd+"'  ";
		boolean b=DBConnection.getData(sql);
		if(b==true)
		{
			session.setAttribute("email", uid);
			sql = "select name from user where email='"+uid+"'";
			String name=DBConnection.getName(sql);
			session.setAttribute("name", name);
			response.sendRedirect("UserHome.jsp");
		}
		else{
			pw.println("<script type=\"text/javascript\">");
			pw.println("alert('Please enter valid Details');");
			pw.println("window.location='UserLogin.jsp';</script>");
		}
	}
}
