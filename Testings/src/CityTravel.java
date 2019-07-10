import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.TreeMap;

public class CityTravel {

	public static void main(String args[] ) throws Exception {

		try (Scanner s = new Scanner(System.in)){
			int distance = s.nextInt(); 
			int limit = s.nextInt();
			int exceptions = s.nextInt();
			int days = 0;
			Map<Integer, Integer> excValues = new TreeMap<>();
			for(int i=1; i<=exceptions; i++)
				excValues.put(s.nextInt(), s.nextInt());

			/*while(distance>0){
				days++;
				Integer dist = excValues.get(days);
				if(dist == null)
					dist = limit;
				distance -= dist;
			}*/

			int initial = 0;
			for(Entry<Integer, Integer> entry : excValues.entrySet()) {
				if(distance>0) {
					int diff = entry.getKey()-initial;
					distance = distance-(limit*(diff-1) + entry.getValue());
					if(distance-(limit*(diff-1))>0) {
						distance = distance-(limit*(diff-1));
						days = days + diff-1;
					} else {
						for(int i=1; i< diff; i++) {
							distance = distance-limit;
							days++;
							if(distance<=0)
								break;
						
						}
						break;
					}
					if(distance-entry.getValue()>=0) {
						distance = distance-entry.getValue();
						days++;
					} else {
						days++;
						break;
					}
					initial = entry.getKey();
				}

			}
			System.out.println(days);
		}
	}
}