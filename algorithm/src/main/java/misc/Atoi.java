package misc;

public class Atoi {

	/**
	 *  Problem: Convert a string to an interger, i.e. String str = "733" => int = 733
	 *           Be careful of all corner cases
	 * 
	 * */
	static int atoi(char[] str)
	{
	    // null or empty string
		if(str==null || str.length==0) {
	    	return 0;
	    }
	    
		int result = 0; 
		int sign = 1;
		int i = 0;
		
		// handle negative number
		if(str[0] == '-') {
			sign = -1;
			i++;
		}
		
	    // Iterate through all characters of input string and update result
	    for (; i<str.length; ++i) {
	        
	    	if(!Character.isDigit(str[i])) {
	    		System.err.println("Invalid number: " + String.valueOf(str));
	    		return 0;
	    	}
	    	result = result*10 + str[i] - '0';	        		
	    }
	    
	    // handle max and min permitted in Java
	    if( result > Integer.MAX_VALUE) {
	    	return Integer.MAX_VALUE;
	    }
	    if( result < Integer.MIN_VALUE) {
	    	return Integer.MIN_VALUE;
	    }
	 
	    // return result.
	    return sign * result;
	}
	
	public static void main(String[] args) {
		
		System.out.println(atoi("733".toCharArray()));
		
	}
}
