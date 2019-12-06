package nievasj.com;

import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;


import java.util.List;
import javax.sql.DataSource;

public class ProductModel {

	private DataSource dataSource;
	
	public ProductModel(DataSource dataOrigin) {
		this.dataSource= dataOrigin;
		}
	
	public List<Test> getProducts() throws SQLException{
		List<Test> testsList = new ArrayList<>();
		Connection myConnection = null;
		Statement myStatement = null;

	try {
	myConnection = dataSource.getConnection();

	myStatement = myConnection.createStatement();
	String sqlString = "Select * from test ORDER BY test . date DESC";
	ResultSet myResultSet = myStatement.executeQuery(sqlString);
	
	while (myResultSet.next()) {
		String testKey = myResultSet.getString(1);
		String courseName = myResultSet.getString(2);
		String testName= myResultSet.getString(3);
		Date date=myResultSet.getDate(4);
		Double testWeight =myResultSet.getDouble(5);
		Double testGrade =myResultSet.getDouble(6);
		//creates an object			
		Test tempTest = new Test(testKey, courseName, testName, date, testWeight, testGrade);
		testsList.add(tempTest);
			}
		}finally{
			myConnection.close();	//**************
			myStatement.close();	//**************
		}	
			
	return testsList;
		}

	private Connection DriverManager(String string) {
		// TODO Auto-generated method stub
		return null;
	}

	public void addNewProduct(Test tempTest) throws SQLException {
		System.out.print(tempTest.toString());
		Connection myConnection = null;
		PreparedStatement myPreparedStatement = null;
		
		try {
		myConnection = dataSource.getConnection();
		String sql = "INSERT INTO test(courseName, testName, date, testWeight, testGrade)" +
				 "VALUES (?,?,?,?,?)";
		myPreparedStatement= myConnection.prepareStatement(sql);
		 // 3 Establish product parameters
		myPreparedStatement.setString(1, tempTest.getCourseName());
		myPreparedStatement.setString(2, tempTest.getTestName());
		java.util.Date utilDate= tempTest.getDate();
		java.sql.Date converteDate = new java.sql.Date(utilDate.getTime());
		myPreparedStatement.setDate(3, converteDate);
		myPreparedStatement.setDouble(4, tempTest.getTestWeight());
		myPreparedStatement.setDouble(5, tempTest.getTestGrade());
		myPreparedStatement.execute();
		System.out.print(myPreparedStatement.toString());
		} catch (Exception e) {
			System.out.print(e.getMessage());		
	}	
		finally{
			myConnection.close();
			myPreparedStatement.close();
		}		
	}

	public Test getProduct(String testKey) throws SQLException {
	Test tempTest= null;
	Connection myConnection = null;
	PreparedStatement myPreparedStatement = null;
	ResultSet myResultSet = null;
	try {
	myConnection = dataSource.getConnection();
	String sql= "SELECT * FROM test WHERE testKey=?";	
	myPreparedStatement= myConnection.prepareStatement(sql);
	myPreparedStatement.setString(1, testKey);	
	myResultSet = myPreparedStatement.executeQuery();	
	if (myResultSet.next()) {
		String itemKey = myResultSet.getString(1);
		String courseName = myResultSet.getString(2);
		String testName= myResultSet.getString(3);
		Date date=myResultSet.getDate(4);
		Double testWeight=myResultSet.getDouble(5);
		Double testGrade=myResultSet.getDouble(6);
		tempTest = new Test(itemKey,courseName, testName, date, testWeight, testGrade);	
	
	}else {	
	throw new Exception("Article code: " + testKey + " was not found");
	} 
	}catch (Exception e) {
		e.printStackTrace();
	}finally{
		myConnection.close();	
		myPreparedStatement.close();	
	}
	return tempTest;
	}


	public void editProduct(Test tempTest) throws SQLException {
		Connection myConnection = null;
		PreparedStatement myPreparedStatement = null;
	try {
		myConnection = dataSource.getConnection();
		String sql = "UPDATE test SET courseName=?, testName=?, date=?, testWeight=?, testGrade=?" +
		"WHERE testKey=?";
		myPreparedStatement= myConnection.prepareStatement(sql);
		myPreparedStatement.setString(1, tempTest.getCourseName());
		myPreparedStatement.setString(2, tempTest.getTestName());
		java.util.Date utilDate= tempTest.getDate();
		java.sql.Date converteDate = new java.sql.Date(utilDate.getTime());
		myPreparedStatement.setDate(3, converteDate);
		myPreparedStatement.setDouble(4, tempTest.getTestWeight());
		myPreparedStatement.setDouble(5, tempTest.getTestGrade());
		myPreparedStatement.setString(6, tempTest.getTestKey());
		myPreparedStatement.execute();
		
		} catch (Exception e) {
		e.printStackTrace();	
	}finally{
		myConnection.close();
		myPreparedStatement.close();	
	}
}

	public void deleteProduct(String testKey)throws SQLException {
		Connection myConnection = null;
		PreparedStatement myPreparedStatement = null;
	try {
		myConnection = dataSource.getConnection();
		String sql = "DELETE FROM test WHERE testKey=? ";
		myPreparedStatement= myConnection.prepareStatement(sql);
		myPreparedStatement.setString(1, testKey);
		myPreparedStatement.execute();
		
		} catch (Exception e) {
		System.out.print(e.getMessage());	
	}finally{
		myConnection.close();	
		myPreparedStatement.close();
	}
	
}



	public List<GridRow> getRows() throws SQLException, ParseException {
		List<GridRow> rowsList = new ArrayList<>();
		Connection myConnection = null;
		Statement myStatement = null;
		String test1 = null;
		String test2 = null;
		String test3 = null;
		String test4 = null;
		String test5 = null;
		String test6 = null;
		String test7 = null;
		Date dueDate = null;
		
		
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date columnDate = sdf.parse("2019-08-01");
		
        Calendar c = Calendar.getInstance();
        c.setTime(columnDate);
         

		
		
	try {
	myConnection = dataSource.getConnection();
	myStatement = myConnection.createStatement();
	String sqlString = "Select * from test ORDER BY test . date DESC";
	ResultSet myResultSet = myStatement.executeQuery(sqlString);
	
	
		
		for (int i = 0; i < 10; i++) {
	    c.add(Calendar.DATE, 1);  // añade un día
	    columnDate = c.getTime(); //Obtienes la nueva fech		
		
	    

	    
		while(myResultSet.next()) {
	
			if(columnDate.compareTo(myResultSet.getDate(4))== 0){
			test1 = myResultSet.getString(2);
			test2= myResultSet.getString(3);
			}

			GridRow tempRow= new GridRow(dueDate ,columnDate, test1, test2, test3, test4, test5,test6, test7);
		rowsList.add(tempRow);
	}}
		}finally{
			myConnection.close();	//**************
			myStatement.close();	//**************
		}	
			
	return rowsList;
		}	
		

}
