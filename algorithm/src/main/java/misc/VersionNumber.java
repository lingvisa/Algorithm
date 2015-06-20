package misc;

/*
 * Author: Congmin Min
 * Date: 06/18/2015
 * 
 * Problem: Compare two version numbers version1 and version2.
 * If version1 > version2 return 1, if version1 < version2 return -1, otherwise return 0.

 * You may assume that the version strings are non-empty and contain only digits and the . character.
 * The . character does not represent a decimal point and is used to separate number sequences.
 * For instance, 2.5 is not "two and a half" or "half way to version three", it is the fifth second-level revision 
 * of the second first-level revision.
 * 
 * Example: 0.1 < 1.1 < 1.2 < 13.37
 * 
 * Algorithm: Compare first and second levels of each version accordingly. Be sure to take care of different combinations of the two levels.
 *            Also, to make sure '0' in second level is equal to '0' or 'null' of the other version number.
 * 
 * */

public class VersionNumber {

	// Case 1: assume only one dot exists in the string: 10.0 : 0.9
	static int compare(String v1, String v2) {

		int loc1 = v1.indexOf('.');
		int loc2 = v2.indexOf('.');

		String v1FirstLevel = v1;
		String v1SecondLevel = "0";
		if(loc1 != -1) {
			v1FirstLevel = v1.substring(0, loc1);
			v1SecondLevel = v1.substring(loc1+1);
		}

		String v2FirstLevel = v2;
		String v2SecondLevel = "0";
		if(loc2 != -1) {
			v2FirstLevel = v2.substring(0, loc2);
			v2SecondLevel = v2.substring(loc2+1);
		}

		int v1FirstLevelInt = Integer.valueOf(v1FirstLevel);
		int v2FirstLevelInt = Integer.valueOf(v2FirstLevel);
		int v1SecondLevelInt = Integer.valueOf(v1SecondLevel);;
		int v2SecondLevelInt = Integer.valueOf(v2SecondLevel);;

		if(v1FirstLevelInt > v2FirstLevelInt) {
			return 1;
		}else if(v1FirstLevelInt < v2FirstLevelInt) {
			return -1;
		}else if(v1SecondLevelInt > v2SecondLevelInt){
			return 1;
		}else if(v1SecondLevelInt < v2SecondLevelInt){
			return -1;
		}else{
			return 0;
		}
	}
	
	// Case 2: A more generic version, allow for multiple occurrences.
	// 1.0.0.0.1 :: 1.0
	// 1.0 :: 1.0.2
	static int compare2(String v1, String v2) {
		
		int loc1 = v1.indexOf('.');
		int loc2 = v2.indexOf('.');

		String v1FirstLevel = v1;
		String v1RestLevel = "0";
		
		int v1FirstLevelInt = 0;
		int v2FirstLevelInt = 0;
		
		if(loc1 != -1) {
			v1FirstLevel = v1.substring(0,loc1);		
			v1RestLevel = v1.substring(loc1+1);
		}
		v1FirstLevelInt = Integer.valueOf(v1FirstLevel);

		String v2FirstLevel = v2;
		String v2RestLevel = "0";
		if(loc2 != -1) {
			v2FirstLevel = v2.substring(0,loc2);		
			v2RestLevel = v2.substring(loc2+1);
		}
		v2FirstLevelInt = Integer.valueOf(v2FirstLevel);
		
		// 1.0 : 1.0
		// v1 doesn't contain dot any more
		if(loc1 == -1){
			if(loc2==-1){ // v2 doesn't contain any dot any more
				if(v1FirstLevelInt > v2FirstLevelInt){
					return 1;
				}else if(v1FirstLevelInt < v2FirstLevelInt) {
					return -1;
				}else{
					return 0;
				}
			}else { // v2 still contain dots, continually split v2, and compare with v1 (no dot)
				compare2(v1RestLevel, v2RestLevel);
			}
		}else if(loc2==-1){ // v1 still contains dot, but v2 doesn't contain dot
			compare2(v1RestLevel,v2RestLevel);
		}

		// both v1 & v2 contain dots, 
		if(v1FirstLevelInt > v2FirstLevelInt){
			return 1;
		}else if(v1FirstLevelInt < v2FirstLevelInt){
			return -1;
		}else{	
			return compare2(v1RestLevel, v2RestLevel);
		}
	}
	
	static void testVersionNumber() {

		assert compare("0.1", "1.1") ==-1;
		assert compare("0.1", "0.1") == 0;
		assert compare("0.1", "0.2") == -1;
		assert compare("0.1", "0.0") == 1;
		assert compare("0.0", "0.1") == -1;
		assert compare("1.0", "1.37") ==-1;
		assert compare("1.1", "1.0") ==1;
		assert compare("1", "1.0") ==0;
		assert compare("1.0", "1") ==0;

		System.out.println("testVersionNumber() successful!");
	}

	static void testVersionNumber2() {

		assert compare2("0.1", "1.1") ==-1;
		assert compare2("0.1", "0.1") == 0;
		assert compare2("0.1", "0.2") == -1;
		assert compare2("0.1", "0.0") == 1;
		assert compare2("0.0", "0.1") == -1;
		assert compare2("1.0", "1.37") ==-1;
		assert compare2("1.1", "1.0") ==1;
		assert compare2("1", "1.0") ==0;
		assert compare2("1.0", "1") ==0;

		// 
		assert compare2("1.0.0.0.1", "1.0") == 1;
		assert compare2("1.0.0.0.0", "1.0") == 0;
		assert compare2("1.0.0.0.0", "1.0.1") == -1;
		assert compare2("1.0.0.0.1", "1.2") == -1;
		assert compare2("1.0", "1.0.2") == -1;
		assert compare2("1", "1") == 0;
		assert compare2("1", "2") == -1;
		assert compare2("2", "1") == 1;
		
		System.out.println("testVersionNumber2() successful!");
	}

	
	public static void main(String[] args) {

		testVersionNumber();
		testVersionNumber2();
	}
}
