package nievasj.com;

public class Course {

int courseKey;	
String courseCode;
String courseName;
int semester;
double creditCourse;
String professorName;
String courseDescription;


public Course(int courseKey, String courseCode, String courseName, int semester, double creditCourse,
		String professorName, String courseDescription) {
	super();
	this.courseKey = courseKey;
	this.courseCode = courseCode;
	this.courseName = courseName;
	this.semester = semester;
	this.creditCourse = creditCourse;
	this.professorName = professorName;
	this.courseDescription = courseDescription;
}


public int getCourseKey() {
	return courseKey;
}


public void setCourseKey(int courseKey) {
	this.courseKey = courseKey;
}


public String getCourseCode() {
	return courseCode;
}


public void setCourseCode(String courseCode) {
	this.courseCode = courseCode;
}


public String getCourseName() {
	return courseName;
}


public void setCourseName(String courseName) {
	this.courseName = courseName;
}


public int getSemester() {
	return semester;
}


public void setSemester(int semester) {
	this.semester = semester;
}


public double getCreditCourse() {
	return creditCourse;
}


public void setCreditCourse(double creditCourse) {
	this.creditCourse = creditCourse;
}


public String getProfessorName() {
	return professorName;
}


public void setProfessorName(String professorName) {
	this.professorName = professorName;
}


public String getCourseDescription() {
	return courseDescription;
}


public void setCourseDescription(String courseDescription) {
	this.courseDescription = courseDescription;
}


@Override
public String toString() {
	return "Course [courseKey=" + courseKey + ", courseCode=" + courseCode + ", courseName=" + courseName
			+ ", semester=" + semester + ", creditCourse=" + creditCourse + ", professorName=" + professorName
			+ ", courseDescription=" + courseDescription + "]";
}

	
	
	
	
}
