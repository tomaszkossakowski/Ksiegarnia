package widoki;

import controller_widokow.BibliotekaController;
import controller_widokow.LogowanieController;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Logowanie extends JFrame {

	private JButton zamknij, zaloguj;
	private JTextField login, haslo;
	private JLabel loginNap, hasloNap;
	BibliotekaController bibliotekaController;

	public Logowanie() {
		setTitle("Logowanie");
		setSize(300, 200);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		LogowanieController logowanieController = new LogowanieController();
		bibliotekaController = new BibliotekaController();
		Biblioteka Af = new Biblioteka();

		zamknij = new JButton("zamknij");
		zaloguj = new JButton("zaloguj");

		login = new JTextField();
		haslo = new JTextField();

		loginNap = new JLabel("login");
		hasloNap = new JLabel("haslo");

		add(zamknij);
		add(zaloguj);

		add(login);
		add(haslo);

		add(loginNap);
		add(hasloNap);

		setLayout(null);
		setPreferredSize(null);

		zamknij.setBounds(150, 90, 80, 20);
		zaloguj.setBounds(50, 90, 80, 20);

		haslo.setBounds(150, 50, 80, 20);
		login.setBounds(50, 50, 80, 20);

		hasloNap.setBounds(150, 10, 80, 20);
		loginNap.setBounds(50, 10, 80, 20);

		zaloguj.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (logowanieController.zaloguj(haslo.getText(), login.getText())) {
					setVisible(false);
					Biblioteka af = new Biblioteka();
					Af.setVisible(true);

				} else {
					JOptionPane.showMessageDialog(null, "Poda³eœ z³y login lub has³o");
				}
			}
		});

		zamknij.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});

	}

}
