public class Kalkis{

    public double pluss(double x, double y){
        return x + y;
    }
    public double minus(double x, double y){
        return x - y;
    }
    public double gange(double x, double y){
        return x * y;
    }
    public double divisjon(double x, double y){
        double svar = 0;
        try{
            svar = x / y;
        }catch(Exception e){
              System.out.println("e: " + e);
        }
        return svar;
    }

    public  double div(int x, int y){
		return x/y;
	}
}