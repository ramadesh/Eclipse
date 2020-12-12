import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;
import javax.swing.JOptionPane;

public class CalculatorClient {
	public static void main(String[] args) throws UnknownHostException, IOException, ClassNotFoundException {
        Scanner scan = new Scanner(System.in);
        String serv = null; 
    	int servNum = 0;
    	JOptionPane.showMessageDialog(null, "Welcome!", "Calc",
                JOptionPane.INFORMATION_MESSAGE);
        
        String hostName = null; 
        while ((hostName == null) || (hostName.isBlank())) {
            hostName = JOptionPane.showInputDialog(null, "What is your hostname?",
                    "Calc", JOptionPane.QUESTION_MESSAGE);
            if ((hostName == null) || (hostName.isBlank())) {
                JOptionPane.showMessageDialog(null, "Host name cannot be empty!", "Calc",
                        JOptionPane.ERROR_MESSAGE);
    
            }
        }
        while ((serv == null) || (serv.isBlank()) || (servNum == 0)) {
            serv = JOptionPane.showInputDialog(null, "What is the server number?",
                    "Calc", JOptionPane.QUESTION_MESSAGE);
            try {
            	servNum = Integer.parseInt(serv);
      		} catch (NumberFormatException e) {
      			if ((serv == null) || (serv.isBlank())) {
                	
                	JOptionPane.showMessageDialog(null, "Server number cannot be empty!", "Calc",
                            JOptionPane.ERROR_MESSAGE);
      			} else {
                	JOptionPane.showMessageDialog(null, "Please enter a valid number!", "Calc",
                            JOptionPane.ERROR_MESSAGE);
                }
            }       
        }
        BufferedReader reader = null;
        PrintWriter writer = null;
        try {
        Socket socket = new Socket(hostName, servNum);
        reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        writer = new PrintWriter(socket.getOutputStream());
        } catch (IOException e) {
        	JOptionPane.showMessageDialog(null, "Connection failed", "Calc",
                    JOptionPane.ERROR_MESSAGE);
        	return;
        } 
        JOptionPane.showMessageDialog(null, "Connection established!", "Calc",
                JOptionPane.INFORMATION_MESSAGE);
        
        boolean more = true;
        while (more == true)
        {
        	boolean expressionCorrect = false;
        	String response = null;
        	while (response == null || response.isBlank())
        	{
        		response = JOptionPane.showInputDialog(null, "What do you want to send to the server?", "Calc",
                        JOptionPane.QUESTION_MESSAGE);
        		if (response == null || response.isBlank())
        		{
        			JOptionPane.showMessageDialog(null, "Expression is blank", "Calc",
                            JOptionPane.ERROR_MESSAGE);
        		}
        	}
        	while (expressionCorrect == false)
        	{
        		if (response.indexOf(" ") == -1)
            	{
            		JOptionPane.showMessageDialog(null, "Put a space before and after the operator", "Calc",
                            JOptionPane.ERROR_MESSAGE);
            		response = JOptionPane.showInputDialog(null, "What do you want to send to the server?", "Calc",
                            JOptionPane.QUESTION_MESSAGE);
            	}
            	else
            	{
            		String[] inputArr = response.split(" ");
                	if (inputArr.length != 3)
                	{
                		JOptionPane.showMessageDialog(null, "Enter a number before and after the operator", "Calc",
                                JOptionPane.ERROR_MESSAGE);
                		response = JOptionPane.showInputDialog(null, "What do you want to send to the server?", "Calc",
                                JOptionPane.QUESTION_MESSAGE);
                	}
                	else
                	{
                		try {
                			double num = Double.valueOf(inputArr[0]);
                			double num2 = Double.valueOf(inputArr[2]);
                			expressionCorrect = true;
                		} catch (NumberFormatException e) {
                			JOptionPane.showMessageDialog(null, "Must enter a number before and after the operator", "Calc",
                                    JOptionPane.ERROR_MESSAGE);
                			response = JOptionPane.showInputDialog(null, "What do you want to send to the server?", "Calc",
                                    JOptionPane.QUESTION_MESSAGE);
                		}
                	}
            	}
        		
        	}
        	
        	
            writer.write(response);
            writer.println();
            writer.flush(); // ensure data is sent to the server
            System.out.printf("Sent to server:\n%s\n", response);
            String s1 = reader.readLine();
            JOptionPane.showMessageDialog(null, s1, "Calc",
                    JOptionPane.INFORMATION_MESSAGE);
            System.out.printf("Received from server:\n%s\n", s1);
            int moreEq = JOptionPane.showConfirmDialog(null, "Use calculator again?", "Calc",
                    JOptionPane.YES_NO_OPTION);
            if (moreEq == JOptionPane.NO_OPTION)
            {
            	JOptionPane.showMessageDialog(null, "Thank you. Bye!", "Calc",
                        JOptionPane.ERROR_MESSAGE);
            	writer.write("no");
            	more = false;
            }
            else if (moreEq == JOptionPane.YES_OPTION)
            {
            	writer.write("yes");
                writer.println();
                writer.flush();
            }
        }
        writer.close();
        reader.close();
        
    }
}
