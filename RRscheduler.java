import java.util.ArrayList;
import java.util.LinkedList;



public class RRscheduler {

	private CPU cpu;
	private ArrayList<PCB> allProcesses;
	private LinkedList<PCB> readyQueue;
	private int maxBurstTime;
	private int minBurstTime;
	private int sumBurstTime;
	private int timeline;
	private double totalTurnAroundTime; // to calculate the average TurnAround Time easily with out looping over the all
	// processes
	private double totalWaitingTime; // to calculate the average waiting time easily with out looping over the all
	// processes

	public RRscheduler(int quantum) {
		cpu = new CPU(quantum);
		allProcesses = new ArrayList<PCB>();
		readyQueue = new LinkedList<PCB>();
		maxBurstTime = Integer.MIN_VALUE;
		minBurstTime = Integer.MAX_VALUE;
		sumBurstTime = 0;
	}

	public void insertProcess(PCB pcb) {
		allProcesses.add(pcb);
		sumBurstTime += pcb.cpuBurst;

		if (pcb.cpuBurst > maxBurstTime)
			maxBurstTime = pcb.cpuBurst;
		else if (pcb.cpuBurst < minBurstTime)
			minBurstTime = pcb.cpuBurst;

	}

	public int getNumberOfProcesses() {
		return allProcesses.size();
	}

	public int getMaximumBurstTime() {
		return maxBurstTime;
	}

	public int getMinimumBurstTime() {
		return minBurstTime;
	}

	public int countMoreThanAvg() {
		double avg = getAvg();
		int count = 0;
		for (int i = 0; i < allProcesses.size(); i++) {
			if ((double) allProcesses.get(i).cpuBurst > avg)
				count++;
		}

		return count;
	}

	public int countLessThanAvg() {
		double avg = getAvg();
		int count = 0;
		for (int i = 0; i < allProcesses.size(); i++) {
			if ((double) allProcesses.get(i).cpuBurst < avg)
				count++;
		}

		return count;
	}

	private double getAvg() {
		return (double) sumBurstTime / allProcesses.size();
	}

	public void startExecution() {
		// first we sorted allProcesses based on arrival time
		allProcesses.sort(new ArrivalTimeComparator());
		
		int index = 0;		
		PCB process = null;
		while (index < allProcesses.size() || !readyQueue.isEmpty()) {
			
//		 enter for the first time or if a gap occur
			if(readyQueue.isEmpty()) {
				while(allProcesses.get(index).arrivalTime > timeline)
				timeline++;
				
				readyQueue.add(allProcesses.get(index));
				index++;
			}
			
			process = readyQueue.poll();
			
			// here we update the last time a process entered the cpu
			process.lastEnter = timeline;
			if(process.counter == 0) {
				process.FirstEnter = process.lastEnter; // To find the start time of executed process
				process.counter++;
			}
			updateWaitingTime(process);
			
			// Execution start 
			timeline += cpu.run(process);
			// Execution end and we update the last time a process entered the cpu 
			process.lastExit = timeline;
			
			// if there any process arrived in this time we inserted first
			while(index < allProcesses.size() && allProcesses.get(index).arrivalTime <= timeline)
				readyQueue.add(allProcesses.get(index++));
			
			// if a process not finished it will  enter the readyqueue
			if (process.cpuBurst > 0) 
				readyQueue.add(process);
			
			// Otherwise we will calculate its turnAroundTime
			else {
				process.finishTime = timeline;
				updateTurnAroundTime(process);
			}
		}

	}

	private void updateWaitingTime(PCB process) {
		process.waitingTime += timeline - process.lastExit;
		totalWaitingTime += timeline - process.lastExit;
		
	}

	private void updateTurnAroundTime(PCB process) {
			process.turnAroundTime = process.finishTime - process.arrivalTime;
			totalTurnAroundTime += process.finishTime - process.arrivalTime;
		
		
	}

	public PCB getProcess(int index) {

		return allProcesses.get(index);
	}

	public void orderOnFinishTime() {
		// sort allProcesses based on finishtime
		allProcesses.sort(new FinishTimeComparator());
	}

	public void displayFinishTime() {
		for (int i = 0; i < allProcesses.size(); i++) {

			System.out
					.println("PID: " + allProcesses.get(i).getID() + ", finishTime: " + allProcesses.get(i).finishTime);

		}

	}

	public int getSumBrust() {
		return sumBurstTime;
	}

	public int getCpuExecutionTime() {
		return cpu.getExecutionTime();
	}

	public double getAvgTurnAroundTime() {
		return totalTurnAroundTime / allProcesses.size();
	}

	public double geAvgWaitingTime() {		
		return totalWaitingTime / allProcesses.size();
	}
	public int countLessThanAvgTurnAroundTime() {
		double avg = getAvgTurnAroundTime();
		int count = 0;
		for(int i=0; i<allProcesses.size(); i++) {
			if((double) allProcesses.get(i).getTurnAroundTime() < avg)
				count++;
		}
		return count;
	}

}
