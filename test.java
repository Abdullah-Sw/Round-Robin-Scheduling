import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class test {
	
	public static void main(String[] args) {
		
		RRscheduler rr = new RRscheduler();
		String fileName = "data for students 01.csv"; // Use the path
		File file = new File(fileName);
		try {
			Scanner inputStream = new Scanner(file);
			while(inputStream.hasNext()) {
				String data = inputStream.next();
				String[] sentence = data.split(",");
				rr.insertProcess(new PCB(Integer.parseInt(sentence[0]), Integer.parseInt(sentence[1]), Integer.parseInt(sentence[2])));
			}
			inputStream.close();
		} catch(FileNotFoundException e) {
			e.printStackTrace();
		}

		
		System.out.println("==========================");
		System.out.println("Total number of processes: " + rr.getNumberOfProcesses());
		System.out.println("Maximum Burst: " + rr.getMaximumBurstTime());
		System.out.println("Minimum Burst: " + rr.getMinimumBurstTime());
		System.out.println("Number of process have more than average burst time: " + rr.countMoreThanAvg());
		System.out.println("Number of process have less than average burst time: " + rr.countLessThanAvg());
		 
	}
}
