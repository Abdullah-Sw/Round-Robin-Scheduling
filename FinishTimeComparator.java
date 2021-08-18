import java.util.Comparator;

public class FinishTimeComparator implements Comparator<PCB> {
		
		@Override
		public int compare(PCB p1, PCB p2) {
			
			
			if(p1.finishTime > p2.finishTime)
				return 1;
				else if(p1.finishTime < p2.finishTime)
					return -1;
				else if(p1.getID() >= p2.getID())
					return 1;
				else
					return -1;
		}
	}