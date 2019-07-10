import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

/**
 * 
 */

/**
 * @author deesingh13
 *
 */
public class KthSmallestNumber {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int testCases = sc.nextInt();
		int size;
		
		for(int t =1; t <= testCases; t++) {
			size = sc.nextInt();
			Set<Integer> treeSet = new TreeSet<>();
			for(int i=0; i<size;i++) {
				treeSet.add(sc.nextInt());
			}
			int k = sc.nextInt();
			System.out.println(treeSet.toArray()[k-1]);
		}
		sc.close();	
	}
}
