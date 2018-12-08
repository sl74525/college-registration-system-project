import java.util.*;

public class ManagementSystem {
	public static Scanner keyboard = new Scanner(System.in);
	private static HashMap<String, Account> accounts = new HashMap<>();
	private static ArrayList<Course> courses = new ArrayList<>();
	private static HashSet<String> professorIds = new HashSet<>();
	
	
	protected static Account currentAccount = null;
	private static boolean isFinished = false;
	
	static { 
		professorIds.add("123");
		professorIds.add("456");
		professorIds.add("789");
	}

	public static void register(Account account) {
		accounts.put(account.getAccountName(), account);
		System.out.println("Account has been successfully registered");
		System.out.println("There are now " + accounts.size() + " accounts.");
	}

	public static Account createOrLogin() {
		String createOrLoginChoice = null;
		while (true) {
			System.out.println("Welcome to UGA account management system. Do you want to:");
			System.out.println();
			System.out.println("===================================");
			System.out.println("1. Create account");
			System.out.println("2. Login");
			System.out.println("3. Exit");
			System.out.println("Please enter 1, 2 or 3");
			createOrLoginChoice = keyboard.next()+keyboard.nextLine();
			
			if (!createOrLoginChoice.equals("1") && !createOrLoginChoice.equals("2") && !createOrLoginChoice.equals("3")) {
				System.out.println("Error, please enter 1, 2 or 3.");
				continue;
			}
			else {
				break;
			}
		}
		
		if (createOrLoginChoice.equals("1")) {// 1start
			createAccount();	
			return null;
		}
		else if (createOrLoginChoice.equals("2")) {
			return loginAccount();
		}
		else {
			isFinished = true;
			return null;
		}
	}
	
	public static void createAccount() {
		String createStudentOrProfesorChoice = null;
		while (true) {
			System.out.println();
			System.out.println("===================================");
			System.out.println("Creating account");
			System.out.println("Are you a student or a professor?");
			System.out.println("1. Student");
			System.out.println("2. Professor");
			System.out.println("Please enter 1 or 2");
			createStudentOrProfesorChoice = keyboard.next()+keyboard.nextLine();

			if (!createStudentOrProfesorChoice.equals("1") && !createStudentOrProfesorChoice.equals("2")) {
				System.out.println("Error, please enter 1 or 2.");
				continue;
			}
			else {
				break;
			}
		}
		if (createStudentOrProfesorChoice.equals("1")) {
			createStudentAccount();
			return;
		}
		if (createStudentOrProfesorChoice.equals("2")) {
			createProfessorAccount();
			return;
		}
	}
	
	public static void createStudentAccount() {
		String accountName = null;
		String password = null;
		while (true) {
			System.out.println();
			System.out.println("===================================");
			System.out.println("Creating student account");
			System.out.println("Please enter your account name");
			accountName = keyboard.next()+keyboard.nextLine();
			if (accountName.length() < 4) {
				System.out.println("Error, account name can not be shorter than 4 symbols");
				continue;
			}
			if (accounts.containsKey(accountName)) {
				System.out.println("Error, account with such name already exists");
				continue;
			}
			
			System.out.println("Please enter your password");
			password = keyboard.next()+keyboard.nextLine();
			break;
		}
		register(new Student(accountName, password));
	}
	
	public static void createProfessorAccount() {
		String accountName = null;
		String password = null;
		String professorId = null;
		while (true) {
			System.out.println();
			System.out.println("===================================");
			System.out.println("Creating professor account");
			System.out.println("Please enter professor ID (this number has been assigned to you.)");
			professorId = keyboard.next()+keyboard.nextLine();
			if (!professorIds.contains(professorId)) {
				System.out.println("Error, professor ID is wrong");
				continue;
			}
			
			System.out.println("Please enter your account name");
			accountName = keyboard.next()+keyboard.nextLine();
			if (accountName.length() < 4) {
				System.out.println("Error, account name can not be shorter than 4 symbols");
				continue;
			}
			if (accounts.containsKey(accountName)) {
				System.out.println("Error, account with such name already exists");
				continue;
			}
			
			System.out.println("Please enter your password");
			password = keyboard.next()+keyboard.nextLine();
			
			
			break;
		}
		register(new Professor(professorId, accountName, password));
	}
	
