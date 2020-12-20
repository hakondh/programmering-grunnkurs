import java.time.*;
import java.time.temporal.ChronoUnit;

abstract class BonusMedlem {
	private final int medlNr;
	private final Personalia pers;
	private final LocalDate innmeldtDato;
	private int poeng=0;

	public BonusMedlem(int medlNr, Personalia pers, LocalDate startTid) {
		this.medlNr=medlNr;
		this.pers=pers;
		this.innmeldtDato = startTid;
	}

	public int getMedlnr(){
		return medlNr;
	}

	public Personalia getPers(){
		return pers;
	}

	public LocalDate getInnmeldtDato(){
		return innmeldtDato;
	}

	public int getPoeng(){
		return poeng;
	}

	public int finnKvalPoeng(LocalDate dato2){
		long dagerMellom = ChronoUnit.DAYS.between(innmeldtDato, dato2);
		if (dagerMellom<365){
			return poeng;
		}
		return 0;
	}

	public boolean okPassord(String passord){
		if (pers.okPassord(passord)){
			return true;
		}
		else{
			return false;
		}
	}

	public void registrerPoeng(int poengene){
		poeng+=poengene;
	}
}