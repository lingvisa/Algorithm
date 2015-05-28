package misc;


/* Problem: convert an integer into a string representation.
   Algorithm: Keeps dividing number by 10 and take the remainder. Stop when quotient becomes 0.
	          If number was negative initially to print '-' sign.
*/
public class Itoa {

	// 58 => "58"
	static String itoa(int num) {
		
		 if (num == Integer.MIN_VALUE) { 
	         // mininum signed value   
			 return "-2147483648";
		 }

		 boolean negative = false;
		 String s = "";
		 if(num == 0) {
			 return "0";
		 }
		 
		 if (num<0) {
			 negative = true;
		 }
		 
		 if (negative) {
			 num = -1 * num;
		 }
		 while (num != 0)
		 {
			 
			 s = (char)((num % 10) + '0') + s;  // add char to front of s
			 num = num / 10;                   // integer division gives quotient
		 }
		 if (negative) {
			 s = "-" + s;
		 }

		 return s;
	}
	
	public static void main(String[] args) {
		
		System.out.println(itoa(-123));
		System.out.println(itoa(0));
		System.out.println(itoa(123));
		

	}

}
