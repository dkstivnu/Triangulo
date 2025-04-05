package Negocio;

public class Lado {

    private final Punto pto1;
    private final Punto pto2;
    private final double longitud;

    public Lado(Punto pto1, Punto pto2) {
        this.pto1 = pto1;
        this.pto2 = pto2;
        this.longitud = calcularLongitud();
    }

    public double getLongitud() {
        return longitud;
    }

    public double calcularLongitud() {
        double dx = pto2.getX() - pto1.getX();
        double dy = pto2.getY() - pto1.getY();
        return Math.round( Math.sqrt(dx*dx+dy*dy) * 100.0 ) /100.0;
        // Se redondea el valor de la longitud conservando dos numeros decimales
    }

}
