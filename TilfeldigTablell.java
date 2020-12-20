import static javax.swing.JOptionPane.*;
import java.util.Random;

class FinneTall {
	java.util.Random random = new java.util.Random();
	public int siffer;

	public int getTall () {
		siffer = random.nextInt(10);
		return(siffer);
	}
}

class TilfeldigTabell {
	public static void main (String[] args) {
		int[] antall = new int[10];
		FinneTall tall = new FinneTall();
		int nyttTall = 0;
		for (int i=0; i<1000; i++) {
			nyttTall = tall.getTall();
			antall[nyttTall]+=1;
		}
		String utskrift = " 0: " + antall[0] + "\n 1: " + antall[1] + " \n 2: " + antall[2] + "\n 3: " + antall[3] + "\n 4: " + antall[4] + "\n 5: " + antall[5] + "\n 6: " + antall [6] + "\n 7: " + antall[7] + "\n 8: " + antall[8] + "\n 9: " + antall[9];
		System.out.println(utskrift);
	}
}