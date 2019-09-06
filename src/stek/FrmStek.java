package stek;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.EmptyStackException;
import java.util.Stack;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

public class FrmStek extends JFrame {

	private JPanel contentPane;
	private String bojaIvice;
	private String bojaUnutrasnjosti;
	private DefaultListModel<Kvadrat> dlmKvadrat = new DefaultListModel<Kvadrat>();
	private DlgKvadrat dlgk = new DlgKvadrat();
	private Stack<Kvadrat> stek = new Stack<Kvadrat>();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmStek frame = new FrmStek();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public FrmStek() {
		setTitle("Martinovic Sandra IT 10/2016");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));

		JPanel pnlDugmici = new JPanel();
		pnlDugmici.setBackground(Color.WHITE);
		contentPane.add(pnlDugmici, BorderLayout.CENTER);
		GridBagLayout gbl_pnlGlavni = new GridBagLayout();
		gbl_pnlGlavni.columnWidths = new int[] { 0, 0, 0 };
		gbl_pnlGlavni.rowHeights = new int[] { 0, 0, 0 };
		gbl_pnlGlavni.columnWeights = new double[] { 0.0, 1.0, Double.MIN_VALUE };
		gbl_pnlGlavni.rowWeights = new double[] { 1.0, 0.0, Double.MIN_VALUE };
		pnlDugmici.setLayout(gbl_pnlGlavni);

		JButton btnDodaj = new JButton("Dodaj");
		btnDodaj.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dlgk.getTxtXkoordinata().setText("");
				dlgk.getTxtYkoordinata().setText("");
				dlgk.getTxtDuzina().setText("");
				dlgk.getCmbBojaIvica().getSelectedItem();
				dlgk.getCmbBojaUnutrasnjosti().getSelectedItem();
				DlgKvadrat dlgk= new DlgKvadrat();
				dlgk.setVisible(true);

				stek.push(dlgk.dlgKv);
				dlmKvadrat.add(0, dlgk.dlgKv);
			}
		});
		
		GridBagConstraints gbc_btnDodaj = new GridBagConstraints();
		gbc_btnDodaj.insets = new Insets(0, 0, 5, 5);
		gbc_btnDodaj.gridx = 0;
		gbc_btnDodaj.gridy = 0;
		pnlDugmici.add(btnDodaj, gbc_btnDodaj);

		JScrollPane scrollPane = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridheight = 2;
		gbc_scrollPane.insets = new Insets(0, 0, 5, 0);
		gbc_scrollPane.gridx = 1;
		gbc_scrollPane.gridy = 0;
		pnlDugmici.add(scrollPane, gbc_scrollPane);

		JList<Kvadrat> list = new JList<Kvadrat>(dlmKvadrat);
		scrollPane.setViewportView(list);

		JButton btnIzuzmi = new JButton("Izuzmi");
		btnIzuzmi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Kvadrat tempKv = stek.peek();
					dlgk.getTxtXkoordinata().setText("" + tempKv.getGoreLevo().getX() + "");
					dlgk.getTxtYkoordinata().setText("" + tempKv.getGoreLevo().getY() + "");
					dlgk.getTxtDuzina().setText("" + tempKv.getDuzina() + "");
					dlgk.getCmbBojaIvica().setSelectedItem(tempKv.getBojaIvice());
					dlgk.getCmbBojaUnutrasnjosti().setSelectedItem(tempKv.getBojaUnutrasnjosti());

					dlgk.setVisible(true);
					stek.pop();
					dlmKvadrat.remove(0);
				} catch (EmptyStackException e1) {
					JOptionPane.showMessageDialog(null, "Niste uneli nijedan element!", "Upozorenje",
							JOptionPane.WARNING_MESSAGE);
					
				}
				return;
			}
		});
		
		GridBagConstraints gbc_btnIzuzmi = new GridBagConstraints();
		gbc_btnIzuzmi.insets = new Insets(0, 0, 75, 5);
		gbc_btnIzuzmi.gridx = 0;
		gbc_btnIzuzmi.gridy = 1;
		pnlDugmici.add(btnIzuzmi, gbc_btnIzuzmi);
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
}