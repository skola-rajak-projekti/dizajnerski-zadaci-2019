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

import model.KvadratG;
import model.Tacka;

public class DlgModifikujKvadrat extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtXkoordinata;
	private JTextField txtYkoordinata;
	private JTextField txtDuzina;
	private JButton btnBojaIvice;
	private JButton btnBojaUnutrasnjosti;
	private int x;
	private int y;
	private int duzina;
	public KvadratG kvadrat;
	public boolean tempOdustani;

	
	/**
	 * Create the dialog.
	 */
	public DlgModifikujKvadrat() {
		setModal(true);
		setTitle("Modifikacija kvadrata");
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		{
			JPanel pnlModifikujKvadrat = new JPanel();
			contentPanel.add(pnlModifikujKvadrat, BorderLayout.CENTER);
			GridBagLayout gbl_pnlModifikujKvadrat = new GridBagLayout();
			gbl_pnlModifikujKvadrat.columnWidths = new int[] { 0, 0, 0 };
			gbl_pnlModifikujKvadrat.rowHeights = new int[] { 0, 0, 0, 0, 0, 0 };
			gbl_pnlModifikujKvadrat.columnWeights = new double[] { 0.0, 1.0, Double.MIN_VALUE };
			gbl_pnlModifikujKvadrat.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
			pnlModifikujKvadrat.setLayout(gbl_pnlModifikujKvadrat);
			{
				JLabel lblXKoordinataTacke = new JLabel("X koordinata");
				GridBagConstraints gbc_lblXKoordinataTacke = new GridBagConstraints();
				gbc_lblXKoordinataTacke.anchor = GridBagConstraints.EAST;
				gbc_lblXKoordinataTacke.insets = new Insets(0, 0, 5, 5);
				gbc_lblXKoordinataTacke.gridx = 0;
				gbc_lblXKoordinataTacke.gridy = 0;
				pnlModifikujKvadrat.add(lblXKoordinataTacke, gbc_lblXKoordinataTacke);
			}
			{
				txtXkoordinata = new JTextField();
				GridBagConstraints gbc_txtXkoordinata = new GridBagConstraints();
				gbc_txtXkoordinata.insets = new Insets(0, 0, 5, 0);
				gbc_txtXkoordinata.fill = GridBagConstraints.HORIZONTAL;
				gbc_txtXkoordinata.gridx = 1;
				gbc_txtXkoordinata.gridy = 0;
				pnlModifikujKvadrat.add(txtXkoordinata, gbc_txtXkoordinata);
				txtXkoordinata.setColumns(10);
			}
			{
				JLabel lblYKoordinataTake = new JLabel("Y koordinata");
				GridBagConstraints gbc_lblYKoordinataTake = new GridBagConstraints();
				gbc_lblYKoordinataTake.anchor = GridBagConstraints.EAST;
				gbc_lblYKoordinataTake.insets = new Insets(0, 0, 5, 5);
				gbc_lblYKoordinataTake.gridx = 0;
				gbc_lblYKoordinataTake.gridy = 1;
				pnlModifikujKvadrat.add(lblYKoordinataTake, gbc_lblYKoordinataTake);
			}
			{
				txtYkoordinata = new JTextField();
				txtYkoordinata.setText("");
				GridBagConstraints gbc_txtYkoordinata = new GridBagConstraints();
				gbc_txtYkoordinata.insets = new Insets(0, 0, 5, 0);
				gbc_txtYkoordinata.fill = GridBagConstraints.HORIZONTAL;
				gbc_txtYkoordinata.gridx = 1;
				gbc_txtYkoordinata.gridy = 1;
				pnlModifikujKvadrat.add(txtYkoordinata, gbc_txtYkoordinata);
				txtYkoordinata.setColumns(10);
			}
			{
				JLabel lblDuinaStaniceKvadrata = new JLabel("Duzina stanice");
				GridBagConstraints gbc_lblDuinaStaniceKvadrata = new GridBagConstraints();
				gbc_lblDuinaStaniceKvadrata.anchor = GridBagConstraints.EAST;
				gbc_lblDuinaStaniceKvadrata.insets = new Insets(0, 0, 5, 5);
				gbc_lblDuinaStaniceKvadrata.gridx = 0;
				gbc_lblDuinaStaniceKvadrata.gridy = 2;
				pnlModifikujKvadrat.add(lblDuinaStaniceKvadrata, gbc_lblDuinaStaniceKvadrata);
			}
			{
				txtDuzina = new JTextField();
				GridBagConstraints gbc_txtDuzina = new GridBagConstraints();
				gbc_txtDuzina.insets = new Insets(0, 0, 5, 0);
				gbc_txtDuzina.fill = GridBagConstraints.HORIZONTAL;
				gbc_txtDuzina.gridx = 1;
				gbc_txtDuzina.gridy = 2;
				pnlModifikujKvadrat.add(txtDuzina, gbc_txtDuzina);
				txtDuzina.setColumns(10);
			}
			{
				JLabel lblBojaIvice = new JLabel("Boja ivice");
				GridBagConstraints gbc_lblBojaIvice = new GridBagConstraints();
				gbc_lblBojaIvice.anchor = GridBagConstraints.EAST;
				gbc_lblBojaIvice.insets = new Insets(0, 0, 5, 5);
				gbc_lblBojaIvice.gridx = 0;
				gbc_lblBojaIvice.gridy = 3;
				pnlModifikujKvadrat.add(lblBojaIvice, gbc_lblBojaIvice);
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
				gbc_btnBojaIvice.gridy = 3;
				pnlModifikujKvadrat.add(btnBojaIvice, gbc_btnBojaIvice);
			}
			{
				JLabel lblBojaUnutranjosti = new JLabel("Boja unutrasnjosti");
				GridBagConstraints gbc_lblBojaUnutranjosti = new GridBagConstraints();
				gbc_lblBojaUnutranjosti.anchor = GridBagConstraints.EAST;
				gbc_lblBojaUnutranjosti.insets = new Insets(0, 0, 0, 5);
				gbc_lblBojaUnutranjosti.gridx = 0;
				gbc_lblBojaUnutranjosti.gridy = 4;
				pnlModifikujKvadrat.add(lblBojaUnutranjosti, gbc_lblBojaUnutranjosti);
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
				gbc_btnBojaUnutrasnjosti.gridy = 4;
				pnlModifikujKvadrat.add(btnBojaUnutrasnjosti, gbc_btnBojaUnutrasnjosti);
			}
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.CENTER));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton btnPotvrdi = new JButton("Izmeni");
				btnPotvrdi.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						try {
							x = Integer.parseInt(txtXkoordinata.getText());
							y = Integer.parseInt(txtYkoordinata.getText());
							duzina = Integer.parseInt(txtDuzina.getText());
							
							if (tempOdustani == false)
								kvadrat = new KvadratG(new Tacka(x, y), duzina, btnBojaIvice.getBackground(),
										btnBojaUnutrasnjosti.getBackground());
							kvadrat.provera();
							dispose();
						} catch (NumberFormatException e1) {
							JOptionPane.showMessageDialog(null, "Greska pri unosu!", "Upozorenje",
									JOptionPane.WARNING_MESSAGE);
						} catch (Exception e2) {
							JOptionPane.showMessageDialog(null, "Negativna vrednost!", "Upozorenje",
									JOptionPane.WARNING_MESSAGE);
						}
					}
				});
				
				btnPotvrdi.setActionCommand("OK");
				buttonPane.add(btnPotvrdi);
				getRootPane().setDefaultButton(btnPotvrdi);
			}
			{
				JButton btnOdustani = new JButton("Odustani");
				btnOdustani.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
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

	public JTextField getTxtDuzina() {
		return txtDuzina;
	}

	public void setTxtDuzina(JTextField txtDuzina) {
		this.txtDuzina = txtDuzina;
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

	public int getDuzina() {
		return duzina;
	}

	public void setDuzina(int duzina) {
		this.duzina = duzina;
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