import java.awt.event.*;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import java.awt.*;
import java.util.ArrayList;
import java.util.Vector;


public class Window extends JFrame implements ActionListener{
	JButton add;
	JButton remove;
	JButton clear;
	JButton edit;
	JScrollPane scroll;
	ArrayList<String> myList;
	DefaultListModel names;
	JList array;
	JTable table;
	Object a;
	JButton save;
	JButton open;
	public String geta() {return a.toString();}
	Object b;
	public String getb() {return b.toString();}
	Object c;
	public String getc() {return c.toString();}
	Object d;
	public String getd() {return d.toString();}
	Object k;
	public String getk() {return k.toString();}
	Object f;
	public String getf() {return f.toString();}
	private boolean edited;
	public boolean isEdited() {return edited;}
	DefaultTableModel tablemodel;
	private static final int ROW_HEIGHT = 25;
	private static final String[] TABLE_COLUMNS = {"Customer No", "Customer Name", "Driving Years", "Jeep Owner", "Models", "Transmission"};

	public Window(){
		
		Container n = getContentPane();
		n.setLayout(null);
	
	    tablemodel = new DefaultTableModel(TABLE_COLUMNS,0);
		table = new JTable(tablemodel);
		scroll = new JScrollPane(table);
		scroll.setSize(650,200);
		scroll.setLocation(10,40);
		scroll.setVerticalScrollBarPolicy(scroll.VERTICAL_SCROLLBAR_ALWAYS);
		scroll.setHorizontalScrollBarPolicy(scroll.HORIZONTAL_SCROLLBAR_ALWAYS);
		n.add(scroll);
		
		add = new JButton("Add");
		add.setSize(100,50);
		add.setLocation(10,300);
		add.addActionListener(this);
		n.add(add);
		
		remove = new JButton("Remove");
		remove.setSize(100,50);
		remove.setLocation(150,300);
		remove.addActionListener(this);
		n.add(remove);
		
		clear = new JButton("Clear");
		clear.setSize(100,50);
		clear.setLocation(290,300);
		clear.addActionListener(this);
		n.add(clear);
		
		edit = new JButton("Edit");
		edit.setSize(100,50);
		edit.setLocation(425,300);
		edit.addActionListener(this);
		n.add(edit);
		
		save = new JButton("Save");
		save.setSize(100, 50);
		save.setLocation(560,300);
		save.addActionListener(this);
		n.add(save);
		
		open = new JButton("Open");
		open.setSize(100,50);
		open.setLocation(690,300);
		open.addActionListener(this);
		n.add(open);
		
		setSize(1000,1000);
		setVisible(true);
		
		
	}
	public void actionPerformed(ActionEvent e){
		if(e.getSource()==add){
			edited = false;
			TestDialog1 dialog = new TestDialog1(this,"Add User Information","");
			if(!dialog.isCancelled()){
				Vector row = new Vector();
				row.addElement(dialog.getJ());
				row.addElement(dialog.getName());
				row.addElement(dialog.getDriver());
				row.addElement(dialog.getJeeps());
				row.addElement(dialog.getCar());
				row.addElement(dialog.getStick());
				tablemodel.addRow(row);
			}
		}
		   if(e.getSource()==remove){
			   if(table.getSelectedRow() != -1){
				   tablemodel.removeRow(table.getSelectedRow());
			   }
			}
		   if(e.getSource()==edit){
			   edited = true;
			   int selected = table.getSelectedRow();
			   Vector row1 = new Vector();
			   a = tablemodel.getValueAt(selected, 0);
			   b = tablemodel.getValueAt(selected, 1);
			   c = tablemodel.getValueAt(selected, 2);
			   d = tablemodel.getValueAt(selected, 3);
			   k = tablemodel.getValueAt(selected, 4);
			   f = tablemodel.getValueAt(selected, 5);
			   TestDialog1 edit1 = new TestDialog1(this,"Edit","");
			   if(!edit1.isCancelled()){
				   row1.addElement(a);
				   row1.addElement(edit1.getName());
				   row1.addElement(edit1.getDriver());
				   row1.addElement(edit1.getJeeps());
				   row1.addElement(edit1.getCar());
				   row1.addElement(edit1.getStick());
				   tablemodel.removeRow(selected);
				   tablemodel.insertRow(selected, row1);
			   }
			  
			   
		   }
		   
		   if(e.getSource()==clear){
			   int count = tablemodel.getRowCount();
			   for(int m = count - 1; m >= 0; m--){
				   tablemodel.removeRow(m);
			   }
		   }
		}
		
		
	
	public static void main(String[] args){
	Window mainwindow = new Window();
	}
}