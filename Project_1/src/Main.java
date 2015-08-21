import java.awt.*;
import java.io.*;
import java.util.*;
import java.util.List;

import javax.imageio.*;
import javax.swing.*;
public class Main {
	public static void main(String[] args) {
		File file = new File(System.getProperty("user.dir")+ "/bin/truchet.txt");
		try {
			Scanner scanner = new Scanner(file);
			List <Integer> array = new ArrayList<Integer>();
			int i = 0;
			while (i < 2) {
				try {
					int num = scanner.nextInt();
					array.add(num);
				} catch (NoSuchElementException d) {
					break;
				}
			}
			System.out.println(array);

		} catch (FileNotFoundException e) {
			System.out.println("Error File Not Found.");
			
		}
		JFrame frame = new JFrame("Truchet_Tiling");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JLabel whiteLabel = new JLabel();
		whiteLabel.setBackground(new Color(0, 0, 0));
		whiteLabel.setPreferredSize(new Dimension(1000, 1000));
		
		JLabel emptyBorder = new JLabel();

		frame.getContentPane().add(whiteLabel, BorderLayout.CENTER);
		File image1 = new File(System.getProperty("user.dir")+"/bin/Tile1_1.png");
		File image2 = new File(System.getProperty("user.dir")+"/bin/Tile1_2.png");
		File image3 = new File(System.getProperty("user.dir")+"/bin/Tile2_1.png");
		File image4 = new File(System.getProperty("user.dir")+"/bin/Tile2_2.png");
		File image5 = new File(System.getProperty("user.dir")+"/bin/Tile3_1.png");
		File image6 = new File(System.getProperty("user.dir")+"/bin/Tile3_2.png");
		int j = 4;
		while(j != 0){
		try {
			Image img1_1 = ImageIO.read(image1);
			JLabel label = new JLabel(new ImageIcon(img1_1));
			frame.add(label,BorderLayout.SOUTH);
			frame.setBounds(10,10,30,30);
		} catch (IOException c) {
			System.out.println("IOException");
			
		}
		try {
			Image img1_1 = ImageIO.read(image1);
			JLabel label = new JLabel(new ImageIcon(img1_1));
			frame.add(label,BorderLayout.EAST);
			frame.setBounds(10,10,30,30);
		} catch (IOException c) {
			System.out.println("IOException");
		}
		try {
			Image img1_2 = ImageIO.read(image2);
			frame.add(new JLabel(new ImageIcon(img1_2)));
			frame.setBounds(100, 100, 30, 30);
		} catch (IOException f) {
			System.out.println("IOException");
			
			
		}
		j = j -1;
		frame.pack();
		frame.setVisible(true);
	}
}
}
	

