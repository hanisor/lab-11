package Exerciseweek8;


import java.util.Random;

/**
 * This class represent a task to generate a random number.
 * 
 * @author emalianakasmuri
 *
 */
public class RandomNumberTask implements Runnable {
	
	private Random random;
	private int min;
	private int max;
	
	public RandomNumberTask (int min, int max) {
		
		random = new Random();
		
		this.min = min;
		this.max = max;
	}
	
	/**
	 * This method gets a random number between min and max values
	 * 
	 * @return a random number
	 */
	public int getRandomNumber () {
		
		int number = random.nextInt(max-min) + min;
		
		return number;
	}
	
	/* EXERCISE 2
	 * 
	 * task 2
	
	@Override
	public void run()
	{
		Thread currentThread = Thread.currentThread();
		for (int counter = 0; counter < 10; counter++)
		{
			System.out.println(getRandomNumber());
		}
	}
	*/
	
	/* Exercise 4
	 * 
	 * Task 2
	 * 
	
	@Override
	public void run()
	{
		Thread currentThread = Thread.currentThread();
		for (int counter = 0; counter < 10; counter++)
		{
			System.out.println(currentThread.getName() + ": " + getRandomNumber());
		}
	}
	*/

	
	/* EXERCISE 5
	 * 
	 * 
	 */
	@Override
	public void run() {
		
		/*
		 * prints 10 random numbers using getRandom( ).
		 */
		try 
		{
			for (int counter = 0; counter < 10; counter++)
			{
				Thread currentThread1 = Thread.currentThread();
				Thread currentThread2 = Thread.currentThread();
				
				//suspend the operation for 4000 milliseconds before proceed to print statement
				Thread.sleep(4000);
				System.out.println(currentThread1.getName() + " = " + counter + " " + getRandomNumber());
				System.out.println(currentThread2.getName() + " = " + counter + " " + getRandomNumber());
			}
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
	}
	

}
