import static javax.swing.JOptionPane.*;
import java.util.Random;

class MinRandom {
	//Attributter
	int ovre;
	int nedre;
	double nedre2;
	double ovre2;
	java.util.Random random = new java.util.Random();

	//Konstruktør
	public MinRandom(int nedre, int ovre) {
		this.ovre = ovre;
		this.nedre = nedre;
	}
	public MinRandom(double nedre2, double ovre2) {
		this.ovre2 = ovre2;
		this.nedre2 = nedre2;
	}

	//Metoder
	public int getNesteHeltall(){
		int tall = random.nextInt(ovre+1-nedre) + nedre;
		return tall;
	}

	public double getNesteDesimaltall() {
		double tall = random.nextDouble()*(ovre2-nedre2) + nedre2;
		return tall;
	}
}

class Random1 {
	public static void main (String[] args) {
		int valg = Integer.parseInt(showInputDialog("1 - Heltall \n 2 - Desimaltall"));
		if (valg == 1) {
			int nedre = Integer.parseInt(showInputDialog("Nedre: "));
			int ovre = Integer.parseInt(showInputDialog("Øvre: "));
			MinRandom finnHeltall = new MinRandom(nedre, ovre);
			int funnetTall = finnHeltall.getNesteHeltall();
			showMessageDialog(null, funnetTall);
		}
		else if (valg == 2) {
			double nedre = Double.parseDouble(showInputDialog("Nedre: "));
			double ovre = Double.parseDouble(showInputDialog("Øvre: "));
			MinRandom finnDesimaltall = new MinRandom(nedre, ovre);
			double funnetTall = finnDesimaltall.getNesteDesimaltall();
			showMessageDialog(null,funnetTall);
		}
	}
}