import java.util.*;
import static javax.swing.JOptionPane.*;

class Resturant {
	public String resNavn;
	public int etbAar;
	Bord bord = new Bord();

	public Resturant(String resNavn, int etbAar) {
		this.resNavn=resNavn;
		this.etbAar=etbAar;
	}

	public String getNavn () {
		return resNavn;
	}

	public void setNavn (String nyttNavn) {
		resNavn=nyttNavn;
	}

	public int getEtbAar () {
		return etbAar;
	}

	public int hvorGammel () {
		int aar = Calendar.getInstance().get(Calendar.YEAR);
		return aar-etbAar;
	}

	public int getAntLedige () {
		return bord.getLedige();
	}

	public boolean reserver (String navnet, int antallet) {
		return bord.resBord(navnet, antallet);
	}

	public int[] finnBordnr (String navnet) {
		return bord.finnBordNr(navnet);
	}

	public boolean frigi (int[] bordene) {
		return bord.frigivelse(bordene);
	}
}

//-----------------------------------------------------------------------------------------------------------------------------------------------------

class Bord {
	String[] navn = new String[10];

	public int getLedige (){
		int ledige=0;
		for (int i=0; i<navn.length; i++) {
			if (navn[i]==null) ledige++;
		}
		return ledige;
	}

	public int getOpptatte (){
			int opptatte=0;
			for (int i=0; i<navn.length; i++) {
				if (navn[i]!=null) opptatte++;
			}
			return opptatte;
	}

	public boolean resBord (String navnet, int antall) {
		int teller=0;
		if (getLedige()<antall) {
			return false;
		}
		else {
			for (int i=0; i<navn.length; i++) {
				if (navn[i]==null && teller < antall) {
					navn[i]=navnet;
					teller++;
				}
			}
			return true;
		}
	}

	public int[] finnBordNr (String navnet) {
		int teller = 0;
		for (int i=0; i< navn.length; i++) {
			if (navn[i]!=null) {
				if (navnet.compareTo(navn[i])==0) {
					teller++;
				}
			}
		}
		int[] nummerene=new int[teller];
		int teller2=0;
		for (int i=0; i< navn.length; i++) {
			if (navn[i]!=null) {
				if (navnet.compareTo(navn[i])==0) {
					nummerene[teller2]=i;
					teller2++;
				}
			}
		}
		return nummerene;
	}

	public boolean frigivelse(int[] bordene) {
		if (bordene.length>navn.length) {
			return false;
		}
		/*for (int i=0; i<navn.length; i++) {
			for (int h=0; h<bordene.length; h++) {
				navn[h]=null;
			}
		}
		*/
		for (int i=0; i<bordene.length; i++) {
			int indeks = bordene[i];
			navn[indeks]=null;
		}
		return true;
	}
}

class ResturantTest {
	public static void main (String[] args) {
		Resturant resturant = new Resturant("Resturant", 1980);
		//KLIENT
		int valg;
		do {
			valg = Integer.parseInt(showInputDialog(null, "Hva vil du gjøre? \n 1. Reserver bord \n 2. Finn bord som er reservert på et navn \n 3. Frigi bord \n 4. Avslutt"));
			switch (valg) {
			    case 1: // reservere et antall bord på et bestemt navn
		            //....les inn navn og antall bord, og kall metode...
		            int ledigeBordNaa = resturant.getAntLedige();
					String navn=showInputDialog(null, "Navn: ");
					int antallB=Integer.parseInt(showInputDialog(null, "Antall bord ("+ledigeBordNaa + " ledige bord nå): "));
					resturant.reserver(navn, antallB);
					break;
		        case 2:  // finne alle bordene som er reservert på et bestemt navn
		            //...les inn navn, og kall metode...
		            String navnet=showInputDialog(null, "Navn: ");
		            int[] nummer = resturant.finnBordnr(navnet);
		            String melding = navnet + " har bordene: ";
		            if (nummer.length==0) {
						melding+= "Ingen";
					}
		            else {
						for (int i=0; i<nummer.length; i++){
							melding+= nummer[i] + " ";
						}
					}
		            showMessageDialog(null, melding);
		            break;
		        case 3:  // frigi en rekke bord, bordnummer er gitt
		            //....les inn aktuelle bordnummer og kall metode...
		            int frigi = Integer.parseInt(showInputDialog(null, "Hvor mange bord skal frigis?"));
		            int[] bord = new int[frigi];
		            int bordnummer;
		            for (int i=0; i<frigi; i++) {
						bordnummer = Integer.parseInt(showInputDialog(null, "Bord nr: "));
						bord[i]=bordnummer;
					}
					resturant.frigi(bord);
		            break;
		        case 4: //Avslutt

			}
		} while (valg !=4);

		//TEST 2
		//Endre resturantnavn
		System.out.println("Navn før endring: " + resturant.getNavn());
		resturant.setNavn("NyResturant");
		System.out.println("Navn etter endring: " + resturant.getNavn());
		System.out.println("Resturantens alder: " + resturant.hvorGammel());

		/*TEST 1
		Resturant test = new Resturant("Resturant", 1990);
		int alder =test.hvorGammel();
		int ledige = test.getAntLedige();
		System.out.println(alder);
		System.out.println(ledige);
		boolean reserver1 = test.reserver("Pål", 3);
		boolean reserver = test.reserver("Per", 5);
		System.out.print(reserver + "\n" );
		ledige = test.getAntLedige();
		System.out.print(ledige + "\n");
		int[] reserverte=test.finnBordnr("Per");
		System.out.println(Arrays.toString(reserverte));
		int[] frigjor = {0,1,2};
		*/
	}
}
