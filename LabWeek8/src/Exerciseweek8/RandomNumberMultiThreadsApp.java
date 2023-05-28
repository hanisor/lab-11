package Exerciseweek8;


/**
 * This class demonstrate execution of multiple threads object
 * from the same class.
 *
 * @author emalianakasmuri
 *
 */
public class RandomNumberMultiThreadsApp {

	public static void main(String[] args) {

		// Create Runnable object
		Runnable randomNumberTask1 = new RandomNumberTask(1,100);
		Runnable randomNumberTask2 = new RandomNumberTask(5, 50);

		// Create thread objects
		Thread randomNumberThread1 = new Thread(randomNumberTask1);
		Thread randomNumberThread2 = new Thread(randomNumberTask2);
		
		/* EXERCISE 4
		 * 
		 * two different name for the two thread object
		 */
		Thread randomThreadNumber1 = new Thread(randomNumberTask1);
		Thread randomThreadNumber2 = new Thread(randomNumberTask2);
		randomThreadNumber1.setName("Random number 1");
		randomThreadNumber2.setName("Random number 2");

		// Execute threads
		 randomNumberThread1.start();
		 randomNumberThread2.start();
		
		
		/* EXERCISE 4
		 * 
		 * two different name for the two thread object
		 */
		
		randomThreadNumber1.start();
		randomThreadNumber2.start();

		System.out.println("Program ends");


	}

}
