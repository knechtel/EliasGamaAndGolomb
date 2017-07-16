
public class Util {
	
	public static Integer converteAsciiTodictionary(Integer i) {
		if (i == 101) {
			// e
			return 1;
		} else if (i == 116) {
			// t
			return 2;
		} else if (i == 97) {
			// a
			return 3;
		} else if (i == 111) {
			// o
			return 4;
		} else if (i == 105) {
			// i
			return 5;
		} else if (i == 110) {
			// n
			return 6;
		}  if (i == 115) {
			// s
			return 7;
		} else if (i == 104) {
			// h
			return 8;
		} else if (i == 114) {
			// r
			return 9;
		} else if (i == 100) {
			// d
			return 10;
		} else if (i == 108) {
			// l
			return 11;
		} else if (i == 99) {
			// c
			return 12;
		} else if (i == 117) {
			// u
			return 13;
		} else if (i == 109) {
			// m
			return 14;
		} else if (i == 119) {
			// w
			return 15;
		} else if (i == 102) {
			// f
			return 16;
		} else if (i == 103) {
			// g
			return 17;
		} else if (i == 121) {
			// y
			return 18;
		} else if (i == 112) {
			// p
			return 19;
		} else if (i == 118) {
			// p
			return 20;
		} else if (i == 98) {
			// b
			return 21;
		} else if (i == 118) {
			// v
			return 22;
		} else if (i == 107) {
			// k
			return 23;
		} else if (i == 106) {
			// j
			return 24;
		} else if (i == 120) {
			// x
			return 25;

		} else if (i == 113) {
			// q
			return 26;
		} else if (i == 122) {
			// z
			return 27;
		}

		return null;
	}

	public static Integer dictionaryToAscii(Integer i) {
		if (i == 1) {
			// e
			return 101;
		} else if (i == 2) {
			// t
			return 116;
		} else if (i == 3) {
			// a
			return 97;
		} else if (i == 4) {
			// o
			return 111;
		} else if (i == 5) {
			// i
			return 105;
		} else if (i == 6) {
			// n
			return 110;
		} 
		if (i == 7) {
			// s
			return 115;
		} else if (i == 8) {
			// h
			return 104;
		} else if (i == 9) {
			// r
			return 114;
		} else if (i == 10) {
			// d
			return 100;
		} else if (i == 11) {
			// l
			return 108;
		} else if (i == 12) {
			// c
			return 99;
		}  if (i == 13) {
			// u
			return 117;
		} else if (i == 14) {
			// m
			return 109;
		} else if (i == 15) {
			// w
			return 119;
		} else if (i == 16) {
			// f
			return 102;
		} else if (i == 17) {
			// g
			return 103;
		} else if (i == 18) {
			// y
			return 121;
		} else if (i == 19) {
			// p
			return 112;
		} else if (i == 20 ) {
			// p
			return 118;
		} else if (i == 21) {
			// b
			return 98;
		} else if (i == 22) {
			// v
			return 118;
		} else if (i == 23) {
			// k
			return 107;
		} else if (i == 24) {
			// j
			return 106;
		} else if (i == 25) {
			// x
			return 120;

		} else if (i == 26) {
			// q
			return 113;
		} else if (i == 27) {
			// z
			return 122;
		}
		return null;
	}
	
	public static String toBinary(int decimal) {
		String result = "";
		for (int i = 0; i < 8; i++) {
			if (decimal % 2 == 0)
				result = "0" + result;
			else
				result = "1" + result;
			decimal /= 2;
		}
		return result;
	}
	
	public static int getAscii(char c){
		return (int)c;
	}

}
