package view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.Circle;
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
import javax.swing.SwingConstants;

public class DlgModifikujKrug extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtXkoordinata;
	private JTextField txtYkoordinata;
	private JTextField txtPoluprecnik;
	private JButton btnBojaIvice;
	private JButton btnBojaUnutrasnjosti;
	private int x;
	private int y;
	private int poluprecnik;
	public Circle krug;
	public boolean tempOdustani;


	/**
	 * Create the dialog.
	 */
	public DlgModifikujKrug() {
		setModal(true);
		setTitle("Modifikuj krug");
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		{
			JPanel pnlKrug = new JPanel();
			contentPanel.add(pnlKrug, BorderLayout.CENTER);
			GridBagLayout gbl_pnlKrug = new GridBagLayout();
			gbl_pnlKrug.columnWidths = new int[] { 0, 0, 0 };
			gbl_pnlKrug.rowHeights = new int[] { 0, 0, 0, 0, 0, 0, 0 };
			gbl_pnlKrug.columnWeights = new double[] { 0.0, 1.0, Double.MIN_VALUE };
			gbl_pnlKrug.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
			pnlKrug.setLayout(gbl_pnlKrug);
			{
				JLabel lblXKoordinataCentra = new JLabel("X koordinata centra");
				GridBagConstraints gbc_lblXKoordinataCentra = new GridBagConstraints();
				gbc_lblXKoordinataCentra.anchor = GridBagConstraints.EAST;
				gbc_lblXKoordinataCentra.insets = new Insets(0, 0, 5, 5);
				gbc_lblXKoordinataCentra.gridx = 0;
				gbc_lblXKoordinataCentra.gridy = 1;
				pnlKrug.add(lblXKoordinataCentra, gbc_lblXKoordinataCentra);
			}
			{
				txtXkoordinata = new JTextField();
				GridBagConstraints gbc_txtXkoordinata = new GridBagConstraints();
				gbc_txtXkoordinata.insets = new Insets(0, 0, 5, 0);
				gbc_txtXkoordinata.fill = GridBagConstraints.HORIZONTAL;
				gbc_txtXkoordinata.gridx = 1;
				gbc_txtXkoordinata.gridy = 1;
				pnlKrug.add(txtXkoordinata, gbc_txtXkoordinata);
				txtXkoordinata.setColumns(10);
			}
			{
				JLabel lblYKoordinataCentra = new JLabel("Y koordinata centra");
				GridBagConstraints gbc_lblYKoordinataCentra = new GridBagConstraints();
				gbc_lblYKoordinataCentra.anchor = GridBagConstraints.EAST;
				gbc_lblYKoordinataCentra.insets = new Insets(0, 0, 5, 5);
				gbc_lblYKoordinataCentra.gridx = 0;
				gbc_lblYKoordinataCentra.gridy = 2;
				pnlKrug.add(lblYKoordinataCentra, gbc_lblYKoordinataCentra);
			}
			{
				txtYkoordinata = new JTextField();
				GridBagConstraints gbc_txtYkoordinata = new GridBagConstraints();
				gbc_txtYkoordinata.insets = new Insets(0, 0, 5, 0);
				gbc_txtYkoordinata.fill = GridBagConstraints.HORIZONTAL;
				gbc_txtYkoordinata.gridx = 1;
				gbc_txtYkoordinata.gridy = 2;
				pnlKrug.add(txtYkoordinata, gbc_txtYkoordinata);
				txtYkoordinata.setColumns(10);
			}
			{
				JLabel lblPoluprenik = new JLabel("Poluprecnik");
				GridBagConstraints gbc_lblPoluprenik = new GridBagConstraints();
				gbc_lblPoluprenik.anchor = GridBagConstraints.EAST;
				gbc_lblPoluprenik.insets = new Insets(0, 0, 5, 5);
				gbc_lblPoluprenik.gridx = 0;
				gbc_lblPoluprenik.gridy = 3;
				pnlKrug.add(lblPoluprenik, gbc_lblPoluprenik);
			}
			{
				txtPoluprecnik = new JTextField();
				GridBagConstraints gbc_txtPoluprecnik = new GridBagConstraints();
				gbc_txtPoluprecnik.insets = new Insets(0, 0, 5, 0);
				gbc_txtPoluprecnik.fill = GridBagConstraints.HORIZONTAL;
				gbc_txtPoluprecnik.gridx = 1;
				gbc_txtPoluprecnik.gridy = 3;
				pnlKrug.add(txtPoluprecnik, gbc_txtPoluprecnik);
				txtPoluprecnik.setColumns(10);
			}
			{
				JLabel lblBojaIvice = new JLabel("Boja ivice");
				GridBagConstraints gbc_lblBojaIvice = new GridBagConstraints();
				gbc_lblBojaIvice.anchor = GridBagConstraints.EAST;
				gbc_lblBojaIvice.insets = new Insets(0, 0, 5, 5);
				gbc_lblBojaIvice.gridx = 0;
				gbc_lblBojaIvice.gridy = 4;
				pnlKrug.add(lblBojaIvice, gbc_lblBojaIvice);
			}
			{
				btnBojaIvice = new JButton("");
				btnBojaIvice.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						btnBojaIvice.setBackground(odabirBoje(btnBojaIvice.getBackground()));
					}
				});
				btnBojaIvice.setHorizontalAlignment(SwingConstants.RIGHT);
				GridBagConstraints gbc_btnBojaIvice = new GridBagConstraints();
				gbc_btnBojaIvice.insets = new Insets(0, 0, 5, 0);
				gbc_btnBojaIvice.gridx = 1;
				gbc_btnBojaIvice.gridy = 4;
				pnlKrug.add(btnBojaIvice, gbc_btnBojaIvice);
			}
			{
				JLabel lblBojaUnutranosti = new JLabel("Boja unutrasnjosti");
				GridBagConstraints gbc_lblBojaUnutranosti = new GridBagConstraints();
				gbc_lblBojaUnutranosti.anchor = GridBagConstraints.EAST;
				gbc_lblBojaUnutranosti.insets = new Insets(0, 0, 0, 5);
				gbc_lblBojaUnutranosti.gridx = 0;
				gbc_lblBojaUnutranosti.gridy = 5;
				pnlKrug.add(lblBojaUnutranosti, gbc_lblBojaUnutranosti);
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
				gbc_btnBojaUnutrasnjosti.gridy = 5;
				pnlKrug.add(btnBojaUnutrasnjosti, gbc_btnBojaUnutrasnjosti);
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
							poluprecnik = Integer.parseInt(txtPoluprecnik.getText());

							if (tempOdustani == false)
								krug = new Circle(new Tacka(x, y), poluprecnik, btnBojaIvice.getBackground(),
										btnBojaUnutrasnjosti.getBackground());
							krug.provera();
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

	public JTextField getTxtPoluprecnik() {
		return txtPoluprecnik;
	}

	public void setTxtPoluprecnik(JTextField txtPoluprecnik) {
		this.txtPoluprecnik = txtPoluprecnik;
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

	public int getPoluprecnik() {
		return poluprecnik;
	}

	public void setPoluprecnik(int poluprecnik) {
		this.poluprecnik = poluprecnik;
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