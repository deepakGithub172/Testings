import java.io.IOException;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * @author deesingh13
 *
 */
public class QueenAttack {

	// Complete the queensAttack function below.
	static int queensAttack(int n, int k, int r_q, int c_q, int[][] obstacles) {

        Set<String> attackAreas = new HashSet<>();
        int i=1;
        while(i<=n){
            if(i!=r_q)
                attackAreas.add(i+","+c_q);
            i++;
        }
        int r=r_q,r1 =r_q, r2= r_q, c= c_q;
        while(c>=2){
            c--;
            attackAreas.add(r+","+c);
            if(r1>=2) {
                r1=r1-1;
                attackAreas.add(r1+","+c);
            }
            if(r2<=n-1) {
                r2=r2+1;
                attackAreas.add(r2+","+c);
            }
        }
        r=r_q;
        r1 =r_q;
        r2 =r_q;
        c= c_q;
        while(c<=n-1){
            c++;
            attackAreas.add(r+","+c);
            if(r1>=2) {
                r1=r1-1;
                attackAreas.add(r1+","+c);
            }
            if(r2<=n-1) {
                r2=r2+1;
                attackAreas.add(r2+","+c);
            }
        }
        for(int j=0; j<k; j++){
            String obstacle = obstacles[j][0]+","+obstacles[j][1];
            attackAreas.remove(obstacle);
        }
        return attackAreas.size();
    }

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws IOException {

		String[] nk = scanner.nextLine().split(" ");

		int n = Integer.parseInt(nk[0]);

		int k = Integer.parseInt(nk[1]);

		String[] r_qC_q = scanner.nextLine().split(" ");

		int r_q = Integer.parseInt(r_qC_q[0]);

		int c_q = Integer.parseInt(r_qC_q[1]);

		int[][] obstacles = new int[k][2];

		for (int i = 0; i < k; i++) {
			String[] obstaclesRowItems = scanner.nextLine().split(" ");
			scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

			for (int j = 0; j < 2; j++) {
				int obstaclesItem = Integer.parseInt(obstaclesRowItems[j]);
				obstacles[i][j] = obstaclesItem;
			}
		}

		int result = queensAttack(n, k, r_q, c_q, obstacles);

		System.out.println(result);

		scanner.close();
	}

}
