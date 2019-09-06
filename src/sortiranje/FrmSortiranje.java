package sortiranje;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

import stek.DlgKvadrat;
import stek.Kvadrat;

public class FrmSortiranje extends JFrame {

	private JPanel contentPane;
	private DefaultListModel<Kvadrat> dlmKvadrat = new DefaultListModel<Kvadrat>();
	private ArrayList<Kvadrat> lista = new ArrayList<Kvadrat>();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmSortiranje frame = new FrmSortiranje();
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
	public FrmSortiranje() {
		setTitle("Martinovic Sandra IT 10/2016");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));

		JPanel pnlGlavni = new JPanel();
		pnlGlavni.setBackground(Color.WHITE);
		contentPane.add(pnlGlavni, BorderLayout.CENTER);
		GridBagLayout gbl_pnlGlavni = new GridBagLayout();
		gbl_pnlGlavni.columnWidths = new int[] { 0, 0, 0 };
		gbl_pnlGlavni.rowHeights = new int[] { 0, 0, 0 };
		gbl_pnlGlavni.columnWeights = new double[] { 0.0, 1.0, Double.MIN_VALUE };
		gbl_pnlGlavni.rowWeights = new double[] { 1.0, 0.0, Double.MIN_VALUE };
		pnlGlavni.setLayout(gbl_pnlGlavni);

		JButton btnDodaj = new JButton("Dodaj");
		btnDodaj.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				DlgKvadrat dlgk = new DlgKvadrat();
				dlgk.setVisible(true);
				
				lista.add(dlgk.dlgKv);
				dlmKvadrat.add(0, dlgk.dlgKv);
			}
		});
		
		GridBagConstraints gbc_btnDodaj = new GridBagConstraints();
		gbc_btnDodaj.insets = new Insets(0, 0, 5, 5);
		gbc_btnDodaj.gridx = 0;
		gbc_btnDodaj.gridy = 0;
		pnlGlavni.add(btnDodaj, gbc_btnDodaj);

		JScrollPane scrollPane = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridheight = 2;
		gbc_scrollPane.insets = new Insets(0, 0, 5, 0);
		gbc_scrollPane.gridx = 1;
		gbc_scrollPane.gridy = 0;
		pnlGlavni.add(scrollPane, gbc_scrollPane);

		JList<Kvadrat> list = new JList<Kvadrat>(dlmKvadrat);
		scrollPane.setViewportView(list);

		JButton btnSortiraj = new JButton("Sortiraj");
		btnSortiraj.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dlmKvadrat.removeAllElements();
				lista.sort(null);

				Iterator<Kvadrat> it = lista.iterator();
				while (it.hasNext())
					dlmKvadrat.addElement(it.next());
			}
		});
		
		GridBagConstraints gbc_btnSortiraj = new GridBagConstraints();
		gbc_btnSortiraj.insets = new Insets(0, 0, 75, 5);
		gbc_btnSortiraj.gridx = 0;
		gbc_btnSortiraj.gridy = 1;
		pnlGlavni.add(btnSortiraj, gbc_btnSortiraj);
	}
}