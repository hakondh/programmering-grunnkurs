import static javax.swing.JOptionPane.*;

class Student{
	private final String navn;
	private int antOppg;

	Student(String navn) {
		this.navn=navn;
	}

	public String getNavn() {
		return navn;
	}

	public int getAntOppg() {
		return antOppg;
	}

	public void setAntOppg(int antOppg){
		if (antOppg<0) {
			throw new IllegalArgumentException();
		}
		else {
			this.antOppg=antOppg;
		}
	}

	public String toString() {
		return "Navn: " + navn + ", antall oppgaver: " + antOppg;
	}
}

//------------------------------------------------------------------------------------------------------------------------------------------------------

class OppgaveOversikt {
	private Student[] studenter = new Student[5];
	private int antStud=0;

	public boolean	regNyStudent (String navn) {

		for (int i=0; i < studenter.length; i++) {
			if (studenter[i]!=null) {
				if (studenter[i].getNavn().compareTo(navn)==0){
					 return false;
				}
			}
		}

		if (antStud<studenter.length) {
			studenter[antStud]= new Student(navn);
			antStud++;
			return true;
		}
		else {
			Student[] nyTab = new Student[studenter.length + 5];
			for (int i=0; i < antStud; i++) {
				nyTab[i]=studenter[i];
			}
			studenter = nyTab;
			studenter[antStud]= new Student(navn);
			antStud++;
			return true;
		}
	}

	public int finnAntStud (){
		return antStud;
	}

	public int finnAntOppgaver (String navn){
		for (int i=0; i < studenter.length; i++) {
			if (studenter[i].getNavn().compareTo(navn)==0) {
				return studenter[i].getAntOppg();
			}
		}
		return -1;
	}

	public boolean �kAntOppg (String navn, int �kning) {
		for (int i=0; i < studenter.length; i++) {
			if (studenter[i].getNavn().compareTo(navn)==0) {
				int antOppgN�=studenter[i].getAntOppg();
				studenter[i].setAntOppg(antOppgN�+�kning);
				return true;
			}
		}
		return false;
	}

	public String[] finnAlleNavn () {
		String[] alleNavn = new String[studenter.length];
		for (int i=0; i < studenter.length; i++) {
			if (studenter[i]==null) continue;
			alleNavn[i] = studenter[i].getNavn();
		}
		return alleNavn;
	}

	public String toString () {
		String studentinfo = "";
		for (int i=0; i < studenter.length; i++) {
			if (studenter[i]==null) continue;
			studentinfo+="Navn: " + studenter[i].getNavn() + ", antall oppgaver l�st: " + studenter[i].getAntOppg() + "\n";
		}
		return "Antall studenter: " + antStud + ".\nStudentene: \n" + studentinfo;
	}
}
/**
 *
 * Program som kan brukes til � pr�ve ut metodene laget i �vingen.
 *
 * Om det er vanskelig � lese, kan det kanskje v�re p� sin plass � repetere litt:
 *
 * Brukergrensesnittet er lagt til en egen klasse, se kapittel 6.4, side 193.
 * For �vrig er et menystyrt program vist i kapittel 9.6, side 304.
 */

class GodkjenningBGS {
  public final String NY_STUDENT = "Ny student";
  public final String AVSLUTT = "Avslutt";
  private String[] muligeValg = {NY_STUDENT, AVSLUTT};  // f�rste gang, ingen studenter registrert

  private OppgaveOversikt oversikt;
  public GodkjenningBGS(OppgaveOversikt oversikt) {
    this.oversikt = oversikt;
  }

  /**
   *
   * Metoden leser inn valget som en streng, og returnerer den.
   * Valget skal v�re argument til metoden utf�rValgtOppgave().
   * Hvis programmet skal avsluttes, returneres null.
   */
  public String lesValg() {
    int antStud = oversikt.finnAntStud();
    String valg = (String) showInputDialog(null, "Velg fra listen, " + antStud + " studenter:",  "Godkjente oppgaver",
             DEFAULT_OPTION, null, muligeValg, muligeValg[0]);
    if (AVSLUTT.equals(valg)) {
      valg = null;
    }
    return valg;
  }

