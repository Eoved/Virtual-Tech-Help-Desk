//Andrew DeVoe - IB Computer Science HL IA fileStoage

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.io.*;

public class fileStorage
{
	
	boolean match;
	String solution;
	problem newProb, lineProb;
	char cat, dev;
	Map<Character, String> catsCS, devsCS; 
	Map<String, Character> catsSC, devsSC;
	Map<String, Integer> gradeSI;
	
	public fileStorage()
	{
		catsCS = new HashMap<Character, String>();
		catsCS.put('a', "wi-fi");
		catsCS.put('b', "appkiosk");
		catsCS.put('c', "airdrop");
		catsCS.put('d', "hardware");
		catsCS.put('e', "software");
		catsCS.put('f', "javahelp");
		catsCS.put('g', "pythonhelp");
		catsCS.put('h', "appleid");
		catsCS.put('i', "loginissues");
		catsCS.put('j', "powerschool");
		catsCS.put('k', "canvas");
		catsCS.put('l', "schoology");
		catsCS.put('m', "other");
		devsCS = new HashMap<Character, String>();
		devsCS.put('a', "ipad");
		devsCS.put('b', "mac");
		devsCS.put('c', "windows");
		devsCS.put('d', "linux");
		devsCS.put('e', "other");
		solution = "";
		match = false;
		
		//String to char
		catsSC = new HashMap<String, Character>();
		catsSC.put("wi-fi", 'a');
		catsSC.put("appkiosk", 'b');
		catsSC.put("airdrop", 'c');
		catsSC.put("hardware", 'd');
		catsSC.put("software", 'e');
		catsSC.put("javahelp", 'f');
		catsSC.put("pythonhelp", 'g');
		catsSC.put("appleid", 'h');
		catsSC.put("loginissues", 'i');
		catsSC.put("powerschool", 'j');
		catsSC.put("canvas", 'k');
		catsSC.put("schoology", 'l');
		catsSC.put("other", 'm');
		devsSC = new HashMap<String, Character>();
		devsSC.put("ipados", 'a');
		devsSC.put("macos", 'b');
		devsSC.put("windows", 'c');
		devsSC.put("linux", 'd');
		devsSC.put("other", 'e');
		
		//Grade string to int
		gradeSI = new HashMap<String, Integer>();
		gradeSI.put("freshman", 9);
		gradeSI.put("sophomore", 10);
		gradeSI.put("junior", 11);
		gradeSI.put("senior", 12);
		gradeSI.put("faculty", 0);
		
		solution = "";
		match = false;
	}
	
	public void addProblem(String prob) //Problem is a string of the ArrayList
	{
		
		try
		{
			//Makes a problem from the input
			String[] data = prob.split(";");
			cat = catsSC.get(data[0].toLowerCase());
			dev = devsSC.get(data[1].toLowerCase());
			int gr = gradeSI.get(data[2].toLowerCase());
			int ts = Integer.parseInt(data[3]);
			String specs = data[4].toLowerCase().replaceAll(",",  " ").replaceAll(" ", "");
			String sol = data[5];
			newProb = new problem(cat, dev, gr, ts, specs, sol);
			File file = new File("solutionData");
			FileReader freader = new FileReader(file);
			BufferedReader breader = new BufferedReader(freader);
			String line = breader.readLine();
			while(line != null)
			{
				if(match == false) //Makes a problem from the line
				{
					String[] lineData = line.split(";");
					char lineCat = lineData[0].charAt(0);
					char lineDev = lineData[1].charAt(0);
					int lineGr = Integer.parseInt(lineData[2]);
					int lineTs = Integer.parseInt(lineData[3]);
					String lineSpecs = lineData[4].toLowerCase().replaceAll(" ", "");
					String lineSol = lineData[5];
					lineProb = new problem(lineCat, lineDev, lineGr, lineTs, lineSpecs, lineSol);
					if((newProb.getCat() == lineProb.getCat()) && (newProb.getDev() == lineProb.getDev()) && (newProb.getSpecs().equals(lineProb.getSpecs())) && (newProb.getGra() == lineProb.getGra()))
					{
						solution = lineProb.getSolution();
						match = true;
					}
				}
				line = breader.readLine();
			}
			freader.close();
			breader.close();
			
			if(match == false) //If problem has not already been solved it gets added to the bottom of the data file
			{
				FileWriter fwriter = new FileWriter(file, true);
				BufferedWriter bwriter = new BufferedWriter(fwriter);
				PrintWriter pwriter = new PrintWriter(bwriter);
				pwriter.println(newProb.toString());
				pwriter.flush();
				pwriter.close();
				bwriter.close();
				fwriter.close();
			}
			else //If a problem has been solved before the times solved gets incremented
			{
				FileReader fr = new FileReader(file);
				BufferedReader br = new BufferedReader(fr);
				String templine = br.readLine();
				LinkedList<String> temp = new LinkedList<String>();
				while(templine != null)
				{
					String[] lineData = templine.split(";");
					int temptimes = Integer.parseInt(lineData[3]);
					String comp = "" + lineData[0] + ";" + lineData[1] + ";" + lineData[2] + ";" + lineData[4];
					if(comp.equals(newProb.compare()))
					{
						newProb.addTimes(temptimes);
						temp.add(newProb.toString());
					}
					else
						temp.add(templine);
					templine = br.readLine();
				}
				FileWriter fwriter = new FileWriter(file, false);
				BufferedWriter bwriter = new BufferedWriter(fwriter);
				PrintWriter pwriter = new PrintWriter(bwriter, false);
				pwriter.flush();
				for(int i = 0; i < temp.size(); i++)
					pwriter.println(temp.get(i));
				pwriter.close();
				bwriter.close();
				fwriter.close();
			}
		
		} catch (IOException e)
		{
			System.out.println(e);
		}
	}
	
	public String toString()
	{
		if(solution.equals("Solution not found"))
			return "We're sorry, but a solution to your problem could not be found. Please see a help desk worker.";
		else if(match == true)
			return solution;
		else
			return "We're sorry, but a solution to your problem could not be found. Please see a help desk worker.";
	}
}
