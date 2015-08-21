import java.awt.event.*;

import javax.swing.*;

import java.awt.*;
import java.util.ArrayList;

public class TestDialog1 extends JDialog implements ActionListener{
	JButton bnAdd;
	JButton bnCancel;
	public static JTextField foo;
	JTextField bar;
	JRadioButton yes;
	JRadioButton no;
	JCheckBox compass;
	JCheckBox grand;
	JCheckBox patriot;
	JCheckBox renegade;
	JCheckBox other;
	JRadioButton fivespeed;
	JRadioButton sixspeed;
	JRadioButton eightspeed;
	JRadioButton careless;
	ArrayList<String> items;
	ButtonGroup radioGroup;
	ButtonGroup yea;
	private String temporary;
    public static int i;
	private boolean cancelled;
    public boolean isCancelled() { return cancelled; }
    private String answer;
    public String getAnswer() {return answer;}
    private String j;
    public String getJ() {return j;}
    private String name;
    public String getName() { return name; }
    private String driver;
    public String getDriver() {return driver;}
    private String car;
    private String jeeps;
    public String getJeeps() {return jeeps;}
    public String getCar() {return car;}
    private String stick;
    public String getStick() {return stick;}
	
	
	public TestDialog1(Window window, String Title, String initstr){
		super(window,Title,true);
		
		
		j = Integer.toString(i);
		
		Container c = getContentPane();
		c.setLayout(null);
		
		JLabel customer = new JLabel("Customer Number");
		customer.setSize(150,50);
		customer.setLocation(100,50);
		c.add(customer);
		
		JLabel number = new JLabel(j);
		number.setSize(100,50);
		number.setLocation(250,50);
		if(window.isEdited()){
			number.setText(window.geta());
		}
		c.add(number);
		
		JLabel name = new JLabel("Customer Name");
		name.setSize(150,50);
		name.setLocation(100,100);
		c.add(name);
		
		foo = new JTextField();
		foo.setSize(200,25);
		foo.setLocation(250,113);
		foo.addActionListener(this);
		if(window.isEdited() == true){
			foo.replaceSelection(window.getb());
		}
		c.add(foo);
		
		JLabel years = new JLabel("How many years have you been driving?");
		years.setSize(350,50);
		years.setLocation(100,150);
		c.add(years);
		
		bar = new JTextField();
		bar.setSize(100,25);
		bar.setLocation(360,163);
		bar.addActionListener(this);
		if(window.isEdited()){
			bar.replaceSelection(window.getc());
		}
		c.add(bar);
		
		JLabel jeep = new JLabel("Do you have a Jeep?");
		jeep.setSize(200,50);
		jeep.setLocation(100,200);
		c.add(jeep);
		
		yes = new JRadioButton("Yes");
		yes.setSize(75,75);
		yes.setLocation(150,225);
		yes.addActionListener(this);
		c.add(yes);
		
		no = new JRadioButton("No");
		no.setSize(75,75);
		no.setLocation(225,225);
		no.addActionListener(this);
		c.add(no);
		
		yea = new ButtonGroup();
		yea.add(yes);
		yea.add(no);
		
		if(window.isEdited()==true){
			if(window.getd()== "yes"){
				yes.setSelected(true);
			}
			else if(window.getd()== "no"){
				no.setSelected(true);
			}
		}
		
		JLabel models = new JLabel("Which models are you interested in?");
		models.setSize(400,50);
		models.setLocation(100,275);
		c.add(models);
		
		compass = new JCheckBox("Compass");
		compass.setSize(100,50);
		compass.setLocation(150,310);
		compass.addActionListener(this);
		c.add(compass);
		
		grand = new JCheckBox("Grand Cherokee");
		grand.setSize(150,50);
		grand.setLocation(250,310);
		grand.addActionListener(this);
		c.add(grand);
		
		patriot = new JCheckBox("Patriot");
		patriot.setSize(100,50);
		patriot.setLocation(385,310);
		patriot.addActionListener(this);
		c.add(patriot);
		
		renegade = new JCheckBox("Renegade");
		renegade.setSize(100,50);
		renegade.setLocation(470,310);
		renegade.addActionListener(this);
		c.add(renegade);
		
		other = new JCheckBox("Others");
		other.setSize(100,50);
		other.setLocation(565,310);
		other.addActionListener(this);
		c.add(other);
		
		if(window.isEdited()==true){
			temporary = window.getk();
			if(temporary.charAt(0)=='C'){
				compass.setSelected(true);
			}
			if(temporary.charAt(1)=='G'){
				grand.setSelected(true);
			}
			if(temporary.charAt(2)=='P'){
				patriot.setSelected(true);
			}
			if(temporary.charAt(3)=='R'){
				renegade.setSelected(true);
			}
			if(temporary.charAt(4)=='O'){
				other.setSelected(true);
			}
		}
		
		JLabel tran = new JLabel("Transmission:");
		tran.setSize(100,50);
		tran.setLocation(100,350);
		c.add(tran);
		
		fivespeed = new JRadioButton("5-speed Manual");
		fivespeed.setSize(150,50);
		fivespeed.setLocation(150,385);
		fivespeed.addActionListener(this);
		c.add(fivespeed);
		
		sixspeed = new JRadioButton("6-speed Manual");
		sixspeed.setSize(150,50);
		sixspeed.setLocation(300,385);
		sixspeed.addActionListener(this);
		c.add(sixspeed);
		
		eightspeed = new JRadioButton("8-speed Paddle-Shift Automatic");
		eightspeed.setSize(250,50);
		eightspeed.setLocation(450,385);
		eightspeed.addActionListener(this);
		c.add(eightspeed);
		
		careless = new JRadioButton("Don't Care");
		careless.setSize(150,50);
		careless.setLocation(700,385);
		careless.addActionListener(this);
		c.add(careless);
		
		radioGroup = new ButtonGroup();
		radioGroup.add(fivespeed);
		radioGroup.add(sixspeed);
		radioGroup.add(eightspeed);
		radioGroup.add(careless);
		
		if(window.isEdited()==true){
			if(window.getf()== "5-speed Manual"){
				fivespeed.setSelected(true);
			}
			else if(window.getf()== "6-speed Manual"){
				sixspeed.setSelected(true);
			}
			else if(window.getf()=="8-speed Paddle-Shift Automatic"){
				eightspeed.setSelected(true);
			}
			else if(window.getf()== "Don't Care"){
				careless.setSelected(true);
			}
		}
		
		bnAdd = new JButton("Submit");
		bnAdd.setSize(100,75);
		bnAdd.setLocation(200,500);
		bnAdd.addActionListener(this);
		c.add(bnAdd);
		
		bnCancel = new JButton("Cancel");
		bnCancel.setSize(100,75);
		bnCancel.setLocation(450,500);
		bnCancel.addActionListener(this);
		c.add(bnCancel);
		
		setSize(800,600);
		setLocationRelativeTo(window);
		setVisible(true);
		}
	
