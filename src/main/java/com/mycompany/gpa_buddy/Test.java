package nievasj.com;

import java.util.Date;

public class Test {
		private String testKey;
		private String courseName;
		private String testName;
		private Date date;
		private Double testWeight;
		private Double testGrade;
		
		
		public Test(String testKey, String courseName, String testName, Date date, Double testWeight, Double testGrade) {
			super();
			this.testKey = testKey;
			this.courseName = courseName;
			this.testName = testName;
			this.date = date;
			this.testWeight = testWeight;
			this.testGrade = testGrade;
		}
		
		
		
		public String getTestKey() {
			return testKey;
		}
		public void setTestKey(String testKey) {
			this.testKey = testKey;
		}
		public String getCourseName() {
			return courseName;
		}
		public void setCourseName(String className) {
			this.courseName = className;
		}
		public String getTestName() {
			return testName;
		}
		public void setTestName(String testName) {
			this.testName = testName;
		}
		public Date getDate() {
			return date;
		}
		public void setDate(Date date) {
			this.date = date;
		}
		public Double getTestWeight() {
			return testWeight;
		}
		public void setTestWeight(Double testWeight) {
			this.testWeight = testWeight;
		}
		public Double getTestGrade() {
			return testGrade;
		}
		public void setTestGrade(Double testGrade) {
			this.testGrade = testGrade;
		}



		@Override
		public String toString() {
			return "Test [testKey=" + testKey + ", courseName=" + courseName + ", testName=" + testName + ", date=" + date
					+ ", testWeight=" + testWeight + ", testGrade=" + testGrade + "]";
		}

		
		
}
