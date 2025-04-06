package Negocio;

public class Triangulo {

    private Punto pt1, pt2, pt3;
    private Lado ladoA, ladoB, ladoC;
    private double area, perimetro, base, altura;

    public Triangulo(Punto pt1, Punto pt2, Punto pt3) {
        this.pt1 = pt1;
        this.pt2 = pt2;
        this.pt3 = pt3;
        actualizarTriangulo();

    }

    public Punto getPt1() {
        return pt1;
    }

    public void setPt1(Punto pt1) {
        this.pt1 = pt1;
        actualizarTriangulo();
    }

    public Punto getPt2() {
        return pt2;
    }

    public void setPt2(Punto pt2) {
        this.pt2 = pt2;
        actualizarTriangulo();
    }

    public Punto getPt3() {
        return pt3;
    }

    public void setPt3(Punto pt3) {
        this.pt3 = pt3;
        actualizarTriangulo();
    }

    public double getLadoA() {
        return ladoA.getLongitud();
    }

    public double getLadoB() {
        return ladoB.getLongitud();
    }

    public double getLadoC() {
        return ladoC.getLongitud();
    }

    public double getArea() {
        return area;
    }

    public double getPerimetro() {
        return perimetro;
    }

    public double getBase() {
        return base;
    }

    public void calcularLados() {
        this.ladoA = new Lado(pt1, pt2);
        this.ladoB = new Lado(pt2, pt3);
        this.ladoC = new Lado(pt3, pt1);

    }

    private void actualizarTriangulo() {
        calcularLados();
        calcularArea();
        calcularPerimetro();
        calcularBase();
    }

    private void calcularBase() {

    }

    private Lado calcularLadoMasGrande() {
        Lado ladoMax = ladoA;

        if (ladoB.getLongitud() > ladoMax.getLongitud()) {
            ladoMax = ladoB;
        }

        if (ladoC.getLongitud() > ladoMax.getLongitud()) {
            ladoMax = ladoC;
        }

        return ladoMax;
    }

    private void calcularPerimetro() {
        double periAux = ladoA.getLongitud() + ladoB.getLongitud() + ladoC.getLongitud();
        this.perimetro = Math.round(periAux * 100.0) / 100.0;
    }

    private void calcularArea() {
        double area = 0.5 * (Math.abs(
                (pt1.getX() * (pt2.getY() - pt3.getY())) +
                        (pt2.getX() * (pt3.getY() - pt1.getY())) +
                        (pt3.getX() * (pt1.getY() - pt2.getY()))));

        area = Math.round(area * 100.0) / 100.0;
        this.area = area;
    }

    @Override
    public String toString() {
        return "\n--- TRIANGULO ---" +
                "\n1° " + pt1 +
                "\n2° " + pt2 +
                "\n3° " + pt3 +
                "\nL. lado A: " + getLadoA() + " u" + "  | " + ladoA.getStringEsBase() +
                "\nL. lado B: " + getLadoB() + " u" + "  | " + ladoB.getStringEsBase() +
                "\nL. lado C: " + getLadoC() + " u" + "  | " + ladoC.getStringEsBase() +
                "\n Area: " + area + " u²" +
                "\n Perimetro: " + perimetro + " u" +
                "\n--- TRIANGULO ---";
    }


}


