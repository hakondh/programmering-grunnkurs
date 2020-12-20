import java.io.*;
import java.util.Arrays;
class TribuneTest implements Serializable{
	public static void main (String[] args) throws IOException {
		Staa staa1 = new Staa("Ståtribune 1", 312, 50);
		Staa staa2 = new Staa("Staa2", 346, 100);
		Sitte sitte1 = new Sitte("Sittetribune 1", 20, 300, 2);
		VIP vip1 = new VIP("VIP-tribune 1", 20, 500, 5, 5);

		Tribune[] tribuner = {staa1, staa2, sitte1, vip1};

		//Kjøpe billetter, printer ut
			//Ståtribune 1
		System.out.println("\nKJØPE 2 BILLETTER TIL STÅTRIBUNE 1, PRINTER UT");

		System.out.println("Info om tribunen: ");
		System.out.println(tribuner[0].toString());

		Billett[] staa1Billetter = tribuner[0].kjøpBilletter(2);
		for (int i=0; i<2; i++){
			System.out.println(staa1Billetter[i].toString());
		}

			//Ståtribune 2
		System.out.println("\nKJØPE 2 BILLETTER TIL STÅTRIBUNE 2, PRINTER UT");

		System.out.println("Info om tribunen: ");
		System.out.println(tribuner[1].toString());

		String[] navn = {"Per", "Pål"};
		Billett[] staa2Billetter = tribuner[1].kjøpBilletter(navn);
		for (int i=0; i<2; i++){
			System.out.println(staa2Billetter[i].toString());
		}
			//Sittetribune 1
		System.out.println("\nKJØPE 3 BILLETTER TIL SITTETRIBUNE 1, PRINTER UT");

		System.out.println("Info om tribunen: ");
		System.out.println(tribuner[2].toString());

		Billett[] sitte1Billetter = tribuner[2].kjøpBilletter(6);
		for (int i=0; i<sitte1Billetter.length; i++){
			System.out.println(sitte1Billetter[i].toString());
		}


		Billett[] sitte2Billetter = tribuner[2].kjøpBilletter(5);
		for (int i=0; i<sitte2Billetter.length; i++){
			System.out.println(sitte2Billetter[i].toString());
		}

		Billett[] sitte3Billetter = tribuner[2].kjøpBilletter(2);
		for (int i=0; i<sitte3Billetter.length; i++){
			System.out.println(sitte3Billetter[i].toString());
		}

			//VIP-tribune 1
		System.out.println("\nKJØPE 2 BILLETTER TIL VIP-TRIBUNE 1, PRINTER UT");

		System.out.println("Info om tribunen: ");
		System.out.println(tribuner[3].toString());

		String[] navn2 = {"Espen", "Elias"};
		Billett[] VIP1Billeter = tribuner[3].kjøpBilletter(navn2);
		for (int i=0; i<2; i++){
			System.out.println(VIP1Billeter[i].toString());
		}

		System.out.println("\nOPPDATERT INFO OM TRIBUNENE");
		for (int i=0; i<tribuner.length; i++){
			System.out.println(tribuner[i].toString()+"\n");
		}

		//Sortering
		System.out.println("Sorterer tribunene etter inntekt.");
		for (int i=0; i<tribuner.length; i++){
			int minsteHittil = i;
			for (int k=i+1; k<tribuner.length; k++){
				if ((tribuner[minsteHittil].finnInntekt()) > tribuner[k].finnInntekt()) minsteHittil=k;
			}
			Tribune hjelp = tribuner[minsteHittil];
			tribuner[minsteHittil]=tribuner[i];
			tribuner[i]=hjelp;
		}

		for (int i=0; i<tribuner.length; i++){
			System.out.println(tribuner[i].finnInntekt() + " - " + tribuner[i].getTribunenavn());
		}

	System.out.println("\nLESE/SKRIVE TIL FIL");
	System.out.println("-Skrive\n");
	for (int i=0; i<tribuner.length; i++){
		try {
			if(skrivTilFil(tribuner[i])) System.out.println("Skriving " + i + " vellykket.");
		}
		catch(Exception e){
			System.out.println("ERROR");
		}
	}

	System.out.println("\n-Lese\n");

	for (int i=0; i<tribuner.length; i++){
		try {
			System.out.println(lesFraFil("tribuner.ser"));
		}
		catch (Exception e){
			System.out.print("ERROR");
		}
	}


	//Metode for skriving
	}
	public static boolean skrivTilFil(Tribune t)throws Exception{
		try{
			FileOutputStream utstrøm = new FileOutputStream("tribuner.ser");
			ObjectOutputStream ut = new ObjectOutputStream(utstrøm);
			ut.writeObject(t);
			ut.close();
			return true;
		}
		catch(FileNotFoundException e){
			System.out.println("Finner ikke filen.");
			return false;
		}
		catch(Exception e){
			System.out.println("" + e.toString());
			return false;
		}
	}

	public static Tribune lesFraFil (String filnavn) throws Exception{
		Tribune t;
		try{
			FileInputStream innstrom = new FileInputStream(filnavn);
			ObjectInputStream inn = new ObjectInputStream(innstrom);
			t = (Tribune)inn.readObject();
			inn.close();
		}
		catch(FileNotFoundException e){
			System.out.println("Finner ikke filen.");
			t = null;
		}
		catch(Exception e){
			System.out.println("Filen er tom");
			t = null;
		}
		return t;
	}
}