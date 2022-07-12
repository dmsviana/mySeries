package views;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import classes.Usuario;
import icone.Icone;
import imagens.Imagens;
import persistencia.CentralDeInformacoes;
import persistencia.Persistencia;
import utils.JButtonPadrao;
import utils.JFramePadrao;
import utils.JLabelPadrao;
import utils.JTextFieldPadrao;

public class TelaLogin extends JFramePadrao {

	Persistencia persistencia = new Persistencia();
	CentralDeInformacoes central = null;

	// Atributos
	private JTextFieldPadrao txtLogin;
	private JPasswordField txtSenha;
	

	// Construtor
	public TelaLogin() {
		super("Login - mySeries", 410, 490);
		adicionarImagens();
		adicionarLabels();
		adicionarInputs();
		adicionarButtons();
		setVisible(true);
	}

	// Componentes
	private void adicionarImagens() {
		JLabel lblLogoProjeto = new JLabel(Imagens.LOGO_MY_SERIES_250x250);
		lblLogoProjeto.setBounds(85, 25, 200, 173);
		add(lblLogoProjeto);

//		JLabel lblUser = new Icone(Imagens.USER_25x25, 30, 225, 35, 35);
//		add(lblUser);
//
//		JLabel lblLock = new Icone(Imagens.LOCK_25x25, 30, 300, 35, 35);
//		add(lblLock);
	}

	private void adicionarLabels() {
		JLabel lblLogin = new JLabelPadrao("Login:", 20, 160, 100, 100);
		add(lblLogin);

		JLabel lblSenha = new JLabelPadrao("Senha:", 23, 235, 100, 100);
		add(lblSenha);

		JLabel lblEsqueceuASenha = new JLabelPadrao("Esqueceu a senha?", 120, 350, 140, 20);
		
		lblEsqueceuASenha.setForeground(new Color(42, 133, 175));
		
		lblEsqueceuASenha.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				setCursor(new Cursor(HAND_CURSOR));
				JOptionPane.showMessageDialog(null, "Oops! Essa parte ainda não foi desenvolvida!", "Aviso!", JOptionPane.WARNING_MESSAGE);
				
			}
		});
		add(lblEsqueceuASenha);
	}

	private void adicionarInputs() {
		txtLogin = new JTextFieldPadrao(50, 225, 305, 36);
		txtLogin.setToolTipText("Digite seu e-mail aqui");
		add(txtLogin);

		txtSenha = new JPasswordField();
		txtSenha.setBounds(50, 300, 305, 36);
		txtSenha.setToolTipText("Digite sua senha aqui");
		txtSenha.setHorizontalAlignment(JTextField.CENTER);
		add(txtSenha);
	}

	private void adicionarButtons() {
		JButton btnEntrar = new JButtonPadrao("Entrar", 30, 385, 160, 40);

		btnEntrar.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				
				
				
				try {
					new TelaHome();
					
				} catch(Exception erro) {
					erro.printStackTrace();
				}
				

			}
		});
		add(btnEntrar);

		JButton btnNovaConta = new JButtonPadrao("Criar conta", 210, 385, 160, 40);
		btnNovaConta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new TelaCadastro();
				dispose();
			}
		});
		btnNovaConta.setCursor(new Cursor(Cursor.HAND_CURSOR));
		add(btnNovaConta);
	}

	

}
