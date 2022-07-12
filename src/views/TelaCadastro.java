package views;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.text.MaskFormatter;

import classes.Usuario;
import persistencia.CentralDeInformacoes;
import persistencia.Persistencia;
import utils.JButtonPadrao;
import utils.JFramePadrao;
import utils.JLabelPadrao;
import utils.JTextFieldPadrao;

import imagens.*;

public class TelaCadastro extends JFramePadrao {

	private JTextField txtNome;
	private JFormattedTextField txtCPF;
	private JFormattedTextField txtDataDeNascimento;
	private JFormattedTextField txtTelefone;
	private JTextField txtEmail;
	private JPasswordField txtSenha;
	private JPasswordField txtConfirmarSenha;

	Persistencia persistencia = new Persistencia();
	CentralDeInformacoes central = persistencia.recuperarCentral("database.xml");

	public TelaCadastro() {
		super("Cadastro - mySeries", 635, 515);
		adicionarSeparador();
		adicionarImagens();
		adicionarTextFields();
		adicionarLabels();
		adicionarButtons();
		setVisible(true);
	}

	private void adicionarImagens() {
		JLabel iconeNovoUsuario = new JLabel(Imagens.NOVO_USER_100x100);
		iconeNovoUsuario.setBounds(40, 165, 100, 100);
		add(iconeNovoUsuario);
	}

	private void adicionarTextFields() {
		txtNome = new JTextFieldPadrao(195, 85, 400, 35);
		add(txtNome);

		try {
			MaskFormatter maskCPF = new MaskFormatter("###.###.###-##");

			txtCPF = new JFormattedTextField(maskCPF);
			txtCPF.setBounds(195, 155, 195, 35);
			txtCPF.setFont(new Font("Roboto", Font.PLAIN, 14));
			txtCPF.setHorizontalAlignment(JTextField.CENTER);
			add(txtCPF);

			MaskFormatter maskData = new MaskFormatter("##/##/####");
			txtDataDeNascimento = new JFormattedTextField(maskData);
			txtDataDeNascimento.setBounds(400, 155, 195, 35);
			txtDataDeNascimento.setFont(new Font("Roboto", Font.PLAIN, 14));
			txtDataDeNascimento.setHorizontalAlignment(JTextField.CENTER);
			add(txtDataDeNascimento);

			MaskFormatter maskTelefone = new MaskFormatter("(##) #.####-####");
			txtTelefone = new JFormattedTextField(maskTelefone);
			txtTelefone.setBounds(195, 225, 400, 35);
			txtTelefone.setFont(new Font("Roboto", Font.PLAIN, 14));
			txtTelefone.setHorizontalAlignment(JTextField.CENTER);
			add(txtTelefone);
		} catch (ParseException e) {
			JOptionPane.showMessageDialog(null, "Ops! Aconteceu um erro durante a validação dos dados!");
		}

		txtEmail = new JTextFieldPadrao(195, 295, 400, 35);
		add(txtEmail);

		txtSenha = new JPasswordField();
		txtSenha.setBounds(195, 365, 195, 35);
		txtSenha.setHorizontalAlignment(JPasswordField.CENTER);
		add(txtSenha);

		txtConfirmarSenha = new JPasswordField();
		txtConfirmarSenha.setBounds(400, 365, 195, 35);
		txtConfirmarSenha.setHorizontalAlignment(JPasswordField.CENTER);
		add(txtConfirmarSenha);
	}

