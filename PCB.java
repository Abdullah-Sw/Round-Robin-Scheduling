
public class PCB{
	
	private int id;
	public int cpuBurst;
	public int arrivalTime;
	public int lastEnter;
	public int FirstEnter;
	public int counter;
	
	public int lastExit;
	public int waitingTime;
	public int turnAroundTime;
	public int finishTime;
	
	public PCB(int id, int cpuBurst, int arrivalTime) {
		this.id = id;
		this.cpuBurst = cpuBurst;
		this.arrivalTime = arrivalTime;
		lastExit = arrivalTime;
		counter = 0;
	}
	
	public int getID() {
		return id;
	}
	public int getTurnAroundTime() {
		return turnAroundTime;
	}
	@Override
	public String toString() {
		return id +"," + cpuBurst +"," + arrivalTime + ", " + finishTime;
	}
	

}
