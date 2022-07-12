package views;

import java.awt.Color;
import java.awt.Desktop;
import java.awt.Font;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.net.URI;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;

import classes.Usuario;
import imagens.Imagens;
import utils.JButtonVoltar;
import utils.JFramePadrao;
import utils.JLabelPadrao;

public class TelaSobre extends JFramePadrao {

	public TelaSobre() {
		super("mySeries - Sobre", 400, 400);
		adicionarLabels();
		adicionarIcones();
		adicionarSeparadores();
		adicionarButtons();
		setVisible(true);

	}
	
	
	private void adicionarButtons( ) {
		JButtonVoltar btnVoltar = new JButtonVoltar();
		btnVoltar.setBounds(10, 0, 30, 30);
		btnVoltar.addActionListener(new ActionListener() {
			
			
			public void actionPerformed(ActionEvent e) {
				dispose();
				
			}
		});
		
		add(btnVoltar);
	}
	
	
	
	private void adicionarLabels() {
		JLabelPadrao lblInfo = new JLabelPadrao("<html>Desenvolvedores: </html>", 65, 80, 250,
				50);
		lblInfo.setHorizontalAlignment(JLabel.CENTER);

		JLabel lblAlunos = new JLabel();
		lblAlunos.setText("<html>Diogo Marcelo <br>João Emanuel <br>José Augusto</html>");
		lblAlunos.setFont(new Font("Roboto", Font.PLAIN, 14));
		lblAlunos.setBounds(145, 120, 100, 80);

		JLabel lblContato = new JLabelPadrao("Contato: ", 140, 250, 100, 50);
		lblContato.setHorizontalAlignment(JLabel.CENTER);
		
		
		add(lblContato);
		add(lblAlunos);
		add(lblInfo);
	}

	private void adicionarIcones() {
		
		JLabel logoIFPB = new JLabel(Imagens.LOGO_IFPB);
		logoIFPB.setBounds(-10, 20, 400, 60);
		logoIFPB.setHorizontalAlignment(JLabel.CENTER);
		add(logoIFPB);
		
		
		JLabel iconeGit = new JLabel(Imagens.ICONE_GITHUB);
		iconeGit.setBounds(140, 320, 24, 24);
		iconeGit.setToolTipText("Github de Diogo");
		iconeGit.addMouseListener(new MouseListener() {


			public void mouseReleased(MouseEvent e) {
			}

			public void mousePressed(MouseEvent e) {
			}

			public void mouseExited(MouseEvent e) {
				iconeGit.setForeground(Color.black);
			}

			public void mouseEntered(MouseEvent e) {
				iconeGit.setForeground(Color.blue);
			}

			
			public void mouseClicked(MouseEvent e) {
				JOptionPane.showMessageDialog(null, "Você será redirecionado para uma página web! 😊");
				try {
					URI link = new URI("www.github.com/dmsviana");
					Desktop.getDesktop().browse(link);
				} catch (Exception erro) {
					System.out.println(erro);
				}

			}
		});

		JLabel iconeGit2 = new JLabel(Imagens.ICONE_GITHUB);
		iconeGit2.setBounds(180, 320, 24, 24);
		iconeGit2.setToolTipText("Github de João");

		JLabel iconeGit3 = new JLabel(Imagens.ICONE_GITHUB);
		iconeGit3.setBounds(220, 320, 24, 24);
		iconeGit3.setToolTipText("Github de José");

		add(iconeGit);
		add(iconeGit2);
		add(iconeGit3);
	}
	
	
	private void adicionarSeparadores() {
		JSeparator separator = new JSeparator(SwingConstants.VERTICAL);
		separator.setBounds(170, 315, 10, 35);
		separator.setBackground(Color.GRAY);
		add(separator);
		
		JSeparator separator2 = new JSeparator(SwingConstants.VERTICAL);
		separator2.setBounds(210, 315, 10, 35);
		separator2.setBackground(Color.GRAY);
		add(separator2);
		
	}


	
}
