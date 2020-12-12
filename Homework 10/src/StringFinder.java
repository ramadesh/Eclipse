
public class StringFinder extends Thread {

	private static int counter;
	private int start;
	private int end;
	private String inputText;
	private String wordToFind;
	public static StringFinder sf = new StringFinder();
	private String[] inputTextArray;
	
	public StringFinder()
	{
		
	}
	public StringFinder(String inputText, String wordToFind, int start, int end)
	{
		this.inputText = inputText.toLowerCase();
		this.wordToFind = wordToFind;
		this.start = start;
		this.end = end;
	}
	
	public static void main(String[] args) {
		String inputText = "She didn’t understand how change worked. " +
                "When she looked at today compared to yesterday," +
                " there was nothing that she could see that was different." +
                " Yet, when she looked at today compared to last year, " + 
                "she couldn’t see how anything was ever the same.";
		StringFinder one = new StringFinder(inputText, "today", 0, 40);
		StringFinder two = new StringFinder(inputText, "today", 40, 88);
		one.start();
		two.start();
		try {
			one.join();
			two.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println("final: " + counter); //prints counter value
    }
	
	
	public void run() {
		synchronized(sf)
		{
			inputText = inputText.substring(start, end); //makes sure that input text is only in bounds specified
			inputTextArray = inputText.split(" "); //initializes an array broken up at spaces
			for (String str : inputTextArray) //iterates through each word of the array
			{
				if(str.equals(wordToFind))
				{
					counter++; //counter increments if the wordToFind is found
				}
			}
		}

    }
	
	
}
