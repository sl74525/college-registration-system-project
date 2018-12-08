import java.util.ArrayList;

public class Professor extends Account {
	private static final int SALARY_PER_COURSE = 4000;
	private String professorId;
	private ArrayList<Course> teachingCourses = new ArrayList<>();
	
	public Professor(String professorId, String newAccountName, String newPassword) {
		this.professorId = professorId;
		setAccountName(newAccountName);
		setPassword(newPassword);
	}

	public void addCourse(Course course) {
		teachingCourses.add(course);
	}
	
	public int getBalance() {
		return SALARY_PER_COURSE * teachingCourses.size();
	}

	public void printBalance() {
		System.out.println("Your current balance is $" + getBalance());
	}

	public void printData() {
		System.out.println("Professor");
		System.out.println("Professor ID: " + professorId);
		System.out.println("Account Name: " + getAccountName());
		System.out.println("Password: " + getPassword());
		System.out.println("Teaching Courses:");
		for (Course course : teachingCourses) {
			System.out.println("\t" + course.getCourseName());
		}
	}
}
