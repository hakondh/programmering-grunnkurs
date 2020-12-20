import java.io.*;
import static javax.swing.JOptionPane.*;
class MineData {
	public static void main (String[] args) throws IOException {
		String filnavn = "minedata.txt";
		FileReader leseforbTilFil = new FileReader(filnavn);
		BufferedReader leser = new BufferedReader(leseforbTilFil);

		FileWriter skriveforbTilFil = new FileWriter(filnavn, true);
		PrintWriter skriver = new PrintWriter(new BufferedWriter(skriveforbTilFil));


		int teller = 0;
		String tekstlinje = leser.readLine();
		while (tekstlinje != null) {
		teller++;
		skriver.println(tekstlinje.toUpperCase());
		tekstlinje = leser.readLine();
		}
		leser.close();
		skriver.close();
		System.out.println("Antallet linjer: " + teller);
	}
}