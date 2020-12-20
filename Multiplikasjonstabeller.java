import static javax.swing.JOptionPane.*;

class Multiplikasjonstabeller {

	public static void main (String[] args) {

		int fra = Integer.parseInt(showInputDialog("Fra: "));
		int til = Integer.parseInt(showInputDialog("Til: "));

		String utskrift = " ";

		while (fra <= til) {
			int faktor = 1;
			while (faktor <= 10) {
				int produkt = faktor * fra;
				if (faktor == 1 ) {
					utskrift += "\n" + fra + "-gangen:" + "\n";
				}
				utskrift += faktor + " * " + fra + " = " + produkt + "\n";


				if (fra == til && faktor == 10) {
					System.out.println(utskrift);
				}
				faktor++;
				}
			fra++;
			}
		}
}