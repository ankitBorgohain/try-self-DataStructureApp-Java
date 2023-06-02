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
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.ImageIcon;

public class Array extends JFrame {

	private JPanel contentPane;
	private JTextField length;
	private JTextField element;
	private JTextField positionI;
	private JTextField deletepos;
	private JTextField displaybox;
	private int arr[];
	private final JLabel lblNewLabel = new JLabel("New label");

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Array frame = new Array();
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
	public Array() throws LineUnavailableException, UnsupportedAudioFileException, IOException {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 709, 600);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(238, 232, 170));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		File file_intro=new File("Music/arrayIntro.wav");
		AudioInputStream audioStream = AudioSystem.getAudioInputStream(file_intro);
		Clip clip=AudioSystem.getClip();
		clip.open(audioStream);
		clip.start();
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel header = new JLabel("ARRAY DATA STRUCTURE");
		header.setBackground(new Color(255, 255, 255));
		header.setForeground(new Color(230, 230, 230));
		header.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 27));
		header.setBounds(190, 26, 263, 30);
		contentPane.add(header);
		
		JLabel lsize = new JLabel("ENTER SIZE OF THE ARRAY");
		lsize.setForeground(new Color(255, 255, 255));
		lsize.setFont(new Font("Trebuchet MS", Font.PLAIN, 14));
		lsize.setBounds(111, 120, 168, 18);
		contentPane.add(lsize);
		
		length = new JTextField();
		length.setBackground(new Color(255, 234, 173));
		length.setBounds(329, 118, 96, 25);
		contentPane.add(length);
		length.setColumns(10);
		
		JButton createArayBtn = new JButton("CREATE ARRAY");
		createArayBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				//code to create the array
				arr=new int[Integer.valueOf(length.getText())];
				String message="Array of length "+length.getText()+" is created";
				JOptionPane.showMessageDialog(contentPane,message);
				
				
			}
		});
		createArayBtn.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.BOLD, 17));
		createArayBtn.setForeground(new Color(255, 255, 255));
		createArayBtn.setBackground(new Color(106, 181, 255));
		createArayBtn.setBounds(448, 113, 144, 30);
		contentPane.add(createArayBtn);
		
		JLabel le = new JLabel("ENTER INTEGER ELEMENT");
		le.setForeground(new Color(255, 255, 255));
		le.setFont(new Font("Trebuchet MS", Font.PLAIN, 14));
		le.setBounds(36, 213, 168, 26);
		contentPane.add(le);
		
		element = new JTextField();
		element.setBackground(new Color(255, 234, 173));
		element.setBounds(233, 215, 96, 25);
		contentPane.add(element);
		element.setColumns(10);
		
		JLabel lp = new JLabel("POSITION");
		lp.setForeground(new Color(255, 255, 255));
		lp.setFont(new Font("Trebuchet MS", Font.PLAIN, 14));
		lp.setBounds(366, 217, 59, 18);
		contentPane.add(lp);
		
		positionI = new JTextField();
		positionI.setBackground(new Color(255, 234, 173));
		positionI.setBounds(446, 215, 74, 25);
		contentPane.add(positionI);
		positionI.setColumns(10);
		
		JLabel ld = new JLabel("ENTER POSITION TO DELETE");
		ld.setForeground(new Color(255, 255, 255));
		ld.setFont(new Font("Trebuchet MS", Font.PLAIN, 14));
		ld.setBounds(50, 316, 178, 25);
		contentPane.add(ld);
		
		deletepos = new JTextField();
		deletepos.setBackground(new Color(255, 234, 173));
		deletepos.setBounds(276, 317, 79, 25);
		contentPane.add(deletepos);
		deletepos.setColumns(10);
		
		JButton btnNewButton = new JButton("DELETE");
		btnNewButton.setForeground(new Color(255, 234, 173));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			//code for deletion 
				int pos=Integer.valueOf(deletepos.getText());
				arr[pos]=0;
				String message="Element deleted at position "+pos;
				JOptionPane.showMessageDialog(contentPane,message);
				
			}
		});
		btnNewButton.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.ITALIC, 17));
		btnNewButton.setBackground(new Color(255, 69, 0));
		btnNewButton.setBounds(413, 312, 115, 30);
		contentPane.add(btnNewButton);
		
		displaybox = new JTextField();
		displaybox.setBackground(new Color(166, 255, 166));
		displaybox.setColumns(10);
		displaybox.setBounds(145, 474, 383, 27);
		contentPane.add(displaybox);
		
		JButton insert = new JButton("INSERT");
		insert.setForeground(new Color(0, 128, 0));
		insert.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//code for insertion
				int ele=Integer.valueOf(element.getText());
				int pos=Integer.valueOf(positionI.getText());
				arr[pos]=ele;
				String message="Element "+ele+" is inserted at pos "+pos;
				JOptionPane.showMessageDialog(contentPane,message);
				
			}
		});
		insert.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.ITALIC, 17));
		insert.setBackground(new Color(182, 253, 123));
		insert.setBounds(538, 210, 115, 30);
		contentPane.add(insert);
		
		JButton btnDisplay = new JButton("DISPLAY");
		btnDisplay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			//code for displaying
				String msg="";
				for(int i=0;i<=arr.length-1;i++) {
					msg= msg+" "+arr[i];
				}
				displaybox.setText(msg);
			}
		});
		btnDisplay.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.ITALIC, 17));
		btnDisplay.setBackground(new Color(0, 183, 0));
		btnDisplay.setBounds(263, 411, 120, 40);
		contentPane.add(btnDisplay);
		
		JButton back = new JButton("BACK");
		back.setForeground(new Color(255, 255, 255));
		back.setBackground(new Color(0, 0, 213));
		back.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.BOLD, 15));
		back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				//to go back
				setVisible(false);
			}
		});
		back.setBounds(10, 10, 74, 27);
		contentPane.add(back);
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\Ankit\\workspace\\MyMiniProject1\\src\\bg.jpg"));
		lblNewLabel.setBounds(-388, -786, 1083, 1349);
		contentPane.add(lblNewLabel);
	}
}
