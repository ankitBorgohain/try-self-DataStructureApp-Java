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

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.ImageIcon;

public class CircularQueue extends JFrame {

	private JPanel contentPane;
	private JTextField length;
	private JTextField element;
	private JTextField displaybox;
	private int arr[];
	private int size;
	private int r=-1;
	private int f=0;
	private int count =0;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CircularQueue frame = new CircularQueue();
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
	public CircularQueue() throws UnsupportedAudioFileException, IOException, LineUnavailableException {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 709, 600);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 228, 196));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		File file_intro=new File("Music/cQueueIntro.wav");
		AudioInputStream audioStream = AudioSystem.getAudioInputStream(file_intro);
		Clip clip=AudioSystem.getClip();
		clip.open(audioStream);
		clip.start();

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel header = new JLabel("CIRCULAR QUEUE");
		header.setBackground(new Color(255, 255, 255));
		header.setForeground(new Color(255, 128, 128));
		header.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.BOLD, 30));
		header.setBounds(193, 47, 253, 34);
		contentPane.add(header);
		
		JLabel ls = new JLabel("ENTER SIZE OF THE QUEUE :");
		ls.setForeground(new Color(192, 192, 192));
		ls.setFont(new Font("Tahoma", Font.PLAIN, 15));
		ls.setBounds(48, 112, 205, 17);
		contentPane.add(ls);
		
		length = new JTextField();
		length.setBackground(new Color(255, 255, 128));
		length.setBounds(271, 108, 50, 30);
		contentPane.add(length);
		length.setColumns(10);
		
		JButton createArraybtn = new JButton("CREATE ARRAY");
		createArraybtn.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 17));
		createArraybtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//code to create array
				size=Integer.valueOf(length.getText());
				arr=new int[size];
				JOptionPane.showMessageDialog(contentPane,"Array created of size "+size);
			}
		});
		createArraybtn.setBackground(new Color(30, 255, 30));
		createArraybtn.setForeground(new Color(0, 0, 0));
		createArraybtn.setBounds(215, 162, 183, 30);
		contentPane.add(createArraybtn);
		
		JLabel le = new JLabel("ENTER AN ELEMENT :");
		le.setForeground(new Color(192, 192, 192));
		le.setFont(new Font("Tahoma", Font.PLAIN, 15));
		le.setBounds(35, 258, 174, 17);
		contentPane.add(le);
		
		JButton insertbtn = new JButton("INSERT");
		insertbtn.setForeground(new Color(255, 255, 255));
		insertbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//code to insert
				if(count==size)
				{
					JOptionPane.showMessageDialog(contentPane,"insertion not possible, queue is full");
				}else{
					
					int ele=Integer.valueOf(element.getText());
					JOptionPane.showMessageDialog(contentPane,"Element entered is "+ele);
					r=(r+1)%size;
					arr[r]=ele;
					++count;
					
						}
			}
		});
		insertbtn.setBackground(new Color(66, 66, 255));
		insertbtn.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 19));
		insertbtn.setBounds(403, 246, 100, 38);
		contentPane.add(insertbtn);
		
		element = new JTextField();
		element.setBackground(new Color(128, 255, 128));
		element.setColumns(10);
		element.setBounds(249, 256, 96, 25);
		contentPane.add(element);
		
		JButton delbtn = new JButton("DELETE");
		delbtn.setForeground(new Color(26, 26, 26));
		delbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			//code to delete
				if(count==0) {
					JOptionPane.showMessageDialog(contentPane,"Deletion not possible, queue is empty");
					
				}else {
					JOptionPane.showMessageDialog(contentPane,"Deleted element is "+arr[f]);
					f=(f+1)%size;
					--count;
				}
			}
		});
		delbtn.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.BOLD, 19));
		delbtn.setBackground(new Color(255, 0, 0));
		delbtn.setBounds(249, 330, 100, 38);
		contentPane.add(delbtn);
		
		displaybox = new JTextField();
		displaybox.setBounds(171, 502, 250, 25);
		contentPane.add(displaybox);
		displaybox.setColumns(10);
		
		JButton btnDisplay = new JButton("DISPLAY");
		btnDisplay.setForeground(new Color(0, 0, 0));
		btnDisplay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//code to display
				String msg="";
				int f1=f;
				if(count==0){
					JOptionPane.showMessageDialog(contentPane,"Display not possible");
					displaybox.setText("");
				}else {
					for(int i=1;i<=count;i++){
						msg=msg+" "+arr[f1];
						f1=(f1+1)%size;
					}
					displaybox.setText(msg);
				}
				
			}
		});
		btnDisplay.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.BOLD, 19));
		btnDisplay.setBackground(new Color(255, 215, 0));
		btnDisplay.setBounds(226, 431, 151, 38);
		contentPane.add(btnDisplay);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setBackground(new Color(66, 66, 255));
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\Ankit\\Downloads\\wp4411816-gradient-rainbow-wallpapers.png"));
		lblNewLabel.setBounds(-514, -570, 1303, 1163);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("BACK");
		btnNewButton.setBackground(new Color(115, 185, 255));
		btnNewButton.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 19));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//to go back
				setVisible(false);
			}
		});
		btnNewButton.setBounds(10, 10, 85, 21);
		contentPane.add(btnNewButton);
	}

}
