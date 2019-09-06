package view;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Shape;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JToggleButton;
import javax.swing.border.EmptyBorder;

import controller.Command;
import controller.CommandStack;
import controller.DeleteShapeCommand;
import controller.aligment.MoveToFront;
import controller.circleCommands.AddNewCircleCommand;
import controller.circleCommands.CircleController;
import controller.lineCommands.AddNewLineCommand;
import controller.lineCommands.LineController;
import controller.pointCommands.AddNewPointCommand;
import controller.pointCommands.PointController;
import controller.rectangleCommands.AddNewRectangleCommand;
import controller.rectangleCommands.RectangleController;
import controller.squareCommands.AddNewSquareCommand;
import controller.squareCommands.SquareController;
import model.Circle;
import model.KvadratG;
import model.Linija;
import model.Oblik;
import model.Pravougaonik;
import model.Tacka;

public class FrmCrtanje extends JFrame {

	private JPanel contentPane;
	private PnlCrtez pnlCrtanje = new PnlCrtez();
	private ButtonGroup buttonGroup = new ButtonGroup();
	private String odabranaOpcija;
	private boolean selektovanOblik;
	private boolean klik = false;
	private Tacka tackaKlika;
	
	private Oblik currentSelectedObject = null;

	private static CommandStack cs = new CommandStack();

	//

	/**
	 * Create the frame.
	 */
	public FrmCrtanje() {
		setTitle("Martinovic Sandra IT 10/2016");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(200, 200, 750, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[] { 0, 0, 0, 0, 0, 0 };
		gbl_contentPane.rowHeights = new int[] { 0, 0, 0, 0 };
		gbl_contentPane.columnWeights = new double[] { 1.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		gbl_contentPane.rowWeights = new double[] { 0.0, 0.0, 1.0, Double.MIN_VALUE };
		contentPane.setLayout(gbl_contentPane);

		/*********
		 * TODO: AKO MOZES, BILO BI MNOGO LEPO DA STAVIS NEGDE OVA DUGMAD POSTO JA NE
		 * ZNAM
		 ******************/

		JButton undo = new JButton("Undo");
		undo.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				cs.undo();
			}
		});
		contentPane.add(undo);
		
