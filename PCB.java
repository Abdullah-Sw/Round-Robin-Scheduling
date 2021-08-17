
public class PCB{
	enum State {
		ready, running, terminated
	}
	
	private int id;
	public int cpuBurst;
	public int arrivalTime;
	public State state;
	public int waitingTime;
	public int finishedTime;
	public int turnAroundTime;
	
	public PCB(int id, int cpuBurst, int arrivalTime) {
		this.id = id;
		this.cpuBurst = cpuBurst;
		this.arrivalTime = arrivalTime;
	}
	
	@Override
	public String toString() {
		return id +"," + cpuBurst +"," + arrivalTime;
	}
	

}
