//Andrew DeVoe - IB Computer Science HL IA problem

public class problem 
{
	private char category, device;
	private int grade, timesSolved;
	private String specifics, solution;
	
	public problem()
	{
		category = '0';
		device = '0';
		grade = 0;
		timesSolved = 0;
		specifics = null;
		solution = null;
	}
	
	public problem(char cat, char dev, int gr, int ts, String specs, String sol)
	{
		category = cat;
		device = dev;
		grade = gr;
		timesSolved = ts;
		specifics = specs;
		solution = sol;
	}
	
	public char getCat() //Returns the problem category
	{
		return category;
	}
	
	public char getDev() //Returns the device's OS
	{
		return device;
	}
	
	public int getGra() //Returns the student's grade
	{
		return grade;
	}
	
	public int getTimes() //Returns the number of times solved
	{
		return timesSolved;
	}
	
	public void addTimes(int times) //Increases the times a problem has been solved
	{
		timesSolved = times + 1;
	}

	public String getSpecs() //Returns the specifics of the problem
	{
		return specifics;
	}
	
	public String getSolution() //Returns the solution of the problem
	{
		return solution;
	}
	
	
	public String compare() //Returns the toString without timessolved and solution
	{
		return ""+ category + ";" + device + ";" + grade + ";" + specifics;
	}
	
	public String toString() //Returns the data of problem in a String
	{
		//Format "Category: " + category + ";Device: " + device + ";Grade: " + grade + ";Specifics: " + specifics + ";Solution: " + solution;
		return ""+ category + ";" + device + ";" + grade + ";" + timesSolved + ";" + specifics + ";" + solution;
	}

}
