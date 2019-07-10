import java.util.Scanner;

/**
 * 
 */

/**
 * @author deesingh13
 *
 */
public class GeneralisedFabonacci {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int testCases = sc.nextInt();
		int a,b,c,n,m;
		double fabo = 0;		
		for(int t =1; t <= testCases; t++) {
			a = sc.nextInt();
			b = sc.nextInt();
			c = sc.nextInt();
			n = sc.nextInt();
			m = sc.nextInt();
			fabo = getFabo(a, b, c, n);
			System.out.println(fabo%m);
		}
		sc.close();
	}
	
	private static double getFabo(int a,int b,int c, int n) {
		if(n==1 || n==2)
			return 1;
		return (a*getFabo(a, b, c, n-1)+b*getFabo(a, b, c, n-2)+c);
	}

}
