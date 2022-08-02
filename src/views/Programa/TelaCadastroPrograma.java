package views.Programa;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ButtonGroup;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.text.MaskFormatter;

import classes.Canal;
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

public class TelaCadastroPrograma extends JFramePadrao {

	private JButtonPadrao btnCadastrar;
	private JButtonVoltar btnVoltar;
	private JComboBox<String> cbCanais;
	private JComboBox<String> cbGenero;
	private JComboBox<String> cbStatus;
	private JComboBox<String> cbTipoPrograma;

	private JRadioButton rbAnimada;
	private JRadioButton rbLiveAction;
	private JTextFieldPadrao txtApresentadores;
	private JRadioButton txtDias;
	private JFormattedTextField txtHorario;
	private JTextFieldPadrao txtNomePrograma;
	private JFormattedTextField txtRetorno;

	public TelaCadastroPrograma() {
		super("mySeries - Cadastrar Programa", 650, 538);
		adicionarLabels();
		adicionarButtons();
		adicionarComboBoxStatus();
		adicionarComboBoxTipoPrograma();
		adicionarComboBoxCanais();
		adicionarComboBoxGenero();
		adicionarTextFields();
		adicionarRadioButtons();
		setVisible(true);
	}

	private void adicionarButtons() {
		btnCadastrar = new JButtonPadrao("Cadastrar", 240, 450, 150, 30);

		

		btnVoltar = new JButtonVoltar();
		btnVoltar.setBounds(50, 20, 50, 40);

		btnVoltar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				new TelaPrograma();
				dispose();

			}
		});
		
		add(btnVoltar);
		add(btnCadastrar);
	}

	private void adicionarRadioButtons() {
		rbAnimada = new JRadioButton("Animada");
		rbLiveAction = new JRadioButton("Live Action");

		rbLiveAction.setBounds(60, 380, 85, 22);
		rbAnimada.setBounds(60, 410, 74, 22);

		ButtonGroup btnGroup = new ButtonGroup();
		btnGroup.add(rbAnimada);
		btnGroup.add(rbLiveAction);

		add(rbAnimada);
		add(rbLiveAction);

	}

	private void adicionarComboBoxStatus() {
		String[] status = { "Hiato", "Cancelado", "Finalizado" };
		cbStatus = new JComboBox<String>(status);
		cbStatus.setBounds(60, 310, 140, 30);
		add(cbStatus);

	}

	private void adicionarComboBoxGenero() {
		String[] genero = { "Ação", "Aventura", "Terror", "Ficção Científica", "Drama/Suspense", "Comédia" };
		cbGenero = new JComboBox<String>(genero);
		cbGenero.setBounds(430, 380, 130, 30);
		add(cbGenero);
	}

	private void adicionarComboBoxTipoPrograma() {
		String[] tipoPrograma = { "Serie", "Reality Show", "Contínuo" };
		cbTipoPrograma = new JComboBox<String>(tipoPrograma);
		cbTipoPrograma.setBounds(60, 240, 140, 30);
		add(cbTipoPrograma);
	}

	private void adicionarLabels() {
		JLabelPadraoTitulo lblTitulo = new JLabelPadraoTitulo("CADASTRO DE PROGRAMAS", 170, 20, 260, 28);

		JLabelPadrao lblNome = new JLabelPadrao("Nome do Programa: ", 55, 70, 130, 30);

		JLabelPadrao lblCanal = new JLabelPadrao("Canal de exibição:", 425, 70, 120, 30);

		JLabelPadrao lblHorario = new JLabelPadrao("Horário:", 50, 140, 60, 30);

		JLabelPadrao lblDias = new JLabelPadrao("Dias de exibição:", 420, 140, 120, 30);

		JLabelPadrao lblTipoPrograma = new JLabelPadrao("Tipo do Programa:", 55, 210, 120, 30);

		JLabelPadrao lblStatus = new JLabelPadrao("Status:", 15, 280, 130, 30);

		JLabelPadrao lblRetorno = new JLabelPadrao("Data de Retorno: ", 425, 280, 110, 30);

		JLabelPadrao lblEstilo = new JLabelPadrao("Estilo:", 55, 348, 40, 30);

		JLabelPadrao lblGenero = new JLabelPadrao("Gênero:", 420, 350, 60, 30);

		JLabelPadrao lblApresentador = new JLabelPadrao("Apresentadores: ", 425, 210, 110, 30);

		add(lblTitulo);
		add(lblNome);
		add(lblCanal);
		add(lblHorario);
		add(lblDias);
		add(lblTipoPrograma);
		add(lblStatus);
		add(lblRetorno);
		add(lblEstilo);
		add(lblGenero);
		add(lblApresentador);
	}

	private void adicionarComboBoxCanais() {
		Persistencia persistencia = new Persistencia();
		CentralDeInformacoes central = persistencia.recuperarCentral("database.xml");
		String[] canais = new String[central.getTodosOsCanais().size()];

		ArrayList<Canal> canaisCadastrados = central.getTodosOsCanais();

		for (int i = 0; i < canaisCadastrados.size(); i++) {
			canais[i] = canaisCadastrados.get(i).getNomeDoCanal();
		}

		cbCanais = new JComboBox<String>(canais);
		cbCanais.setBounds(430, 100, 140, 30);
		add(cbCanais);
	}

	private void adicionarTextFields() {

		txtNomePrograma = new JTextFieldPadrao(60, 100, 180, 30);

		txtDias = new JFormattedTextField();
		txtDias.setBounds(430, 170, 140, 30);

		try {
			MaskFormatter maskHorario = new MaskFormatter("##:##");
			txtHorario = new JFormattedTextField(maskHorario);
			txtHorario.setBounds(60, 170, 70, 30);

			MaskFormatter maskData = new MaskFormatter("####-##-##");

			txtRetorno = new JFormattedTextField(maskData);
			txtRetorno.setBounds(430, 310, 120, 30);

		} catch (Exception erro) {
			JOptionPane.showMessageDialog(null, "Oops! Algo deu errado, tente novamente mais tarde!", "Erro!",
					JOptionPane.ERROR_MESSAGE, Imagens.ICONE_ERRO);
		}

		txtApresentadores = new JTextFieldPadrao(430, 240, 50, 30);
		txtApresentadores.setDocument(new LimitaCaracteres(2, LimitaCaracteres.TipoEntrada.NUMEROINTEIRO));

		add(txtNomePrograma);
		add(txtDias);
		add(txtRetorno);
		add(txtHorario);
		add(txtApresentadores);

	}

}
