
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class ConvertToAscii {

	static List<String> listString = new ArrayList<String>();
	
	
	public static void doConv(){
		byte[] b = null;
		try {
			FileReader fr = new FileReader(new File(
					System.getProperty("user.dir")+"/words.txt"));
			BufferedReader br = new BufferedReader(fr);
			String str = null;
			while ((str = br.readLine()) != null) {
				b = str.getBytes();

				for (byte bt : b) {
					System.out.println(Util.toBinary(Util.getAscii((char) bt)));
					listString.add(Util.toBinary(Util.getAscii((char) bt)));
					//01100001
				}

			}
			System.out.println(b.length);
			br.close();
			fr.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		FileWriter fw = null;
		BufferedWriter bw = null;
		try {
			fw = new FileWriter(new File(
					System.getProperty("user.dir")+"/ascii.txt"));
			 bw = new BufferedWriter(fw);

			for (String s : listString) {
				bw.write(s+"\n");
			}

			
			bw.close();
			fw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static void main(String[] args) {
		byte[] b = null;
		try {
			FileReader fr = new FileReader(new File(
					System.getProperty("user.dir")+"/words.txt"));
			BufferedReader br = new BufferedReader(fr);
			String str = null;
			while ((str = br.readLine()) != null) {
				b = str.getBytes();

				for (byte bt : b) {
					System.out.println(Util.toBinary(Util.getAscii((char) bt)));
					listString.add(Util.toBinary(Util.getAscii((char) bt)));
					//01100001
				}

			}
			System.out.println(b.length);
			br.close();
			fr.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		FileWriter fw = null;
		BufferedWriter bw = null;
		try {
			fw = new FileWriter(new File(
					System.getProperty("user.dir")+"/ascii.txt"));
			 bw = new BufferedWriter(fw);

			for (String s : listString) {
				bw.write(s+"\n");
			}

			
			bw.close();
			fw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
