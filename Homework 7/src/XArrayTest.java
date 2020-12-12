import java.util.Arrays;
public class XArrayTest 
{
	public static void main(String[] args) 
	{

	    DrawX sample = new DrawX(3); 

	    char[][] testArray = sample.generateArray(); 

	    for (int i = 0; i < testArray.length; i++) 
	    {
	        System.out.println(Arrays.toString(testArray[i]));
	    }
	}

}
