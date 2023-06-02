

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.Color;
import java.awt.EventQueue;

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
import java.awt.SystemColor;

public class DoublyLinkedList extends JFrame {
	
	class Node{
		int data;
		Node prelink;
		Node nextlink;
	}
	
	private JPanel contentPane;
	private JTextField eler;
	private JTextField elef;
	private Node first;
	private JTextField displaybox;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DoublyLinkedList frame = new DoublyLinkedList();
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
	public DoublyLinkedList() throws UnsupportedAudioFileException, IOException, LineUnavailableException {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 709, 600);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(221, 160, 221));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		//audio
		File file_intro=new File("Music/DlinkedIntro.wav");
		AudioInputStream audioStream = AudioSystem.getAudioInputStream(file_intro);
		Clip clip=AudioSystem.getClip();
		clip.open(audioStream);
		clip.start();

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel header = new JLabel("DOUBLY LINKED LIST DATA STRUCTURE");
		header.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 27));
		header.setBounds(118, 34, 409, 30);
		contentPane.add(header);
		
		JLabel ler = new JLabel("ENTER THE ELEMENT :");
		ler.setForeground(new Color(64, 0, 0));
		ler.setFont(new Font("Trebuchet MS", Font.PLAIN, 17));
		ler.setBounds(22, 109, 185, 20);
		contentPane.add(ler);
		
		eler = new JTextField();
		eler.setBackground(new Color(255, 196, 196));
		eler.setBounds(222, 109, 96, 25);
		contentPane.add(eler);
		eler.setColumns(10);
		
		JButton insertRearbtn = new JButton("INSERT@REAR");
		insertRearbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//insert rear
				
				Node temp;
				
				int ele = Integer.valueOf(eler.getText());
				Node newnode = new Node();
				newnode.data=ele;
				newnode.prelink=null; 
				newnode.nextlink = null;
				if(first==null){
					first=newnode;
					JOptionPane.showMessageDialog(contentPane,"Node has been created");
					
				}else
				{
					temp=first;
					while(temp.nextlink!=null)
					{
						temp=temp.nextlink;
					}
					temp.nextlink=newnode;
					newnode.prelink=temp;
					JOptionPane.showMessageDialog(contentPane,"For Element "+newnode.data+" . Node has been created");
				}
			}
		});
		insertRearbtn.setForeground(new Color(0, 0, 0));
		insertRearbtn.setBackground(new Color(0, 198, 0));
		insertRearbtn.setFont(new Font("Tahoma", Font.BOLD, 14));
		insertRearbtn.setBounds(361, 100, 213, 38);
		contentPane.add(insertRearbtn);
		
		JLabel lef = new JLabel("ENTER THE ELEMENT :");
		lef.setForeground(new Color(64, 0, 0));
		lef.setFont(new Font("Trebuchet MS", Font.PLAIN, 17));
		lef.setBounds(22, 167, 173, 20);
		contentPane.add(lef);
		
		elef = new JTextField();
		elef.setBackground(new Color(255, 196, 196));
		elef.setColumns(10);
		elef.setBounds(222, 167, 96, 25);
		contentPane.add(elef);
		
		JButton insertFrontbtn = new JButton("INSERT@FRONT");
		insertFrontbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// logic to insert front of DLL
				
				int ele = Integer.valueOf(elef.getText());
				Node newnode = new Node();
				newnode.data=ele;
				newnode.prelink=null; 
				newnode.nextlink = null;
				if(first==null){
					first=newnode;
					JOptionPane.showMessageDialog(contentPane,"Node has been created");

				}else
				{
					newnode.nextlink=first;
					first.prelink=newnode;
					first=newnode;
					JOptionPane.showMessageDialog(contentPane,"New Node of value "+first.data+" has been added");
				}
				
				
			}
		});
		insertFrontbtn.setForeground(Color.BLACK);
		insertFrontbtn.setFont(new Font("Tahoma", Font.BOLD, 14));
		insertFrontbtn.setBackground(new Color(0, 204, 0));
		insertFrontbtn.setBounds(361, 158, 213, 38);
		contentPane.add(insertFrontbtn);
		
		JButton delRear = new JButton("DELETE@REAR");
		delRear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				//logic to delete rear
				Node temp;
				if(first==null){
					JOptionPane.showMessageDialog(contentPane,"Deletion not possible");
				}else if(first.nextlink==null){
					JOptionPane.showMessageDialog(contentPane,"Element deleted is : "+first.data);
					first=null;
				}else{
					temp=first;
					while(temp.nextlink.nextlink!=null)
					{
						temp=temp.nextlink;
					}
					
					JOptionPane.showMessageDialog(contentPane,"Deleted element is : "+temp.nextlink.data);
					
					temp.nextlink=null;
				}
			}
		});
		delRear.setForeground(Color.BLACK);
		delRear.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 18));
		delRear.setBackground(new Color(236, 0, 0));
		delRear.setBounds(106, 360, 213, 38);
		contentPane.add(delRear);
		
		JButton delFront = new JButton("DELETE@FRONT");
		delFront.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(first==null){
					JOptionPane.showMessageDialog(contentPane,"Deletion not possible");
				}
				else if( first.nextlink==null){
					JOptionPane.showMessageDialog(contentPane,"Element deleted is : "+first.data);
					first=null;
				}else{
					JOptionPane.showMessageDialog(contentPane,"Element deleted is : "+first.data);
					first=first.nextlink;
					first.prelink=null;
				}
			}
		});
		delFront.setForeground(Color.BLACK);
		delFront.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 18));
		delFront.setBackground(new Color(255, 0, 0));
		delFront.setBounds(361, 360, 213, 38);
		contentPane.add(delFront);
		
		JButton displayfwdbtn = new JButton("DISPLAY FORWARD");
		displayfwdbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//logic for fwd display
				String msg="";
				Node temp;
				if(first==null){
					JOptionPane.showMessageDialog(contentPane,"disp not possible");
					displaybox.setText("");
				}else if(first.nextlink==null){
					displaybox.setText(String.valueOf(first.data));
				}else{
					temp=first;
					while(temp!=null){
						msg=msg+" "+temp.data;
						
						temp=temp.nextlink;
					}System.out.println();
					displaybox.setText(msg);
				}
			}
		});
		displayfwdbtn.setForeground(Color.BLACK);
		displayfwdbtn.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 18));
		displayfwdbtn.setBackground(new Color(100, 149, 237));
		displayfwdbtn.setBounds(106, 440, 213, 38);
		contentPane.add(displayfwdbtn);
		
		JButton displayrevbtn = new JButton("DISPLAY REVERSE");
		displayrevbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//logic for rever display
				String msg="";
				Node temp;
				if(first==null){
					JOptionPane.showMessageDialog(contentPane,"Display not possible");
					displaybox.setText("");
				}else if(first.nextlink==null){
					JOptionPane.showMessageDialog(contentPane,"The element that is availabe is :"+first.data);
					displaybox.setText(String.valueOf(first.data));
				}else{
					temp=first;
					while(temp.nextlink!=null){
						
						temp=temp.nextlink;
					}
					while(temp!=null){
						msg=msg+" "+temp.data;
						temp=temp.prelink;
					}displaybox.setText(msg);
			}
			}
		});
		displayrevbtn.setForeground(new Color(255, 255, 255));
		displayrevbtn.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 18));
		displayrevbtn.setBackground(new Color(0, 0, 255));
		displayrevbtn.setBounds(361, 440, 213, 38);
		contentPane.add(displayrevbtn);
		
		displaybox = new JTextField();
		displaybox.setBackground(new Color(128, 255, 128));
		displaybox.setBounds(222, 499, 240, 30);
		contentPane.add(displaybox);
		displaybox.setColumns(10);
		
		JButton btnNewButton = new JButton("BACK");
		btnNewButton.setBackground(SystemColor.menu);
		btnNewButton.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 19));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//to go back
				setVisible(false);
			}
		});
		btnNewButton.setBounds(10, 10, 85, 21);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\Ankit\\Downloads\\wp11117421-fluffy-clouds-wallpapers.jpg"));
		lblNewLabel.setBounds(-188, -16, 1172, 949);
		contentPane.add(lblNewLabel);
	}

}
