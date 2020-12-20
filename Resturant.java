import java.util.*;
class Resturant {
		public String navn;
		public int etbAar;

		public Resturant(String navn, int etbAar) {
			this.navn=navn;
			this.etbAar=etbAar;
		}

		public String getNavn () {
			return navn;
		}

		public void setNavn (String nyttNavn) {
			navn=nyttNavn;
		}

		public int getEtbAar () {
			return etbAar;
		}

		public int hvorGammel () {
			int aar = Calendar.getInstance().get(Calendar.YEAR);
			return aar-etbAar;
		}
}