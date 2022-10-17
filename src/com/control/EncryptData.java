package com.control;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import com.Dao.DBConnection;
import com.Dao.PortNumber;
import com.bean.UploadBean;

/**
 * Servlet implementation class EncryptData
 */
@WebServlet("/EncryptData")
@MultipartConfig(maxFileSize = 16177215)
public class EncryptData extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EncryptData() {
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
		PrintWriter o = response.getWriter();
		HttpSession session = request.getSession(false);
		String email=(String)request.getSession().getAttribute("email");
		String fid = PortNumber.getFid();
		String fname = request.getParameter("filename");
		String keyword1 = request.getParameter("index_key");
		Part img = request.getPart("photo");
		InputStream photo = null, photo1 = null;
		if(img != null){
			photo = img.getInputStream();
			photo1 = img.getInputStream();
		}
		String content = img.getContentType();
		String key = com.Dao.PortNumber.getKeys();
		String text = "";
		int j = 0;
		while((j=photo.read())!=-1) {
			text = text + (char) j;
		}
		String enc = com.Dao.Test.encryption(text, key);
		System.out.println(enc);
		
		UploadBean u = new UploadBean();
		u.setEmail(email);
		u.setFid(fid);
		u.setFilename(fname);
		u.setKeyword1(keyword1);
		u.setPhoto1(photo1);
		u.setEnc(enc);
		u.setContent(content);
		u.setKey(key);
		String sql = "insert into encrypt values(?,?,?,?,?,?,?,?)";
		int i = DBConnection.upload(sql, u);
		if(i > 0){
			o.println("<script type=\"text/javascript\">");
			o.println("alert('File Encrypted...');");
			o.println("window.location='EncryptData.jsp';</script>");
		}else{
			o.println("<script type=\"text/javascript\">");
			o.println("alert('File not Encrypted');");
			o.println("window.location='EncryptData.jsp';</script>");
		}
	}

}
