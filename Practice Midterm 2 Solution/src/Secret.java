import java.io.*;
import java.util.ArrayList;

/**
 * [CS18000] Practice Midterm 2 Solution
 *
 * @author kedarabhyankar
 * @version 10/31/2020
 */
public class Secret {

    public static String readSecretFromFile(String filename) throws UnsupportedFileException {
        ArrayList<String> linesFromFile = new ArrayList<>();
        int cipherShift = 0;
        int counter = 0;
        File toProcess = new File(filename);
        if (!toProcess.exists()) {
            return null;
        }
        try (BufferedReader br = new BufferedReader(new FileReader(toProcess))) {
            String line;
            while ((line = br.readLine()) != null) {
                if (counter == 0) {
                    try {
                        cipherShift = Integer.parseInt(line);
                        counter++;
                        continue;
                    } catch (NumberFormatException numE) {
                        throw new UnsupportedFileException("Invalid format.");
                    }
                }
                linesFromFile.add(line);
            }
            
            String decryptedText = "";
            for(String s : linesFromFile){
                for(int i = 0; i < s.length(); i++){
                    decryptedText += ((char) (s.charAt(i) - cipherShift));
                }
            }

            return decryptedText;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void writeSecretToFile(int shift, String message, String filename) {
        File toWrite = new File(filename);
        if (toWrite.exists()) 
        {
            toWrite.delete();
            try {
                toWrite.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
                return;
            }
        }
        try (PrintWriter pw = new PrintWriter(new FileWriter(toWrite))) {
            String writeSecret = "";
            for (int i = 0; i < message.length(); i++) 
            {
                writeSecret += (char) (message.charAt(i) + shift);
            }
            pw.println(writeSecret);
            pw.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String changeText(boolean encrypt, int shift, String message) {
    	String messaged = "";
        if (encrypt) 
        {
            for (int i = 0; i < message.length(); i++) 
            {
                messaged += (char) (message.charAt(i) + shift);
            }
        } else 
        {
            for (int i = 0; i < message.length(); i++) 
            {
            	messaged += (char) (message.charAt(i) - shift);
            }
        }

        return messaged;
    }

    public static void main(String[] args) throws UnsupportedFileException {
        System.out.println(readSecretFromFile("ExampleFile.txt"));
        writeSecretToFile(10, "SampleMessage", "Encrypt.txt");
    }
}
