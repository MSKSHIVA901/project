package com.control;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.Dao.DBConnection;

/**
 * Servlet implementation class UserReq
 */
@WebServlet("/UserReq")
public class UserReq extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserReq() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter o = response.getWriter();
		String fid = request.getParameter("fid");
		String da = request.getParameter("da");
		String sql = "update keyreq set status1='Approved' where fid='"+fid+"' and Date1='"+da+"'";
		int i = DBConnection.update(sql);
		if(i > 0){
			o.println("<script type=\"text/javascript\">");
			o.println("alert('Search Keys Request Approved Successfully...');");
			o.println("window.location='Request.jsp';</script>");
		}else{
			o.println("<script type=\"text/javascript\">");
			o.println("alert('Search Keys Request Not Approved');");
			o.println("window.location='Request.jspjsp';</script>");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
