public class Testklient {
    public static void main(String[] args) throws Exception {
        String dbDriver = "com.mysql.jdbc.Driver";
        String dbNavn = "jdbc:mysql://mysql.stud.iie.ntnu.no:3306/haakodh?user=haakodh&password=UnaR4W4T";
        Bok bok1 = new Bok("132", "Hallo", "Espen");

        try{
            Database db = new Database(dbDriver, dbNavn);

            if (db.regNyBok(bok1)){
                System.out.println("Suksess.");
            }
            else {
                System.out.println("Klarte ikke registrere ny bok.");
            }

            int eksRegResultat = db.regnytteksemplar("131");

            if(eksRegResultat==2 && eksRegResultat != 0){
                System.out.println("Suksess. Eksemplarnummer: " + eksRegResultat);
            }
            else {
                System.out.println("Shiet. Eksmemplarnummer: " + eksRegResultat);
            }
        }
        catch(Exception e){
            System.out.print("Klarte ikke å registrere en ny bok. Feilmelding: " + e);
        }
    }
}
