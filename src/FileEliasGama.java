import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileEliasGama {
	static List<String> listCharacter = new ArrayList<String>();
	static 	List<String> listString = new ArrayList<String>();
	static void decodeEliasGama() {

	listCharacter = new ArrayList<>();
		StringBuilder sb = new StringBuilder();
		StringBuilder sBIT = new StringBuilder();

		try {

			BufferedReader br = new BufferedReader(
					new FileReader(new File(System.getProperty("user.dir") + "/eliasGama.txt")));

			String str = "";

			boolean ctlStopBit = false;
			while ((str = br.readLine()) != null) {
				String bits[] = str.split("\\.*");

				for (String strBit : bits) {

					if (strBit.equals("1")) {
						ctlStopBit = true;
					}

					if (ctlStopBit == true) {
						sBIT.append(strBit);
					} else {
						sb.append(strBit);
					}

				}
				ctlStopBit = false;

				if (sb.length() == 0) {
					int iAscii = Util.dictionaryToAscii(Integer.parseInt(sBIT.toString()));
					char c = (char) iAscii;
					listCharacter.add(c + "");

				} else {

					double vl = Math.pow(2, sb.length());

					sBIT.delete(0, 1);
					int i = Integer.parseInt(sBIT.toString(), 2);

					int total = i + (int) vl;

					int iAscii = Util.dictionaryToAscii(total);
					char c = (char) iAscii;
					listCharacter.add(c + "");
				}

				sBIT = new StringBuilder();
				sb = new StringBuilder();
			}
			br.close();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println("decode:");
		for (String s : listCharacter)
			System.out.println(s);

	}

	static void encodeEliasGama() {
		listString = new ArrayList<String>();
		StringBuilder text = new StringBuilder();
		byte[] b = null;
		try {
			BufferedReader br = new BufferedReader(
					new FileReader(new File(System.getProperty("user.dir") + "/ascii.txt")));

			BufferedWriter bw = null;
			try {
				bw = new BufferedWriter(new FileWriter(new File(System.getProperty("user.dir") + "/eliasGama.txt")));

				String s = "";

				while ((s = br.readLine()) != null) {
					String[] bytes = s.split("\n");
					for (String sb : bytes) {
						// bw.write();
						int iascii = Integer.parseInt(sb, 2);
						listString.add(FileGolomb.eliasGama(Util.converteAsciiTodictionary(iascii)));

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
			fw = new FileWriter(new File(System.getProperty("user.dir") + "/eliasGama.txt"));
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

	public static void main(String[] args) {
		decodeEliasGama();
//encodeEliasGama();
	}

}
