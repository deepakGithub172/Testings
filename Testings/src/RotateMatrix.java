import java.util.Scanner;

/**
 * 
 */

/**
 * @author deesingh13
 *
 */
public class RotateMatrix {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int testCases = sc.nextInt();
		int size;
		
		for(int t =1; t <= testCases; t++) {
			size = sc.nextInt();
			int[][] matrix = new int[size][size];
			for(int i=0; i<size;i++) {
				for(int j=0; j<size; j++) {
					matrix[j][(size-1)-i]=sc.nextInt();
				}
			}
			for(int i=0; i<size;i++) {
				for(int j=0; j<size; j++) {
					System.out.print(matrix[i][j]+" ");
				}
			}
			System.out.println();
		}
		sc.close();	
	}
}
