package views.Canal;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;

import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JOptionPane;
import javax.swing.text.MaskFormatter;

import classes.Canal;
import classes.CanalBroadcastingAberto;
import classes.CanalBroadcastingPago;
import classes.CanalTVAberta;
import classes.CanalTVPago;
import excecoes.CanalJaExisteException;
import imagens.Imagens;
import persistencia.CentralDeInformacoes;
import persistencia.Persistencia;
import utils.JButtonPadrao;
import utils.JButtonVoltar;
import utils.JFramePadrao;
import utils.JLabelPadrao;
import utils.JLabelPadraoTitulo;
import utils.JTextFieldPadrao;
import utils.LimitaCaracteres;

public class TelaCadastroCanal extends JFramePadrao {

	private JTextFieldPadrao txtNomeDoCanal;
	private JTextFieldPadrao txtNumeroDoCanal;
	private JTextFieldPadrao txtURLDoCanal;
	private JTextFieldPadrao txtMensalidade;
	private JComboBox cbTipoDoCanal;
	private JButtonPadrao btnCadastrar;
	private JButtonVoltar btnVoltar;

	public TelaCadastroCanal() {
		super("mySeries - Cadastro Canal", 510, 400);
		adicionarLabels();
		adicionarComboBox();
		adicionarTextFields();
		adicionarButtons();
		setVisible(true);
	}

	private void adicionarLabels() {
		JLabelPadraoTitulo lblTitulo = new JLabelPadraoTitulo("CADASTRO CANAL", 180, 10, 150, 50);

		JLabelPadrao lblNomeCanal = new JLabelPadrao("Nome do canal:", 40, 70, 100, 20);

		JLabelPadrao lblTipoDoCanal = new JLabelPadrao("Tipo do canal:", 340, 60, 90, 40);

		JLabelPadrao lblNumeroDoCanal = new JLabelPadrao("Numero do canal:", 40, 140, 110, 30);

		JLabelPadrao lblURL = new JLabelPadrao("URL:", 340, 140, 30, 40);

		JLabelPadrao lblMensalidade = new JLabelPadrao("Mensalidade:", 40, 240, 80, 16);

		add(lblTitulo);
		add(lblNomeCanal);
		add(lblNumeroDoCanal);
		add(lblTipoDoCanal);
		add(lblURL);
		add(lblMensalidade);
	}

	private void adicionarTextFields() {
		txtNomeDoCanal = new JTextFieldPadrao(40, 90, 130, 30);

		txtNumeroDoCanal = new JTextFieldPadrao(40, 170, 130, 30);
		txtNumeroDoCanal.setDocument(new LimitaCaracteres(4, LimitaCaracteres.TipoEntrada.NUMEROINTEIRO));

		txtURLDoCanal = new JTextFieldPadrao(340, 170, 130, 30);
		txtURLDoCanal.setEditable(false);

		txtMensalidade = new JTextFieldPadrao(40, 260, 130, 30);
		txtMensalidade.setEditable(false);
		txtMensalidade.setDocument(new LimitaCaracteres(6, LimitaCaracteres.TipoEntrada.NUMERODECIMAL));

		add(txtNomeDoCanal);
		add(txtNumeroDoCanal);
		add(txtURLDoCanal);
		add(txtMensalidade);
		repaint();
	}

	private void adicionarComboBox() {
		String[] opcoes = { "Canal Aberto", "Broadcasting Aberto", "Canal Pago", "Broadcasting Pago" };
		cbTipoDoCanal = new JComboBox<String>(opcoes);
		cbTipoDoCanal.setBounds(340, 90, 130, 30);

		cbTipoDoCanal.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				String opcao = (String) cbTipoDoCanal.getSelectedItem();
				if (opcao.equalsIgnoreCase("Broadcasting Pago")) {
					txtURLDoCanal.setEditable(true);
					txtNumeroDoCanal.setEditable(false);
					txtMensalidade.setEditable(true);
				} else if (opcao.equalsIgnoreCase("Broadcasting Aberto")) {
					txtMensalidade.setEditable(false);
					txtNumeroDoCanal.setEditable(false);
					txtURLDoCanal.setEditable(true);
				} else if (opcao.equalsIgnoreCase("Canal Pago")) {
					txtURLDoCanal.setEditable(false);
					txtMensalidade.setEditable(true);
					txtNumeroDoCanal.setEditable(true);
				} else {
					txtURLDoCanal.setEditable(false);
					txtMensalidade.setEditable(false);
				}

			}
		});

		add(cbTipoDoCanal);
	}

	private void adicionarButtons() {
		btnCadastrar = new JButtonPadrao("Cadastrar", 190, 320, 120, 30);
		add(btnCadastrar);

		btnCadastrar.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				Persistencia persistencia = new Persistencia();
				CentralDeInformacoes central = persistencia.recuperarCentral("database.xml");
				Canal novoCanal = null;
				if (txtNomeDoCanal.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "O nome do canal não pode ser vazio!", "Atenção",
							JOptionPane.WARNING_MESSAGE, Imagens.ICONE_ERRO);
				} else {
					String opcao = (String) cbTipoDoCanal.getSelectedItem();
					if (opcao.equalsIgnoreCase("Broadcasting Pago")) {
						novoCanal = new CanalBroadcastingPago(txtURLDoCanal.getText(),
								Double.parseDouble(txtMensalidade.getText()), txtNomeDoCanal.getText());
					} else if (opcao.equalsIgnoreCase("Broadcasting Aberto")) {
						novoCanal = new CanalBroadcastingAberto(txtNomeDoCanal.getText(), txtURLDoCanal.getText());
					} else if (opcao.equalsIgnoreCase("Canal Aberto")) {
						novoCanal = new CanalTVAberta(Integer.parseInt(txtNumeroDoCanal.getText()),
								txtNomeDoCanal.getText());
					} else {
						novoCanal = new CanalTVPago(Double.parseDouble(txtMensalidade.getText()),
								txtNomeDoCanal.getText());
					}

					try {
						central.adicionarCanal(novoCanal);
						persistencia.salvarCentral(central, "database.xml");
						JOptionPane.showMessageDialog(null, "Canal adicionado com sucesso!", "Sucesso!",
								JOptionPane.OK_OPTION, Imagens.ICONE_CHECK);
						new TelaCanal();
						dispose();
					} catch (Exception erro) {
						JOptionPane.showMessageDialog(null, erro.getMessage(), "Erro!", JOptionPane.WARNING_MESSAGE,
								Imagens.ICONE_ERRO);
					}

				}
			}
		});
		btnVoltar = new JButtonVoltar();
		btnVoltar.setBounds(10, 10, 32, 32);
		btnVoltar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				new TelaCanal();
				dispose();

			}
		});

		add(btnVoltar);

	}

}
