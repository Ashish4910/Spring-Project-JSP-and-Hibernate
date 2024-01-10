///*
// * package com.coder.community;
// * 
// * import java.io.IOException; import java.io.PrintWriter; import
// * java.sql.Connection; import java.sql.DriverManager;
// * 
// * import javax.servlet.ServletException; import
// * javax.servlet.annotation.WebServlet; import javax.servlet.http.HttpServlet;
// * import javax.servlet.http.HttpServletRequest; import
// * javax.servlet.http.HttpServletResponse;
// * 
// * @WebServlet("/coder_community") public class coder_community extends
// * HttpServlet { private static final long serialVersionUID = 1L;
// * 
// * protected void doGet(HttpServletRequest request, HttpServletResponse
// * response) throws ServletException, IOException { // TODO Auto-generated
// * method stub
// * 
// * 
// * PrintWriter out = response.getWriter();
// * 
// * String url="jdbc:mysql://localhost:3306/spring_crud_jsp_project"; String
// * userName="springstudent"; String password = "springstudent"; String driver =
// * "com.mysql.cj.jdbc.Driver"; try { out.print("Connection to the Driver"+
// * driver); Class.forName(driver);
// * 
// * Connection conn = DriverManager.getConnection(url,userName,password);
// * out.print("Connection to the Driver"+ url); conn.close(); } catch(Exception
// * ex) { ex.printStackTrace(); }
// * 
// * }
// * 
// * }
// * 
// 
// */
//
//package com.coder.community;
//
//import java.io.IOException;
//import java.io.PrintWriter;
//import java.sql.Connection;
//import java.sql.DriverManager;
//
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//@WebServlet("/coder_community")
//public class CoderCommunityServlet extends HttpServlet {
//	private static final long serialVersionUID = 1L;
//
//	protected void doGet(HttpServletRequest request, HttpServletResponse response)
//			throws ServletException, IOException {
//		// TODO Auto-generated method stub
//
//		PrintWriter out = response.getWriter();
//
//		String url = "jdbc:mysql://localhost:3306/spring_crud_jsp_project";
//		String userName = "springstudent";
//		String password = "springstudent";
//		String driver = "com.mysql.cj.jdbc.Driver"; // Corrected driver class name
//
//		try {
//			out.print("Connection to the Driver: " + driver);
//			Class.forName(driver);
//
//			Connection conn = DriverManager.getConnection(url, userName, password);
//			out.print("Connection to the URL: " + url);
//			conn.close();
//		} catch (Exception ex) {
//			ex.printStackTrace();
//		}
//
//	}
//}
