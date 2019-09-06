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

import model.Tacka;

public class DlgModifikujTacku extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtXkoordinata;
	private JTextField txtYkoordinata;
	private JButton btnBojaIvice;
	private int x;
	private int y;
	public Tacka tacka;
	public boolean tempOdustani;

	

	/**
	 * Create the dialog.
	 */
	public DlgModifikujTacku() {
		setModal(true);
		setTitle("Modifikuj tacku");
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
			gbl_panel.rowHeights = new int[] { 0, 0, 0, 0, 0 };
			gbl_panel.columnWeights = new double[] { 0.0, 1.0, Double.MIN_VALUE };
			gbl_panel.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
			panel.setLayout(gbl_panel);
			{
				JLabel lblXKoordinata = new JLabel("X koordinata");
				GridBagConstraints gbc_lblXKoordinata = new GridBagConstraints();
				gbc_lblXKoordinata.anchor = GridBagConstraints.EAST;
				gbc_lblXKoordinata.insets = new Insets(0, 0, 5, 5);
				gbc_lblXKoordinata.gridx = 0;
				gbc_lblXKoordinata.gridy = 1;
				panel.add(lblXKoordinata, gbc_lblXKoordinata);
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
				JLabel lblYKoordinata = new JLabel("Y koordinata");
				GridBagConstraints gbc_lblYKoordinata = new GridBagConstraints();
				gbc_lblYKoordinata.anchor = GridBagConstraints.EAST;
				gbc_lblYKoordinata.insets = new Insets(0, 0, 5, 5);
				gbc_lblYKoordinata.gridx = 0;
				gbc_lblYKoordinata.gridy = 2;
				panel.add(lblYKoordinata, gbc_lblYKoordinata);
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
				JLabel lblBoja = new JLabel("Boja");
				GridBagConstraints gbc_lblBoja = new GridBagConstraints();
				gbc_lblBoja.insets = new Insets(0, 0, 0, 5);
				gbc_lblBoja.gridx = 0;
				gbc_lblBoja.gridy = 3;
				panel.add(lblBoja, gbc_lblBoja);
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
				gbc_btnBojaIvice.gridy = 3;
				panel.add(btnBojaIvice, gbc_btnBojaIvice);
			}
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.CENTER));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton btnIzmeni = new JButton("Izmeni");
				btnIzmeni.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						try {
							x = Integer.parseInt(txtXkoordinata.getText());
							y = Integer.parseInt(txtYkoordinata.getText());
							
							if (tempOdustani == false)
								tacka = new Tacka(x, y, btnBojaIvice.getBackground());
							tacka.provera();
							dispose();
						} catch (NumberFormatException e) {
							e.printStackTrace();
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
				JButton cancelButton = new JButton("Odustani");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						tempOdustani = true;
						dispose();
					}
				});
				
				cancelButton.setActionCommand("btnOdustani");
				buttonPane.add(cancelButton);
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