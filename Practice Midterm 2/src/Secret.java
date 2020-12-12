import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class Secret {
	public static String readSecretFromFile(String filename) throws UnsupportedFileException
	{
		File f = new File(filename); 
	    FileReader fr = null;
		try {
			fr = new FileReader(f);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    BufferedReader bfr = new BufferedReader(fr);
	    String line = null;
	    String secrets = "";
	    String messaged = "";
	    int num;
	    try {
			line = bfr.readLine();
			num = Integer.parseInt(line);
			while (line != null) {
	            
	            try {
	    			line = bfr.readLine();
	    			secrets += line;
	    		} catch (IOException e) {
	    			e.printStackTrace();
	    		}
	        }
			messaged = changeText(false, num, secrets);
		} catch (NumberFormatException e) {
			// not an integer!
		} catch (IOException e) {
			e.printStackTrace();
		}
        
        try {
			bfr.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return messaged;
        
	}
	public static void writeSecretToFile(int shift, String message, String filename)
	{
		File f = new File(filename);
	    FileOutputStream fos;
		try {
			fos = new FileOutputStream(f, true);
			PrintWriter pw = new PrintWriter(fos); 
			pw.println(changeText(true, shift, message));
		    pw.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    
	}
	public static String changeText(boolean encrypt, int shift, String message)
	{
		String changed = "";
		if (encrypt == true)
		{
			for (int i = 0; i < message.length(); i++)
			{
				char ch = message.charAt(i);
				int ascii = (int) ch;
				if (encrypt == true)
				{
					ascii += shift;
				}
				else if (encrypt == false)
				{
					ascii -= shift;
				}
				changed += (char) ascii;
				
			}
		}
		return changed;
	}
	public static void main(String[] args) throws UnsupportedFileException
	{
		System.out.println(readSecretFromFile("ExampleFile.txt"));
	}
}
