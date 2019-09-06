package stek;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import model.Tacka;

public class DlgKvadrat extends JDialog {

	private final JPanel pnlCentar = new JPanel();
	private JTextField txtXkoordinata;
	private JTextField txtYkoordinata;
	private JTextField txtDuzina;
	private JComboBox cmbBojaIvica;
	private JComboBox cmbBojaUnutrasnjosti;
	private int x;
	private int y;
	private int duzinaStranice;
	private String bojaIvice;
	private String bojaUnutrasnjosti;
	public Kvadrat dlgKv;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DlgKvadrat dialog = new DlgKvadrat();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DlgKvadrat() {
		setModal(true);
		setTitle("Podaci o kvadratu");
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		pnlCentar.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(pnlCentar, BorderLayout.CENTER);
		GridBagLayout gbl_pnlCentar = new GridBagLayout();
		gbl_pnlCentar.columnWidths = new int[] { 0, 0, 0 };
		gbl_pnlCentar.rowHeights = new int[] { 0, 0, 0, 0, 0, 0 };
		gbl_pnlCentar.columnWeights = new double[] { 0.0, 1.0, Double.MIN_VALUE };
		gbl_pnlCentar.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		pnlCentar.setLayout(gbl_pnlCentar);
		{
			JLabel lblXkoordinata = new JLabel("X koordinata");
			GridBagConstraints gbc_lblXkoordinata = new GridBagConstraints();
			gbc_lblXkoordinata.insets = new Insets(0, 0, 5, 5);
			gbc_lblXkoordinata.anchor = GridBagConstraints.EAST;
			gbc_lblXkoordinata.gridx = 0;
			gbc_lblXkoordinata.gridy = 0;
			pnlCentar.add(lblXkoordinata, gbc_lblXkoordinata);
		}
		{
			txtXkoordinata = new JTextField();
			GridBagConstraints gbc_txtXkoordinata = new GridBagConstraints();
			gbc_txtXkoordinata.insets = new Insets(0, 0, 5, 0);
			gbc_txtXkoordinata.fill = GridBagConstraints.HORIZONTAL;
			gbc_txtXkoordinata.gridx = 1;
			gbc_txtXkoordinata.gridy = 0;
			pnlCentar.add(txtXkoordinata, gbc_txtXkoordinata);
			txtXkoordinata.setColumns(10);
		}
		{
			JLabel lblYkoordinata = new JLabel("Y koordinata");
			GridBagConstraints gbc_lblYkoordinata = new GridBagConstraints();
			gbc_lblYkoordinata.anchor = GridBagConstraints.EAST;
			gbc_lblYkoordinata.insets = new Insets(0, 0, 5, 5);
			gbc_lblYkoordinata.gridx = 0;
			gbc_lblYkoordinata.gridy = 1;
			pnlCentar.add(lblYkoordinata, gbc_lblYkoordinata);
		}
		{
			txtYkoordinata = new JTextField();
			GridBagConstraints gbc_txtYkoordinata = new GridBagConstraints();
			gbc_txtYkoordinata.anchor = GridBagConstraints.NORTH;
			gbc_txtYkoordinata.insets = new Insets(0, 0, 5, 0);
			gbc_txtYkoordinata.fill = GridBagConstraints.HORIZONTAL;
			gbc_txtYkoordinata.gridx = 1;
			gbc_txtYkoordinata.gridy = 1;
			pnlCentar.add(txtYkoordinata, gbc_txtYkoordinata);
			txtYkoordinata.setColumns(10);
		}
		{
			JLabel lblDuzina = new JLabel("Duzina stranice");
			GridBagConstraints gbc_lblDuzina = new GridBagConstraints();
			gbc_lblDuzina.anchor = GridBagConstraints.EAST;
			gbc_lblDuzina.insets = new Insets(0, 0, 5, 5);
			gbc_lblDuzina.gridx = 0;
			gbc_lblDuzina.gridy = 2;
			pnlCentar.add(lblDuzina, gbc_lblDuzina);
		}
		{
			txtDuzina = new JTextField();
			GridBagConstraints gbc_txtDuzina = new GridBagConstraints();
			gbc_txtDuzina.insets = new Insets(0, 0, 5, 0);
			gbc_txtDuzina.fill = GridBagConstraints.HORIZONTAL;
			gbc_txtDuzina.gridx = 1;
			gbc_txtDuzina.gridy = 2;
			pnlCentar.add(txtDuzina, gbc_txtDuzina);
			txtDuzina.setColumns(10);
		}
		{
			JLabel lblBojaIvica = new JLabel("Boja ivice");
			GridBagConstraints gbc_lblBojaIvica = new GridBagConstraints();
			gbc_lblBojaIvica.anchor = GridBagConstraints.EAST;
			gbc_lblBojaIvica.insets = new Insets(0, 0, 5, 5);
			gbc_lblBojaIvica.gridx = 0;
			gbc_lblBojaIvica.gridy = 3;
			pnlCentar.add(lblBojaIvica, gbc_lblBojaIvica);
		}
		{
			cmbBojaIvica = new JComboBox();
			cmbBojaIvica.setModel(new DefaultComboBoxModel(new String[] { "bela", "crna", "crvena", "plava", "zuta", "zelena" }));
			GridBagConstraints gbc_cmbBojaIvica = new GridBagConstraints();
			gbc_cmbBojaIvica.insets = new Insets(0, 0, 5, 0);
			gbc_cmbBojaIvica.fill = GridBagConstraints.HORIZONTAL;
			gbc_cmbBojaIvica.gridx = 1;
			gbc_cmbBojaIvica.gridy = 3;
			pnlCentar.add(cmbBojaIvica, gbc_cmbBojaIvica);
		}
		{
			JLabel lblBojaUnutrasnjosti = new JLabel("Boja unutrasnjosti");
			GridBagConstraints gbc_lblBojaUnutrasnjosti = new GridBagConstraints();
			gbc_lblBojaUnutrasnjosti.anchor = GridBagConstraints.EAST;
			gbc_lblBojaUnutrasnjosti.insets = new Insets(0, 0, 0, 5);
			gbc_lblBojaUnutrasnjosti.gridx = 0;
			gbc_lblBojaUnutrasnjosti.gridy = 4;
			pnlCentar.add(lblBojaUnutrasnjosti, gbc_lblBojaUnutrasnjosti);
		}
		{
			cmbBojaUnutrasnjosti = new JComboBox();
			cmbBojaUnutrasnjosti.setModel(new DefaultComboBoxModel(new String[] { "bela", "crna", "crvena", "plava", "zuta", "zelena" }));
			GridBagConstraints gbc_cmbBojaUnutrasnjosti = new GridBagConstraints();
			gbc_cmbBojaUnutrasnjosti.fill = GridBagConstraints.HORIZONTAL;
			gbc_cmbBojaUnutrasnjosti.gridx = 1;
			gbc_cmbBojaUnutrasnjosti.gridy = 4;
			pnlCentar.add(cmbBojaUnutrasnjosti, gbc_cmbBojaUnutrasnjosti);
		}
		{
			JPanel btnDugmad = new JPanel();
			btnDugmad.setLayout(new FlowLayout(FlowLayout.CENTER));
			getContentPane().add(btnDugmad, BorderLayout.SOUTH);
			{
				JButton btnPotvrdi = new JButton("Potvrdi");
				btnPotvrdi.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						try {
							x = Integer.parseInt(txtXkoordinata.getText());
							y = Integer.parseInt(txtYkoordinata.getText());
							duzinaStranice = Integer.parseInt(txtDuzina.getText());
							bojaIvice = (String) cmbBojaIvica.getSelectedItem();
							bojaUnutrasnjosti = (String) cmbBojaUnutrasnjosti.getSelectedItem();

							dlgKv = new Kvadrat(new Tacka(x, y), duzinaStranice, bojaIvice, bojaUnutrasnjosti);
							dlgKv.provera();
							
						} catch (NumberFormatException e1) {
							JOptionPane.showMessageDialog(null, "Imate gresku pri unosu!", "Upozorenje",
									JOptionPane.WARNING_MESSAGE);
							return;
						} catch (Exception e2) {
							JOptionPane.showMessageDialog(null, e2.getMessage(), "Upozorenje",
									JOptionPane.WARNING_MESSAGE);
							return;
						}
						dispose();
					}
				});

