import static javax.swing.JOptionPane.*;
import java.util.Random;

class Temperaturer {
	//Attributter
	int[][] temperaturer = new int[30][24];
	java.util.Random random = new java.util.Random();

	public double[] middeltemperaturHverDag () {
		for (int i=0; i<30; i++) {
			for (int j=0; j<24; j++) {
				temperaturer[i][j] = random.nextInt(30);
			}
		}

		double samlet=0;
		double[] middeltemperaturer = new double [30];
		for (int i=0; i<30; i++){
			for (int j=0; j<24; j++) {
				samlet+=temperaturer[i][j];
			}
			middeltemperaturer[i]=(samlet)/24;
			samlet=0;
		}
		return middeltemperaturer;
	}
}

class Temperaturinfo {
	public static void main (String[] args) {
		Temperaturer finn = new Temperaturer();
		double[] middeltemperaturene = finn.middeltemperaturHverDag();
		System.out.println(middeltemperaturene);
	}
}
