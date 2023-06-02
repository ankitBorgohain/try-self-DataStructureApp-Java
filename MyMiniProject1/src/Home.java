import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
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

@SuppressWarnings("serial")
public class Home extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					
					Home frame = new Home();
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
	public Home() throws LineUnavailableException, IOException, UnsupportedAudioFileException {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 709, 600);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(154, 205, 50));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		//for the welcome audio
		File file_intro=new File("Music/w_Audio.wav");
		AudioInputStream audioStream = AudioSystem.getAudioInputStream(file_intro);
		Clip clip=AudioSystem.getClip();
		clip.open(audioStream);
		clip.start();

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel header = new JLabel("CHOOSE A DATA STRUCTURE");
		header.setBounds(160, 37, 421, 74);
		header.setForeground(Color.ORANGE);
		header.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 37));
		contentPane.add(header);
		
		JButton stack = new JButton("STACK");
		stack.setBackground(new Color(206, 255, 10));
		stack.setBounds(57, 290, 180, 60);
		stack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					new Stack().setVisible(true);
				} catch (UnsupportedAudioFileException | IOException | LineUnavailableException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		stack.setForeground(new Color(133, 133, 133));
		stack.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 25));
		contentPane.add(stack);
		
		JButton q = new JButton("QUEUE");
		q.setBackground(new Color(0, 64, 128));
		q.setBounds(461, 136, 180, 60);
		q.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					new Queue().setVisible(true);
				} catch (LineUnavailableException | UnsupportedAudioFileException | IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		q.setForeground(new Color(255, 234, 173));
		q.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 25));
		contentPane.add(q);
		
		JButton ll = new JButton("SINGLY LINKED LIST");
		ll.setBackground(new Color(128, 128, 255));
		ll.setBounds(57, 455, 180, 60);
		ll.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//logic to attach the tow frames by creating an object of the class 
				try {
					new SinglyLinkedList().setVisible(true);
				} catch (UnsupportedAudioFileException | IOException | LineUnavailableException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		ll.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 18));
		ll.setForeground(new Color(255, 234, 173));
		contentPane.add(ll);
		
		JButton dll = new JButton("DOUBLY LINKED LIST");
		dll.setBackground(new Color(255, 128, 0));
		dll.setBounds(461, 455, 180, 60);
		dll.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//logic to attach the two frames by creating an object of the class 
				try {
					new DoublyLinkedList().setVisible(true);
				} catch (UnsupportedAudioFileException | IOException | LineUnavailableException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		dll.setForeground(new Color(128, 64, 64));
		dll.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 17));
		contentPane.add(dll);
		
		JButton array = new JButton("ARRAY");
		array.setBackground(new Color(0, 255, 128));
		array.setBounds(57, 136, 180, 60);
		array.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//Place ARRAY WINDOW OPENING
//				Array a=new Array();
//				a.setVisible(true);
				try {
					new Array().setVisible(true);
				} catch (LineUnavailableException | UnsupportedAudioFileException | IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		array.setForeground(new Color(133, 133, 133));
		array.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 25));
		contentPane.add(array);
		
		JButton circularq = new JButton("CIRCULAR QUEUE");
		circularq.setBackground(new Color(255, 209, 71));
		circularq.setBounds(461, 291, 180, 60);
		circularq.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					new CircularQueue().setVisible(true);
				} catch (UnsupportedAudioFileException | IOException | LineUnavailableException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		circularq.setForeground(new Color(128, 64, 64));
		circularq.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 20));
		contentPane.add(circularq);
		
		JLabel bg = new JLabel("New label");
		bg.setIcon(new ImageIcon("C:\\Users\\Ankit\\workspace\\MyMiniProject1\\src\\123.jpg"));
		bg.setBounds(0, 0, 695, 561);
		contentPane.add(bg);
	}
}