				btnPotvrdi.setActionCommand("OK");
				btnDugmad.add(btnPotvrdi);
				getRootPane().setDefaultButton(btnPotvrdi);
			}
			{
				JButton btnOdustani = new JButton("Odustani");
				btnOdustani.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						txtXkoordinata.setText("");
						txtYkoordinata.setText("");
						txtDuzina.setText("");
						dispose();
					}
				});
				
				btnOdustani.setActionCommand("Cancel");
				btnDugmad.add(btnOdustani);
			}
		}
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

	public int getDuzinaStranice() {
		return duzinaStranice;
	}

	public void setDuzinaStranice(int duzinaStranice) {
		this.duzinaStranice = duzinaStranice;
	}

	public String getBojaIvice() {
		return bojaIvice;
	}

	public void setBojaIvice(String bojaIvice) {
		this.bojaIvice = bojaIvice;
	}

	public String getBojaUnutrasnjosti() {
		return bojaUnutrasnjosti;
	}

	public void setBojaUnutrasnjosti(String bojaUnutrasnjosti) {
		this.bojaUnutrasnjosti = bojaUnutrasnjosti;
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

	public JComboBox getCmbBojaIvica() {
		return cmbBojaIvica;
	}

	public void setCmbBojaIvica(JComboBox cmbBojaIvica) {
		this.cmbBojaIvica = cmbBojaIvica;
	}

	public JComboBox getCmbBojaUnutrasnjosti() {
		return cmbBojaUnutrasnjosti;
	}

	public void setCmbBojaUnutrasnjosti(JComboBox cmbBojaUnutrasnjosti) {
		this.cmbBojaUnutrasnjosti = cmbBojaUnutrasnjosti;
	}

	public void provera(int x, int y, int stranica) throws Exception {
		if (x < 0 | y < 0 | stranica < 0) {
			throw new Exception("Unete vrednosti su negativne!");
		}
	}
}