		JButton to_front = new JButton("to front");
		to_front.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				
				cs.execute(new MoveToFront( currentSelectedObject ));
			}
		});
		contentPane.add(to_front);
		/**********************************************************************************************************/
		JToggleButton tglbtnTacka = new JToggleButton("Tacka");
		tglbtnTacka.setBackground(Color.PINK);
		tglbtnTacka.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				odabranaOpcija = "tacka";
			}
		});
		buttonGroup.add(tglbtnTacka);
		GridBagConstraints gbc_tglbtnTacka = new GridBagConstraints();
		gbc_tglbtnTacka.weightx = 80.0;
		gbc_tglbtnTacka.insets = new Insets(0, 0, 5, 5);
		gbc_tglbtnTacka.gridx = 0;
		gbc_tglbtnTacka.gridy = 0;
		contentPane.add(tglbtnTacka, gbc_tglbtnTacka);

		JToggleButton tglbtnLinija = new JToggleButton("Linija");
		tglbtnLinija.setBackground(Color.PINK);
		tglbtnLinija.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				odabranaOpcija = "linija";
			}
		});
		buttonGroup.add(tglbtnLinija);
		GridBagConstraints gbc_tglbtnLinija = new GridBagConstraints();
		gbc_tglbtnLinija.weightx = 80.0;
		gbc_tglbtnLinija.insets = new Insets(0, 0, 5, 5);
		gbc_tglbtnLinija.gridx = 1;
		gbc_tglbtnLinija.gridy = 0;
		contentPane.add(tglbtnLinija, gbc_tglbtnLinija);

		JToggleButton tglbtnKvadrat = new JToggleButton("Kvadrat");
		tglbtnKvadrat.setBackground(Color.PINK);
		tglbtnKvadrat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				odabranaOpcija = "kvadrat";
			}
		});
		buttonGroup.add(tglbtnKvadrat);
		GridBagConstraints gbc_tglbtnKvadrat = new GridBagConstraints();
		gbc_tglbtnKvadrat.weightx = 80.0;
		gbc_tglbtnKvadrat.insets = new Insets(0, 0, 5, 5);
		gbc_tglbtnKvadrat.gridx = 2;
		gbc_tglbtnKvadrat.gridy = 0;
		contentPane.add(tglbtnKvadrat, gbc_tglbtnKvadrat);

		JToggleButton tglbtnPravougaonik = new JToggleButton("Pravougaonik");
		tglbtnPravougaonik.setBackground(Color.PINK);
		tglbtnPravougaonik.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				odabranaOpcija = "pravougaonik";
			}
		});
		buttonGroup.add(tglbtnPravougaonik);
		GridBagConstraints gbc_tglbtnPravougaonik = new GridBagConstraints();
		gbc_tglbtnPravougaonik.weightx = 80.0;
		gbc_tglbtnPravougaonik.insets = new Insets(0, 0, 5, 5);
		gbc_tglbtnPravougaonik.gridx = 3;
		gbc_tglbtnPravougaonik.gridy = 0;
		contentPane.add(tglbtnPravougaonik, gbc_tglbtnPravougaonik);

		JToggleButton tglbtnKrug = new JToggleButton("Krug");
		tglbtnKrug.setBackground(Color.PINK);
		tglbtnKrug.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				odabranaOpcija = "krug";
			}
		});
		buttonGroup.add(tglbtnKrug);
		GridBagConstraints gbc_tglbtnKrug = new GridBagConstraints();
		gbc_tglbtnKrug.weightx = 80.0;
		gbc_tglbtnKrug.insets = new Insets(0, 0, 5, 0);
		gbc_tglbtnKrug.gridx = 4;
		gbc_tglbtnKrug.gridy = 0;
		contentPane.add(tglbtnKrug, gbc_tglbtnKrug);

		JToggleButton tglbtnSelektuj = new JToggleButton("Selektuj");
		tglbtnSelektuj.setBackground(Color.LIGHT_GRAY);
		buttonGroup.add(tglbtnSelektuj);
		tglbtnSelektuj.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				odabranaOpcija = "selektuj";
			}
		});
		GridBagConstraints gbc_tglbtnSelektuj = new GridBagConstraints();
		gbc_tglbtnSelektuj.weightx = 80.0;
		gbc_tglbtnSelektuj.insets = new Insets(0, 0, 5, 5);
		gbc_tglbtnSelektuj.gridx = 0;
		gbc_tglbtnSelektuj.gridy = 1;
		contentPane.add(tglbtnSelektuj, gbc_tglbtnSelektuj);

		JButton btnModifikuj = new JButton("Modify");
		btnModifikuj.setBackground(Color.LIGHT_GRAY);
		btnModifikuj.setEnabled(false);
		btnModifikuj.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (selektovanOblik == true) {
					Oblik oblik;

					for (int i = 0; i < pnlCrtanje.listaOblika.size(); i++) {
						if (pnlCrtanje.listaOblika.get(i).isSelektovan() == true) {
							oblik = pnlCrtanje.listaOblika.get(i);
							if (oblik instanceof Tacka) {
								PointController.modifySelectedPoint(pnlCrtanje, oblik, i);

							} else if (oblik instanceof Linija) {

								LineController.modifySelectedLine(pnlCrtanje, oblik, i);

							} else if (oblik instanceof Pravougaonik) {

								RectangleController.modifySelectedRectangle(pnlCrtanje, oblik, i);

							} else if (oblik instanceof KvadratG) {

								SquareController.modifySelectedSquare(pnlCrtanje, oblik, i);

							} else if (oblik instanceof Circle) {

								CircleController.modifySelectedCircle(pnlCrtanje, oblik, i);

							}
							selektovanOblik = false;
						}
					}
				} else
					JOptionPane.showMessageDialog(null, "Nijedan oblik nije selektovan!", "Greska",
							JOptionPane.WARNING_MESSAGE);
			}
		});
		GridBagConstraints gbc_btnModifikuj = new GridBagConstraints();
		gbc_btnModifikuj.weightx = 80.0;
		gbc_btnModifikuj.insets = new Insets(0, 0, 5, 5);
		gbc_btnModifikuj.gridx = 1;
		gbc_btnModifikuj.gridy = 1;
		contentPane.add(btnModifikuj, gbc_btnModifikuj);

		/*
		 * 
		 * TODO: Posebne metode za izgled delete dijaloga u zavisnosti od oblika
		 * 
		 */
		JButton btnObrisi = new JButton("Obrisi");
		btnObrisi.setEnabled(false);
		btnObrisi.setBackground(Color.LIGHT_GRAY);
		btnObrisi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (selektovanOblik == true) {

					for (int i = pnlCrtanje.listaOblika.size() - 1; i >= 0; i--) {

						if (pnlCrtanje.listaOblika.get(i).isSelektovan() == true) {
							Object[] options = { "Da", "Ne" };
							int n = JOptionPane.showOptionDialog(null,
									"Da li ste sigurni da zelite da obrisete selektovan oblik?", "Potvrda brisanja",
									JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
							if (n == 0) {

								cs.execute(new DeleteShapeCommand(PnlCrtez.listaOblika.get(i)));

								selektovanOblik = false;
							} else {
								for (int j = pnlCrtanje.listaOblika.size() - 1; j >= 0; j--) {
									if (pnlCrtanje.listaOblika.get(i).isSelektovan() == true) {
										pnlCrtanje.listaOblika.get(i).setSelektovan(false);
										j = 0;
										selektovanOblik = false;
									}
								}
							}
							i = 0;
						}
					}
				} else
					JOptionPane.showMessageDialog(null, "Nijedan oblik nije selektovan!", "Greska",
							JOptionPane.WARNING_MESSAGE);
			}
		});

		GridBagConstraints gbc_btnObrisi = new GridBagConstraints();
		gbc_btnObrisi.weightx = 80.0;
		gbc_btnObrisi.insets = new Insets(0, 0, 5, 5);
		gbc_btnObrisi.gridx = 2;
		gbc_btnObrisi.gridy = 1;
		contentPane.add(btnObrisi, gbc_btnObrisi);

		JButton btnBojaIvice = new JButton("Boja ivice");
		btnBojaIvice.setForeground(Color.WHITE);
		btnBojaIvice.setBackground(Color.BLACK);
		btnBojaIvice.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnBojaIvice.setBackground(odabirBoje(btnBojaIvice.getBackground()));
			}
		});

		GridBagConstraints gbc_btnBojaIvice = new GridBagConstraints();
		gbc_btnBojaIvice.weightx = 80.0;
		gbc_btnBojaIvice.insets = new Insets(0, 0, 5, 5);
		gbc_btnBojaIvice.gridx = 3;
		gbc_btnBojaIvice.gridy = 1;
		contentPane.add(btnBojaIvice, gbc_btnBojaIvice);

		JButton btnBojaUnutrasnjosti = new JButton("Boja unutrasnjosti");
		btnBojaUnutrasnjosti.setForeground(Color.BLACK);
		btnBojaUnutrasnjosti.setBackground(Color.WHITE);
		btnBojaUnutrasnjosti.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnBojaUnutrasnjosti.setBackground(odabirBoje(btnBojaUnutrasnjosti.getBackground()));
			}
		});

		GridBagConstraints gbc_btnBojaUnutrasnjosti = new GridBagConstraints();
		gbc_btnBojaUnutrasnjosti.weightx = 80.0;
		gbc_btnBojaUnutrasnjosti.insets = new Insets(0, 0, 5, 0);
		gbc_btnBojaUnutrasnjosti.gridx = 4;
		gbc_btnBojaUnutrasnjosti.gridy = 1;
		contentPane.add(btnBojaUnutrasnjosti, gbc_btnBojaUnutrasnjosti);

		// TODO: Podeliti na tri mouse listener-a

		// point
		pnlCrtanje.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				int x = e.getX();
				int y = e.getY();
				Tacka startingShapePoint = new Tacka(x, y, btnBojaIvice.getBackground());

				if (odabranaOpcija.equalsIgnoreCase("tacka")) {
					// PnlCrtez.listaOblika.add(startingShapePoint);
					cs.execute(new AddNewPointCommand(startingShapePoint));
				}
			}
		});

		// line
		pnlCrtanje.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {

				if (odabranaOpcija.equalsIgnoreCase("linija")) {
					if (klik == false) {
						int x1 = e.getX();
						int y1 = e.getY();
						tackaKlika = new Tacka(x1, y1);
						klik = true;
					} else {
						Linija l = new Linija(tackaKlika, new Tacka(e.getX(), e.getY()), btnBojaIvice.getBackground());

						cs.execute(new AddNewLineCommand(l));
						klik = false;

					}

				}
			}
		});

		// square
		pnlCrtanje.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				int x = e.getX();
				int y = e.getY();
				Tacka startingShapePoint = new Tacka(x, y, btnBojaIvice.getBackground());

				if (odabranaOpcija.equalsIgnoreCase("kvadrat")) {

					DlgDodajKvadrat dodajKv = new DlgDodajKvadrat();
					dodajKv.setVisible(true);

					KvadratG kv = new KvadratG(startingShapePoint, dodajKv.getDuzina(), btnBojaIvice.getBackground(),
							btnBojaUnutrasnjosti.getBackground());

					if (dodajKv.getDuzina() > 0)
						// PnlCrtez.listaOblika.add(kv);
						cs.execute(new AddNewSquareCommand(kv));
					else
						return;
				}
			}
		});

		// rectangle
		pnlCrtanje.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				int x = e.getX();
				int y = e.getY();
				Tacka startingShapePoint = new Tacka(x, y, btnBojaIvice.getBackground());

				if (odabranaOpcija.equalsIgnoreCase("pravougaonik")) {
					DlgDodajPravougaonik dodajPravougaonik = new DlgDodajPravougaonik();
					dodajPravougaonik.setVisible(true);
					Pravougaonik pravougaonik = new Pravougaonik(startingShapePoint, dodajPravougaonik.getSirina(),
							dodajPravougaonik.getVisina(), btnBojaIvice.getBackground(),
							btnBojaUnutrasnjosti.getBackground());
					if (dodajPravougaonik.getSirina() > 0 & dodajPravougaonik.getVisina() > 0)
						// PnlCrtez.listaOblika.add(pravougaonik);
						cs.execute(new AddNewRectangleCommand(pravougaonik));
					else
						return;
				}
			}
		});

		// circle
		pnlCrtanje.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				int x = e.getX();
				int y = e.getY();
				Tacka startingShapePoint = new Tacka(x, y, btnBojaIvice.getBackground());

				if (odabranaOpcija.equalsIgnoreCase("krug")) {
					DlgDodajKrug dodajKrug = new DlgDodajKrug();
					dodajKrug.setVisible(true);

					Circle krug = new Circle(startingShapePoint, dodajKrug.getPoluprecnik(),
							btnBojaIvice.getBackground(), btnBojaUnutrasnjosti.getBackground());

					if (dodajKrug.getPoluprecnik() > 0) {
						cs.execute(new AddNewCircleCommand(krug));
					} else
						return;
				}
			}
		});

		pnlCrtanje.addMouseListener(new MouseAdapter() {
			

			public void mouseClicked(MouseEvent e) {
				int x = e.getX();
				int y = e.getY();
				// starting shape point
				Tacka startingShapePoint = new Tacka(x, y, btnBojaIvice.getBackground());


				try {
					  if (odabranaOpcija.equalsIgnoreCase("selektuj")) {						
						 for (int i = pnlCrtanje.listaOblika.size() - 1; i >= 0; i--) {									
							 if (pnlCrtanje.listaOblika.get(i).equals(currentSelectedObject)) {
								 pnlCrtanje.listaOblika.get(i).setSelektovan(false);
								 currentSelectedObject = null;
							 }
						 }
							 for (int i = pnlCrtanje.listaOblika.size() - 1; i >= 0; i--) {
							
								 if (pnlCrtanje.listaOblika.get(i).sadrzi(startingShapePoint.getX(),startingShapePoint.getY()) == true) {
									
								 	pnlCrtanje.listaOblika.get(i).setSelektovan(true);								 	
								 	currentSelectedObject =  pnlCrtanje.listaOblika.get(i);						 	
								 	btnModifikuj.setEnabled(true);
								 	btnObrisi.setEnabled(true);
								 	i = 0;
								 }
							 }
						 
					}
				} catch (Exception exc) {
					JOptionPane.showMessageDialog(null, "Niste selektovali nijednu opciju!");
				}
			}
		});

		pnlCrtanje.setBackground(Color.WHITE);
		GridBagConstraints gbc_pnlCrtanje = new GridBagConstraints();
		gbc_pnlCrtanje.gridwidth = 5;
		gbc_pnlCrtanje.insets = new Insets(0, 0, 0, 5);
		gbc_pnlCrtanje.fill = GridBagConstraints.BOTH;
		gbc_pnlCrtanje.gridx = 0;
		gbc_pnlCrtanje.gridy = 2;
		contentPane.add(pnlCrtanje, gbc_pnlCrtanje);
	}

	public Color odabirBoje(Color prethodnaBoja) {
		Color novaBoja = JColorChooser.showDialog(null, "Odabir boje", prethodnaBoja);
		if (novaBoja != null)
			return novaBoja;
		else {
			return prethodnaBoja;
		}
	}

	public static void addCommandToStack(Command command) {
		cs.execute(command);

	}
}