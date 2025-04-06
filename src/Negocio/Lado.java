package Negocio;

public class Lado {

    private final Punto pto1;
    private final Punto pto2;
    private final double longitud;
    private boolean esBase;

    public Lado(Punto pto1, Punto pto2) {
        this.pto1 = pto1;
        this.pto2 = pto2;
        this.esBase = esLaBase();
        this.longitud = calcularLongitud();
    }

    private boolean esLaBase() {
        return this.pto1.getX() == this.pto2.getX() ||
                this.pto1.getY() == this.pto2.getY();
    }

    public double getLongitud() {
        return longitud;
    }

    public double calcularLongitud() {
        double dx = pto2.getX() - pto1.getX();
        double dy = pto2.getY() - pto1.getY();
        return Math.round(Math.sqrt(dx * dx + dy * dy) * 100.0) / 100.0;
        // Se redondea el valor de la longitud conservando dos numeros decimales
    }

    public boolean getEsBase() {
        return esBase;
    }

    public String getStringEsBase() {
        if (esBase) {
            return "Es la base";
        }
        return "";
    }

    public void setEsBase(boolean esBase) {
        this.esBase = esBase;
    }

}