  /**
   *
   * Metode som s�rger for at �nsket valg blir utf�rt.
   */
  public void utf�rValgtOppgave(String valg) {
    if (valg != null && !valg.equals(AVSLUTT)) {
      if (valg.equals(NY_STUDENT)) {
        registrerNyStudent();
      } else {
        registrerOppgaver(valg);  // valg er navnet til studenten
      }
    }
  }

  /**
   *
   * Metoden registrere ny student.
   * Hvis student med dette navnet allerede eksisterer, skjer ingen registrering.
   * Resultatet av operasjonen skrives ut til brukeren.
   */
  private void registrerNyStudent() {
    String navnNyStud = null;
    do {
      navnNyStud = showInputDialog("Oppgi navn: ");
    } while (navnNyStud == null);

    navnNyStud = navnNyStud.trim();
    if (oversikt.regNyStudent(navnNyStud)) {
      showMessageDialog(null, navnNyStud + " er registrert.");
      String[] alleNavn = oversikt.finnAlleNavn();
      String[] nyMuligeValg = new String[alleNavn.length + 2];
      for (int i = 0; i < alleNavn.length; i++) {
        nyMuligeValg[i] = alleNavn[i];
      }
      nyMuligeValg[alleNavn.length] = NY_STUDENT;
      nyMuligeValg[alleNavn.length + 1] = AVSLUTT;
      muligeValg = nyMuligeValg;
      } else  {
        showMessageDialog(null, navnNyStud + " er allerede registrert.");
      }
    }

    /**
     *
     * Metoden registrerer oppgaver for en navngitt student.
     * Brukerinput kontrolleres ved at det m� kunne tolkes som et tall.
     * Registreringsmetoden (i klassen Student) kan kaste unntaksobjekt IllegalArgumentException.
     * Dette fanges ogs� opp. I begge tilfeller m� brukeren gjenta inntasting inntil ok data.
     * Endelig skrives det ut en melding om antall oppgaver studenten n� har registrert.
     */
    private void registrerOppgaver(String studNavn) {
      String melding = "Oppgi antall nye oppgaver som skal godkjennes for " + studNavn +": ";
      int antOppg�kning = 0;
      boolean registrert = false;
      do { // gjentar inntil registrering aksepteres av objektet oversikt
        try {
          antOppg�kning = lesHeltall(melding);
          oversikt.�kAntOppg(studNavn, antOppg�kning);  // kan ikke returnere false, pga navn alltid gyldig
          registrert = true; // kommer hit bare dersom exception ikke blir kastet
        } catch (IllegalArgumentException e) {  // kommer hit hvis studenter f�r negativt antall oppgaver
          melding = "Du skrev " + antOppg�kning + ". \nIkke godkjent �kning for " + studNavn + ". Pr�v igjen: ";
        }
      } while (!registrert);

      melding = "Totalt antall oppgaver registrert p� " + studNavn + " er " + oversikt.finnAntOppgaver(studNavn) + ".";
      showMessageDialog(null, melding);
    }

    /* Hjelpemetode som g�r i l�kke inntil brukeren skriver et heltall. */
    private int lesHeltall(String melding) {
      int tall = 0;
      boolean ok = false;
      do {  // gjentar inntil brukerinput kan tolkes som tall
        String tallLest = showInputDialog(melding);
        try {
          tall = Integer.parseInt(tallLest);
          ok = true;
        } catch (Exception e) {
          showMessageDialog(null, "Kan ikke tolke det du skrev som tall. Pr�v igjen. ");
        }
      } while (!ok);
      return tall;
    }
  }


  /**
   * Hovedprogrammet. G�r i l�kke og lar brukeren gj�re valg.
   */
  class Oving3 {
    public static void main(String[] args) {

    OppgaveOversikt oversikt = new OppgaveOversikt();
    GodkjenningBGS bgs = new GodkjenningBGS(oversikt);

    String valg = bgs.lesValg();
    while (valg != null) {
      bgs.utf�rValgtOppgave(valg);
      valg = bgs.lesValg();
    }

    /* Pr�ver toString() */
    System.out.println("\nHer kommer informasjon om alle studentene: ");
    System.out.println(oversikt);
  }
}