	private void adicionarLabels() {

		JLabel lblSubTitulo = new JLabelPadrao("PREENCHA TODOS OS DADOS", 170, 20, 465, 20);
		add(lblSubTitulo);

		JLabel lblTitulo = new JLabel("NOVA CONTA");
		lblTitulo.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 16));
		lblTitulo.setBounds(35, 275, 200, 20);
		add(lblTitulo);

		JLabel lblNome = new JLabelPadrao("Nome:", 190, 45, 50, 50);
		add(lblNome);

		JLabel lblCPF = new JLabelPadrao("CPF:", 185, 115, 50, 50);
		add(lblCPF);

		JLabel lblDataDeNascimento = new JLabelPadrao("Data de Nascimento:", 375, 115, 200, 50);
		add(lblDataDeNascimento);

		JLabel lblTelefone = new JLabelPadrao("Telefone:", 175, 185, 100, 50);
		add(lblTelefone);

		JLabel lblEmail = new JLabelPadrao("E-mail:", 170, 255, 100, 50);
		add(lblEmail);

		JLabel lblSenha = new JLabelPadrao("Senha:", 170, 325, 100, 50);
		add(lblSenha);

		JLabel lblConfirmarSenha = new JLabelPadrao("Confirmar Senha:", 360, 325, 200, 50);
		add(lblConfirmarSenha);
	}

	private void adicionarButtons() {
		JButton btnCadastrar = new JButtonPadrao("CADASTRAR", 195, 415, 195, 40);
		btnCadastrar.addActionListener(new OuvinteCadastrar());
		add(btnCadastrar);

		JButton btnCancelar = new JButtonPadrao("CANCELAR", 400, 415, 195, 40);
		btnCancelar.addActionListener(new OuvinteCancelar());
		add(btnCancelar);
	}

	private void adicionarSeparador() {
		JSeparator separador = new JSeparator(SwingConstants.VERTICAL);
		separador.setForeground(Color.GRAY);
		separador.setBounds(170, 5, 2, 465);
		add(separador);
	}


	public class OuvinteCancelar implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			dispose();
			new TelaLogin();
		}
	}

	private class OuvinteCadastrar implements ActionListener {

		public void actionPerformed(ActionEvent event) {

			if (txtNome.getText().isEmpty() || txtCPF.getText().isEmpty() || txtTelefone.getText().isEmpty()
					|| txtDataDeNascimento.getText().isEmpty() || txtEmail.getText().isEmpty()
					|| txtSenha.getPassword().length == 0) {
				JOptionPane.showMessageDialog(null, "Preencha todos os dados!", "ATENÇÃO!",
						JOptionPane.WARNING_MESSAGE);
			} else if (!(new String(txtSenha.getPassword()).equals(new String(txtConfirmarSenha.getPassword())))) {
				JOptionPane.showMessageDialog(null, "Senhas diferentes!", "ATENÇÃO!", JOptionPane.ERROR_MESSAGE, Imagens.ICONE_ERRO);
				txtSenha.setText("");
				txtConfirmarSenha.setText("");
				repaint();
			} else if (new String(txtSenha.getPassword()).length() < 5) {
				JOptionPane.showMessageDialog(null,
						"Sua senha é muito curta! Tente uma senha com mais de 6 caracteres!", "ATENÇÃO!",
						JOptionPane.WARNING_MESSAGE, Imagens.ICONE_ERRO);
				txtSenha.setText("");
				txtConfirmarSenha.setText("");
			} else if (txtCPF.getText().equals("000.000.000-00")) {
				JOptionPane.showMessageDialog(null, "CPF Inválido!", "ATENÇÃO!", JOptionPane.ERROR_MESSAGE, Imagens.ICONE_ERRO);
				txtCPF.setText("");
			} else if (txtTelefone.getText().equals("(00) 0.0000-0000")) {
				JOptionPane.showMessageDialog(null, "Telefone inválido!", "ATENÇÃO!", JOptionPane.ERROR_MESSAGE, Imagens.ICONE_ERRO);
				txtTelefone.setText("");
			} else {
				Usuario novoUsuario = null;
				Date dataDeNascimento = null;

				try {
					SimpleDateFormat formatoDataDeNascimento = new SimpleDateFormat("dd/MM/yyyy");
					formatoDataDeNascimento.setLenient(false);
					dataDeNascimento = formatoDataDeNascimento.parse(txtDataDeNascimento.getText());
				} catch (Exception erro) {
					JOptionPane.showMessageDialog(null, "Data de nascimento inválida!", "ATENÇÃO!",
							JOptionPane.ERROR_MESSAGE, Imagens.ICONE_ERRO);
					txtDataDeNascimento.setText("");
					return;
				}

				for (Usuario usuario : central.getTodosOsUsuarios()) {
					if (usuario.getCPF().equals(txtCPF.getText())) {
						JOptionPane.showMessageDialog(null, "Usuário já existe!", "Atenção!",
								JOptionPane.ERROR_MESSAGE);
					} else {
						novoUsuario = new Usuario(txtNome.getText(), txtCPF.getText(), txtTelefone.getText(),
								dataDeNascimento, txtEmail.getText(), new String(txtSenha.getPassword()));

					}

				}

				try {
					central.adicionarUsuario(novoUsuario);
					JOptionPane.showMessageDialog(null, "Sua conta foi criada com sucesso!", "Nova conta",
							JOptionPane.INFORMATION_MESSAGE, Imagens.ICONE_CHECK);
					persistencia.salvarCentral(central, "database.xml");
					dispose();
					new TelaLogin();
				} catch (Exception erro) {
					JOptionPane.showMessageDialog(null, erro.getMessage(), "ATENÇÃO!", JOptionPane.WARNING_MESSAGE, Imagens.ICONE_ERRO);
				}
			}
		}

	}

}
