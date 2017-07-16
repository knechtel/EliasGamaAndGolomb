import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class Desktop {
	@SuppressWarnings("unused")
	private static File selectedFile = null;

	public static void main(String[] args) {
		JFrame frame = new JFrame("TGA- compact text");
		frame.setVisible(true);
		frame.setSize(650, 200);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JPanel panel = new JPanel();
		frame.add(panel);
		JButton button = new JButton("Golomb");
		panel.add(button);
		button.addActionListener(new Action2());

		JButton buttonDecodeGolomb = new JButton("decode Golomb");
		panel.add(buttonDecodeGolomb);
		buttonDecodeGolomb.addActionListener(new DecodeGolomb());

		JButton button2 = new JButton("Encode elias/Gama");
		panel.add(button2);
		button2.addActionListener(new EncodeEliasGama());

		JButton buttonDecodeEliasGama = new JButton("Decode elias/Gama");
		panel.add(buttonDecodeEliasGama);
		buttonDecodeEliasGama.addActionListener(new DecodeEliasGama());

		JButton buttonLoadFile = new JButton("loadFile");
		panel.add(buttonLoadFile);

		buttonLoadFile.addActionListener(new Action3());

		JButton buttonTextToAscii = new JButton("text to ascii");

		panel.add(buttonTextToAscii);

		buttonTextToAscii.addActionListener(new ActionTextToAscii());

		JButton buttonWord = new JButton("texto simples");
		panel.add(buttonWord);
		buttonWord.addActionListener(new SimpleText());

	}

	static class ActionTextToAscii implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			ConvertToAscii.doConv();
		}
	}

	static class Action2 implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			String inStr = JOptionPane.showInputDialog("Entre com o divisor para compactar o texto");

			Integer i = Integer.parseInt(inStr);

			FileGolomb.encodeGolomb(i);
			FileGolomb.readFileAscii();

			JFrame f = new JFrame("Codificação Golomb e ascii:");

			JPanel upperPanel = new JPanel();
			JPanel lowerPanel = new JPanel();
			f.getContentPane().add(upperPanel, "North");
			f.getContentPane().add(lowerPanel, "South");

			JTextArea ta = new JTextArea("Golomb file\n", 21, 8);
			ta.setLineWrap(true);
			lowerPanel.add(new JScrollPane(ta));

			JTextArea ta2 = new JTextArea("ascii file\n", 21, 8);
			ta2.setLineWrap(true);
			ta2.setWrapStyleWord(true);
			lowerPanel.add(new JScrollPane(ta2));

			f.pack();
			f.setVisible(true);
			f.setSize(400, 400);

			for (String str : FileGolomb.listString) {
				int integer = Integer.parseInt(str);

				ta.append(Integer.toHexString(integer) + "\n");
			}

			for (String str : FileGolomb.listBit) {
				int integer = Integer.parseInt(str);

				ta2.append(Integer.toHexString(integer) + "\n");
			}
		}
	}

	static class DecodeGolomb implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			String inStr = JOptionPane.showInputDialog("Entre com o divisor para compactar o texto");

			Integer i = Integer.parseInt(inStr);

			FileGolomb.decodeGolomb(i);

			JFrame f = new JFrame("Codificação Golomb e ascii:");

			JPanel upperPanel = new JPanel();
			JPanel lowerPanel = new JPanel();
			f.getContentPane().add(upperPanel, "North");
			f.getContentPane().add(lowerPanel, "South");

			JTextArea ta = new JTextArea("text file\n", 21, 29);
			ta.setLineWrap(true);
			lowerPanel.add(new JScrollPane(ta));

			f.pack();
			f.setVisible(true);
			f.setSize(400, 400);

			for (Character c : FileGolomb.listCharacterDecode)
				ta.append(c.toString());

		}
	}

	static class Action3 implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			JFileChooser fileChooser = new JFileChooser();
			int returnValue = fileChooser.showOpenDialog(null);
			if (returnValue == JFileChooser.APPROVE_OPTION) {

				selectedFile = fileChooser.getSelectedFile();

			}
		}

	}

	static class SimpleText implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			try {
				System.out.println(System.getProperty("user.dir"));

				// start notepad "myfile.txt"
				Runtime.getRuntime().exec("open " + System.getProperty("user.dir") + "/words.txt");
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}

	}

	static class EncodeEliasGama implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			FileGolomb.readFileAscii();
			FileEliasGama.encodeEliasGama();

			JFrame f = new JFrame("Codificação EliasGama e ascii:");

			JPanel upperPanel = new JPanel();
			JPanel lowerPanel = new JPanel();
			f.getContentPane().add(upperPanel, "North");
			f.getContentPane().add(lowerPanel, "South");

			JTextArea ta = new JTextArea("Elias/Gama file ", 21, 8);
			ta.setLineWrap(true);
			lowerPanel.add(new JScrollPane(ta));

			JTextArea ta2 = new JTextArea("ascii file\n", 21, 8);
			ta2.setLineWrap(true);
			ta2.setWrapStyleWord(true);
			lowerPanel.add(new JScrollPane(ta2));

			f.pack();
			f.setVisible(true);
			f.setSize(400, 400);

			for (String str : FileGolomb.listBit) {
				int integer = Integer.parseInt(str);

				ta2.append(Integer.toHexString(integer) + "\n");
			}

			for (String c : FileEliasGama.listString) {
				int integer = Integer.parseInt(c);
				ta.append(Integer.toHexString(integer) + "\n");
			}

		}
	}

	static class DecodeEliasGama implements ActionListener {
		public void actionPerformed(ActionEvent e) {

			FileEliasGama.decodeEliasGama();

			JFrame f = new JFrame("Codificação Elias/Gama e ascii:");

			JPanel upperPanel = new JPanel();
			JPanel lowerPanel = new JPanel();
			f.getContentPane().add(upperPanel, "North");
			f.getContentPane().add(lowerPanel, "South");

			JTextArea ta = new JTextArea("text file\n", 21, 29);
			ta.setLineWrap(true);
			lowerPanel.add(new JScrollPane(ta));

			f.pack();
			f.setVisible(true);
			f.setSize(400, 400);

			for (String c : FileEliasGama.listCharacter)
				ta.append(c.toString());

		}
	}

	static String content = "start\n";

}
