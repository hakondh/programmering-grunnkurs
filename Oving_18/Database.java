import java.sql.*;

public class Database {
    private Connection forbindelse;

    public Database(String dbDriver, String dbNavn) throws Exception{
        try{
            Class.forName(dbDriver);
            forbindelse = DriverManager.getConnection(dbNavn);
        }
        catch(Exception e) {
            System.out.println("Klarte ikke å opprette forbindelse i klassen Database. Feilmelding: " + e);
        }
    }

    public void lukkForbindelse(){
        try{
            if (forbindelse != null){
                forbindelse.close();
            }
        }
        catch(SQLException e){
            System.out.println("Klarte ikke å lukke forbindelse. Feilmelding:" + e);
        }
    }

    private void lukkSetning(Statement stm){
        try {
            if (stm != null) {
                stm.close();
            }
        } catch (SQLException e) {
            System.out.println("Klarte ikke å lukke setning. Feilmelding: " + e);
        }
    }

    public boolean regNyBok(Bok nyBok){
        Statement setning = null;
        String nyBoktittel = "insert into boktittel(isbn, forfatter, tittel) values('" + nyBok.getIsbn() + "','" +            nyBok.getForfatter() + "' ,'"+ nyBok.getTittel() +  "')";
        String nyttEksemplar = "insert into eksemplar(isbn, eks_nr) values ('" + nyBok.getIsbn() + "', 1)";

        try{
            setning = forbindelse.createStatement();
            setning.executeUpdate(nyBoktittel);
            System.out.println(nyBoktittel);

            setning.executeUpdate(nyttEksemplar);
            System.out.println(nyttEksemplar);

            return true;
        }
        catch(SQLException e){
            System.out.println("Klarte ikke å registrere en ny bok i klassen Database. Feilmelding: " + e);
            return false;
        }
        finally{
            lukkSetning(setning);
        }
    }

    public int regnytteksemplar(String isbn){
        Statement setning = null;
        ResultSet res;

        try {
            setning = forbindelse.createStatement();
            res = setning.executeQuery("SELECT isbn as funnetISBN FROM eksemplar WHERE isbn='" + isbn + "'");
            res.next();
            if ((res.getString("funnetISBN")).equals(isbn)){
                res = setning.executeQuery("SELECT MAX(eks_nr) AS maks FROM eksemplar WHERE isbn='" + isbn +"'");
                res.next();
                int eksemplarnummer = res.getInt("maks")+1;
                String nyttEksemplar = "insert into eksemplar(isbn, eks_nr) values('" + isbn + "', " +                                (eksemplarnummer) + ")";
                return eksemplarnummer;
            }
            return 0;
        }
        catch(Exception e){
            System.out.println("Klarte ikke å registrere nytt eksemplar. Feilmelding: " + e);
            return -1;
        }
        finally{
            lukkSetning(setning);
        }
    }

    /*public boolean lånuteksemplar(string isbn, string navn, int eksnr){

    }*/
}
