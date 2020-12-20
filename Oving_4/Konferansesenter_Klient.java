import static javax.swing.JOptionPane.*;
import java.util.*;

class Konferansesenter_Klient {yiuyuigujktyuuiyjhghjghjghjghjglugkghjlghkjøuioyøioæpuyiuåyioypygpiypuiguiptoyuty89yuiyutouiypuitpuiuiptiuhøuiuiyipyuihøiopiu
	public static void main(String[] args) {
		Konferansesenter konferansesenteret = new Konferansesenter();
		String[] muligheter = {"Registrer nytt rom", "Reserver et rom", "Finn romnr med indeks", "Finn indeks med romnr", "Skriv ut all informasjon", "Avsutt"};
		int valg=0;

		while (valg!=5){
			valg = showOptionDialog(null, "Hva vil du gjøre?", "Konferansesenter", 0, PLAIN_MESSAGE, null, muligheter, muligheter[0]);
			switch(valg) {
				case 0:
					int romnummer = Integer.parseInt(showInputDialog(null, "Romnummer: "));
					int størrelse = Integer.parseInt(showInputDialog(null, "Antall personer det er plass til i rommet: "));
					if (konferansesenteret.regNyttRom(romnummer,størrelse)) {
						showMessageDialog(null, "Rommet ble registrert.");
					}
					else {
						showMessageDialog(null, "Rommet ble ikke registrert, må ha unikt romnummer.");
					}
					break;

				case 1:
					if (konferansesenteret.getAntallRom()==0){
						showMessageDialog(null, "Det er ingen rom registrert");
						break;
					}
					long fra = Long.parseLong(showInputDialog("Fra tidspunktet(ååååmmddtttt): ", "20180121tttt"), 10);
					long til = Long.parseLong(showInputDialog("Til tidspunktet(ååååmmddtttt): ", "20180121tttt"), 10);
					int antall = Integer.parseInt(showInputDialog("Antall personer: "));
					String navnet = showInputDialog("Navn: ");
					String tlfnummeret = showInputDialog("Telefonnummer: ");
					if (konferansesenteret.reserverRom(new Tidspunkt(fra), new Tidspunkt(til), antall, navnet, tlfnummeret)){
						showMessageDialog(null, "Du har reservert et rom.");
					}
					else {
						showMessageDialog(null, "Det er ingen ledige rom.");
					}
					break;
				case 2:
					int indeksen = Integer.parseInt(showInputDialog(null, "Skriv inn indeks."));
					if (konferansesenteret.finnRomnr(indeksen)<0){
						System.out.println("Fant ikke rom med denne indeksen.");
					}
					else {
						System.out.println(konferansesenteret.finnRomnr(indeksen));
					}
					break;

				case 3:
					int romnummeret = Integer.parseInt(showInputDialog(null, "Skriv inn romnummer."));
					if (konferansesenteret.finnRomindeks(romnummeret)<0){
						System.out.println("Fant ikke indeks for dette romnummeret.");
					}
					else{
						System.out.println(konferansesenteret.finnRomindeks(romnummeret));
					}
					break;

				case 4:
					//Antall rom
					int antallRom=konferansesenteret.getAntallRom();
					System.out.println("Antall rom: " + antallRom + "\n");
					//Romnummer som er registrert, samt romplass og om det er reservert
					ArrayList<String> registrerteRomnr = new ArrayList<String>();
					String reservasjonsinfoen= "";
					for (int i=0; i<antallRom; i++) {
						reservasjonsinfoen= "";
						if (konferansesenteret.getRommene().get(i).getAntallReservasjoner()!=0){
							reservasjonsinfoen+=" Reservert for: " + Arrays.toString(konferansesenteret.getRommene().get(i).reservasjonsInfo()) + "\n";
						}
						else if (reservasjonsinfoen.equals(""))reservasjonsinfoen="Rommet er ledig.";
						registrerteRomnr.add("Rom nummer " + konferansesenteret.finnRomnr(i) + ", plass til " + konferansesenteret.getPlass(i) + " personer." + reservasjonsinfoen);
					}
					if(registrerteRomnr.isEmpty()) {
						System.out.println("Det er ingen registrerte rom.");
					}
					else {
						for (int i=0; i<registrerteRomnr.size(); i++) {
							System.out.println(registrerteRomnr.get(i));
						}
					}
					break;
			}
		}
	}
}