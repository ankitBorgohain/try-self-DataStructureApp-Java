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
import java.awt.event.ActionEvent;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.ImageIcon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;

public class Stack extends JFrame {

	private JPanel contentPane;
	private JTextField length;
	private JTextField element;
	private int arr[];
	private int size;
	private int top=-1;
	private JTextField displaybox;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Stack frame = new Stack();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @throws IOException 
	 * @throws UnsupportedAudioFileException 
	 * @throws LineUnavailableException 
	 */
	public Stack() throws UnsupportedAudioFileException, IOException, LineUnavailableException {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 709, 600);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(238, 232, 170));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		//intro audio
			File file_intro=new File("Music/stackIntro.wav");
			AudioInputStream audioStream = AudioSystem.getAudioInputStream(file_intro);
			Clip clip=AudioSystem.getClip();
			clip.open(audioStream);
			clip.start();

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel header = new JLabel("STACK DATA STRUCTURE");
		header.setForeground(new Color(255, 192, 4));
		header.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 30));
		header.setBounds(186, 46, 287, 30);
		contentPane.add(header);
		
		JLabel ls = new JLabel("ENTER STACK SIZE");
		ls.setFont(new Font("Trebuchet MS", Font.PLAIN, 15));
		ls.setForeground(new Color(26, 26, 26));
		ls.setBounds(130, 132, 143, 30);
		contentPane.add(ls);
		
		length = new JTextField();
		length.setBackground(new Color(226, 255, 111));
		length.setBounds(302, 137, 100, 25);
		contentPane.add(length);
		length.setColumns(10);
		
		JLabel le = new JLabel("ENTER ELEMENT");
		le.setForeground(new Color(26, 26, 26));
		le.setFont(new Font("Trebuchet MS", Font.PLAIN, 15));
		le.setBounds(146, 230, 126, 30);
		contentPane.add(le);
		
		element = new JTextField();
		element.setBackground(new Color(226, 255, 111));
		element.setColumns(10);
		element.setBounds(302, 235, 100, 25);
		contentPane.add(element);
		
		JButton pushbtn = new JButton("PUSH");
		pushbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//code to push element into the stack
				int ele=Integer.valueOf(element.getText());
				if(top==size-1){
					String message="PUSH Not possible. Stack is full";
					JOptionPane.showMessageDialog(contentPane,message);
					
				}else {
					++top;
					arr[top]=ele;
					String message="Element "+ele+" pushed succesfully";
					JOptionPane.showMessageDialog(contentPane,message);
				}
				
				
			}
		});
		pushbtn.setForeground(new Color(253, 245, 230));
		pushbtn.setFont(new Font("Tw Cen MT Condensed", Font.BOLD, 17));
		pushbtn.setBackground(new Color(0, 0, 128));
		pushbtn.setBounds(285, 279, 135, 30);
		contentPane.add(pushbtn);
		
		JButton popbtn = new JButton("POP");
		popbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//code to pop element out of stack
				if(top==-1) {
					String message="POP Not possible. Stack is empty";
					JOptionPane.showMessageDialog(contentPane,message);
				}else {
					String message="pop element is "+arr[top];
					JOptionPane.showMessageDialog(contentPane,message);
					--top;
					
				}
			}
		});
		popbtn.setForeground(new Color(253, 245, 230));
		popbtn.setFont(new Font("Tw Cen MT Condensed", Font.BOLD, 17));
		popbtn.setBackground(new Color(255, 0, 0));
		popbtn.setBounds(285, 332, 135, 30);
		contentPane.add(popbtn);
		
		JButton displaybtn = new JButton("DISPLAY");
		displaybtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String msg="";
				
				//code to display
				if(top==-1){
					JOptionPane.showMessageDialog(contentPane, "Display not possible, stack is empty");
					displaybox.setText("");
				}else{
					for(int i=top;i>=0;i--){
						msg=msg+" "+arr[i];
					}
					displaybox.setText(msg);
				}
			} 
		});
		displaybtn.setForeground(new Color(253, 245, 230));
		displaybtn.setFont(new Font("Tw Cen MT Condensed", Font.BOLD, 17));
		displaybtn.setBackground(new Color(0, 202, 0));
		displaybtn.setBounds(306, 430, 96, 30);
		contentPane.add(displaybtn);
		
		JButton createStack = new JButton("CREATE STACK");
		createStack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//Code to create a new stack
				size=Integer.valueOf(length.getText());
				arr=new int[size];
				size=arr.length;			
				String message="Stack of size "+size+" is created";
				JOptionPane.showMessageDialog(contentPane,message);	
			}
		});
		createStack.setForeground(new Color(0, 0, 0));
		createStack.setFont(new Font("Tw Cen MT Condensed", Font.BOLD, 17));
		createStack.setBackground(new Color(255, 215, 0));
		createStack.setBounds(285, 184, 135, 30);
		contentPane.add(createStack);
		
		displaybox = new JTextField();
		displaybox.setBackground(new Color(226, 255, 111));
		displaybox.setBounds(177, 484, 384, 30);
		contentPane.add(displaybox);
		displaybox.setColumns(10);
		
		JLabel bg = new JLabel("BACK");
		bg.setIcon(new ImageIcon("C:\\Users\\Ankit\\Downloads\\bg123.png"));
		bg.setBounds(-1316, -1133, 2237, 1945);
		contentPane.add(bg);
		
		JButton btnNewButton = new JButton("BACK");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//to go back
				setVisible(false);
			}
		});
		btnNewButton.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 17));
		btnNewButton.setBackground(new Color(189, 222, 255));
		btnNewButton.setBounds(10, 10, 85, 21);
		contentPane.add(btnNewButton);
	}
}
