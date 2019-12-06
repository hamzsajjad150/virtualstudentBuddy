package nievasj.com;

import java.util.Date;

public class GridRow {
	Date dueDate;
	Date columnDate;
	String test1 = null;
	String test2 = null;
	String test3 = null;
	String test4 = null;
	String test5 = null;
	String test6 = null;
	String test7 = null;
	
	
	
	public GridRow(Date dueDate, Date columnDate, String test1, String test2, String test3, String test4, String test5,
			String test6, String test7) {
		super();
		this.dueDate = dueDate;
		this.columnDate = columnDate;
		this.test1 = test1;
		this.test2 = test2;
		this.test3 = test3;
		this.test4 = test4;
		this.test5 = test5;
		this.test6 = test6;
		this.test7 = test7;
	}
	
	public Date getDueDate() {
		return dueDate;
	}
	public void setDueDate(Date dueDate) {
		this.dueDate = dueDate;
	}
	public Date getColumnDate() {
		return columnDate;
	}
	public void setColumnDate(Date columnDate) {
		this.columnDate = columnDate;
	}
	public String getTest1() {
		return test1;
	}
	public void setTest1(String test1) {
		this.test1 = test1;
	}
	public String getTest2() {
		return test2;
	}
	public void setTest2(String test2) {
		this.test2 = test2;
	}
	public String getTest3() {
		return test3;
	}
	public void setTest3(String test3) {
		this.test3 = test3;
	}
	public String getTest4() {
		return test4;
	}
	public void setTest4(String test4) {
		this.test4 = test4;
	}
	public String getTest5() {
		return test5;
	}
	public void setTest5(String test5) {
		this.test5 = test5;
	}
	public String getTest6() {
		return test6;
	}
	public void setTest6(String test6) {
		this.test6 = test6;
	}
	public String getTest7() {
		return test7;
	}
	public void setTest7(String test7) {
		this.test7 = test7;
	}
	

}
