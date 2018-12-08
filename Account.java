public abstract class Account {
	private String accountName;
	private String password;
	
	public abstract int getBalance();
	public abstract void printData();
	
	public String getAccountName() {
		return accountName;
	}

	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void printBalance() {
		
			 String [] balanceDueDates = new String[3];
				balanceDueDates[0] = "8/20";
				balanceDueDates[1] = "1/9";
				balanceDueDates[2] = "5/7";
		 
		if (ManagementSystem.currentAccount instanceof Student)
		{
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
		System.out.println("Your balance is: -$" + getBalance());
		}
		else
		{
			System.out.println("Your balance is: $" + getBalance());
		}
	
	}

	 
}
