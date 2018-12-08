import java.util.ArrayList;

public class Student extends Account {
	private static final int COURSE_COST = 300;
	private ArrayList<Course> studyingCourses = new ArrayList<>();
	
	public Student(String newAccountName, String newPassword) {
		setAccountName(newAccountName);
		setPassword(newPassword);
	}

	public void addCourse(Course course) {
		studyingCourses.add(course);
	}
	
	public int getBalance() {
		return COURSE_COST*studyingCourses.size();
	}
	
	public void printBalance(String [] balanceDueDates) {
		System.out.println("Which semester are you enrolled for:");
		System.out.println("Fall, Spring, or Summer?");
		boolean found = false;
		while (found == false)
		{
		String Semester = ManagementSystem.keyboard.next() + ManagementSystem.keyboard.nextLine();
		if (Semester.equalsIgnoreCase("Fall"))
		{
			System.out.println("Your balance is due on: " + balanceDueDates[0]);
			found = true;
			
		}
		else if (Semester.equalsIgnoreCase("Spring"))
		{
			System.out.println("Your balance is due on: " + balanceDueDates[1]);
			found = true;
			
		}
		else if (Semester.equalsIgnoreCase("Summer"))
		{
			System.out.println("Your balance is due on: " + balanceDueDates[2]);
			found = true;
			
		}
		else
		{
			System.out.println("Please pick Fall, Spring, or Summer");
		}
		}
		
		System.out.println("Your current balance is -$" + getBalance());
		
	}

	public boolean containsCourse(String courseName) {
		for (Course course : studyingCourses) {
			if (course.getCourseName().equals(courseName)) {
				return true;
			}
		}
		return false;
	}
	
	public void printData() {
		System.out.println("Student");
		System.out.println("Account Name: " + getAccountName());
		System.out.println("Password: " + getPassword());
		System.out.println("Studying Courses:");
		for (Course course : studyingCourses) {
			System.out.println("\t" + course.getCourseName());
			
		}
	}
	
}
