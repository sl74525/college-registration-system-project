public class Course {
	private String courseName;
	private Professor professor;
	
	public Course(String courseName, Professor professor) {
		this.courseName = courseName;
		this.professor = professor;
	}

	public String getCourseName() {
		return courseName;
	}

	public Professor getProfessor() {
		return professor;
	}
}
