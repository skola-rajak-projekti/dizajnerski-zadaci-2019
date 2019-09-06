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

public class DlgDodajKvadrat extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField txtDuzina;
	private int duzina;

	
	/**
	 * Create the dialog.
	 */
	public DlgDodajKvadrat() {
		setTitle("Dodavanje kvadrata");
		setModal(true);
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		{
			JPanel pnlKvadrat = new JPanel();
			contentPanel.add(pnlKvadrat, BorderLayout.CENTER);
			GridBagLayout gbl_pnlKvadrat = new GridBagLayout();
			gbl_pnlKvadrat.columnWidths = new int[] { 0, 0, 0 };
			gbl_pnlKvadrat.rowHeights = new int[] { 0, 0, 0, 0, 0 };
			gbl_pnlKvadrat.columnWeights = new double[] { 0.0, 1.0, Double.MIN_VALUE };
			gbl_pnlKvadrat.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
			pnlKvadrat.setLayout(gbl_pnlKvadrat);
			{
				JLabel lblDuzina = new JLabel("Unesite duzinu stranice");
				GridBagConstraints gbc_lblDuzina = new GridBagConstraints();
				gbc_lblDuzina.insets = new Insets(0, 0, 0, 5);
				gbc_lblDuzina.anchor = GridBagConstraints.EAST;
				gbc_lblDuzina.gridx = 0;
				gbc_lblDuzina.gridy = 3;
				pnlKvadrat.add(lblDuzina, gbc_lblDuzina);
			}
			{
				txtDuzina = new JTextField();
				GridBagConstraints gbc_txtDuzina = new GridBagConstraints();
				gbc_txtDuzina.fill = GridBagConstraints.HORIZONTAL;
				gbc_txtDuzina.gridx = 1;
				gbc_txtDuzina.gridy = 3;
				pnlKvadrat.add(txtDuzina, gbc_txtDuzina);
				txtDuzina.setColumns(10);
			}
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.CENTER));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton btnDodaj = new JButton("Dodaj kvadrat");
				btnDodaj.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						try {
							duzina = Integer.parseInt(txtDuzina.getText());
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

	public JTextField getTxtDuzina() {
		return txtDuzina;
	}

	public void setTxtDuzina(JTextField txtDuzina) {
		this.txtDuzina = txtDuzina;
	}

	public int getDuzina() {
		return duzina;
	}

	public void setDuzina(int duzina) {
		this.duzina = duzina;
	}
}