import java.util.Arrays;

/**
 * A class that generates a 2-D char array representing an 'X'
 *
 * <p>Purdue University -- CS18000 -- Fall 2020</p>
 *
 * @author Purdue CS 
 * @version Oct 5, 2020
 */
public class DrawX 
{
	public static void main(String[] args) 
	{

	    DrawX sample = new DrawX(8); 

	    char[][] testArray = sample.generateArray(); 

	    for (int i = 0; i < testArray.length; i++) 
	    {
	        System.out.println(Arrays.toString(testArray[i]));
	    }
	}
	
    private int size; 
    
    public DrawX(int size) 
    {
        this.size = size; 
    }
       
    public char[][] generateArray() 
    {
        char[][] xArray = new char[size][size]; 
        // TODO
        for(int i = 0; i < xArray.length; i++)
        {
        	for(int j = 0; j < xArray[i].length; j++)
        	{
        		if(i == j)
        		{
        			xArray[i][j] = '*';
        		}
        		else if(i + j == xArray.length - 1) 
        		{
        			xArray[i][j] = '*';
        		}
        		else
        		{
        			xArray[i][j] = ' ';
        		}
        	}
        }
        return xArray; 
    }
}