package clases;

public class Credito {
    private int Hipotecario;
    private int Automotriz;


    public Credito()
    {
      Hipotecario = 1000000;
      Automotriz = 500000;
    }

    public int getHipotecario(){return Hipotecario;}
    public int getAutomotriz(){return Automotriz;}
}
