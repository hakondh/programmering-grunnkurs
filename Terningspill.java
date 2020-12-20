import static javax.swing.JOptionPane.*;
import java.util.Random;

class Spiller {
	java.util.Random terning = new java.util.Random();

	//Attributter
	public int sumPoeng;
	private int terningkast;

	//Konstruktør
	public Spiller(int sumPoeng) {
		this.sumPoeng = sumPoeng;
	}

	//Metoder
	private int kastTerningen () {
		terningkast = terning.nextInt(6) + 1;
		return(terningkast);
	}

	public int getSumPoeng () {
		kastTerningen();
		if (terningkast == 1) {
			sumPoeng = 0;
		}
		else {
			sumPoeng +=terningkast;
		}
		return(sumPoeng);
	}
}

class Terningspill {
	public static void main (String[] args) {
		boolean fortsett = true;
		int runde = 0;
		int poengsum1 = 0;
		int poengsum2 = 0;
		int vinnersum = 100;

		while (fortsett) {
			runde++;

			Spiller spiller1 = new Spiller(poengsum1);
			Spiller spiller2 = new Spiller(poengsum2);

			poengsum1 = spiller1.getSumPoeng();
			poengsum2 = spiller2.getSumPoeng();

			String utskrift = "Runde " + runde + ":" + "\n" + "Spiller 1: " + poengsum1 + "\n" + "Spiller 2: " + poengsum2 + "\n";
			System.out.println(utskrift);

			if (poengsum1 > vinnersum) {
				System.out.println("Vinneren er spiller 1");
				fortsett = false;
			}
			else if (poengsum2 > vinnersum) {
				System.out.println("Vinneren er spiller 2");
				fortsett = false;
			}
			else if (poengsum1 > vinnersum && poengsum2 > vinnersum) {
				System.out.println("Uavgjort");
				fortsett = false;
			}
		}
	}
}