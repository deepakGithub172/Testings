
/**
 * @author deesingh13
 *
 */
public class RoughWork {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	static int lilysHomework(int[] arr) {
		int asenArr[] = arr;
		int desenArr[] = arr;
		int n = arr.length;
		int count1 = 0;
		int count2 = 0;

		int min1, min2;        
		for(int i = 0; i < n-1; i++)  {
			min1 = i;
			min2 = n-1-i;
			for(int j = i+1; j < n; j++ ) {
				if(asenArr[j] < asenArr[min1])                
					min1 = j;
				if(asenArr[n-1-i-j] < asenArr[min2])              
					min2 = n-1-i-j;
			}

			int temp = asenArr[min1];
			asenArr[min1]=asenArr[i];
			asenArr[i]=temp;
			if(min1 != i)
				count1++;

			temp = desenArr[min2];
			desenArr[min2]=desenArr[n-1-i];
			desenArr[n-1-i]=temp;
			if(min2 != n-1-i)
				count2++;
		}

		/*for(int k = n-1; k >=0 ; k--)  {
			minimum = k ;
			for(int l = k-1; l >= 0 ; l-- ) {
				if(desenArr[l] < desenArr[minimum])  {                
					minimum = l ;
				}
			}
			int temp = desenArr[minimum];
			desenArr[minimum]=desenArr[k];
			desenArr[k]=temp;
			if(minimum != k)
				count2++;
		}*/
		/*System.out.println("count1" + count1 + "count2" + count2);
	        for(int m = 0; m <= n-1 ; m++)  {
	            System.out.println("A" + asenArr[m] + "B" + desenArr[m]);
	        }*/
		if(count1<count2)
			return count1;
		else
			return count2;
	}

	static int commonChild(String s1, String s2) {
		String str2 = s2;
		String str1 = s1;
		String commonChild = "";
		int j = 0;
		while(j<s1.length()) {
			String temp =  "";
			char[] s1Arr = str1.toCharArray();
			for(int i =0; i < str1.length(); i++) {
				if(str2.contains(Character.toString(s1Arr[i]))){
					temp += s1Arr[i];
					str2 = str2.substring(str2.indexOf(s1Arr[i])+1);
				}
			}
			if(temp.length() > commonChild.length()) {
				commonChild = temp;
			}
			j = j+1;
			str1 = s1.substring(j);
			if(str1.length() < commonChild.length())
				break;
			str2 = s2;
		}
		return commonChild.length();
	} 

	static int commonStr(String s1, String s2) {

		StringBuffer str1 = new StringBuffer(s1);
		StringBuffer str2 = new StringBuffer(s2);
		for(int i=str1.length()-1; i>=0; i--) {
			if(!str2.toString().contains(str1.charAt(i)+"")) {
				str1.deleteCharAt(i);
			}
		}

		for(int i=str2.length()-1; i>=0; i--) {
			if(!str1.toString().contains(str2.charAt(i)+"")) {
				str2.deleteCharAt(i);
			}
		}
		int i=0;
		StringBuffer str11 = new StringBuffer(str1);
		StringBuffer str21 = new StringBuffer(str2);
		while(i< str1.length() && !str1.toString().equals(str2.toString())) {
			char ch1 = str1.toString().charAt(i);
			char ch2 = str2.toString().charAt(i);
			if(ch1 != ch2) { 
				str1.deleteCharAt(i);
				if(str2.toString().contains(ch2+""))
					str2.deleteCharAt(str2.indexOf(ch2+""));
			}
			i++;
		}
		i=0;
		while(i< str21.length() && !str21.toString().equals(str11.toString())) {
			char ch1 = str11.toString().charAt(i);
			char ch2 = str21.toString().charAt(i);
			if(ch1 != ch2) { 
				str21.deleteCharAt(i);
				if(str11.toString().contains(ch2+""))
					str11.deleteCharAt(str11.indexOf(ch2+""));
			}
			i++;
		}
		int min1 = Math.min(str1.length(), str2.length());
		int min2 = Math.min(str11.length(), str21.length());
		if(min1 > min2)
			return min1;
		return min2;
	}

}
