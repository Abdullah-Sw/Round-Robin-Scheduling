import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class test {

	public static void main(String[] args) {

		RRscheduler rr = new RRscheduler(2);
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

//		problem1
//		rr.insertProcess(new PCB(1, 5,0));
//		rr.insertProcess(new PCB(2, 3,1));
//		rr.insertProcess(new PCB(3, 1,2));
//		rr.insertProcess(new PCB(4, 2,3));
//		rr.insertProcess(new PCB(5, 3,4));
		
//		problem2
//		rr.insertProcess(new PCB(1, 4,0));
//		rr.insertProcess(new PCB(2, 5,1));
//		rr.insertProcess(new PCB(3, 2,2));
//		rr.insertProcess(new PCB(4, 1,3));
//		rr.insertProcess(new PCB(5, 6,4));
//		rr.insertProcess(new PCB(6, 3,6));
		
//		problem3
//		rr.insertProcess(new PCB(1, 5,5));
//		rr.insertProcess(new PCB(2, 6,4));
//		rr.insertProcess(new PCB(3, 7,3));
//		rr.insertProcess(new PCB(4, 9,1));
//		rr.insertProcess(new PCB(5, 2,2));
//		rr.insertProcess(new PCB(6, 3,6));
		
//		if there is a gap
//		rr.insertProcess(new PCB(1, 5,20));
//		rr.insertProcess(new PCB(2, 6,19));
//		rr.insertProcess(new PCB(3, 7,17));
//		rr.insertProcess(new PCB(4, 9,1));
//		rr.insertProcess(new PCB(5, 2,2));
//		rr.insertProcess(new PCB(6, 3,6));

		

//		 phase 1
//		System.out.println("==========================");
//		System.out.println("Total number of processes: " + rr.getNumberOfProcesses());
//		System.out.println("Maximum Burst: " + rr.getMaximumBurstTime());
//		System.out.println("Minimum Burst: " + rr.getMinimumBurstTime());
//		System.out.println("Number of process have more than average burst time: " + rr.countMoreThanAvg());
//		System.out.println("Number of process have less than average burst time: " + rr.countLessThanAvg());

		rr.startExecution();

		// phase 2

		System.out.println("==========================");
		System.out.println("Time the first process arrives: " + rr.getProcess(0).arrivalTime);
		System.out.println("PID of the second process executed: " + rr.getProcess(1).getID());

//		rr.orderOnFinishTime();
		System.out.println("Time the last process executed: " + rr.getProcess(rr.getNumberOfProcesses() - 1).FirstEnter);
		System.out.println("PID of the last process executed: " + rr.getProcess(rr.getNumberOfProcesses() - 1).getID());

		System.out.println("Total time for execution of all processes: " + rr.getCpuExecutionTime());
		System.out.println("Average turnaround time: " + rr.getAvgTurnAroundTime());
		System.out.println("Average waiting time: " + rr.geAvgWaitingTime());
		System.out.println("Finish time of every process. ");
		rr.orderOnFinishTime();
		rr.displayFinishTime();

//		

	}
}
