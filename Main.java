import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		RRscheduler rr = new RRscheduler(3);
		String fileName = "data for students 01 ver2.csv";
		File file = new File(fileName);
		try {
			Scanner inputStream = new Scanner(file);
			while (inputStream.hasNext()) {
				String data = inputStream.next();
				String[] sentence = data.split(",");

				try {
					rr.insertProcess(new PCB(Integer.parseInt(sentence[0]), Integer.parseInt(sentence[1]),
							Integer.parseInt(sentence[2])));
				} catch (NumberFormatException e) {
					
				}

			}
			inputStream.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		

//		 phase 1
//		System.out.println("==========================");
//		System.out.println("Total number of processes: " + rr.getNumberOfProcesses());
//		System.out.println("Maximum Burst: " + rr.getMaximumBurstTime());
//		System.out.println("Minimum Burst: " + rr.getMinimumBurstTime());
//		System.out.println("Number of process have more than average burst time: " + rr.countMoreThanAvg());
//		System.out.println("Number of process have less than average burst time: " + rr.countLessThanAvg());

		

		// phase 2
		
		rr.startExecution();

		System.out.println("==========================");
		System.out.println("Time the first process arrives: " + rr.getProcess(0).arrivalTime);
		System.out.println("PID of the second process executed: " + rr.getProcess(1).getID());

		System.out.println("Time the last process executed: " + rr.getProcess(rr.getNumberOfProcesses() - 1).FirstEnter);
		System.out.println("PID of the last process executed: " + rr.getProcess(rr.getNumberOfProcesses() - 1).getID());

		System.out.println("Total time for execution of all processes: " + rr.getCpuExecutionTime());
		System.out.println("Average turnaround time: " + rr.getAvgTurnAroundTime());
		System.out.println("Average waiting time: " + rr.geAvgWaitingTime());

		// here is the answer
		System.out.println("processes have less than average turnaround time: " + rr.countLessThanAvgTurnAroundTime());
		
		
		System.out.println("");
		System.out.println("Finish time of every process. ");
		rr.orderOnFinishTime();
		rr.displayFinishTime();
		
	

	}
}
