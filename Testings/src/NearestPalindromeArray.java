import java.math.BigDecimal;
import java.util.Scanner;

/**
 * 
 */

/**
 * @author deesingh13
 *
 */
public class NearestPalindromeArray {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int testCases = sc.nextInt();
		for(int i =1; i <= testCases; i++) {
		    int arrayLength = sc.nextInt();
		    BigDecimal number = BigDecimal.ZERO;
		    for(int j =1; j<= arrayLength; j++){
		        number = (number.multiply(new BigDecimal(10))).add(new BigDecimal(sc.nextInt()));
		    }
			if(isPalindrome(number))
				System.out.println(number);
			else {
				String numberStr = number.toString();
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
				long diffEq = Long.parseLong(palinNumber)-number.intValue();
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
					long diffEqLess = Long.parseLong(halfStrLess)-number.intValue();
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
					long diffEqMore = Long.parseLong(halfStrMore)-number.intValue();
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

	private static boolean isPalindrome(BigDecimal number) {
		StringBuffer sb = new StringBuffer(number.toString());
		if(sb.reverse().toString().equals(number.toString()))
			return true;
		return false;
	}
}
