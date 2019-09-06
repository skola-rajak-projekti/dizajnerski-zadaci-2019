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

public class DlgDodajKrug extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField txtPoluprecnik;
	private int poluprecnik;

	
	/**
	 * Create the dialog.
	 */
	public DlgDodajKrug() {
		setModal(true);
		setTitle("Dodavanje kruga");
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		{
			JPanel pnlKrug = new JPanel();
			contentPanel.add(pnlKrug, BorderLayout.CENTER);
			GridBagLayout gbl_pnlKrug = new GridBagLayout();
			gbl_pnlKrug.columnWidths = new int[]{0, 0, 0};
			gbl_pnlKrug.rowHeights = new int[]{0, 0};
			gbl_pnlKrug.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
			gbl_pnlKrug.rowWeights = new double[]{0.0, Double.MIN_VALUE};
			pnlKrug.setLayout(gbl_pnlKrug);
			{
				JLabel lblPoluprecnik = new JLabel("Unesite poluprecnik kruga");
				GridBagConstraints gbc_lblPoluprecnik = new GridBagConstraints();
				gbc_lblPoluprecnik.insets = new Insets(0, 0, 0, 5);
				gbc_lblPoluprecnik.anchor = GridBagConstraints.EAST;
				gbc_lblPoluprecnik.gridx = 0;
				gbc_lblPoluprecnik.gridy = 0;
				pnlKrug.add(lblPoluprecnik, gbc_lblPoluprecnik);
			}
			{
				txtPoluprecnik = new JTextField();
				GridBagConstraints gbc_txtPoluprecnik = new GridBagConstraints();
				gbc_txtPoluprecnik.fill = GridBagConstraints.HORIZONTAL;
				gbc_txtPoluprecnik.gridx = 1;
				gbc_txtPoluprecnik.gridy = 0;
				pnlKrug.add(txtPoluprecnik, gbc_txtPoluprecnik);
				txtPoluprecnik.setColumns(10);
			}
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.CENTER));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton btnPotvrdi = new JButton("Dodaj krug");
				btnPotvrdi.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						try {
							poluprecnik = Integer.parseInt(txtPoluprecnik.getText().toString());
						} catch (NumberFormatException e1) {
							JOptionPane.showMessageDialog(null,"Greska pri unosu!",
								    "Upozorenje",JOptionPane.WARNING_MESSAGE);
						}
						dispose();
					}
				});
				
				btnPotvrdi.setActionCommand("OK");
				buttonPane.add(btnPotvrdi);
				getRootPane().setDefaultButton(btnPotvrdi);
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

	public JTextField getTxtPoluprecnik() {
		return txtPoluprecnik;
	}

	public void setTxtPoluprecnik(JTextField txtPoluprecnik) {
		this.txtPoluprecnik = txtPoluprecnik;
	}

	public int getPoluprecnik() {
		return poluprecnik;
	}

	public void setPoluprecnik(int poluprecnik) {
		this.poluprecnik = poluprecnik;
	}
}