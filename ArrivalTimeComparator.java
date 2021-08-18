import java.util.Comparator;

public class ArrivalTimeComparator implements Comparator<PCB> {

		@Override
		public int compare(PCB p1, PCB p2) {

			if(p1.arrivalTime > p2.arrivalTime)
			return 1;
			else if(p1.arrivalTime < p2.arrivalTime)
				return -1;
			else if(p1.getID() >= p2.getID())
				return 1;
			else
				return -1;
						
		}
	}