package Latihan1;

public class CookingTask extends Thread{
	private String task;
	
	CookingTask(String task){
		this.task = task;
	}
	
	public void run() {
		System.out.println(task + "is being prepared" + 
		Thread.currentThread().getName());
	}
}
