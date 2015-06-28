package misc;

/*
 * Problem: Given two binary strings (consisting of all '0' and '1'), return their sum, which is also a binary string
 * 
 * Example: a="11", b="1", return "100"
 * 
 * Algorithm: Two indices i & j moving from the end to the beginning of 'a' and 'b', the sum at each index is 'temp' + a[i] + b[j].
 *            Be careful to update temp's value accordingly based on each pair of a[i] and b[j].
 * 
 * */

public class BinaryString {

	
	static String add(String a, String b) {
		
		if(a==null || b==null) {
			return null;
		}
		
		StringBuilder sb = new StringBuilder();
		char temp='0';
		int j=b.length()-1;
		
		// case 1: 'a' is longer than 'b'
		for(int i=a.length()-1; i>=0; i--){
			
			char charA = a.charAt(i);
			if(j>=0){
				char charB = b.charAt(j);
				
				if((charA=='1' && charB=='0')||
				   (charA=='0' && charB=='1')) {
					if(temp=='0'){
						sb.append('1');
					}else{
						sb.append('0');						
					}
				}else if(charA=='0' && charB=='0') {
					if(temp=='0') {
						sb.append('0');
					}else{
						sb.append('1');
						temp=0;
					}
				}else{
					if(temp=='0'){
						temp=1;
						sb.append('0');
					}else{
						sb.append('1');
					}
				}
				j--;
			}else{
				if(temp=='0') {
					sb.append(charA);
				}else if(charA=='0') {
					sb.append(temp);
					temp=0;
				}else{
					sb.append('0');
				}
			}
		}
		
		// case 2: 'a' is shorter than 'b'
		while(j>=0) {
			char charB = b.charAt(j);
			if(temp=='0') {
				sb.append(charB);
			}else if(charB=='0') {
				sb.append(temp);
				temp=0;
			}else{
				sb.append('0');
			}
			j--;
		}
		
		if(temp==1) {
			sb.append('1');
		}
		
		return sb.reverse().toString();
	}
	
	
	static String add2(String a, String b) {
		
		StringBuilder sb = new StringBuilder();
		
		char charA = '0';
		char charB = '0';
		
		int carry = '0';
		
		for(int i=a.length()-1, j=b.length()-1; i>=0 || j>=0; i--, j--) {
			
			if(i>=0) {
				charA = a.charAt(i);
			}
			if(j>=0) {
				charB = b.charAt(j);
			}
			
			int intA = Character.getNumericValue(charA);
			int intB = Character.getNumericValue(charB);
			
			int sum = (intA+intB)%2;
			carry = (intA+intB)/2;
			
			
			if(sum==1) {
				if(carry==1){
					sum=0;
				}
			}else if(carry==1){
				carry=0;
			}
			
			sb.append(String.valueOf(sum));
		}
		
		if(carry==1) {
			sb.append(carry);
		}
		
		return sb.reverse().toString();
	}
	
	static void testAdd() {

		assert add("11", "1").equals("100");
		assert add("11", "11").equals("110");
		assert add("11", "10").equals("101");
		assert add("00", "00").equals("00");
		assert add("10", "10").equals("100");
		assert add("10", "11").equals("101");
		assert add("00", "0").equals("00");

		assert add("1", "11").equals("100");
		assert add("0", "11").equals("11");
		assert add("101", "1100").equals("10001");

		System.out.println("TestAdd() cases successful!");
	}
	
	static void testAdd2() {
		
		assert add2("11", "1").equals("100");
		assert add2("11", "11").equals("110");
		assert add2("11", "10").equals("101");
		assert add2("00", "00").equals("00");
		assert add2("10", "10").equals("100");
		assert add2("10", "11").equals("101");
		assert add2("00", "0").equals("00");

		assert add2("1", "11").equals("100");
		assert add2("0", "11").equals("11");
		assert add2("101", "1100").equals("10001");
		System.out.println("TestAdd2() cases successful!");
	}
	
	public static void main(String[] args) {

		testAdd();
		testAdd2();
	}
}
