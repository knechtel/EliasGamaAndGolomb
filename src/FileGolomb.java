
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;



public class FileGolomb {
	static List<String> listString = null;

	static List<Character> listCharacterDecode = new ArrayList<Character>();
	static List<String> listBit = null;

	public static void decodeGolomb(int divisor) {
		StringBuilder sb = new StringBuilder();
		StringBuilder sbAntesStopBit = new StringBuilder();
		listCharacterDecode = new ArrayList<Character>();
		try {

			BufferedReader br = new BufferedReader(
					new FileReader(new File(System.getProperty("user.dir") + "/codeGolomb.txt")));

			String str = "";
		

			boolean ctlIsStopBit = false;
			boolean ctlBinary = false;
			while ((str = br.readLine()) != null) {
				String bits[] = str.split("\\.*");
				sbAntesStopBit = new StringBuilder();
				for (String s : bits) {
					if (ctlIsStopBit) {
						sb.append(s);
					}
					sbAntesStopBit.append(s);
					System.out.println(s);
					if (s.equals("1")) {
						ctlIsStopBit = true;

						if (sbAntesStopBit.length() == 1) {
							ctlBinary = true;
						}
					}

					// System.out.println(s);
				}

				ctlIsStopBit = false;
				int i = Integer.parseInt(sb.toString(), 2);
				i = i + divisor;

				String b = Util.toBinary(i);
			

				char letter = (char) i;

				if (ctlBinary) {
					System.out.println(sb);
					String s = sb.substring(1, sb.length() - 1);
					listCharacterDecode.add(Config.binaryToAscii(sb.toString()));
				} else {
					listCharacterDecode.add(Config.binaryToAscii(b));
				}
				System.out.println(letter);

				sb = new StringBuilder();
				ctlBinary = false;
				ctlIsStopBit = false;
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("decode ===========");
		for (Character c : listCharacterDecode)
			System.out.println(c);

	}

	public static String unary(Integer n) {
		String un = "";
		for (int i = 0; i < n; i++) {
			un = un + "0";
		}
		return un;
	}

	public static String eliasGama(Integer code) {
		if (code == 1) {
			return "1";
		}
		Integer unary = (int) (Math.log(code) / Math.log(2));
		Integer binary = (int) ((int) code - Math.pow(2, unary));
		String bStr = Integer.toBinaryString(binary);

		while (bStr.length() < unary(unary).length()) {
			bStr = "0" + bStr;
		}
		String result = unary(unary) + "1" + bStr;
		return result;
	}

	public static String golomb(Integer encode, Integer divisor) {

		Integer q = encode / divisor;
		Integer r = encode % divisor;

		String i = Integer.toBinaryString(r);
		String str = unary(q);

		// stopBit
		str = str + "1" + i;
		return str;
	}

	public static void readFileAscii() {
		listBit = new ArrayList<String>();
		try {
			BufferedReader br = new BufferedReader(
					new FileReader(new File(System.getProperty("user.dir") + "/ascii.txt")));

	
			String str = "";
			try {
				while ((str = br.readLine()) != null) {

					if (listBit == null)
						listBit = new ArrayList<String>();
					listBit.add(str);

				}

				br.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static void readAndWriteAscii() {
		StringBuilder text = new StringBuilder();
		try {
			BufferedReader br = new BufferedReader(
					new FileReader(new File(System.getProperty("user.dir") + "/words.txt")));

			BufferedWriter bw = null;
			try {
				bw = new BufferedWriter(new FileWriter(new File(System.getProperty("user.dir") + "/ascii.txt")));
			} catch (IOException e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}
			String s = "";
			try {
				while ((s = br.readLine()) != null) {

					String[] aux = s.split("\\.*");

					for (String x : aux) {
						char arrays[] = x.toCharArray();

						String sl = "" + Integer.toBinaryString(Util.getAscii(arrays[0]));
						while (sl.length() < 8) {
							sl = "0" + sl;
						}

						text.append("" + sl + "\n");
						System.out.println(text.toString());
					}

				}
				bw.write(text.toString());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				bw.close();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			try {
				br.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void encodeGolomb(Integer divisor) {
		listString = new ArrayList<String>();
		StringBuilder text = new StringBuilder();
		byte[] b = null;
		try {
			BufferedReader br = new BufferedReader(
					new FileReader(new File(System.getProperty("user.dir") + "/ascii.txt")));

			BufferedWriter bw = null;
			try {
				bw = new BufferedWriter(new FileWriter(new File(System.getProperty("user.dir") + "/codeGolomb.txt")));

				String s = "";

				while ((s = br.readLine()) != null) {
					String[] bytes = s.split("\n");
					for (String sb : bytes) {
						// bw.write();
						listString.add(golomb(Integer.parseInt(sb, 2), divisor));

					}

				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {

				for (String s : listString) {
					System.out.println(s);
					bw.write(s + "\n");
				}

				bw.close();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			try {
				br.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		FileWriter fw = null;
		BufferedWriter bw = null;
		try {
			fw = new FileWriter(new File(System.getProperty("user.dir") + "/codeGolomb.txt"));
			bw = new BufferedWriter(fw);

			for (String s : listString) {
				bw.write(s + "\n");
			}

			bw.close();
			fw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static void main(String[] args) throws IOException {
		decodeGolomb(113);
		// System.out.println(eliasGama(28));
		// readAndWriteAscii();
		// readFileAscii();
		// System.out.println(golomb(115, 4));

		// String divisor = JOptionPane.showInputDialog("Escolha o divisor para
		// compactar com Golomb code :");

		// encodeGolomb(Integer.parseInt(divisor));
		// System.out.println("FIM");
	}
}
