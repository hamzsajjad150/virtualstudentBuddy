package nievasj.com;
import javax.sql.DataSource;
import java.sql.SQLException;

import java.io.IOException;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import javax.servlet.annotation.WebServlet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;


import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



@WebServlet("/ProductController")
public class ProductController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ProductModel productModel;
	
@Resource(name = "jdbc/Products")
	private DataSource myPool; 

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	String action = request.getParameter("instruction");
	if (action==null) {
		action="listar";
	} 
 	
	switch (action) {
	case "listar":
		retrieveProducts(request, response);
		break;
	case "insertDDBB" :
		try {
			addProduct(request, response);
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	break;
	case "edit":
		try {
			editProduct(request, response);
		} catch (Exception e) {
			e.printStackTrace();
	}
	break;
	case "updateDDBB":
		try {
			updateDDBB(request, response);	
		} catch (Exception e) {
			e.printStackTrace();

		}
	break;
	
	case "delete":
		try {
			delete(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	break;

	case "grid":
		retrieveGrid(request, response);
		break;
	
		
	default:
		
	}	
	}	

	
	private void delete(HttpServletRequest request, HttpServletResponse response) throws Exception{
	String testKey=request.getParameter("testKey");		
	productModel.deleteProduct(testKey);
	retrieveProducts(request, response);
	}


	private void updateDDBB(HttpServletRequest request, HttpServletResponse response) throws Exception{
		String testKey= request.getParameter("testKey");
		String courseName=request.getParameter("courseName");
		String testName=request.getParameter("testName");
		SimpleDateFormat formatDate = new SimpleDateFormat("yyyy-MM-dd");
		Date date = null;
		try {
			 date= formatDate.parse(request.getParameter("date"));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		 
		Double testWeight =Double.parseDouble(request.getParameter("testWeight"));
		Double testGrade =Double.parseDouble(request.getParameter("testGrade"));
		 
		Test tempTest = new Test(testKey, courseName, testName, date, testWeight, testGrade);	
		productModel.editProduct(tempTest);
		retrieveProducts(request, response);
		
	}


	private void editProduct(HttpServletRequest request, HttpServletResponse response) throws Exception{
	String testKey = request.getParameter("testKey");
	Test tempTest = productModel.getProduct(testKey);	
	request.setAttribute("bla", tempTest);	
	RequestDispatcher myDispatcher= request.getRequestDispatcher("/update.jsp");
	myDispatcher.forward(request, response);
	}


	private void addProduct(HttpServletRequest request, HttpServletResponse response) throws SQLException {
	 String testKey= null;
	 String courseName=request.getParameter("courseName");
	 String testName=request.getParameter("testName");
	 SimpleDateFormat formatDate = new SimpleDateFormat("yyyy-MM-dd");
	 Date date = null;
	 try {
		 date= formatDate.parse(request.getParameter("dueDate"));
	} catch (ParseException e) {
		e.printStackTrace();
	}
	 
	Double testWeight =Double.parseDouble(request.getParameter("testWeight"));
	Double testGrade =Double.parseDouble(request.getParameter("testGrade"));
	 
	Test tempTest = new Test(testKey, courseName, testName, date, testWeight, testGrade);
	
	productModel.addNewProduct(tempTest);
	
	// 5- Show List
	retrieveProducts(request, response);
	
	}


	private void retrieveProducts(HttpServletRequest request, HttpServletResponse response) {
		List<Test> tests;
		try {
		tests= productModel.getProducts();
		request.setAttribute("pro", tests);	
		request.setAttribute("course", new Date());
		RequestDispatcher dispatcher = request.getRequestDispatcher("/productList.jsp");
		dispatcher.forward(request, response);
		} catch (Exception e) {
	     e.printStackTrace();
		}
	}

	private void retrieveGrid(HttpServletRequest request, HttpServletResponse response) {
		List<GridRow> gridRows;
		try {
		gridRows = productModel.getRows();
		
		
		//request.setAttribute("course", new Date());
		request.setAttribute("grid", gridRows);
		System.out.print(gridRows.toString());	
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/grid.jsp");
		dispatcher.forward(request, response);
		} catch (Exception e) {
	     e.printStackTrace();
		}
	}
	
	
	
	
	
	@Override
	public void init() throws ServletException {
		super.init();
		try {
			productModel = new ProductModel(myPool);
		} catch (Exception e) {
			throw new ServletException();
		}
	}
}
