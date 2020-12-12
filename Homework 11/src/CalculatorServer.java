import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class CalculatorServer {
	public static void main(String[] args) {
    	ServerSocket serverSocket = null;
		try {
			serverSocket = new ServerSocket(4242);
		} catch (IOException e) {
			e.printStackTrace();
		}

    	System.out.println("Waiting for the client to connect...");
    	Socket socket = null;
		try {
			socket = serverSocket.accept();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	System.out.println("Client connected!");
    	BufferedReader reader;
		try {
			reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			PrintWriter writer = new PrintWriter(socket.getOutputStream()); 
			String again = "yes";
	    	while (again.equals("yes"))
	    	{
	    		String message = reader.readLine();
	        	System.out.printf("Received from client:\n%s\n", message);

	        	String[] messageArr = message.split(" ");
	        	double result = 0;
	        	if (messageArr[1].equals("+"))
	        	{
	        		result = (Double.valueOf(messageArr[0])) + (Double.valueOf(messageArr[2]));
	        	}
	        	else if (messageArr[1].equals("-"))
	        	{
	        		result = (Double.valueOf(messageArr[0])) - (Double.valueOf(messageArr[2]));
	        	}
	        	else if (messageArr[1].equals("*"))
	        	{
	        		result = (Double.valueOf(messageArr[0])) * (Double.valueOf(messageArr[2]));
	        	}
	        	else if (messageArr[1].equals("/"))
	        	{
	        		result = (Double.valueOf(messageArr[0])) / (Double.valueOf(messageArr[2]));
	        	}

	        	writer.write(String.valueOf(result));
	        	writer.println();
	        	writer.flush(); // Ensure data is sent to the client.
	        	System.out.printf("Sent to client:\n%f\n", result);
	        	again = reader.readLine();
	    	}
	    	writer.close();
	    	reader.close();
	    	serverSocket.close();
		} catch (IOException e) {

		} catch (NumberFormatException e)
		{
			e.printStackTrace();
		}
    	
    	
    	
    }
}
