import java.util.Scanner;

/**
 * 
 */

/**
 * @author deesingh13
 *
 */
public class LongestPalindromicString {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int testCases = sc.nextInt();
		int length;
		String str, longestPalin="";
		for(int t=1; t<=testCases; t++) {
			str = sc.next();
			length = str.length();
			for(int i=0; i<length; i++) {
				char start = str.charAt(i);
				for(int j=(i+1); j<length; j++) {
					char end = str.charAt(j);
					if(start == end) {
						String subStr = str.substring(i, j);
						if(isPalindrome(subStr) && subStr.length()>longestPalin.length())
							longestPalin = subStr;	
					}
				}
			}
			System.out.println(longestPalin);			
		}
		sc.close();
	}

	private static boolean isPalindrome(String str) {
		StringBuffer sb = new StringBuffer(str);
		if(sb.reverse().toString().equals(str))
			return true;
		return false;
	}
}