	public void actionPerformed(ActionEvent e){
		if(e.getSource()==bnAdd){
			name = foo.getText();
			driver = bar.getText();
			if(yes.isSelected()){
				jeeps = "yes";
			}
			else if(no.isSelected()){
				jeeps = "no";
			}
			StringBuilder temp = new StringBuilder();
			temp.append("-----");
			if(compass.isSelected()){
				temp.setCharAt(0, 'C');	
			}
			if(grand.isSelected()){
				temp.setCharAt(1, 'G');
			}
			if(patriot.isSelected()){
				temp.setCharAt(2, 'P');
			}
			if(renegade.isSelected()){
				temp.setCharAt(3, 'R');
			}
			if(other.isSelected()){
				temp.setCharAt(4, 'O');
			}
			car = temp.toString();
			if(fivespeed.isSelected()){
				stick = "5-speed Manual";
			}
			else if(sixspeed.isSelected()){
				stick = "6-speed Manual";
			}
			else if(eightspeed.isSelected()){
				stick = "8-speed Automatic";
			}
			else if(careless.isSelected()){
				stick = "Don't Care";
			}
			i++;
			cancelled = false;
			setVisible(false);	
		}
		else if(e.getSource()==bnCancel){
			cancelled = true;
			setVisible(false);
		}
		
	}
	
}
	

	
		
	
