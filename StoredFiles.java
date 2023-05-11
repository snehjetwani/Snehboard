//imports
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class StoredFiles implements java.io.Serializable {
	//instance
	public ArrayList<String> fileNames;
	//files inputted by user are reloaded when app is opened
	public StoredFiles() {
		fileNames = loadList();
	}
	public void addFile(String path) {
		fileNames.add(path);
	}
	//when app is closed, user-inputted files are stored in a folder called soundboardfiles in the user's home
	public void saveList() {
		try {
	         FileOutputStream fileOut = new FileOutputStream(System.getProperty("user.home") + "/soundboardfiles/list.bin");
	         ObjectOutputStream out = new ObjectOutputStream(fileOut);
	         out.writeObject(this);
	         out.close();
	         fileOut.close();
		} catch (Exception e) {
			File directory = new File(System.getProperty("user.home") + "/soundboardfiles");
			directory.mkdir();
			saveList();
		}
	}
	//when app is reopened, files in soundboardfiles are loaded in the combo box
	public ArrayList<String> loadList() {
		ArrayList<String> fileNames = null;
		try {
	         FileInputStream fileIn = new FileInputStream(System.getProperty("user.home") + "/soundboardfiles/list.bin");
	         ObjectInputStream in = new ObjectInputStream(fileIn);
	         fileNames = ((StoredFiles) in.readObject()).fileNames;
	         in.close();
	         fileIn.close();
	 //if there are no files from the user from the last session, introduce a new arraylist for inputted files
	      } catch (Exception notFound) {
	    	  fileNames = new ArrayList<String>();
	      }
		return fileNames;
	}

}