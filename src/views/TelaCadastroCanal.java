package views;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTextField;

import persistencia.CentralDeInformacoes;
import persistencia.Persistencia;
import utils.JFramePadrao;
import utils.JLabelPadrao;
import utils.JLabelPadraoTitulo;

public class TelaCadastroCanal extends JFramePadrao{

	private JTextField txtNomeCanal;
	private JComboBox comboBox;
	private JTextField txtNumeroCanal;
	private JTextField txtURL;
	
	
	Persistencia persistencia = new Persistencia();
	CentralDeInformacoes central = persistencia.recuperarCentral("database.xml");
	
	public TelaCadastroCanal() {
		super("mySeries - Cadastro de canal", 400, 400);
		setVisible(true);
		adicionarLabels();
		adicionarTextFields();
	}
	
	
	
	private void adicionarLabels() {
		JLabel lblTitulo = new JLabelPadraoTitulo("Cadastro canal", 100, 20, 150, 50);
		
		JLabel lblNomeCanal = new JLabelPadrao("Nome do canal: ", 27, 100, 120, 30);
		JLabel lblTipoCanal = new JLabelPadrao("Tipo do canal: ", 20, 150, 120, 30);
		JLabel lblNumeroCanal = new JLabelPadrao("Número do canal: ", 30, 200, 130, 30);
		JLabel lblURL = new JLabelPadrao("URL: ", 3, 250, 90, 30);
		
		add(lblTitulo);
		add(lblNomeCanal);
		add(lblTipoCanal);
		add(lblNumeroCanal);
		add(lblURL);
						
	}
	
	private void adicionarTextFields() {
		txtNomeCanal = new JTextField();
		txtNomeCanal.setBounds(150, 100, 165, 30);
		
		txtNumeroCanal = new JTextField();
		txtNumeroCanal.setBounds(160, 200, 120, 30);
		
		txtURL = new JTextField();
		txtURL.setBounds(70, 250, 165, 30);
		
		add(txtNumeroCanal);
		add(txtNomeCanal);
		add(txtURL);
	}
	
	//perguntar a kleytos
	private void adicionarComboBox() {
		
	}
	
	

}
