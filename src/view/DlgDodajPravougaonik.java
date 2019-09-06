package view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class DlgDodajPravougaonik extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtVisina;
	private JTextField txtSirina;
	private int visina;
	private int sirina;

	/**
	 * Create the dialog.
	 */
	public DlgDodajPravougaonik() {
		setModal(true);
		setTitle("Dodavanje pravougaonika");
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		{
			JPanel pnlPravougaonik = new JPanel();
			contentPanel.add(pnlPravougaonik, BorderLayout.CENTER);
			GridBagLayout gbl_pnlPravougaonik = new GridBagLayout();
			gbl_pnlPravougaonik.columnWidths = new int[] { 0, 0, 0 };
			gbl_pnlPravougaonik.rowHeights = new int[] { 0, 0, 0, 0, 0 };
			gbl_pnlPravougaonik.columnWeights = new double[] { 0.0, 1.0, Double.MIN_VALUE };
			gbl_pnlPravougaonik.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
			pnlPravougaonik.setLayout(gbl_pnlPravougaonik);
			{
				JLabel lblVisina = new JLabel("Unesite visinu");
				GridBagConstraints gbc_lblVisina = new GridBagConstraints();
				gbc_lblVisina.anchor = GridBagConstraints.EAST;
				gbc_lblVisina.insets = new Insets(0, 0, 5, 5);
				gbc_lblVisina.gridx = 0;
				gbc_lblVisina.gridy = 2;
				pnlPravougaonik.add(lblVisina, gbc_lblVisina);
			}
			{
				txtVisina = new JTextField();
				GridBagConstraints gbc_txtVisina = new GridBagConstraints();
				gbc_txtVisina.insets = new Insets(0, 0, 5, 0);
				gbc_txtVisina.fill = GridBagConstraints.HORIZONTAL;
				gbc_txtVisina.gridx = 1;
				gbc_txtVisina.gridy = 2;
				pnlPravougaonik.add(txtVisina, gbc_txtVisina);
				txtVisina.setColumns(10);
			}
			{
				JLabel lblSirina = new JLabel("Unesite sirinu");
				GridBagConstraints gbc_lblSirina = new GridBagConstraints();
				gbc_lblSirina.anchor = GridBagConstraints.EAST;
				gbc_lblSirina.insets = new Insets(0, 0, 0, 5);
				gbc_lblSirina.gridx = 0;
				gbc_lblSirina.gridy = 3;
				pnlPravougaonik.add(lblSirina, gbc_lblSirina);
			}
			{
				txtSirina = new JTextField();
				GridBagConstraints gbc_txtSirina = new GridBagConstraints();
				gbc_txtSirina.fill = GridBagConstraints.HORIZONTAL;
				gbc_txtSirina.gridx = 1;
				gbc_txtSirina.gridy = 3;
				pnlPravougaonik.add(txtSirina, gbc_txtSirina);
				txtSirina.setColumns(10);
			}
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.CENTER));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton btnDodaj = new JButton("Dodaj pravougaonik");
				btnDodaj.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						try {
							visina = Integer.parseInt(txtVisina.getText().toString());
							sirina = Integer.parseInt(txtSirina.getText().toString());
						} catch (NumberFormatException e1) {
							JOptionPane.showMessageDialog(null, "Greska pri unosu!", "Upozorenje",
									JOptionPane.WARNING_MESSAGE);
						}
						dispose();
					}
				});
				
				btnDodaj.setActionCommand("OK");
				buttonPane.add(btnDodaj);
				getRootPane().setDefaultButton(btnDodaj);
			}
			{
				JButton btnOdustani = new JButton("Odustani");
				btnOdustani.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				
				btnOdustani.setActionCommand("Cancel");
				buttonPane.add(btnOdustani);
			}
		}
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
}