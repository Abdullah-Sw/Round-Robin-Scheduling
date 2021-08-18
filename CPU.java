
public class CPU {
	private int quantum;
	private int executionTime;

	public CPU(int quantum) {
		this.quantum = quantum;
		executionTime = 0;
	}

	public int run(PCB process) {
		int runTime = 0;


		for (int i = 0; i < quantum; i++) {
			if (process.cpuBurst == 0) {
				break;
			}
			// the execution done here
			runTime++;
			executionTime++;
			process.cpuBurst--;
			
		}

		return runTime;

	}



	public int getExecutionTime() {
		return executionTime;
	}



}
