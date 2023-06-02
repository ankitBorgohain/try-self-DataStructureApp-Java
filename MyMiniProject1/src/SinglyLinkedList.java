
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

public class SinglyLinkedList extends JFrame {
	class Node{
		int data;
		Node link;	
	}

	private JPanel contentPane;
	private JTextField eleF;
	private JTextField eleR;
	private Node first;
	private JTextField displaybox;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SinglyLinkedList frame = new SinglyLinkedList();
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
	public SinglyLinkedList() throws UnsupportedAudioFileException, IOException, LineUnavailableException {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 709, 600);
		contentPane = new JPanel();
		contentPane.setForeground(new Color(0, 0, 0));
		contentPane.setBackground(new Color(169, 169, 169));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		//intro audio
				File file_intro=new File("Music/singlyIntro.wav");
				AudioInputStream audioStream = AudioSystem.getAudioInputStream(file_intro);
				Clip clip=AudioSystem.getClip();
				clip.open(audioStream);
				clip.start();
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel header = new JLabel("SINGLY LINKED LIST DATA STRUCTURE");
		header.setForeground(new Color(255, 255, 0));
		header.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.BOLD, 30));
		header.setBounds(95, 59, 659, 44);
		contentPane.add(header);
		
		JLabel lef = new JLabel("ENTER THE ELEMENT");
		lef.setBackground(new Color(0, 0, 0));
		lef.setForeground(new Color(0, 0, 0));
		lef.setFont(new Font("Trebuchet MS", Font.PLAIN, 19));
		lef.setBounds(41, 165, 178, 23);
		contentPane.add(lef);
		
		eleF = new JTextField();
		eleF.setBackground(SystemColor.inactiveCaption);
		eleF.setBounds(287, 165, 129, 30);
		contentPane.add(eleF);
		eleF.setColumns(10);
		
		JButton insFront = new JButton("INSERT@FRONT");
		insFront.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//insert front logic
				
				int ele=Integer.valueOf(eleF.getText());
				Node newnode=new Node();
				JOptionPane.showMessageDialog(contentPane,"Element is "+ele+ " inserted");
				newnode.data=ele;
				newnode.link=null;
				if(first==null){
					first=newnode;
				}else{

					newnode.link=first;
					first=newnode;
				}
			}
		});
		insFront.setForeground(new Color(255, 248, 220));
		insFront.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 17));
		insFront.setBackground(new Color(0, 202, 0));
		insFront.setBounds(492, 163, 145, 30);
		contentPane.add(insFront);
		
		JButton insRear = new JButton("INSERT@REAR");
		insRear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//insert rear logic
				Node temp;
				int ele = Integer.valueOf(eleR.getText());
				Node newnode = new Node();
				JOptionPane.showMessageDialog(contentPane,"New node created");
				newnode.data=ele;
				newnode.link=null;
				if(first==null){
					first=newnode;
				}else{
					
					temp=first;
					while(temp.link!=null){
						temp=temp.link;
						
					}
					temp.link=newnode;
				}
			}
		});
		insRear.setForeground(new Color(255, 248, 220));
		insRear.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 17));
		insRear.setBackground(new Color(0, 202, 0));
		insRear.setBounds(492, 113, 145, 30);
		contentPane.add(insRear);
		
		JButton delfrontbtn = new JButton("DELETE@FRONT");
		delfrontbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				// delete from front
				Node temp;
				if(first==null){
					JOptionPane.showMessageDialog(contentPane,"Deletion not possible, Linked List Empty");
					displaybox.setText("");
				}
				if(first.link==null)
				{
					JOptionPane.showMessageDialog(contentPane,"Deleted element is "+first.data);
					first=null;
					
				}else 
				{ 	
					JOptionPane.showMessageDialog(contentPane,"Deleted : "+String.valueOf(first.data));
				
					first=first.link;
					
					
					
				}
			}
		});
		delfrontbtn.setForeground(new Color(255, 248, 220));
		delfrontbtn.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 17));
		delfrontbtn.setBackground(new Color(255, 0, 0));
		delfrontbtn.setBounds(184, 314, 145, 38);
		contentPane.add(delfrontbtn);
		
		JButton delRearbtn = new JButton("DELETE@REAR");
		delRearbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// delete from rear
				Node temp;
				if(first==null){
					JOptionPane.showMessageDialog(contentPane,"Deletion not possible, Linked List Empty");
				}
				if(first.link==null){
					JOptionPane.showMessageDialog(contentPane,"Deleted element is "+first.data);
					first=null;
					
				}else{
					temp=first;
					while(temp.link.link!=null){
						temp=temp.link;
					}
					JOptionPane.showMessageDialog(contentPane,"Deleted element is "+temp.link.data);
					temp.link=null;
					
					System.out.println();
				}
			}
		});
		delRearbtn.setForeground(new Color(255, 248, 220));
		delRearbtn.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 17));
		delRearbtn.setBackground(new Color(255, 0, 0));
		delRearbtn.setBounds(357, 314, 145, 38);
		contentPane.add(delRearbtn);
		
		JButton displaybtn = new JButton("DISPLAY");
		displaybtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//display logic
				String msg="";
				Node temp;
				if(first==null){
					JOptionPane.showMessageDialog(contentPane,"Display not possible, Linked List Empty");
					displaybox.setText(String.valueOf(""));
				}
				else if(first.link==null){
					JOptionPane.showMessageDialog(contentPane,"Only Element is : "+first.data);
					displaybox.setText(String.valueOf(first.data));
				}else
				{
					temp=first;
					while(temp!=null){
						msg=msg+" "+temp.data;
						temp=temp.link;
					}
					displaybox.setText(msg);
				}
			}
		});
		displaybtn.setForeground(new Color(128, 128, 128));
		displaybtn.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 18));
		displaybtn.setBackground(new Color(255, 255, 0));
		displaybtn.setBounds(271, 408, 129, 38);
		contentPane.add(displaybtn);
		
		JLabel ler = new JLabel("ENTER THE ELEMENT");
		ler.setForeground(new Color(0, 0, 0));
		ler.setFont(new Font("Trebuchet MS", Font.PLAIN, 19));
		ler.setBackground(new Color(0, 0, 0));
		ler.setBounds(41, 113, 222, 32);
		contentPane.add(ler);
		
		eleR = new JTextField();
		eleR.setBackground(SystemColor.inactiveCaption);
		eleR.setColumns(10);
		eleR.setBounds(287, 113, 129, 30);
		contentPane.add(eleR);
		
		displaybox = new JTextField();
		displaybox.setBackground(SystemColor.inactiveCaption);
		displaybox.setBounds(197, 469, 292, 40);
		contentPane.add(displaybox);
		displaybox.setColumns(10);
		
		JButton btnNewButton = new JButton("BACK");
		btnNewButton.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 18));
		btnNewButton.setBackground(SystemColor.activeCaption);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//to go back
				setVisible(false);
			}
		});
		btnNewButton.setBounds(24, 25, 85, 21);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\Ankit\\Downloads\\pexels-gradienta-6985265.jpg"));
		lblNewLabel.setBounds(-63, -419, 1134, 1013);
		contentPane.add(lblNewLabel);
	}
}
