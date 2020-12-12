public class MyCustomString 
{
	private String myString;
	
	public MyCustomString(String myString)
	{
		this.myString = myString;
	}
	
	public String getMyString()
	{
		return myString;
	}
	
	public void setMyString(String myString)
	{
		this.myString = myString;
	}
	
	String stringNums = "";
	/*
	public MyCustomInteger parseMyInt()
	{
		for (int i = 0; i < myString.length(); i++)
		{
			if(myString.indexOf("zero") == 0)
			{
				myString = myString.substring(4);
				stringNums += "0";
			}
			else if(myString.indexOf("one") == 0)
			{
				myString = myString.substring(3);
				stringNums += "1";
			}
			else if(myString.indexOf("two") == 0)
			{
				myString = myString.substring(3);
				stringNums += "2";
			}
			else if(myString.indexOf("three") == 0)
			{
				myString = myString.substring(5);
				stringNums += "3";
			}
			else if(myString.indexOf("four") == 0)
			{
				myString = myString.substring(4);
				stringNums += "4";
			}
			else if(myString.indexOf("five") == 0)
			{
				myString = myString.substring(4);
				stringNums += "5";
			}
			else if(myString.indexOf("six") == 0)
			{
				myString = myString.substring(3);
				stringNums += "6";
			}
			else if(myString.indexOf("seven") == 0)
			{
				myString = myString.substring(5);
				stringNums += "7";
			}
			else if(myString.indexOf("eight") == 0)
			{
				myString = myString.substring(5);
				stringNums += "8";
			}
			else if(myString.indexOf("nine") == 0)
			{
				myString = myString.substring(4);
				stringNums += "9";
			}
		}
		int theSum = 0;
		for (int i = 0; i < stringNums.length(); i++)
		{
			theSum = (int) Math.pow(10, i) + Integer.valueOf(stringNums.substring(stringNums.length()-1,stringNums.length()));
		}
		
	}*/

}