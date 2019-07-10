import java.util.Scanner;

/**
 * 
 */

/**
 * @author deesingh13
 *
 */
public class TrapRainWater {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int testCases = sc.nextInt();
		int size, quantity;

		for(int t=1; t<=testCases; t++) {
			size = sc.nextInt();
			int a[]= new int[size];
			quantity=0;
			int highestPoint =0, highestPosition=0;
			for(int i=0; i<size; i++) {
				a[i] = sc.nextInt();
				if(highestPoint<a[i]) {
					highestPoint = a[i];
					highestPosition = i;
				}
			}
			int highest=a[0], highPos=0, height, blocksBtw=0;	
			for(int i=1; i<=highestPosition; i++) {
				height = a[i];
				if(highest<= height) {
					quantity = quantity+(highest*(i-highPos-1)-blocksBtw);
					highest = height;
					highPos = i;	
					blocksBtw=0;
				}else {
					blocksBtw += height;
				}
			}
			highest=a[size-1];
			highPos=size-1;
			blocksBtw =0;
			for(int i=size-2; i>=highestPosition; i--) {
				height = a[i];
				if(highest<= height) {
					quantity = quantity+(highest*(highPos-i-1)-blocksBtw);
					highest = height;
					highPos = i;	
					blocksBtw=0;
				}else {
					blocksBtw += height;
				}
			}
			System.out.println(quantity);
		}
		sc.close();	
	}
}
