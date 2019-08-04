package com.nucleus.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.nucleus.dao.UserDao;
import com.nucleus.dao.UserDaoRDBMSImpl;
import com.nucleus.entity.User;

/**
 * Servlet implementation class Servlet
 */
@WebServlet("/Servlet")
public class Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public Servlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter writer = response.getWriter();
		String userid = request.getParameter("userid");
		String pass = request.getParameter("pass");
		User user = new User();
		user.setUserId(userid);
		user.setPassword(pass);
		UserDao userdao = new UserDaoRDBMSImpl();
		try {
			User flag = userdao.checkdetails(user);
			String string = flag.getFlag();
			if(string == null)
			{
				HttpSession session = request.getSession();
				session.setAttribute("Userid", userid);
				session.setAttribute("pass", pass);
				userdao.updatedetails(user);
				writer.println("Login Successfully");
				RequestDispatcher rd = request.getRequestDispatcher("LoginSuccess.jsp");
				rd.forward(request, response);
				writer.println("jhjs");
			}
			else if(string.equals("Active"))
			{
				request.setAttribute("flag", string);
				RequestDispatcher rd = request.getRequestDispatcher("NotSuccess.jsp");
				rd.forward(request, response);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
