package com.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class KeyGenerate {
public static String generateKey(String key1,String key2,String key3,String sk,String keyword) {

String res="";
	
	try {
		if(!KeyGenerate.CheckKey(key1, key2, key3, sk).equals("keyexists"))
		{
			
		KeyGenerate.Leaf_key(key3, keyword,sk);
		KeyGenerate.Extension_key(key2, key3,sk);
		KeyGenerate.Branch_key(key1, key2,sk);
		res=key1+','+key2+','+key3;
		}else{
			res="keyexists";
			System.out.println("key generation failed"+KeyGenerate.CheckKey(key1, key2, key3, "mykey"));
		}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		res="keyexists";
		e.printStackTrace();
	}
	return res;
}
public static int Leaf_key(String email,String activity,String sk) throws SQLException
{	Connection con=null;
int i=0;	
try{
	 con =DBConnection.connect();
	String sql="insert into leaf values(0,AES_ENCRYPT(?,'"+sk+"'),AES_ENCRYPT(?,'"+sk+"'));";
	PreparedStatement p=con.prepareStatement(sql);

	
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

public static int Branch_key(String email,String activity,String sk) throws SQLException
{	Connection con=null;
int i=0;	
try{
	 con =DBConnection.connect();
	String sql="insert into branch values(0,AES_ENCRYPT(?,'"+sk+"'),AES_ENCRYPT(?,'"+sk+"'));";
	PreparedStatement p=con.prepareStatement(sql);


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

public static int Extension_key(String email,String activity,String sk) throws SQLException
{	
Connection con=null;
int i=0;	
try{
	 con =DBConnection.connect();
	String sql="insert into extension values(0,AES_ENCRYPT(?,'"+sk+"'),AES_ENCRYPT(?,'"+sk+"'));";
	PreparedStatement p=con.prepareStatement(sql);


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

public static String CheckKey(String key1,String key2,String key3,String sk)

{
	 
	    	String key="";
	    	
			Connection con =DBConnection.connect();
			try {
			String sql="SELECT AES_DECRYPT(leafkey,'"+sk+"') FROM leaf WHERE AES_DECRYPT(leafkey,'"+sk+"')='"+key3+"' ;";
			Statement s = con.createStatement();
				ResultSet r=s.executeQuery(sql);
				
			String sql1="SELECT AES_DECRYPT(extensionkey,'"+sk+"') FROM extension WHERE AES_DECRYPT(extensionkey,'"+sk+"')='"+key2+"' ;";
			Statement s1 = con.createStatement();
				ResultSet r1=s1.executeQuery(sql1);
				
				String sql2="SELECT AES_DECRYPT(branchkey,'"+sk+"') FROM branch WHERE AES_DECRYPT(branchkey,'"+sk+"')='"+key1+"' ;";
				Statement s2 = con.createStatement();
					ResultSet r2=s2.executeQuery(sql2);
					if(r2.next()||r.next()||r1.next())
					{
						key="keyexists";
					}else{
						key=key3+key2+key1;
					}
				
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally{
				try {
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			return key;
	
}


public static int genarate_Index(String email,String keyset,String sk,String keyword) throws SQLException
{	
Connection con=null;
int i=0;	
try{
	 con =DBConnection.connect();
	String sql="insert into keyindex values(0,?,?,?,AES_ENCRYPT(?,'mykey'));";
	PreparedStatement p=con.prepareStatement(sql);
	p.setString(1, email);
	p.setString(2, keyset);
	p.setString(3, sk);
	p.setString(4, keyword);
	
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


}
