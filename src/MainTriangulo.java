
public class MainTriangulo {

    public static void main(String[] args) {
        Punto vert1 = new Punto(-3,2);
        Punto vert2 = new Punto(-5,-1);
        Punto vert3 = new Punto(2, -1);
        Triangulo t = new Triangulo(vert1,vert2,vert3);
        Lado lado1 = new Lado(vert3,vert1);
        lado1.calcularLongitud();

        System.out.println(t);

        System.out.println(lado1);
    }
}
