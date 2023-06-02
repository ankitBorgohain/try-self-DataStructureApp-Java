import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.awt.event.ActionEvent;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.ImageIcon;

public class Queue extends JFrame {

	private JPanel contentPane;
	private JTextField length;
	private JTextField element;
	private int arr[];
	private int size;
	private int f=0;
	private int r=-1;
	private JTextField displaybox;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Queue frame = new Queue();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @throws LineUnavailableException 
	 * @throws IOException 
	 * @throws UnsupportedAudioFileException 
	 */
	public Queue() throws LineUnavailableException, UnsupportedAudioFileException, IOException {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 709, 600);
		contentPane = new JPanel();
		contentPane.setForeground(new Color(210, 180, 140));
		contentPane.setBackground(new Color(255, 235, 205));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		//intro audio
			File file_intro=new File("Music/qIntro.wav");
			AudioInputStream audioStream = AudioSystem.getAudioInputStream(file_intro);
			Clip clip=AudioSystem.getClip();
			clip.open(audioStream);
			clip.start();
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel header = new JLabel("QUEUE DATA STRUCTURE");
		header.setForeground(new Color(181, 0, 0));
		header.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 30));
		header.setBounds(191, 57, 282, 34);
		contentPane.add(header);
		
		JLabel ls = new JLabel("ENTER SIZE OF QUEUE");
		ls.setForeground(new Color(45, 45, 45));
		ls.setFont(new Font("Trebuchet MS", Font.PLAIN, 14));
		ls.setBounds(66, 131, 160, 25);
		contentPane.add(ls);
		
		length = new JTextField();
		length.setBackground(new Color(255, 255, 140));
		length.setBounds(256, 124, 100, 24);
		contentPane.add(length);
		length.setColumns(10);
		
		JLabel le = new JLabel("ENTER THE ELEMENT");
		le.setForeground(new Color(45, 45, 45));
		le.setFont(new Font("Bahnschrift", Font.PLAIN, 14));
		le.setBounds(66, 189, 148, 25);
		contentPane.add(le);
		
		element = new JTextField();
		element.setBackground(new Color(255, 255, 140));
		element.setColumns(10);
		element.setBounds(256, 189, 100, 24);
		contentPane.add(element);
		
		JButton btnNewButton = new JButton("INSERT");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//code to insert
				int ele;
				if(r==size-1){
					
					JOptionPane.showMessageDialog(contentPane,"Insertion not possible, Queue is full");
				}else{
				
				ele=Integer.valueOf(element.getText());
				++r;
				arr[r]=ele;
				JOptionPane.showMessageDialog(contentPane,"Element "+ele+" is inserted");
				}
				
			}
		});
		btnNewButton.setForeground(new Color(222, 222, 222));
		btnNewButton.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 20));
		btnNewButton.setBackground(new Color(62, 62, 255));
		btnNewButton.setBounds(395, 182, 100, 30);
		contentPane.add(btnNewButton);
		
		JButton btnDeleteEmementsFrom = new JButton("DELETE EMEMENTS FROM QUEUE");
		btnDeleteEmementsFrom.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//code to delete
				if(r==-1||f>r){
					JOptionPane.showMessageDialog(contentPane,"Deletion not possible, Queue is empty");
					displaybox.setText("");
				}else{
					JOptionPane.showMessageDialog(contentPane,"Deleted element is "+arr[f]);
					++f;
				}
				
			}
		});
		btnDeleteEmementsFrom.setForeground(new Color(250, 235, 215));
		btnDeleteEmementsFrom.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 17));
		btnDeleteEmementsFrom.setBackground(new Color(240, 4, 4));
		btnDeleteEmementsFrom.setBounds(201, 249, 255, 30);
		contentPane.add(btnDeleteEmementsFrom);
		
		JButton btnDisplay = new JButton("DISPLAY");
		btnDisplay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//code to display
				String msg="";
				if(r==-1||f>r){
					JOptionPane.showMessageDialog(contentPane,"Display not possible, Queue is empty");
				}else{
					for(int i=f;i<=r;i++){
						msg=msg+" "+arr[i];
					}displaybox.setText(msg);
				}
			}
		});
		btnDisplay.setForeground(new Color(250, 235, 215));
		btnDisplay.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 17));
		btnDisplay.setBackground(new Color(0, 100, 0));
		btnDisplay.setBounds(66, 393, 109, 30);
		contentPane.add(btnDisplay);
		
		JButton create = new JButton("CREATE");
		create.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//code to create the queue
				size=Integer.valueOf(length.getText());
				arr=new int [size];
				JOptionPane.showMessageDialog(contentPane,"array of size "+size+" is created");
				
				
			}
		});
		create.setForeground(new Color(74, 74, 74));
		create.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 20));
		create.setBackground(new Color(255, 255, 0));
		create.setBounds(395, 118, 100, 30);
		contentPane.add(create);
		
		displaybox = new JTextField();
		displaybox.setBackground(new Color(166, 255, 166));
		displaybox.setBounds(201, 393, 260, 30);
		contentPane.add(displaybox);
		displaybox.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\Ankit\\Downloads\\wp2885522-html5-background-wallpaper.jpg"));
		lblNewLabel.setBounds(-781, -784, 1542, 1347);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton_1 = new JButton("BACK");
		btnNewButton_1.setBackground(new Color(232, 208, 255));
		btnNewButton_1.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 19));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//to go back
				setVisible(false);
			}
		});
		btnNewButton_1.setBounds(10, 10, 85, 21);
		contentPane.add(btnNewButton_1);
	}

}
