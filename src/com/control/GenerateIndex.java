package com.control;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Dao.DBConnection;
import com.Dao.KeyGenerate;

/**
 * Servlet implementation class GenerateIndex
 */
@WebServlet("/GenerateIndex")
public class GenerateIndex extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GenerateIndex() {
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
		PrintWriter out=response.getWriter();
		String key1=request.getParameter("key1");
		String key2=request.getParameter("key2");
		String key3=request.getParameter("key3");
		String sk=request.getParameter("sk");
		String keyword=request.getParameter("keys");
		
		String result=KeyGenerate.generateKey(key1, key2, key3, sk, keyword);
		String email=(String)request.getSession().getAttribute("email");
		if(result.equals("keyexists"))
		{
			out.println("<script type=\"text/javascript\">");
			out.println("alert('The Key Already Exists!');");
			out.println("window.location='GenratingIndex.jsp'</script>");
		}else{
			try {
			//	DBConnection.addActivity(email, "New Key Index Genarated successfully!", new Date().toLocaleString());
				
				KeyGenerate.genarate_Index(email, result, sk, keyword);
				out.println("<script type=\"text/javascript\">");
				out.println("alert('Key Index Genarated successfully!');");
				out.println("window.location='GenratingIndex.jsp'</script>");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				out.println("<script type=\"text/javascript\">");
				out.println("alert('The Key Already Exists!');");
				out.println("window.location='GenratingIndex.jsp'</script>");
			}
		
		}
		
	}

}
