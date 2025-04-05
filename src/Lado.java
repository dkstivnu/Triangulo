public class Lado {

    private Punto vert1;
    private Punto vert2;
    private double longitud;

    public Lado(Punto vert1, Punto vert2) {
        this.vert1 = vert1;
        this.vert2 = vert2;
        this.longitud = calcularLongitud();
    }

    public Lado() {
        this.vert1 = new Punto();
        this.vert2 = new Punto();
    }

    public Punto getVert1() {
        return vert1;
    }

    public void setVert1(Punto vert1) {
        this.vert1 = vert1;
    }

    public Punto getVert2() {
        return vert2;
    }

    public void setVert2(Punto vert2) {
        this.vert2 = vert2;
    }

    public double getLongitud() {
        return longitud;
    }

    public double calcularLongitud() {

        double dx = vert2.getX() - vert1.getX();
        double dy = vert2.getY() - vert1.getY();
        return (double) Math.round(Math.sqrt(dx * dx + dy * dy) * 100.0) /100.0;
        // Se redondea el valor de la longitud conservando dos numeros decimales

    }

    @Override
    public String toString() {
        return "Lado{" + "vert1=" + vert1 + ", vert2=" + vert2 + ", longitud=" + longitud + '}';
    }
}