	public static Account loginAccount() {
		String accountName = null;
		String password = null;
		while (true) {
			System.out.println();
			System.out.println("===================================");
			System.out.println("Logging In");
			System.out.println("Please enter your account name (enter 'X' if you want to quit)");
			accountName = keyboard.next()+keyboard.nextLine();
			if ("X".equals(accountName) || "x".equals(accountName)) {
				System.out.println("Exit");
				return null;
			}

			
			System.out.println("Please enter your password");
			password = keyboard.next()+keyboard.nextLine();
			Account account = accounts.get(accountName);
			if (account == null) {
				System.out.println("Error, wrong account name or password");
				continue;
			}
			if (!account.getPassword().equals(password)) {
				System.out.println("Error, wrong account name or password");
				continue;
			}
			return account;
		}
	}
	
	public static void mainMenu() {
		String mainMenuChoice = null;
		while (true) {
			System.out.println();
			System.out.println("===================================");
			System.out.println("User: " + currentAccount.getAccountName());
			System.out.println("-----------------------------------");
			System.out.println("Main menu");
			System.out.println("1. Show Info");
			System.out.println("2. Show Balance");
			System.out.println("3. Add courses");
			System.out.println("4. Log out");
			System.out.println("Please enter 1, 2, 3 or 4");
			mainMenuChoice = keyboard.next()+keyboard.nextLine();

			if (!mainMenuChoice.equals("1") && !mainMenuChoice.equals("2") && !mainMenuChoice.equals("3") && !mainMenuChoice.equals("4")) {
				System.out.println("Error, please enter 1,2,3 or 4.");
				continue;
			}
			else {
				break;
			}
		}
		if (mainMenuChoice.equals("1")) {
			showInfo();
			return;
		}
		else if (mainMenuChoice.equals("2")) {
			showBalance();
			return;
		}
		else if (mainMenuChoice.equals("3")) {
			addCourse();
			return;
		}
		else if (mainMenuChoice.equals("4")) {
			currentAccount = null;
			return;
		}
	}
	
	public static void showInfo() {
		System.out.println();
		System.out.println("===================================");
		System.out.println("User: " + currentAccount.getAccountName());
		System.out.println("-----------------------------------");
		currentAccount.printData();
	}
	
	public static void showBalance() {
		System.out.println();
		System.out.println("===================================");
		System.out.println("User: " + currentAccount.getAccountName());
		System.out.println("-----------------------------------");

		
		currentAccount.printBalance();
		
	}
	
	public static void addCourse() {
		while (true) {
			System.out.println();
			System.out.println("===================================");
			System.out.println("User: " + currentAccount.getAccountName());
			System.out.println("-----------------------------------");
			
			if (currentAccount instanceof Student) {
				Student student = (Student) currentAccount;
				if (courses.isEmpty()) {
					System.out.println("No courses available yet");
					return;
				}
				System.out.println("Please choice course: (enter 0 to exit this menu)");
				for (int i = 0; i<courses.size(); i++) {
					System.out.println(String.format("%3d. %s", (i+1), courses.get(i).getCourseName()));
				}
				int courseChoice = -1;
				
				try {
					courseChoice = Integer.parseInt(keyboard.next()+keyboard.nextLine());
					if ((courseChoice < 0) || (courseChoice > courses.size())) {
						throw new NumberFormatException();
					}
					if (courseChoice == 0) {
						return;
					}
					Course course = courses.get(courseChoice-1);
					if (student.containsCourse(course.getCourseName())) {
						System.out.println("Error, student already registered for this course");
						continue;
					}
					student.addCourse(course);
					System.out.println("You have registered for course: " + course.getCourseName());
					break;
				}
				catch (NumberFormatException nfe) {
					System.out.println("Error, please enter course number");
				}
			}
			else {
				Professor professor = (Professor) currentAccount;
				System.out.println("Please enter course name");
				String courseName = keyboard.next()+keyboard.nextLine();
				if (courseName.length() < 2) {
					System.out.println("Error, course name can not be shorter than 2 symbols");
					continue;
				}
				if (containsCourse(courseName)) {
					System.out.println("Error, course with such name already exists");
					continue;
				}
				Course course = new Course(courseName, professor);
				courses.add(course);
				professor.addCourse(course);
				System.out.println("You have registered new course: " + courseName);
				return;
			}
		}
	}
	
	public static void main(String[] args) {
		
		while (!isFinished) {
			if (currentAccount == null) {
				currentAccount = createOrLogin();
			}
			if (currentAccount != null) {
				mainMenu();
			}
		}
	}
	
	private static boolean containsCourse(String courseName) {
		for (Course course : courses) {
			if (course.getCourseName().equals(courseName)) {
				return true;
			}
		}
		return false;
	}
}
