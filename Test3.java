import static javax.swing.JOptionPane.*;
import java.util.Random;

class Spiller {
	//Attributter
	public int sumPoeng;


	//Konstruktør
	public Spiller(int sumPoeng) {
		this.sumPoeng = sumPoeng;
	}

	//Metoder

	public int kastTerningen () {
		int terningkast = (terning.nextInt(6)) + 1;
	}

	public void erFerdig ();

}

class Terningspill {
	public static void main (String[] args) {

		java.util.Random terning = new java.util.Random();

		int terningkast1 = java.util.Random.kastTerningen();


		System.out.println(terningkast1);

		}
}