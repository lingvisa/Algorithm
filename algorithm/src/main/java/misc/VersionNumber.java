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

	public static void main(String[] args) {

		testVersionNumber();
	}
}
