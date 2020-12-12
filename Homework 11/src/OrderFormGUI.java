import javax.swing.*;

public class OrderFormGUI {
    public static void main(String[] args) {
    	boolean done = true;
        while (done == true) 
        {
        	/** DO NOT CHANGE VALUES BELOW **/
            boolean hoodieInStock = true;
            boolean tshirtInStock = false;
            boolean longsleeveInStock = true;
            String item = "";
            int quantity = 0;
            String name = "";
            
            /** DO NOT CHANGE VALUES ABOVE **/
            
        	//TODO: display error GUI if item selected is out of stock
            String[] options = {"Hoodie", "T-shirt", "Long sleeve"};
            boolean inStock = false;
            while (inStock == false)
            {
            	item = (String) JOptionPane.showInputDialog(null, "Select item style ", "Order Form",
                        JOptionPane.PLAIN_MESSAGE, null, options, null);
                if (item == options[0]) 
                {
                	if (hoodieInStock == false)
                	{
                		JOptionPane.showMessageDialog(null, "Out of Stock", "Order Form",
                                JOptionPane.ERROR_MESSAGE);
                	}	
                	else
                	{
                		inStock = true;
                	}
                }
                else if (item == options[1]) 
                {
                	if (tshirtInStock == false)
                	{
                		JOptionPane.showMessageDialog(null, "Out of Stock", "Order Form",
                                JOptionPane.ERROR_MESSAGE);
                	}	
                	else
                	{
                		inStock = true;
                	}
                }
                else if (item == options[2]) 
                {
                	if (longsleeveInStock == false)
                	{
                		JOptionPane.showMessageDialog(null, "Out of Stock", "Order Form",
                                JOptionPane.ERROR_MESSAGE);
                	}	
                	else
                	{
                		inStock = true;
                	}
                }

            }
            //TODO: display error GUI if input is not an int or if input is less than 1
            while (quantity == 0)
            {
            	
            	try {
            		quantity = Integer.parseInt(JOptionPane.showInputDialog(null, "Enter quantity", "Order Form",
            				JOptionPane.QUESTION_MESSAGE));
            		if (quantity == 0)
            		{
            			JOptionPane.showMessageDialog(null, "Enter a number greater than 0", "Order Form",
                				JOptionPane.ERROR_MESSAGE);
            		}
            	} catch (NumberFormatException e) {
                		JOptionPane.showMessageDialog(null, "Enter an integer", "Order Form",
                				JOptionPane.ERROR_MESSAGE);
                }
            }


            //TODO: display error GUI if input does not include a space
            while ((name == null) || (name.isBlank()) || (name.indexOf(" ") == -1))
            {
            	name = JOptionPane.showInputDialog(null, "Enter your Name", "Order Form",
                        JOptionPane.QUESTION_MESSAGE);
                if (name.indexOf(" ") == -1 && name != null)
                {
                	JOptionPane.showMessageDialog(null, "Enter first and last name", "Order Form",
                            JOptionPane.ERROR_MESSAGE);
                }
                
            }
            
            /** Order Confirmation Message **/
            String resultMessage = "Name: " + name + "\nItem: " + item + "\nQuantity: " + quantity;
            JOptionPane.showMessageDialog(null, resultMessage, "Order Confirmation", JOptionPane.INFORMATION_MESSAGE);

            //TODO: loop through order form again if YES
            int loop = JOptionPane.showConfirmDialog(null, "Would you like to place another order?", "Order Form", JOptionPane.YES_NO_OPTION);
            if (loop == JOptionPane.NO_OPTION)
            {
            	done = false;
            }
        }
    }
}