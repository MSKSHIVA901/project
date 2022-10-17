package com.Dao;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.bean.KeyReqBean;
import com.bean.UploadBean;
import com.bean.UserBean;

public class DBConnection {
public static Connection connect()
{
	Connection con=null;
	try {
		Class.forName("com.mysql.jdbc.Driver");
		con=DriverManager.getConnection("jdbc:mysql://localhost:3306/vtjcc10-2020","root","root");
		return con;
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		return con;
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return con;
}

public static boolean getData(String sql) {
	// TODO Auto-generated method stub
	boolean b = false;
	Connection con = connect();
	try {
		PreparedStatement ps = con.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		b = rs.next();
		rs.close();
		ps.close();
		con.close();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return b;
}

public static String getName(String sql) {
	// TODO Auto-generated method stub
	String name ="";
	Connection con = connect();
	try {
		PreparedStatement ps = con.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		if(rs.next()){
			name = rs.getString(1);
		}
		rs.close();
		ps.close();
		con.close();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return name;

}

public static int setUser(String sql, UserBean ub) {
	// TODO Auto-generated method stub
	int i=0;
	Connection con=connect();
	try {
		PreparedStatement ps=con.prepareStatement(sql);
		ps.setString(1, ub.getName());
		ps.setString(2, ub.getEmail());
		ps.setString(3, ub.getAge());
		ps.setString(4, ub.getGender());
		ps.setString(5, ub.getPassword());
		ps.setString(6, ub.getMobile());
		i=ps.executeUpdate();
		ps.close();
		con.close();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return i;
}
public static ResultSet getUser() throws SQLException  
{
	Connection con=DBConnection.connect();
	String sql="select * from user";
	Statement st=con.createStatement();
	ResultSet rs=st.executeQuery(sql);
	return rs;
}
public static int setContact(String sql, UserBean ub) {
	// TODO Auto-generated method stub
	int i=0;
	Connection con=connect();
	try {
		PreparedStatement ps=con.prepareStatement(sql);
		ps.setString(1, ub.getName());
		ps.setString(2, ub.getEmail());
		ps.setString(3, ub.getComment());
		i=ps.executeUpdate();
		ps.close();
		con.close();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return i;
}
public static int upload(String sql, UploadBean u) 
{
	// TODO Auto-generated method stub
		int i = 0;
		Connection con = connect();
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, u.getEmail());
			ps.setString(2, u.getFid());
			ps.setString(3, u.getFilename());
			ps.setString(4, u.getKeyword1());
			InputStream photo = u.getPhoto();
			if (photo != null) {
				ps.setBinaryStream(5, photo);
			}
			ps.setString(6, u.getEnc());
			ps.setString(7, u.getContent());
			ps.setString(8, u.getKey());
			i = ps.executeUpdate();
			ps.close();
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return i;
	}
public static List<String> getUFile(String sql) {
	// TODO Auto-generated method stub
	List<String> lt = new ArrayList<String>();
	Connection con = connect();
	try {
		PreparedStatement ps = con.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		while(rs.next()){
			lt.add(rs.getString(1));
			lt.add(rs.getString(2));
			lt.add(rs.getString(3));
			lt.add(rs.getString(4));
		}
		rs.close();
		ps.close();
		con.close();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return lt;
}

public static ResultSet getKeys() throws SQLException
{
	Connection con =DBConnection.connect();
	String sql="select *, AES_DECRYPT(keyword,'mykey') as mykey from keyindex ";
	Statement s=con.createStatement();
	ResultSet r=s.executeQuery(sql);
	return r;
}
public static int sendRKeys(String sql, KeyReqBean kb) {
	// TODO Auto-generated method stub
	int i = 0;
	Connection con = connect();
	try {
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, kb.getFid());
		ps.setString(2, kb.getOwn());
		ps.setString(3, kb.getEmail());
		ps.setString(4, "pending");
		ps.setString(5, kb.getDa());
		i = ps.executeUpdate();
		ps.close();
		con.close();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return i;
}
public static ResultSet getUserRequest(String oid) throws SQLException
{
	Connection con =DBConnection.connect();
	String sql="select * from keyreq where status1='pending' and owner='"+oid+"' ";
	Statement s=con.createStatement();
	ResultSet r=s.executeQuery(sql);
	return r;
}
public static ResultSet getUFile1(String sql) throws SQLException
{
	Connection con =DBConnection.connect();
//	String sql="select * from keyreq where status1='pending' and owner='"+oid+"' ";
	Statement s=con.createStatement();
	ResultSet r=s.executeQuery(sql);
	return r;
}
public static int update(String sql) {
	// TODO Auto-generated method stub
	int i = 0;
	Connection con = connect();
	try {
		PreparedStatement ps = con.prepareStatement(sql);
		i = ps.executeUpdate();
		ps.close();
		con.close();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return i;
}
public static ResultSet getData1(String sql) {
	// TODO Auto-generated method stub
		Connection con = connect();
		ResultSet rs = null;
		try{
			PreparedStatement ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
		}catch(SQLException e){
			e.printStackTrace();
		}
		return rs;
	}
public static ResultSet getUserResponse(String uid1) throws SQLException
{
	Connection con =DBConnection.connect();
	String sql="select * from keyreq where status1='Approved' and userid='"+uid1+"' ";
	Statement s=con.createStatement();
	ResultSet r=s.executeQuery(sql);
	return r;
}
public static String getFid(String sql) {
	// TODO Auto-generated method stub
	String fid ="";
	Connection con = connect();
	try {
		PreparedStatement ps = con.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		if(rs.next()){
			fid = rs.getString(1);
		}
		rs.close();
		ps.close();
		con.close();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return fid;

}
public static ResultSet getFile() throws SQLException
{
	Connection con =DBConnection.connect();
	String sql="select * from encrypt ";
	Statement s=con.createStatement();
	ResultSet r=s.executeQuery(sql);
	return r;
}
public static ResultSet getFile1(String uid1) throws SQLException
{
	Connection con =DBConnection.connect();
	String sql="select * from encrypt where email='"+uid1+"'";
	Statement s=con.createStatement();
	ResultSet r=s.executeQuery(sql);
	return r;
}
public static int addActivity(String email,String activity,String time) throws SQLException
{	Connection con=null;
int i=0;	
try{
	 con =DBConnection.connect();
	String sql="insert into activity values(0,?,?,?);";
	PreparedStatement p=con.prepareStatement(sql);

	p.setString(3, time);
	p.setString(1, email);
	p.setString(2, activity);
	
	i=p.executeUpdate();
	}catch (SQLException e) {
		// TODO: handle exception
		e.printStackTrace();
	}finally{
		try {
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	return i;
}
public static ResultSet getUserIndexes() throws SQLException  
{
	Connection con=DBConnection.connect();
	String sql="select * from keyindex";
	Statement st=con.createStatement();
	ResultSet rs=st.executeQuery(sql);
	return rs;
}
public static ResultSet getUserSearchRequests() throws SQLException  
{
	Connection con=DBConnection.connect();
	String sql="select * from keyreq";
	Statement st=con.createStatement();
	ResultSet rs=st.executeQuery(sql);
	return rs;
}
}
