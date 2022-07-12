package app;

import javax.swing.UIManager;

import com.formdev.flatlaf.FlatDarkLaf;

import views.TelaCadastroCanal;
import views.TelaHome;
import views.TelaLogin;

public class MainTeste {
	public static void main(String[] args) throws Exception {

		try {

			UIManager.setLookAndFeel(new FlatDarkLaf());

		} catch (Exception ex) {
			System.err.println("Failed to initialize LaF");
		}
	
		new TelaCadastroCanal();
	}
}