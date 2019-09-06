package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import model.Pravougaonik;
import model.Tacka;

public class DlgModifikujPravougaonik extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtXkoordinata;
	private JTextField txtYkoordinata;
	private JTextField txtVisina;
	private JTextField txtSirina;
	private JButton btnBojaIvice;
	private JButton btnBojaUnutrasnjosti;
	private int x;
	private int y;
	private int visina;
	private int sirina;
	public Pravougaonik pravougaonik;
	public boolean tempOdustani;

	

	/**
	 * Create the dialog.
	 */
	public DlgModifikujPravougaonik() {
		setModal(true);
		setTitle("Modifikuj pravougaonik");
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		{
			JPanel panel = new JPanel();
			contentPanel.add(panel, BorderLayout.CENTER);
			GridBagLayout gbl_panel = new GridBagLayout();
			gbl_panel.columnWidths = new int[] { 0, 0, 0 };
			gbl_panel.rowHeights = new int[] { 0, 0, 0, 0, 0, 0, 0, 0 };
			gbl_panel.columnWeights = new double[] { 0.0, 1.0, Double.MIN_VALUE };
			gbl_panel.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
			panel.setLayout(gbl_panel);
			{
				JLabel lblXKoordinataTake = new JLabel("X koordinata");
				GridBagConstraints gbc_lblXKoordinataTake = new GridBagConstraints();
				gbc_lblXKoordinataTake.anchor = GridBagConstraints.EAST;
				gbc_lblXKoordinataTake.insets = new Insets(0, 0, 5, 5);
				gbc_lblXKoordinataTake.gridx = 0;
				gbc_lblXKoordinataTake.gridy = 1;
				panel.add(lblXKoordinataTake, gbc_lblXKoordinataTake);
			}
			{
				txtXkoordinata = new JTextField();
				GridBagConstraints gbc_txtXkoordinata = new GridBagConstraints();
				gbc_txtXkoordinata.insets = new Insets(0, 0, 5, 0);
				gbc_txtXkoordinata.fill = GridBagConstraints.HORIZONTAL;
				gbc_txtXkoordinata.gridx = 1;
				gbc_txtXkoordinata.gridy = 1;
				panel.add(txtXkoordinata, gbc_txtXkoordinata);
				txtXkoordinata.setColumns(10);
			}
			{
				JLabel lblYKoordinataU = new JLabel("Y koordinata");
				GridBagConstraints gbc_lblYKoordinataU = new GridBagConstraints();
				gbc_lblYKoordinataU.anchor = GridBagConstraints.EAST;
				gbc_lblYKoordinataU.insets = new Insets(0, 0, 5, 5);
				gbc_lblYKoordinataU.gridx = 0;
				gbc_lblYKoordinataU.gridy = 2;
				panel.add(lblYKoordinataU, gbc_lblYKoordinataU);
			}
			{
				txtYkoordinata = new JTextField();
				GridBagConstraints gbc_txtYkoordinata = new GridBagConstraints();
				gbc_txtYkoordinata.insets = new Insets(0, 0, 5, 0);
				gbc_txtYkoordinata.fill = GridBagConstraints.HORIZONTAL;
				gbc_txtYkoordinata.gridx = 1;
				gbc_txtYkoordinata.gridy = 2;
				panel.add(txtYkoordinata, gbc_txtYkoordinata);
				txtYkoordinata.setColumns(10);
			}
			{
				JLabel lblVisinaPravougaonika = new JLabel("Visina");
				GridBagConstraints gbc_lblVisinaPravougaonika = new GridBagConstraints();
				gbc_lblVisinaPravougaonika.anchor = GridBagConstraints.EAST;
				gbc_lblVisinaPravougaonika.insets = new Insets(0, 0, 5, 5);
				gbc_lblVisinaPravougaonika.gridx = 0;
				gbc_lblVisinaPravougaonika.gridy = 3;
				panel.add(lblVisinaPravougaonika, gbc_lblVisinaPravougaonika);
			}
			{
				txtVisina = new JTextField();
				GridBagConstraints gbc_txtVisina = new GridBagConstraints();
				gbc_txtVisina.insets = new Insets(0, 0, 5, 0);
				gbc_txtVisina.fill = GridBagConstraints.HORIZONTAL;
				gbc_txtVisina.gridx = 1;
				gbc_txtVisina.gridy = 3;
				panel.add(txtVisina, gbc_txtVisina);
				txtVisina.setColumns(10);
			}
			{
				JLabel lblirinaPravougaonika = new JLabel("Sirina");
				GridBagConstraints gbc_lblirinaPravougaonika = new GridBagConstraints();
				gbc_lblirinaPravougaonika.anchor = GridBagConstraints.EAST;
				gbc_lblirinaPravougaonika.insets = new Insets(0, 0, 5, 5);
				gbc_lblirinaPravougaonika.gridx = 0;
				gbc_lblirinaPravougaonika.gridy = 4;
				panel.add(lblirinaPravougaonika, gbc_lblirinaPravougaonika);
			}
			{
				txtSirina = new JTextField();
				GridBagConstraints gbc_txtSirina = new GridBagConstraints();
				gbc_txtSirina.insets = new Insets(0, 0, 5, 0);
				gbc_txtSirina.fill = GridBagConstraints.HORIZONTAL;
				gbc_txtSirina.gridx = 1;
				gbc_txtSirina.gridy = 4;
				panel.add(txtSirina, gbc_txtSirina);
				txtSirina.setColumns(10);
			}
			{
				JLabel lblBojaIvice = new JLabel("Boja ivice");
				GridBagConstraints gbc_lblBojaIvice = new GridBagConstraints();
				gbc_lblBojaIvice.anchor = GridBagConstraints.EAST;
				gbc_lblBojaIvice.insets = new Insets(0, 0, 5, 5);
				gbc_lblBojaIvice.gridx = 0;
				gbc_lblBojaIvice.gridy = 5;
				panel.add(lblBojaIvice, gbc_lblBojaIvice);
			}
			{
				btnBojaIvice = new JButton("");
				btnBojaIvice.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						btnBojaIvice.setBackground(odabirBoje(btnBojaIvice.getBackground()));
					}
				});
				GridBagConstraints gbc_btnBojaIvice = new GridBagConstraints();
				gbc_btnBojaIvice.insets = new Insets(0, 0, 5, 0);
				gbc_btnBojaIvice.gridx = 1;
				gbc_btnBojaIvice.gridy = 5;
				panel.add(btnBojaIvice, gbc_btnBojaIvice);
			}
			{
				JLabel lblBojaUnutranjosti = new JLabel("Boja unutrasnjosti");
				GridBagConstraints gbc_lblBojaUnutranjosti = new GridBagConstraints();
				gbc_lblBojaUnutranjosti.anchor = GridBagConstraints.EAST;
				gbc_lblBojaUnutranjosti.insets = new Insets(0, 0, 0, 5);
				gbc_lblBojaUnutranjosti.gridx = 0;
				gbc_lblBojaUnutranjosti.gridy = 6;
				panel.add(lblBojaUnutranjosti, gbc_lblBojaUnutranjosti);
			}
			{
				btnBojaUnutrasnjosti = new JButton("");
				btnBojaUnutrasnjosti.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						btnBojaUnutrasnjosti.setBackground(odabirBoje(btnBojaUnutrasnjosti.getBackground()));
					}
				});
				GridBagConstraints gbc_btnBojaUnutrasnjosti = new GridBagConstraints();
				gbc_btnBojaUnutrasnjosti.gridx = 1;
				gbc_btnBojaUnutrasnjosti.gridy = 6;
				panel.add(btnBojaUnutrasnjosti, gbc_btnBojaUnutrasnjosti);
			}
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.CENTER));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton btnIzmeni = new JButton("Izmeni");
				btnIzmeni.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						try {
							x = Integer.parseInt(txtXkoordinata.getText());
							y = Integer.parseInt(txtYkoordinata.getText());
							visina = Integer.parseInt(txtVisina.getText());
							sirina = Integer.parseInt(txtSirina.getText());

							if (tempOdustani == false)
								pravougaonik = new Pravougaonik(new Tacka(x, y), sirina, visina,
										btnBojaIvice.getBackground(), btnBojaUnutrasnjosti.getBackground());
							pravougaonik.provera();
							dispose();
						} catch (NumberFormatException e1) {
							JOptionPane.showMessageDialog(null, "Greska pri unosu!", "Upozorenje",
									JOptionPane.WARNING_MESSAGE);
						} catch (Exception e2) {
							JOptionPane.showMessageDialog(null, "Negativne vrednosti!", "Upozorenje",
									JOptionPane.WARNING_MESSAGE);
						}
					}
				});
				
				btnIzmeni.setActionCommand("OK");
				buttonPane.add(btnIzmeni);
				getRootPane().setDefaultButton(btnIzmeni);
			}
			{
				JButton btnOdustani = new JButton("Odustani");
				btnOdustani.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						tempOdustani = true;
						dispose();
					}
				});
				
				btnOdustani.setActionCommand("Cancel");
				buttonPane.add(btnOdustani);
			}
		}
	}

	public JTextField getTxtXkoordinata() {
		return txtXkoordinata;
	}

	public void setTxtXkoordinata(JTextField txtXkoordinata) {
		this.txtXkoordinata = txtXkoordinata;
	}

	public JTextField getTxtYkoordinata() {
		return txtYkoordinata;
	}

	public void setTxtYkoordinata(JTextField txtYkoordinata) {
		this.txtYkoordinata = txtYkoordinata;
	}

	public JTextField getTxtVisina() {
		return txtVisina;
	}

	public void setTxtVisina(JTextField txtVisina) {
		this.txtVisina = txtVisina;
	}

	public JTextField getTxtSirina() {
		return txtSirina;
	}

	public void setTxtSirina(JTextField txtSirina) {
		this.txtSirina = txtSirina;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getVisina() {
		return visina;
	}

	public void setVisina(int visina) {
		this.visina = visina;
	}

	public int getSirina() {
		return sirina;
	}

	public void setSirina(int sirina) {
		this.sirina = sirina;
	}

	public JButton getBtnBojaIvice() {
		return btnBojaIvice;
	}

	public void setBtnBojaIvice(JButton btnBojaIvice) {
		this.btnBojaIvice = btnBojaIvice;
	}

	public JButton getBtnBojaUnutrasnjosti() {
		return btnBojaUnutrasnjosti;
	}

	public void setBtnBojaUnutrasnjosti(JButton btnBojaUnutrasnjosti) {
		this.btnBojaUnutrasnjosti = btnBojaUnutrasnjosti;
	}

	public Color odabirBoje(Color prethodnaBoja) {
		Color novaBoja = JColorChooser.showDialog(null, "Odabir boje", prethodnaBoja);
		if (novaBoja != null)
			return novaBoja;
		else {
			return prethodnaBoja;
		}
	}
}