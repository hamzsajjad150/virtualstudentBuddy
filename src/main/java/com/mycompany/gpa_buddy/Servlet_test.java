package nievasj.com;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.*;


@WebServlet("/Servlet_test")
public class Servlet_test extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Resource(name = "jdbc/Products")
	private DataSource myPool;    
	
    public Servlet_test() {
        super();
    }

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	PrintWriter out = response.getWriter();
	response.setContentType("text/plain");
	Connection myConection = null;
	Statement myStatement = null;
	ResultSet myResultset = null;
	try {
		myConection = myPool.getConnection();
		String mySql= "SELECT * FROM PRODUCTS";
		myStatement = myConection.createStatement();
		myResultset = myStatement.executeQuery(mySql);
		while (myResultset.next()) {
			String article_name= myResultset.getNString(3);
			out.println(article_name);
		}
		
	} catch (Exception e) {
		e.printStackTrace();
	}
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
