public class Triangulo {

    private Punto pt1, pt2, pt3;
    private Lado ladoA, ladoB, ladoC;
    private double area, perimetro;

    public Triangulo(Punto pt1, Punto pt2, Punto pt3) {
        this.pt1 = pt1;
        this.pt2 = pt2;
        this.pt3 = pt3;
        calcularLados();
        this.area = calcularArea(pt1, pt2, pt3);
        calcularPerimetro();
    }

    private void calcularPerimetro() {
        perimetro = ladoA.getLongitud() + ladoB.getLongitud() + ladoC.getLongitud();
    }

    private double calcularArea(Punto pt1, Punto pt2, Punto pt3) {
        return 0.5 * (Math.abs(
                (pt1.getX() * (pt2.getY() - pt3.getY())) +
                (pt2.getX() * (pt3.getY() - pt1.getY())) +
                (pt3.getX() * (pt1.getY() - pt2.getY()))
                              )
                     );
    }

    public Triangulo() {
        this.pt1 = new Punto();
        this.pt2 = new Punto();
        this.pt3 = new Punto();
    }

    public Punto getPt1() {
        return pt1;
    }

    public void setPt1(Punto pt1) {
        this.pt1 = pt1;
    }

    public Punto getPt2() {
        return pt2;
    }

    public void setPt2(Punto pt2) {
        this.pt2 = pt2;
    }

    public Punto getPt3() {
        return pt3;
    }

    public void setPt3(Punto pt3) {
        this.pt3 = pt3;
    }

    public void calcularLados() {
        this.ladoA = new Lado(pt1, pt2);
        this.ladoB = new Lado(pt2, pt3);
        this.ladoC = new Lado(pt3, pt1);

    }

    @Override
    public String toString() {
        return "Triangulo{" +
                "vert1=" + pt1 +
                ", vert2=" + pt2 +
                ", vert3=" + pt3 +
                ", ladoA=" + ladoA +
                ", ladoB=" + ladoB +
                ", ladoC=" + ladoC +
                ", area=" + area +
                ", perimetro=" + perimetro +
                '}';
    }
}


