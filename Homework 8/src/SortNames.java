import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Collections; 
/**
 * A program that reads names from a text file, sorts them, then writes them to another text file.
 *
 * <p>Purdue University -- CS18000 -- Fall 2020</p>
 *
 * @author Purdue CS 
 * @version October 12, 2020
 */
public class SortNames {
    public static ArrayList<String> readFile(String filename) throws FileNotFoundException{
    	File f = new File(filename);
    	FileReader fr = new FileReader(f);
    	BufferedReader bfr = new BufferedReader(fr);
        ArrayList<String> list = new ArrayList<String>(); 
        // TODO
        String line = null;
		try {
			line = bfr.readLine();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        while (line != null) {
            list.add(line);
            try {
				line = bfr.readLine();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        }
        try {
			bfr.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        return list; 
    }

    public static void writeFile(String fileName, ArrayList<String> names) 
        throws FileNotFoundException {
        // TODO
    	File f = new File(fileName);
    	FileOutputStream fos = new FileOutputStream(f,true); 
    	PrintWriter pw = new PrintWriter(fos); 
    	for (int i = 0; i < names.size(); i++){
    	    pw.println(names.get(i));
    	}

    	pw.close(); 
    }

    public static void main(String[] args){
        ArrayList<String> names;
        System.out.println("Enter filename with unsorted names");
        Scanner sc = new Scanner(System.in);
        String filename = sc.nextLine();
        try {
    	    names = readFile(filename);
            Collections.sort(names);
            writeFile("sorted_names.txt", names);
        } catch (FileNotFoundException e){
            System.out.println("File not found!");
            return;
        }
        System.out.println("Sorted names written to sorted_names.txt");
    }
}