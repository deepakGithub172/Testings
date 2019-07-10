import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;


/**
 * @author deesingh13
 *
 */
public class MergingTwoSortedArray {

	public static void main(String[] args) {

		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			int testCases = Integer.parseInt(br.readLine());
			int size1, size2;
			String arr1[], arr2[], sizes[];
			for(int t=1; t<=testCases; t++) {
				sizes = br.readLine().split(" ");
				size1 = Integer.parseInt(sizes[0]);
				size2 = Integer.parseInt(sizes[1]);
				String array1 = br.readLine();
				arr1 = array1.split(" ");
				String array2 = br.readLine();
				arr2 = array2.split(" ");
				int i=0, j=0;
				Integer num1 = null, num2 = null;
				while(i<size1 || j<size2) {
					if(i<size1)
						num1 = Integer.parseInt(arr1[i]);
					if(j<size2)
						num2 = Integer.parseInt(arr2[j]);

					if((num2 == null) || (num1 != null && num1<=num2)) {
						System.out.print(num1+" ");
						i++;
						num1 = null;
					} 
					if((num1 == null) || (num2 != null && num1>num2)){
						System.out.print(num2+" ");
						j++;
						num2 = null;
					}
				}
				System.out.println();
			}
			br.close();
		}catch (IOException e) {
			// TODO: handle exception
		}
		//planB();
	}

	private static void planB() {
		Scanner sc = new Scanner(System.in);
		int testCases = sc.nextInt();
		Map<Integer, String> sortedTree = new TreeMap<>();
		for(int t=1; t<=testCases; t++) {
			int size1 = sc.nextInt();
			int size2 = sc.nextInt();
			for(int a=0; a<(size1+size2); a++) {
				int num = sc.nextInt();
				String value = "";
				if(sortedTree.containsKey(num)) {
					value = sortedTree.get(num)+" ";
				}
				value = value+num;
				sortedTree.put(num, value);
			}
			String result = sortedTree.values().toString();
			result = result.substring(1, result.length()-1);
			result = result.replaceAll(",", " ");
			System.out.println(result);
		}
		sc.close();
	}

}
