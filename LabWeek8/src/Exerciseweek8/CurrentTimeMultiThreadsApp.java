package Exerciseweek8;

/**
 * This class demonstrate the application of multiple threads object in
 * a simple Java multithreaded application
 *
 * @author emalianakasmuri
 *
 */
public class CurrentTimeMultiThreadsApp {

	public static void main(String[] args) {

		// Create thread objects
		Thread currentTimeThread1 = new CurrentTimeTask();
		Thread currentTimeThread2 = new CurrentTimeTask();
		
		/* EXERCISE 3
		 * 
		 * Give two different name for the two thread object 
		 * 
		 */

		Thread currentThreadTime1 = new Thread(currentTimeThread1);
		Thread currentThreadTime2 = new Thread(currentTimeThread2);
		currentThreadTime1.setName("Current Time 1");
		currentThreadTime2.setName("Current time 2");
		
		/*
		// Execute threads
		currentTimeThread2.start();
		currentTimeThread1.start();
		*/
		
		/* EXERCISE 3
		 * 
		 * Give two different name for the two thread object 
		 * 
		 */
		
		currentThreadTime2.start();
		currentThreadTime1.start();

		System.out.println("Program ends");

	}

}
