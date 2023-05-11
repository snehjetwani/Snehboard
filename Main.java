//imports
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.BorderLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JFileChooser;
import java.awt.Button;
import java.awt.Color;
import javax.swing.JList;
import javax.swing.JComboBox;

public class Main {
	//instances
	private static ArrayList<String> files;
	private static StoredFiles stored;
	private static JComboBox FileList;
	private static JFrame frame;

	//opens app
	public static void main(String[] args) {
		//retrieve files from previous sessions
		stored = new StoredFiles();
		files = stored.fileNames;
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main window = new Main();
					window.frame.setVisible(true);
					frame.addWindowListener(new WindowAdapter() {
					    public void windowClosing(WindowEvent e) {
					    	//when app is closed, all custom songs are saved
					        stored.saveList();
					    }
					});
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public Main() {
		initialize();
	}
	///initialize the contents of the frame.
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("Snehboard"); //frame title
		frame.setBounds(100, 100, 426, 300); //frame size
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //closing procedure
		frame.getContentPane().setBackground(Color.RED); //frame color
		
		//setting up "Ahem" button
		JButton btnAhem = new JButton("Ahem");
		btnAhem.setBounds(6, 6, 130, 52);
		btnAhem.addActionListener(new ActionListener() {

			@Override
			//click method
			public void actionPerformed(ActionEvent e) {
				try{
					//ahem sound is retrieved from src using filePath
		            SimpleAudioPlayer.filePath = "src/sounds/cough.wav";
		            SimpleAudioPlayer audioPlayer = 
		                            new SimpleAudioPlayer();
		              //play sound command
		            audioPlayer.play();
		            //sleep until the sound is done
		            Thread.sleep((long) SimpleAudioPlayer.lengthInMillis());
		            audioPlayer.gotoChoice(4);
		        } 
		          //if sound doesn't work, display error
		        catch (Exception ex) {
		            System.out.println("Error with playing sound.");
		            ex.printStackTrace();
		          }
			}
		});
		frame.getContentPane().setLayout(null);
		frame.getContentPane().add(btnAhem);
		//setting up "Spring" button
		JButton btnSpring = new JButton("Spring");
		btnSpring.setBounds(148, 6, 130, 52);
		btnSpring.addActionListener(new ActionListener() {

			@Override
			//click method
			public void actionPerformed(ActionEvent e) {
				try{
					//spring sound is retrieved from src using filePath
		            SimpleAudioPlayer.filePath = "src/sounds/spring.wav";
		            SimpleAudioPlayer audioPlayer = 
		                            new SimpleAudioPlayer();
		              //play sound command
		            audioPlayer.play();
		            //sleep until the sound is done
		            Thread.sleep((long) SimpleAudioPlayer.lengthInMillis());
		            audioPlayer.gotoChoice(4); 
		        } 
				//if sound doesn't work, display error message
		        catch (Exception ex) {
		            System.out.println("Error with playing sound.");
		            ex.printStackTrace();
		          }
			}
		});
		frame.getContentPane().add(btnSpring);
		//setting up "Boom" sound
		JButton btnBoom = new JButton("Boom");
		btnBoom.setBounds(290, 6, 130, 52);
		btnBoom.addActionListener(new ActionListener() {

			@Override
			//click method
			public void actionPerformed(ActionEvent e) {
				try{
					//boom sound is retrieved from src using filePath
		            SimpleAudioPlayer.filePath = "src/sounds/boom.wav";
		            SimpleAudioPlayer audioPlayer = 
		                            new SimpleAudioPlayer();
		            //play sound command  
		            audioPlayer.play();
		            //sleep until the sound is done
		            Thread.sleep((long) SimpleAudioPlayer.lengthInMillis());
		            audioPlayer.gotoChoice(4);    
		        } 
		        //if sound doesn't work, display error
		        catch (Exception ex) {
		            System.out.println("Error with playing sound.");
		            ex.printStackTrace();
		          }
			}
		});
		frame.getContentPane().add(btnBoom);
		//setting up "Sheep" sound
		JButton btnSheep = new JButton("Sheep");
		btnSheep.setBounds(6, 70, 130, 52);
		btnSheep.addActionListener(new ActionListener() {

			@Override
			//click method
			public void actionPerformed(ActionEvent e) {
				try{
					//sheep sound is retrieved from src using filePath
		            SimpleAudioPlayer.filePath = "src/sounds/sheep.wav";
		            SimpleAudioPlayer audioPlayer = 
		                            new SimpleAudioPlayer();
		            //play sound command
		            audioPlayer.play();
		            //sleep until the sound is done
		            Thread.sleep((long) SimpleAudioPlayer.lengthInMillis());
		            audioPlayer.gotoChoice(4);
		        } 
		        //if sound doesn't work, display error
		        catch (Exception ex) {
		            System.out.println("Error with playing sound.");
		            ex.printStackTrace();
		          }
			}
		});
		frame.getContentPane().add(btnSheep);
		//setting up "Sneeze" sound
		JButton btnSneeze = new JButton("Sneeze");
		btnSneeze.setBounds(148, 70, 130, 52);
		btnSneeze.addActionListener(new ActionListener() {

			@Override
			//click method
			public void actionPerformed(ActionEvent e) {
				try{
					//sneeze sound is retrieved from src using filePath
		            SimpleAudioPlayer.filePath = "src/sounds/sneeze.wav";
		            SimpleAudioPlayer audioPlayer = 
		                            new SimpleAudioPlayer();
		              //play sound command
		            audioPlayer.play();
		            //sleep until the sound is done
		            Thread.sleep((long) SimpleAudioPlayer.lengthInMillis());
		            audioPlayer.gotoChoice(4);
		        } 
		        //if sound doesn't work, display error  
		        catch (Exception ex) {
		        	//if sound doesn't work, display error
		            System.out.println("Error with playing sound.");
		            ex.printStackTrace();
		          }
			}
		});
		frame.getContentPane().add(btnSneeze);
		//creating a combo box to display custom uploaded songs by user
		FileList = new JComboBox();
		FileList.setBounds(6, 222, 105, 27);
		//for-each loop to add user-uploaded files from the array, files, to combo box, fileList
		for (String file : files) {
			FileList.addItem(file);
		}
		frame.getContentPane().add(FileList);
		//setting up "Upload" button
		JButton btnUpload = new JButton("Upload");
		btnUpload.setBounds(303, 221, 117, 29);
		btnUpload.addActionListener(new ActionListener() {
			
			@Override
			//click method
			public void actionPerformed(ActionEvent e) {
				//window that opens up when upload is clicked. it displays a text field for the filePath and instructions
				String input = new JOptionPane().showInputDialog("Please Enter The File Path To Your Custom Sound");
				//if there is an input, it is stored in the combo box
				if (input != null) {
					try {
						stored.addFile(input);
						files = stored.fileNames;
						FileList.removeAllItems();
						for (String file : files) {
							FileList.addItem(file);
						}
					//do nothing if there is no input
					} catch (Exception noExistingFile) {
				}
			}	
		}
	});
		frame.getContentPane().add(btnUpload);
		//setting up "Play Sound" button
		JButton btnPlayCustom = new JButton("Play Sound");
		btnPlayCustom.setBounds(111, 221, 117, 29);
		btnPlayCustom.addActionListener(new ActionListener() {

			@Override
			//click method
			public void actionPerformed(ActionEvent e) {
				try{
					//convert user-selected file path to string
		            SimpleAudioPlayer.filePath = FileList.getSelectedItem().toString();
		            SimpleAudioPlayer audioPlayer = 
		                            new SimpleAudioPlayer();
		            //play the user-selected sound
		            audioPlayer.play();
		            //sleep until the sound is done
		            Thread.sleep((long) SimpleAudioPlayer.lengthInMillis());
		            audioPlayer.gotoChoice(4);  
		        } catch (Exception ex){
		        	//if the user-inputted file path is not a .wav file, show an error message dialog
				JOptionPane.showMessageDialog(null, "Error: Your file either does not exist or is unsupported");
		        }
			}
		});
		frame.getContentPane().add(btnPlayCustom);
		
		
		
		
	}
}
