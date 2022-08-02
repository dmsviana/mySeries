package views;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;

import classes.Usuario;
import imagens.Imagens;
import persistencia.CentralDeInformacoes;
import persistencia.Persistencia;
import utils.JButtonPadrao;
import utils.JFramePadrao;
import utils.JLabelPadrao;
import utils.JLabelPadraoTitulo;
import utils.JTextFieldPadrao;

public class TelaLogin extends JFramePadrao{
	
	Persistencia persistencia = new Persistencia();
	CentralDeInformacoes central = persistencia.recuperarCentral("database.xml");

    private JTextFieldPadrao txtEmail;
    private JPasswordField txtSenha;
    private JButtonPadrao btnEntrar;
    private JButtonPadrao btnCriarConta;
    private JSeparator separador;
    

    public TelaLogin(){
        super("mySeries - Login", 495, 300);
        adicionarLabels();
        adicionarTextFields();
        adicionarButtons();
        adicionarSeparador();
        adicionarIcon();
        setVisible(true);
    }

    private void adicionarIcon(){
        JLabel lblLogo = new JLabel(Imagens.LOGO_MY_SERIES_250x250);
        lblLogo.setBounds(0, 80, 120, 120);
        add(lblLogo);
    }

    private void adicionarLabels(){
        JLabelPadraoTitulo lblTitulo = new JLabelPadraoTitulo("LOGIN", 270, 30, 60, 28);

        JLabelPadrao lblEmail = new JLabelPadrao("Email: ", 170, 110, 50, 19);
        JLabelPadrao lblSenha = new JLabelPadrao("Senha: ", 170, 160, 50, 19);

        add(lblTitulo);
        add(lblEmail);
        add(lblSenha);

    }

    private void adicionarTextFields(){
        txtEmail = new JTextFieldPadrao(220, 110, 160, 22);

        txtSenha = new JPasswordField();
        txtSenha.setBounds(220, 160, 160, 22);

        add(txtEmail);
        add(txtSenha);
    }


    private void adicionarButtons(){
        btnEntrar = new JButtonPadrao("Entrar", 320, 220, 75, 22);

        btnEntrar.addActionListener(new ActionListener() {
			
			
			public void actionPerformed(ActionEvent e) {
				if(txtEmail.getText().isEmpty() || txtSenha.getPassword().length == 0) {
					JOptionPane.showMessageDialog(null, "Preencha todos os campos!", "Atenção!", JOptionPane.WARNING_MESSAGE);
				} 
				try {
					if(central.autenticarUsuario(txtEmail.getText(), new String(txtSenha.getPassword())) != null) {
						new TelaHome();
						dispose();
					}
					
;				} catch(Exception erro) {
					JOptionPane.showMessageDialog(null, erro.getMessage(), "Atenção!", JOptionPane.ERROR_MESSAGE);
				}
			}
		});

        btnCriarConta = new JButtonPadrao("Cadastrar", 170, 220, 85, 22);
        add(btnEntrar);
        
        
        btnCriarConta.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
				new TelaCadastroUsuario();
				dispose();
			}
        });

        
        add(btnCriarConta);

    }

    private void adicionarSeparador(){
        separador = new JSeparator(SwingConstants.VERTICAL);
        separador.setBounds(120, 0, 20, 300);
        add(separador);
    }





    
}
