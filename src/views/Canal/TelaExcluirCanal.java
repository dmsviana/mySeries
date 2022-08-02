package views.Canal;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import classes.Canal;
import persistencia.CentralDeInformacoes;
import persistencia.Persistencia;
import utils.JButtonPadrao;
import utils.JFramePadrao;
import utils.JLabelPadrao;
import utils.JLabelPadraoTitulo;

public class TelaExcluirCanal extends JFramePadrao {

	Persistencia persistencia = new Persistencia();
	CentralDeInformacoes central = persistencia.recuperarCentral("database.xml");

	private JComboBox<String> cbCanais;
	private ArrayList<Canal> canaisCadastrados = central.getTodosOsCanais();

	public TelaExcluirCanal() {
		super("mySeries - Excluir Canal", 360, 215);
		adicionarLabels();
		adicionarButtons();
		adicionarComboBox();
		setVisible(true);
	}

	private void adicionarLabels() {
		JLabelPadraoTitulo lblTitulo = new JLabelPadraoTitulo("Excluir Canal", 0, 20, 360, 20);
		lblTitulo.setHorizontalAlignment(JLabel.CENTER);
		add(lblTitulo);

		JLabelPadrao lblNomeDaSala = new JLabelPadrao("Nome do Canal:", 20, 55, 100, 20);
		add(lblNomeDaSala);
	}

	private void adicionarButtons() {
		JButtonPadrao btnConfirmar = new JButtonPadrao("Confirmar", 20, 125, 145, 35);
		btnConfirmar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (canaisCadastrados.isEmpty()) {
					JOptionPane.showMessageDialog(null, "Não existe canais cadastrados!", "Atenção!",
							JOptionPane.ERROR_MESSAGE);
					new TelaExcluirCanal();
					dispose();
				} else {
					String dadosDaSala = (String) cbCanais.getSelectedItem();
					String[] dados = dadosDaSala.split("-");
					long ID = Long.parseLong(dados[0].trim());

					try {
						central.deletarCanal(ID);
						JOptionPane.showMessageDialog(null, "Canal excluído com sucesso!", "Sucesso!",
								JOptionPane.WARNING_MESSAGE);
						persistencia.salvarCentral(central, "database.xml");
					} catch (Exception erro) {
						JOptionPane.showMessageDialog(null, erro.getMessage(), "Atenção!", JOptionPane.ERROR_MESSAGE);
					}

					dispose();
					new TelaExcluirCanal();
				}
			}
		});
		add(btnConfirmar);

		JButtonPadrao btnCancelar = new JButtonPadrao("Cancelar", 180, 125, 145, 35);
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new TelaListarCanais();
			}
		});
		add(btnCancelar);
	}

	private void adicionarComboBox() {
		String[] opcoes = new String[canaisCadastrados.size()];

		for (int i = 0; i < canaisCadastrados.size(); i++) {
			opcoes[i] = canaisCadastrados.get(i).getId() + " - " + canaisCadastrados.get(i).getNomeDoCanal();
		}

		cbCanais = new JComboBox<String>(opcoes);
		cbCanais.setBounds(20, 80, 305, 30);
		add(cbCanais);
	}
}
