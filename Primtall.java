import static javax.swing.JOptionPane.*;

class Primtall {

	public static void main (String[] args) {

		String tallLest = showInputDialog("Tall du vil sjekke: ");

		while (tallLest != null) {

		int tall = Integer.parseInt(tallLest);

		if (tall == 0) {
			showMessageDialog(null, tall + " er ikke et primtall");
			tallLest = showInputDialog("Tall du vil sjekke: ");
			continue;
			}

		else if (tall == 1) {
			showMessageDialog(null, tall + " er ikke et primtall");
			tallLest = showInputDialog("Tall du vil sjekke: ");
			continue;
			}

			else if (tall == 2) {
				showMessageDialog(null, tall + " er et primtall");
				tallLest = showInputDialog("Tall du vil sjekke: ");
				continue;
			}

		else if (tall % 2 == 0) {
			showMessageDialog(null, tall + " er ikke et primtall");
			tallLest = showInputDialog("Tall du vil sjekke: ");
			continue;
			}

		for (int teller = 3; teller <= tall; teller += 2) {

			if ((tall%teller)==0 && tall != teller ) {
				showMessageDialog(null, tall + " er ikke et primtall.");
				tallLest = showInputDialog("Tall du vil sjekke: ");
				break;
				}
			else if (tall == teller) {
				showMessageDialog(null, tall + " er et primtall.");
				tallLest = showInputDialog("Tall du vil sjekke: ");
				break;
				}
			}
			continue;
		}
	}
}