package Exerciseweek8;

public class CurrentTimeRandomNumberApp {
	
	public static void main (String [] args)
	{
		// Create two objects of thread from class RandomNumberTask
		Runnable randomNumber1 = new RandomNumberTask(1,100);
		Runnable randomNumber2 = new RandomNumberTask(5,20);
		
		// Create an object of thread from class CurrentTimeTask
		Thread time1 = new CurrentTimeTask();
				
		Thread currentTime1 = new Thread(randomNumber1);
		Thread currentTime2 = new Thread(randomNumber2);

		// Execute threads
		currentTime2.start();
		currentTime1.start();
		time1.start();	
	}
	

}
