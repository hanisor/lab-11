package Exerciseweek8;

import java.util.ArrayList;
import java.util.List;

public class TextExtractorTask extends Thread {
	
	private String text;
	private List<String> text2;
	
	// define constructor
	
	public TextExtractorTask() 
	{
		text = "The List component presents the user with scrolling list of text items. The list can be set up so that the user can choose either one item or multiple items.";
		
		text2 = new ArrayList<String>();
		
		String[] words = text.split(" ");
		
		for(String word : words)
		{
			text2.add(word);
		}
	}
	
		// task 3 = generate text from list of words
		public void RandomTextGenerator()
		{
	        // generating random number of word to be generated with the help of Math.random() function
			int word = (int)(Math.random() * text2.size());
			
			// declare an object of String builder to manipulate the string
			// StringBuilder : represents a mutable sequence of characters (change their value or data in place without affecting the object's identity.)
	        StringBuilder line = new StringBuilder();
	        
	        // generate word based on random index and combine these words into a single sentence
	        // The process continues until it reach the number of words to be generated
	        for(int counter = 0; counter < word; counter++)
	        {
	        	int random = (int)(Math.random() * text2.size());
	        	line.append(text2.get(random)).append(" ");
	        }
	        
	        // convert the sentence that append to StringBuilder to String to obtain final string
	        String RandomText = line.toString().trim();
	        System.out.println(RandomText);
		}
		
		// task 4 : extract a portion of text at random length
		public void RandomTextExtractor()
		{
	        // generating random index with the help of Math.random() function
			int index = (int) (Math.random()*text.length());
			
			// extract the first variable, text starting from index 0 to the random index generated 
			System.out.println(text.substring(0, index));
	       
		}
		
		
		// task 5 : execute RandomTextGenerator() when the name of the thread contains “Generator”.
				// and execute  RandomTextExtractor() when the name of the thread contains “Extractor”.

		@Override
		public void run()
		{

			Thread currentThread = Thread.currentThread();
			

			if(currentThread.getName().equals("Generator") || currentThread.getName().equals("generator"))
			{
				RandomTextGenerator();
			}
			
			else if(currentThread.getName().equals("Extractor") || currentThread.getName().equals("extractor"))
			{
				RandomTextExtractor();
			}
			
			else
			{
				System.out.println("Error!");
			}
			
		}
	}
	


