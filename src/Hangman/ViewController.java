package Hangman;

import java.util.Random;

import javax.swing.JOptionPane;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.stage.Stage;;

public class ViewController implements ViewControllerInterface {

	@FXML
	protected Line line1;
	@FXML
	protected Line line2;
	@FXML
	protected Line line3;
	@FXML
	protected Line line4;
	@FXML
	protected Line line5;
	@FXML
	protected Circle line6;
	@FXML
	protected Line line7;
	@FXML
	protected Line line8;
	@FXML
	protected Line line9;
	@FXML
	protected Line line10;
	@FXML
	protected Line line11;
	@FXML
	protected Label solution;
	public String word;
	public char[] guess;
	public boolean start = true;
	public int k;
	public boolean line = false;
	public int s = 0;
	public char[] array;

	@FXML
	public void test(MouseEvent test) {
		String letter = ((Label) test.getSource()).getText();
		for (int i = 0; i < word.length(); i++) {
			if (letter.charAt(0) == word.charAt(i)) {
				System.out.println("yay");
				line = true;
				s++;
				array[i] = letter.charAt(0);
				String b = new String(array);
				solution.setText(b);
			}
		}
		if (s == word.length()) {
			JOptionPane.showMessageDialog(null, "Du hast es Geschafft!!!", "Overpro", JOptionPane.ERROR_MESSAGE);
			Load.loadScene("Hangman");
		}
		((Label) test.getSource()).setVisible(false);
		if (!line) {

			switch (k) {
			case (1):
				line1.setVisible(true);
				break;
			case (2):
				line2.setVisible(true);
				break;
			case (3):
				line3.setVisible(true);
				break;
			case (4):
				line4.setVisible(true);
				break;
			case (5):
				line5.setVisible(true);
				break;
			case (6):
				line6.setVisible(true);
				break;
			case (7):
				line7.setVisible(true);
				break;
			case (8):
				line8.setVisible(true);
				break;
			case (9):
				line9.setVisible(true);
				break;
			case (10):
				line10.setVisible(true);
				break;
			case (11):
				line11.setVisible(true);
				break;
			}
			k++;
			if (k == 12) {
				JOptionPane.showMessageDialog(null, "Game Over dein Wort war: " + word, "FAIL", JOptionPane.ERROR_MESSAGE);
				Load.loadScene("Hangman");
			}
		}
		line = false;
	}

	@Override
	public void init(Stage stage) {
		s = 0;
		String[] words = { "BEISPIEL", "BAUM", "PFLANZE", "BANANE", "APFEL", "XYLOPHON", "WESTSIDE", "BIRD", "WORT", "EMO", "BEHINDERUNG", "EMMENTALER", "STINKTIER", "FINN", "SHIFT", "APOTHEKE", "RITZEN" , "RITZE", "KÄSE"  };
		int random = new Random().nextInt(words.length);
		word = (words[random]);

		k = 1;
		array = new char[word.length()];
		for(int o=0;o<word.length();o++ ){
			array[o] = '_';
		}
		String text = new String(array);
		solution.setText(text);
	}
}