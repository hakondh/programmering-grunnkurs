import static javax.swing.JOptionPane.*;
import java.util.*;

class Temperaturer {
	//Attributter
	int[][] temperaturer = new int[30][24];
	double[] middeltemperaturer = new double[30];
	java.util.Random random = new java.util.Random();

	public void initialisere () {
		for (int i=0; i<30; i++) {
			for (int j=0; j<24; j++) {
				temperaturer[i][j] = random.nextInt(60) - 30;
			}
		}
	}

	public double[] middeltemperaturHverDag () {
		double samlet=0;
		for (int i=0; i<30; i++){
			for (int j=0; j<24; j++) {
				samlet+=temperaturer[i][j];
			}
			middeltemperaturer[i]=(samlet)/24;
			samlet=0;
		}
		return middeltemperaturer;
	}

	public double[] middeltemperaturHverTime () {
		double[] hverTime = new double[24];
		double samlet=0;
		for (int i=0; i<24; i++){
			for (int j=0; j<30; j++) {
				samlet+=temperaturer[j][i];
			}
			hverTime[i]=(samlet)/30;
			samlet=0;
		}
		return hverTime;
	}

	public double middeltemperatur () {
		double samlet=0;
		for (int i=0; i<30; i++){
			for (int j=0; j<24; j++) {
			samlet+=temperaturer[i][j];
			}
		}
		return ((samlet)/720);
	}

	public String[] statestikk () {
		String[] statestikken = {"Antall døgn mindre enn -5 grader: ", "Antall døgn mellom -5 og 0 grader: ", "Antall døgn mellom 0 og 5 grader: ", "Antall døgn mellom 5 og 10 grader: ", "Antall døgn over 10 grader: "};
		int [] verdier = new int [statestikken.length];
		for (int i=0; i<30; i++){

			if (middeltemperaturer[i]< -5) {
				verdier[0]++;
			}
			else if (middeltemperaturer[i] >= -5 && middeltemperaturer[i] < 0) {
				verdier[1]++;
			}
			else if (middeltemperaturer[i] >= 0 && middeltemperaturer[i] < 5) {
				verdier[2]++;
			}
			else if (middeltemperaturer[i] >= 5 && middeltemperaturer[i] < 10) {
				verdier[3]++;
			}
			else {
				verdier[4]++;
			}
		}
		for (int i=0; i<statestikken.length; i++){
			statestikken[i]+=verdier[i];
		}
		return statestikken;
	}
}

class Temperaturinfo {
	public static void main (String[] args) {
		Temperaturer finn = new Temperaturer();

		finn.initialisere();

		double[] middeltemperaturene = finn.middeltemperaturHverDag();
		System.out.println("Middeltemperaturen for hver enkelt dag: \n");
		System.out.println(Arrays.toString(middeltemperaturene));

		System.out.println();

		double[] hverAvTimene = finn.middeltemperaturHverTime();
		System.out.println("Middeltemperaturen for hver enkel time: \n");
		System.out.println(Arrays.toString(hverAvTimene));

		System.out.println();

		double middeltemperatur = finn.middeltemperatur();
		System.out.println("Middeltemperaturen for måneden er: \n");
		System.out.println(middeltemperatur);

		System.out.println();

		String[] statestikken = finn.statestikk();
		System.out.println(Arrays.toString(statestikken));
	}
}
