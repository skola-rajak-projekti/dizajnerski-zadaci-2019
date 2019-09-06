package view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.Linija;
import model.Tacka;

import java.awt.Color;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DlgModifikujLiniju extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtXkoorPocetna;
	private JTextField txtYkoorPocetna;
	private JTextField txtXkoorKrajnja;
	private JTextField txtYkoorKrajnja;
	private JButton btnBojaIvice;
	private int xPocetna;
	private int yPocetna;
	private int xKrajnja;
	private int yKrajnja;
	public Linija linija;
	public boolean tempOdustani;

	
	/**
	 * Create the dialog.
	 */
	public DlgModifikujLiniju() {
		setTitle("Modifikuj liniju");
		setModal(true);
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		{
			JPanel pnlLinija = new JPanel();
			contentPanel.add(pnlLinija, BorderLayout.CENTER);
			GridBagLayout gbl_pnlLinija = new GridBagLayout();
			gbl_pnlLinija.columnWidths = new int[] { 0, 0, 0 };
			gbl_pnlLinija.rowHeights = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
			gbl_pnlLinija.columnWeights = new double[] { 0.0, 1.0, Double.MIN_VALUE };
			gbl_pnlLinija.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
			pnlLinija.setLayout(gbl_pnlLinija);
			{
				JLabel lblPoetnaTaka = new JLabel("Pocetna tacka");
				GridBagConstraints gbc_lblPoetnaTaka = new GridBagConstraints();
				gbc_lblPoetnaTaka.insets = new Insets(0, 0, 5, 5);
				gbc_lblPoetnaTaka.gridx = 0;
				gbc_lblPoetnaTaka.gridy = 1;
				pnlLinija.add(lblPoetnaTaka, gbc_lblPoetnaTaka);
			}
			{
				JLabel lblXKoordinata = new JLabel("X koordinata");
				GridBagConstraints gbc_lblXKoordinata = new GridBagConstraints();
				gbc_lblXKoordinata.anchor = GridBagConstraints.EAST;
				gbc_lblXKoordinata.insets = new Insets(0, 0, 5, 5);
				gbc_lblXKoordinata.gridx = 0;
				gbc_lblXKoordinata.gridy = 2;
				pnlLinija.add(lblXKoordinata, gbc_lblXKoordinata);
			}
			{
				txtXkoorPocetna = new JTextField();
				GridBagConstraints gbc_txtXkoorPocetna = new GridBagConstraints();
				gbc_txtXkoorPocetna.anchor = GridBagConstraints.NORTH;
				gbc_txtXkoorPocetna.insets = new Insets(0, 0, 5, 0);
				gbc_txtXkoorPocetna.fill = GridBagConstraints.HORIZONTAL;
				gbc_txtXkoorPocetna.gridx = 1;
				gbc_txtXkoorPocetna.gridy = 2;
				pnlLinija.add(txtXkoorPocetna, gbc_txtXkoorPocetna);
				txtXkoorPocetna.setColumns(10);
			}
			{
				JLabel lblYKoordinata = new JLabel("Y koordinata");
				GridBagConstraints gbc_lblYKoordinata = new GridBagConstraints();
				gbc_lblYKoordinata.anchor = GridBagConstraints.EAST;
				gbc_lblYKoordinata.insets = new Insets(0, 0, 5, 5);
				gbc_lblYKoordinata.gridx = 0;
				gbc_lblYKoordinata.gridy = 3;
				pnlLinija.add(lblYKoordinata, gbc_lblYKoordinata);
			}
			{
				txtYkoorPocetna = new JTextField();
				GridBagConstraints gbc_txtYkoorPocetna = new GridBagConstraints();
				gbc_txtYkoorPocetna.anchor = GridBagConstraints.NORTH;
				gbc_txtYkoorPocetna.insets = new Insets(0, 0, 5, 0);
				gbc_txtYkoorPocetna.fill = GridBagConstraints.HORIZONTAL;
				gbc_txtYkoorPocetna.gridx = 1;
				gbc_txtYkoorPocetna.gridy = 3;
				pnlLinija.add(txtYkoorPocetna, gbc_txtYkoorPocetna);
				txtYkoorPocetna.setColumns(10);
			}
			{
				JLabel lblKrajnjaTaka = new JLabel("Krajnja tacka");
				GridBagConstraints gbc_lblKrajnjaTaka = new GridBagConstraints();
				gbc_lblKrajnjaTaka.insets = new Insets(0, 0, 5, 5);
				gbc_lblKrajnjaTaka.gridx = 0;
				gbc_lblKrajnjaTaka.gridy = 5;
				pnlLinija.add(lblKrajnjaTaka, gbc_lblKrajnjaTaka);
			}
			{
				JLabel lblXKoordinata_1 = new JLabel("X koordinata");
				GridBagConstraints gbc_lblXKoordinata_1 = new GridBagConstraints();
				gbc_lblXKoordinata_1.anchor = GridBagConstraints.EAST;
				gbc_lblXKoordinata_1.insets = new Insets(0, 0, 5, 5);
				gbc_lblXKoordinata_1.gridx = 0;
				gbc_lblXKoordinata_1.gridy = 6;
				pnlLinija.add(lblXKoordinata_1, gbc_lblXKoordinata_1);
			}
			{
				txtXkoorKrajnja = new JTextField();
				GridBagConstraints gbc_txtXkoorKrajnja = new GridBagConstraints();
				gbc_txtXkoorKrajnja.insets = new Insets(0, 0, 5, 0);
				gbc_txtXkoorKrajnja.fill = GridBagConstraints.HORIZONTAL;
				gbc_txtXkoorKrajnja.gridx = 1;
				gbc_txtXkoorKrajnja.gridy = 6;
				pnlLinija.add(txtXkoorKrajnja, gbc_txtXkoorKrajnja);
				txtXkoorKrajnja.setColumns(10);
			}
			{
				JLabel lblYKoordinata_1 = new JLabel("Y koordinata");
				GridBagConstraints gbc_lblYKoordinata_1 = new GridBagConstraints();
				gbc_lblYKoordinata_1.anchor = GridBagConstraints.EAST;
				gbc_lblYKoordinata_1.insets = new Insets(0, 0, 5, 5);
				gbc_lblYKoordinata_1.gridx = 0;
				gbc_lblYKoordinata_1.gridy = 7;
				pnlLinija.add(lblYKoordinata_1, gbc_lblYKoordinata_1);
			}
			{
				txtYkoorKrajnja = new JTextField();
				GridBagConstraints gbc_txtYkoorKrajnja = new GridBagConstraints();
				gbc_txtYkoorKrajnja.insets = new Insets(0, 0, 5, 0);
				gbc_txtYkoorKrajnja.fill = GridBagConstraints.HORIZONTAL;
				gbc_txtYkoorKrajnja.gridx = 1;
				gbc_txtYkoorKrajnja.gridy = 7;
				pnlLinija.add(txtYkoorKrajnja, gbc_txtYkoorKrajnja);
				txtYkoorKrajnja.setColumns(10);
			}
			{
				JLabel lblBoja = new JLabel("Boja");
				GridBagConstraints gbc_lblBoja = new GridBagConstraints();
				gbc_lblBoja.anchor = GridBagConstraints.EAST;
				gbc_lblBoja.insets = new Insets(0, 0, 0, 5);
				gbc_lblBoja.gridx = 0;
				gbc_lblBoja.gridy = 8;
				pnlLinija.add(lblBoja, gbc_lblBoja);
			}
			{
				btnBojaIvice = new JButton("");
				btnBojaIvice.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						btnBojaIvice.setBackground(odabirBoje(btnBojaIvice.getBackground()));
					}
				});
				GridBagConstraints gbc_btnBojaIvice = new GridBagConstraints();
				gbc_btnBojaIvice.gridx = 1;
				gbc_btnBojaIvice.gridy = 8;
				pnlLinija.add(btnBojaIvice, gbc_btnBojaIvice);
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
							xPocetna = Integer.parseInt(txtXkoorPocetna.getText());
							yPocetna = Integer.parseInt(txtYkoorPocetna.getText());
							xKrajnja = Integer.parseInt(txtXkoorKrajnja.getText());
							yKrajnja = Integer.parseInt(txtYkoorKrajnja.getText());
							
							if (tempOdustani == false)
								linija = new Linija(new Tacka(xPocetna, yPocetna), new Tacka(xKrajnja, yKrajnja), btnBojaIvice.getBackground());
							linija.provera();
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

	public JTextField getTxtXkoorPocetna() {
		return txtXkoorPocetna;
	}

	public void setTxtXkoorPocetna(JTextField txtXkoorPocetna) {
		this.txtXkoorPocetna = txtXkoorPocetna;
	}

	public JTextField getTxtYkoorPocetna() {
		return txtYkoorPocetna;
	}

	public void setTxtYkoorPocetna(JTextField txtYkoorPocetna) {
		this.txtYkoorPocetna = txtYkoorPocetna;
	}

	public JTextField getTxtXkoorKrajnja() {
		return txtXkoorKrajnja;
	}

	public void setTxtXkoorKrajnja(JTextField txtXkoorKrajnja) {
		this.txtXkoorKrajnja = txtXkoorKrajnja;
	}

	public JTextField getTxtYkoorKrajnja() {
		return txtYkoorKrajnja;
	}

	public void setTxtYkoorKrajnja(JTextField txtYkoorKrajnja) {
		this.txtYkoorKrajnja = txtYkoorKrajnja;
	}

	public int getXPocetna() {
		return xPocetna;
	}

	public void setXPocetna(int xPocetna) {
		this.xPocetna = xPocetna;
	}

	public int getYPocetna() {
		return yPocetna;
	}

	public void setYPocetna(int yPocetna) {
		this.yPocetna = yPocetna;
	}

	public int getXKrajnja() {
		return xKrajnja;
	}

	public void setXKrajnja(int xKrajnja) {
		this.xKrajnja = xKrajnja;
	}

	public int getYKrajnja() {
		return yKrajnja;
	}

	public void setYKrajnja(int yKrajnja) {
		this.yKrajnja = yKrajnja;
	}

	public JButton getBtnBojaIvice() {
		return btnBojaIvice;
	}

	public void setBtnBojaIvice(JButton btnBojaIvice) {
		this.btnBojaIvice = btnBojaIvice;
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