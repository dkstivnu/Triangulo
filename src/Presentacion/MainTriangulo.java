package Presentacion;

import Negocio.Punto;
import Negocio.Triangulo;

import java.util.Scanner;

public class MainTriangulo {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Punto pto1 = new Punto(0, 0),
                pto2 = new Punto(0, 0),
                pto3 = new Punto(0, 0);
        Triangulo t = new Triangulo(pto1, pto2, pto3);
        boolean puntosInvalidos = true;

        int opcion;

        do {
            imprimirMenu();

            System.out.println("Introduzca una opcion: ");
            opcion = sc.nextInt();

            switch (opcion) {
                case 1:
                    do {
                        System.out.println("Ingrese las coordenadas del primer punto");
                        pto1 = new Punto(obtenerX(sc), obtenerY(sc));

                        System.out.println("Ingrese las coordenadas del segundo punto");
                        pto2 = new Punto(obtenerX(sc), obtenerY(sc));

                        System.out.println("Ingrese las coordenadas del tercer punto");
                        pto3 = new Punto(obtenerX(sc), obtenerY(sc));

                        if (validarPuntos(pto1, pto2, pto3)) {
                            puntosInvalidos = false;
                            t = new Triangulo(pto1, pto2, pto3);
                        } else {
                            puntosInvalidos = true;
                            System.out.println("Los tres puntos no forman un triangulo , ingresalos nuevamente.");
                        }
                    } while (puntosInvalidos);
                    break;
                case 2: {
                    if (puntosInvalidos) {
                        System.out.println("Debes ingresar los puntos de un triangulo para designar la base.");
                    } else {

                        int opcionMenu;

                        do {
                            imprimirMenuBase(t);
                            opcionMenu = sc.nextInt();

                            switch (opcionMenu) {
                                case 1: {
                                    t.getLadoA().setEsBase(true);
                                    t.getLadoB().setEsBase(false);
                                    t.getLadoC().setEsBase(false);

                                    t.setBase(t.getLadoA().getLongitud());
                                    t.calcAltura();
                                    opcionMenu = 0;

                                }
                                break;
                                case 2:
                                    t.getLadoB().setEsBase(true);
                                    t.getLadoA().setEsBase(false);
                                    t.getLadoC().setEsBase(false);

                                    t.setBase(t.getLadoB().getLongitud());
                                    t.calcAltura();
                                    opcionMenu = 0;
                                    break;
                                case 3:
                                    t.getLadoC().setEsBase(true);
                                    t.getLadoB().setEsBase(false);
                                    t.getLadoA().setEsBase(false);

                                    t.setBase(t.getLadoC().getLongitud());
                                    t.calcAltura();
                                    opcionMenu = 0;
                                    break;
                                default:
                                    System.out.println("Opcion no valida");
                                    break;
                            }
                        } while (opcionMenu != 0);
                    }
                }
                break;
                case 3: {
                    if (puntosInvalidos) {
                        System.out.println("Debes ingresar los puntos de un triangulo para imprimir su info.");
                    } else {

                        System.out.println(t);
                    }
                }
                break;
                case 4:
                    if (puntosInvalidos) {
                        System.out.println("Debes ingresar los puntos para poder modificarlos.");
                    } else {
                        int opcionMenu;
                        do {
                            imprimirMenuPunto(t);
                            opcionMenu = sc.nextInt();

                            switch (opcionMenu) {
                                case 1: {
                                    System.out.println("Ingrese las coordenadas del primer punto");
                                    Punto nuevoPunto = new Punto(obtenerX(sc), obtenerY(sc));

                                    // Validamos que el nuevo conjunto de puntos forme un triángulo
                                    if (validarPuntos(nuevoPunto, t.getPt2(), t.getPt3())) {
                                        t.setPt1(nuevoPunto);
                                        opcionMenu = 0;
                                    } else {
                                        System.out.println("Los puntos no forman un triángulo válido. Se mantendrá el punto original.");
                                    }
                                }
                                break;
                                case 2: {
                                    System.out.println("Ingrese las coordenadas del primer punto");
                                    Punto nuevoPunto = new Punto(obtenerX(sc), obtenerY(sc));

                                    // Validar que el nuevo conjunto de puntos forme un triángulo
                                    if (validarPuntos(t.getPt1(), nuevoPunto, t.getPt3())) {
                                        t.setPt2(nuevoPunto);
                                        opcionMenu = 0;
                                    } else {
                                        System.out.println("Los puntos no forman un triángulo válido. Se mantendrá el punto original.");
                                    }
                                }
                                break;
                                case 3: {
                                    System.out.println("Ingrese las coordenadas del primer punto");
                                    Punto nuevoPunto = new Punto(obtenerX(sc), obtenerY(sc));

                                    // Validar que el nuevo conjunto de puntos forme un triángulo
                                    if (validarPuntos(t.getPt1(), t.getPt2(), nuevoPunto)) {
                                        t.setPt3(nuevoPunto);
                                        opcionMenu = 0;
                                    } else {
                                        System.out.println("Los puntos no forman un triángulo válido. Se mantendrá el punto original.");
                                    }
                                }
                                break;
                                default:
                                    System.out.println("Opcion no valida");
                                    break;
                            }


                        } while (opcionMenu != 0);
                    }
                    break;
                default: {
                    System.out.println("Opcion no valida");
                }
            }
        } while (opcion != 5);
    }

    private static void imprimirMenuPunto(Triangulo t) {
        System.out.println("------ ELIGE UN PUNTO ------");
        System.out.println("1. " + t.getPt1().toString());
        System.out.println("2. " + t.getPt2().toString());
        System.out.println("3. " + t.getPt3().toString());
        System.out.println("0. Salir");
    }

    private static void imprimirMenuBase(Triangulo t) {
        System.out.println("------ ELIGE UNA BASE ------");
        System.out.println("1. Lado A :" + t.getLadoA().toString());
        System.out.println("2. Lado B :" + t.getLadoB().toString());
        System.out.println("3. Lado C :" + t.getLadoC().toString());
        System.out.println("0. Salir");
    }

    private static boolean validarPuntos(Punto pto1, Punto pto2, Punto pto3) {
        // Comprobamos que los puntos no sean colineales entre ellos
        // también comprobamos que los puntos no sean iguales entre sí.
        if ((pto1.getX() == pto2.getX() && pto1.getY() == pto2.getY()) ||
                (pto2.getX() == pto3.getX() && pto2.getY() == pto3.getY()) ||
                (pto3.getX() == pto1.getX() && pto3.getY() == pto1.getY())) {
            return false;
        } else {
            // Nos preparamos para calcular las pendientes de los segmentos del triángulo
            int dx1 = pto2.getX() - pto1.getX();
            int dy1 = pto2.getY() - pto1.getY();

            int dx2 = pto3.getX() - pto2.getX();
            int dy2 = pto3.getY() - pto2.getY();

            //Si las pendientes de los dos segmentos son equivalentes

            //Si son equivalentes son colineales, entonces no forman un triangulo
            //Sino son equivalentes las pendientes significa que forman un triangulo
            return (dx1 * dy2 - dy1 * dx2) != 0;
        }
    }

    private static int obtenerY(Scanner sc) {
        System.out.print("y: ");
        return sc.nextInt();
    }

    private static int obtenerX(Scanner sc) {
        System.out.print("x: ");
        return sc.nextInt();
    }

    public static void imprimirMenu() {
        System.out.println("----- MENU -----");
        System.out.println("1. Ingresar los puntos de un triangulo");
        System.out.println("2. Elige la base del triangulo");
        System.out.println("3. Info. del triangulo");
        System.out.println("4. Modifica un punto del triangulo");
        System.out.println("5. Salir");
        System.out.println("----- MENU -----");
    }

}
