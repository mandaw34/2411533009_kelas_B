package Latihan2;

public class DownloadLambda {
	public static void main(String[] args) {
		
		Thread f1 = new Thread(() -> download("File-1"));
		Thread f2 = new Thread(() -> download("File-2"));
		Thread f3 = new Thread(() -> download("File-3"));
		
		System.out.print("Downloading... \n");
	} 
	
	private static void download(String fileName) {
		for (int i = 10; i <= 100; i += 10) {
			System.out.println(fileName + " : " + i + "%");
			
			try {
				Thread.sleep(500);
			}catch (InterruptedException e) {
				e.printStackTrace();
			}
			}
		System.out.println(fileName + " selesao diunduh!\n");
		}
	}


