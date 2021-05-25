//Andrew DeVoe - IB Computer Science HL IA GUI

import javax.swing.*;
import javax.imageio.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class GUI extends JFrame
{

	private JPanel welcome, panel, end;
	private String cat, dev, grd, det, solution;
	private fileStorage fileS;
	private boolean detval;
	
	public GUI() 
	{
		//Sets default variable values
		cat = dev = grd = det = solution = "";
		detval = false;
		
		//Creates screen
		JFrame frame = new JFrame("Virtual Tech Help Desk");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Color background = new Color(0xF9D142);
		frame.setBackground(background);
		
		//Creates welcome screen
		welcome = new JPanel();
		welcome.setBackground(background);
		getContentPane().add(welcome, BorderLayout.CENTER);
		welcome.setLayout(new BoxLayout(welcome, BoxLayout.X_AXIS));
						
		//Creates left panel for welcome
		JPanel leftPanelTwo = new JPanel();
		leftPanelTwo.setLayout(new GridLayout(1,1));
		leftPanelTwo.setBackground(background);
								
		//Adds image to left panel
		try {
			BufferedImage img = ImageIO.read(new File("UASchools.png"));
			ImageIcon icon = new ImageIcon(img);
			JLabel image = new JLabel(icon);
			leftPanelTwo.add(image);
		} catch (IOException e)
		{
			System.out.println(e);
		}
					
		//Creates right panel
		JPanel rightPanelTwo = new JPanel();
		rightPanelTwo.setBackground(background);
		rightPanelTwo.setLayout(new GridLayout(6, 1));
		JPanel welcomeText = new JPanel(new FlowLayout(FlowLayout.CENTER));
		welcomeText.setBackground(background);
		JLabel welcomeTxt = new JLabel("Welcome to the Virtual Tech Help Desk!");
		welcomeTxt.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		welcomeText.add(welcomeTxt);
		JPanel findSolution = new JPanel(new FlowLayout(FlowLayout.CENTER));
		findSolution.setBackground(background);
		JButton findSol = new JButton("Find a Solution!");
		findSol.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		findSol.addActionListener(a -> { //Changes welcome screen to input screen
			frame.remove(welcome);
			frame.add(panel);
			frame.setSize(1369, 700);
			frame.setVisible(true);
		});
		findSolution.add(findSol);
		
		//Sets welcome screen
		JPanel one = new JPanel();
		one.setBackground(background);
		JPanel two = new JPanel();
		two.setBackground(background);
		JPanel four = new JPanel();
		four.setBackground(background);
		JPanel six = new JPanel();
		six.setBackground(background);
		rightPanelTwo.add(one);
		rightPanelTwo.add(two);
		rightPanelTwo.add(welcomeText);
		rightPanelTwo.add(four);
		rightPanelTwo.add(findSolution);
		rightPanelTwo.add(six);
			
		//Adds panels to welcome screen
		welcome.add(leftPanelTwo);
		welcome.add(rightPanelTwo);
		frame.setSize(1370, 700);
		frame.add(welcome);
		frame.setVisible(true);
		
		
		//Creates a panel
		panel = new JPanel();
		panel.setBackground(background);
		getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));
		
		//Creates left panel
		JPanel leftPanel = new JPanel();
		leftPanel.setLayout(new GridLayout(1,1));
		leftPanel.setBackground(background);
		
		//Adds image to left panel
		try {
			BufferedImage img = ImageIO.read(new File("UASchools.png"));
			ImageIcon icon = new ImageIcon(img);
			JLabel image = new JLabel(icon);
			leftPanel.add(image);
		} catch (IOException e)
		{
			System.out.println(e);
		}
		
		//Creates right panel
		JPanel rightPanel = new JPanel();
		rightPanel.setBackground(background);
		rightPanel.setLayout(new GridLayout(7, 1));
		
		//Creates title for right panel
		JPanel titleField = new JPanel();
		titleField.setBackground(background);
		JLabel title = new JLabel("Please fill out every field before hitting submit.");
		title.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		titleField.add(title);
		
		//Adds category menu to a panel
		JPanel category = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		category.setBackground(background);
		JLabel categoryLbl = new JLabel("Issue Category:");
		categoryLbl.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		String[] categories = new String[]{"Select", "AirDrop", "App Kiosk", "Apple ID", "Canvas", "Hardware", "Java Help", "Login Issues", "PowerSchool", "Python Help", "Schoology", "Software", "Wi-Fi", "Other"};
		JComboBox categoryBox = new JComboBox(categories);
		categoryBox.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		categoryBox.addActionListener(a -> {
			cat = categoryBox.getSelectedItem().toString();
		});
		category.add(categoryLbl);
		category.add(categoryBox);
		
		//Adds device menu to a panel
		JPanel device = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		device.setBackground(background);
		JLabel deviceLbl = new JLabel("Device Operating System:");
		deviceLbl.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		String[] devices = new String[]{"Select", "iPadOS", "MacOS", "Windows", "Linux", "Other"};
		JComboBox deviceBox = new JComboBox(devices);
		deviceBox.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		deviceBox.addActionListener(a -> {
			dev = deviceBox.getSelectedItem().toString();
		});
		device.add(deviceLbl);
		device.add(deviceBox);
		
		//Adds grade menu to a panel
		JPanel grade = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		grade.setBackground(background);
		JLabel gradeLbl = new JLabel("Grade Level:");
		gradeLbl.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		String[] gradeLvl = new String[]{"Select", "Freshman", "Sophomore", "Junior", "Senior", "Faculty"};
		JComboBox gradeBox = new JComboBox(gradeLvl);
		gradeBox.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		gradeBox.addActionListener(a -> {
			grd = gradeBox.getSelectedItem().toString();
		});
		grade.add(gradeLbl);
		grade.add(gradeBox);
		
		//Adds details menu to a panel
		JPanel details = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		details.setBackground(background);
		JLabel detailsLbl = new JLabel("Details Keywords (Press ENTER when done typing): ");
		detailsLbl.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		JTextField detailsField = new JTextField();
		detailsField.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		detailsField.addActionListener(a -> {
			String tdet = detailsField.getText();
			if(!tdet.equals(""))
			{
				det = tdet;
				detval = true;
			}
			tdet = "";
		});
		detailsField.setColumns(15);
		details.add(detailsLbl);
		details.add(detailsField);
		
		//Adds Submit button
		JPanel rightPanelThree = new JPanel();
		JPanel buttons = new JPanel(new FlowLayout(FlowLayout.CENTER));
		buttons.setBackground(background);
		JButton submit = new JButton("Submit");
		submit.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		JButton cancel = new JButton("Cancel");
		cancel.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		submit.addActionListener(a -> {
			if(detval)
			{
				String file = cat.replaceAll(" ", "") + ";" + dev.replaceAll(" ", "") + ";" + grd + ";" + 0 + ";" + det + ";Solution not found";
				fileS = new fileStorage();
				fileS.addProblem(file);
				//Gets solution
				solution = fileS.toString();
				cat = "";
				dev = "";
				grd = "";
				det = "";
				detval = false;
		
				//Adds info to right end panel NEEDED HERE SO SOLUTION HAS A VALUE
				rightPanelThree.setBackground(background);
				rightPanelThree.setLayout(new GridLayout(6, 1));
				JPanel first = new JPanel();
				first.setBackground(background);
				JPanel b = new JPanel();
				b.setBackground(background);
				JPanel d = new JPanel();
				d.setBackground(background);
				JPanel f = new JPanel();
				f.setBackground(background);
				JPanel endText = new JPanel(new FlowLayout(FlowLayout.LEFT));
				endText.setBackground(background);
				JLabel endTxt = new JLabel("Solution: " + solution);
				endTxt.setFont(new Font("Times New Roman", Font.PLAIN, 20));
				endText.add(endTxt);
				JPanel toStart = new JPanel(new FlowLayout(FlowLayout.CENTER));
				toStart.setBackground(background);
				JButton start = new JButton("Solve Another Problem");
				start.setFont(new Font("Times New Roman", Font.PLAIN, 20));
				start.addActionListener(action -> {
					frame.remove(end);
					rightPanelThree.remove(first);
					rightPanelThree.remove(b);
					rightPanelThree.remove(endText);
					rightPanelThree.remove(d);
					rightPanelThree.remove(toStart);
					rightPanelThree.remove(f);
					frame.add(welcome);
					frame.setSize(1371, 700);
					frame.setVisible(true);
				});
				toStart.add(start);
						
				//Formats rightPanelThree
				rightPanelThree.add(first);
				rightPanelThree.add(b);
				rightPanelThree.add(endText);
				rightPanelThree.add(d);
				rightPanelThree.add(toStart);
				rightPanelThree.add(f);
				
			
		
				//Resets interface for next use
				categoryBox.setSelectedItem("Select");
				deviceBox.setSelectedItem("Select");
				gradeBox.setSelectedItem("Select");
				detailsField.setText(null);
		
				//Goes to end screen
				frame.remove(panel);
				frame.add(end);
				frame.setSize(1370, 700);
				frame.setVisible(true);
			}
		});
		
		buttons.add(submit);
		cancel.addActionListener(a -> {
			categoryBox.setSelectedItem("Select");
			deviceBox.setSelectedItem("Select");
			gradeBox.setSelectedItem("Select");
			detailsField.setText(null);
			frame.remove(panel);
			frame.add(welcome);
			frame.setSize(1370, 700);
			frame.setVisible(true);
		});
		buttons.add(cancel);
		
		//Adds the selection panels to the right panel
		JPanel blank = new JPanel();
		blank.setBackground(background);
		rightPanel.add(blank);
		rightPanel.add(titleField);
		rightPanel.add(category);
		rightPanel.add(device);
		rightPanel.add(grade);
		rightPanel.add(details);
		rightPanel.add(buttons);
		
		//Adds the right and left sides to one panel
		panel.add(leftPanel);
		panel.add(rightPanel);
		JPanel space = new JPanel();
		space.setBackground(background);
		panel.add(space);
		
		//Creates end panel
		end = new JPanel();
		end.setBackground(background);
		getContentPane().add(end, BorderLayout.CENTER);
		end.setLayout(new BoxLayout(end, BoxLayout.X_AXIS));
				
		//Creates left panel for end
		JPanel leftPanelThree = new JPanel(new GridLayout(1,1));
		leftPanelThree.setBackground(background);
								
		//Adds image to left panel
		try {
			BufferedImage img = ImageIO.read(new File("UASchools.png"));
			ImageIcon icon = new ImageIcon(img);
			JLabel image = new JLabel(icon);
			leftPanelThree.add(image);
		} catch (IOException e)
		{
			System.out.println(e);
		}
				
		end.add(leftPanelThree);
		end.add(rightPanelThree);
	}
}