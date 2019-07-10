import java.util.Scanner;

/**
 * @author deesingh13
 *
 */
public class NearestPalindrome {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int testCases = sc.nextInt();
		for(int i =1; i <= testCases; i++) {
			int number = sc.nextInt();
			if(isPalindrome(number))
				System.out.println(number);
			else {
				/*for(int j=1;j<Math.sqrt(number);j++) {
					if(isPalindrome(number-j)) {
						System.out.println(number-j);
						break;
					}
					if(isPalindrome(number+j)) {
						System.out.println(number+j);
						break;
					}
				}*/
				String numberStr = Integer.toString(number);
				int length = numberStr.length();
				String halfStr = null;
				StringBuffer revHalf = null;
				if(length%2==0) {
					halfStr = numberStr.substring(0, (length/2));
					revHalf = new StringBuffer(halfStr.substring(0, halfStr.length()));
				} else {
					halfStr = numberStr.substring(0, (length/2)+1);
					revHalf = new StringBuffer(halfStr.substring(0, halfStr.length()-1));
				}

				revHalf.reverse();
				String palinNumber = halfStr.concat(revHalf.toString());
				int diffEq = Integer.parseInt(palinNumber)-number;
				if(diffEq==0) {
					System.out.println(number);
					break;
				}
				if(diffEq>0) {
					int halfLess = Integer.parseInt(halfStr)-1;
					String halfStrLess = Integer.toString(halfLess);
					StringBuffer revHalfLess = null;
					if(length%2==0) {
						revHalfLess = new StringBuffer(halfStrLess.substring(0, halfStrLess.length()));
					} else {
						revHalfLess = new StringBuffer(halfStrLess.substring(0, halfStrLess.length()-1));
					}
					revHalfLess.reverse();
					halfStrLess = halfStrLess.concat(revHalfLess.toString());
					int diffEqLess = Integer.parseInt(halfStrLess)-number;
					if(Math.abs(diffEqLess)<=Math.abs(diffEq)) {
						System.out.println(halfStrLess);
					} else {
						System.out.println(palinNumber); 
					}
				} else {
					int halfMore = Integer.parseInt(halfStr)+1;
					String halfStrMore = Integer.toString(halfMore);
					StringBuffer revHalfMore = null;
					if(length%2==0) {
						revHalfMore = new StringBuffer(halfStrMore.substring(0, halfStrMore.length()));
					} else {
						revHalfMore = new StringBuffer(halfStrMore.substring(0, halfStrMore.length()-1));
					}
					revHalfMore.reverse();
					halfStrMore = halfStrMore.concat(revHalfMore.toString());
					int diffEqMore = Integer.parseInt(halfStrMore)-number;
					if(Math.abs(diffEq)<=Math.abs(diffEqMore)) {
						System.out.println(palinNumber);
					} else {
						System.out.println(halfStrMore); 
					}
				}

			}				
		}
		sc.close();
	}

	private static boolean isPalindrome(Integer number) {
		StringBuffer sb = new StringBuffer(number+"");
		if(sb.reverse().toString().equals(number+""))
			return true;
		return false;
	}
}
