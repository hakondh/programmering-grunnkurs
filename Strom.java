import java.io.*;
import static javax.swing.JOptionPane.*;
class Strom {
	public static void main (String[] args) throws IOException{
		String filnavn = "filmer.txt";

		FileReader leseforbTilFil = new FileReader(filnavn);
		BufferedReader leser = new BufferedReader(leseforbTilFil);

		String enFilm = leser.readLine();
		String info = "Disse filmene har vi: ";
		int antallFilmer=0;
		while (enFilm != null) {
			if (antallFilmer==0){
				info+= enFilm;
				antallFilmer++;
				enFilm=leser.readLine();
				continue;
			}
			info+=", " + enFilm;
			antallFilmer++;
			enFilm=leser.readLine();
		}
		leser.close();
		showMessageDialog(null, info + ". Det er totalt " + antallFilmer + " filmer.");

		int svar = showConfirmDialog(null, "Skal filmer legges til?", "Filmregister", YES_NO_OPTION);

		if (svar==YES_OPTION) {
			FileWriter skriveforbTilFil = new FileWriter(filnavn, true);
			PrintWriter skriver = new PrintWriter(new BufferedWriter(skriveforbTilFil));

			while (svar==YES_OPTION) {
				String nyFilm = showInputDialog("Skriv inn filmtittel: ");
				skriver.println("\n" + nyFilm);
				svar = showConfirmDialog(null, "Skal filmer legges til?", "Filmregister", YES_NO_OPTION);
			}
			skriver.close();
		}

	}
}