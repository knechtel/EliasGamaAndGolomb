
public class Config {

	@SuppressWarnings("null")
	static char binaryToAscii(String s) {
		
		if(s.equals("01011011")||s.equals("1011011"))
			return '[';
		if(s.equals("01011101")||s.equals("1011101"))
			return ']';
		if(s.equals("00111011")||s.equals("0111011")||s.equals("111011"))
			return ';';
		
		if(s.equals("00100010")||s.equals("0100010")||s.equals("100010"))
			return '\"';
		
		if(s.equals("00111001")||s.equals("0111001")||s.equals("111001"))
			return '9';
		if(s.equals("00111000")||s.equals("0111000")||s.equals("111000"))
			return '8';
		if(s.equals("00110111")||s.equals("0110111")||s.equals("110111"))
			return '7';
		
		if(s.equals("00110110")||s.equals("0110110")||s.equals("110110"))
			return '6';
		
		if(s.equals("00110101")||s.equals("0110101")||s.equals("110101"))
			return '5';
		
		if(s.equals("00110100")||s.equals("0110100")||s.equals("110100"))
			return '4';
		
		if(s.equals("00110011")||s.equals("110011")||s.equals("0110011"))
			return '3';
		
		if(s.equals("00110010")||s.equals("0110010")||s.equals("110010"))
			return '2';
		
		if(s.equals("00110001")||s.equals("110001")||s.equals("0110001"))
			return '1';
		
		if(s.equals("00110000")||s.equals("110000")||s.equals("0110000"))
			return '0';
		
		if(s.equals("00101000")||s.equals("0101000")||s.equals("101000"))
			return '(';
		
		if(s.equals("00101001")||s.equals("0101001")||s.equals("101001"))
			return ')';
		
		if(s.equals("00101100")||s.equals("101100")||s.equals("0101100"))
			return ',';
		
		if(s.equals("00101110")||s.equals("0101110")||s.equals("101110"))
			return '.';
		if(s.equals("00100111")||s.equals("0100111")||s.equals("100111"))
			return '\'';

		if (s.equals("01000001") || s.equals("1000001"))
			return 'A';

		if (s.equals("01000010") || s.equals("1000010"))
			return 'B';

		if (s.equals("01000011") || s.equals("1000011"))
			return 'C';

		if (s.equals("01000100") || s.equals("1000100"))
			return 'D';
		if (s.equals("01000101") || s.equals("1000101"))
			return 'E';

		if (s.equals("01000110") || s.equals("1000110"))
			return 'F';

		if (s.equals("01000111") || s.equals("1000111"))
			return 'G';

		if (s.equals("01001000") || s.equals("1001000"))
			return 'H';

		if (s.equals("01001001") || s.equals("1001001"))
			return 'I';

		if (s.equals("01001010") || s.equals("1001010"))
			return 'J';
		if (s.equals("01001011") || s.equals("1001011"))
			return 'K';

		if (s.equals("01001100") || s.equals("1001100"))
			return 'L';

		if (s.equals("01001101") || s.equals("1001101"))
			return 'M';

		if (s.equals("01001110") || s.equals("1001110"))
			return 'N';

		if (s.equals("01001111") || s.equals("1001111"))
			return 'O';

		if (s.equals("01010000") || s.equals("1010000"))
			return 'P';

		if (s.equals("01010001") || s.equals("1010001"))
			return 'Q';
		if (s.equals("01010010") || s.equals("1010010"))
			return 'R';
		if (s.equals("01010011") || s.equals("1010011"))
			return 'S';
		
		if(s.equals("01010100")||s.equals("1010100"))
			return 'T';
		
		if(s.equals("01010101")|| s.equals("1010101"))
			return 'U';
		
		if(s.equals("01010110")||s.equals("1010110"))
			return 'V';
			
		if(s.equals("01010111")||s.equals("1010111"))	
			return 'W';
		
		if(s.equals("01011000")||s.equals("1011000"))
			return 'X';
		
		if(s.equals("01011001")||s.equals("1011001"))
			return 'Y';
		
		if(s.equals("01011010")||s.equals("1011010"))
			return 'Z';
		
		if (s.equals("00100000") || s.equals("0100000") || s.equals("100000"))
			return ' ';
		if (s.equals("01111010") || s.equals("1111010"))
			return 'z';

		if (s.equals("01111001") || s.equals("1111001"))
			return 'y';

		if (s.equals("01111000") || s.equals("1111000"))
			return 'x';

		if (s.equals("1110111") || s.equals("01110111"))
			return 'w';

		if (s.equals("01110110") || s.equals("1110110"))
			return 'v';

		if (s.equals("01110101") || s.equals("1110101"))
			return 'u';

		if (s.equals("01110010") || s.equals("1110010"))
			return 'r';

		if (s.equals("01110001") || s.equals("1110001"))
			return 'q';

		if (s.equals("01110000") || s.equals("1110000"))
			return 'p';

		if (s.equals("01101111") || s.equals("1101111"))
			return 'o';

		if (s.equals("01101110") || s.equals("1101110"))
			return 'n';

		if (s.equals("01101101") || s.equals("1101101"))
			return 'm';

		if (s.equals("01101100") || s.equals("1101100"))
			return 'l';

		if (s.equals("01101011") || s.equals("1101011"))
			return 'K';
		if (s.equals("01101010") || s.equals("1101010"))
			return 'j';
		if (s.equals("01101001") || s.equals("1101001"))
			return 'i';

		if (s.equals("1110100") || s.equals("01110100"))
			return 't';

		// h
		if (s.equals("01101000") || s.equals("1101000"))
			return 'h';
		if (s.equals("01100111") || s.equals("1100111"))
			return 'g';
		if (s.equals("1100110") || s.equals("01100110"))
			return 'f';
		if (s.equals("1100100") || s.equals("01100100"))
			return 'd';
		if (s.equals("1100011") || s.equals("01100011"))
			return 'c';
		if (s.equals("1100101") || s.equals("01100101"))
			return 'e';
		if (s.equals("1100010") || s.equals("01100010"))
			return 'b';
		if (s.equals("1100001") || s.equals("01100001"))
			return 'a';
		if (s.equals("01110011"))
			// 11010010
			// 11100001
			return (Character) 's';
		
			return (Character) null;
	}
	
	static void asciiToEliasGama(String str){
		if(str.equals("1100101")){
			
		}
	}

}
