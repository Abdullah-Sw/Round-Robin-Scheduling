import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;

public class RRscheduler {

	static class CustomPCBComparator implements Comparator<PCB> {

		@Override
		public int compare(PCB p1, PCB p2) {

			return p1.arrivalTime >= p2.arrivalTime ? 1 : -1;
		}
	}

	private ArrayList<PCB> allPCB = new ArrayList<PCB>();
	private LinkedList<PCB> readyQueue = new LinkedList<PCB>();
	private int maxBurstTime = Integer.MIN_VALUE;
	private int minBurstTime = Integer.MAX_VALUE;
	private int sumBurstTime = 0;

	public void insertProcess(PCB pcb) {
		allPCB.add(pcb);
		sumBurstTime += pcb.cpuBurst;

		if (pcb.cpuBurst > maxBurstTime)
			maxBurstTime = pcb.cpuBurst;
		else if (pcb.cpuBurst < minBurstTime)
			minBurstTime = pcb.cpuBurst;

	}
	
	public int getNumberOfProcesses() {
		return allPCB.size();
	}
	
	public int getMaximumBurstTime() {
		return maxBurstTime;
	}
	
	public int getMinimumBurstTime() {
		return minBurstTime;
	}
	
	private double getAvg() {
		return (double) sumBurstTime / allPCB.size();
	}
	public int countMoreThanAvg() {
		double avg = getAvg();
		int count = 0;
		for (int i = 0; i < allPCB.size(); i++) {
			if((double)allPCB.get(i).cpuBurst > avg)
				count++;
		}
		
		return count;
	}
	
	public int countLessThanAvg() {
		double avg = getAvg();
		int count = 0;
		for (int i = 0; i < allPCB.size(); i++) {
			if((double) allPCB.get(i).cpuBurst < avg)
				count++;
		}
		
		return count;
	}

}
