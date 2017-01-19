package widoki;

import java.awt.*;

class Main {
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {

				Logowanie lo = new Logowanie();

				lo.setVisible(true);
				Biblioteka af = new Biblioteka();
				af.setVisible(false);
			}

		});
	}
}