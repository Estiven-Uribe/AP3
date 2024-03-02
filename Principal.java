import javax.swing.*;
import java.util.ArrayList;

public class Principal {

    private ArrayList<Polinomio> polinomios;

    public Principal() {
        polinomios = new ArrayList<>();
        polinomios.add(new Polinomio("2x^2 + 3x + 5"));
        polinomios.add(new Polinomio("x^3 - 4x^2 + 6"));
    }

    public void mostrarMenu() {
        int opcion;
        do {
            opcion = Integer.parseInt(JOptionPane.showInputDialog(
                    "Menu:\n" +
                            "1. Ingreso de polinomio\n" +
                            "2. Modificar polinomio\n" +
                            "3. Eliminar un polinomio\n" +
                            "4. Mostrar polinomios\n" +
                            "5. Ingresar a forma 1\n" +
                            "6. Ingresar a forma 2\n" +
                            "7. Ingresar a forma 3\n" +
                            "8. Salir\n" +
                            "Ingrese una opción:"));

            switch (opcion) {
                case 1:
                    ingresarPolinomio();
                    break;
                case 2:
                    modificarPolinomio();
                    break;
                case 3:
                    eliminarPolinomio();
                    break;
                case 4:
                    mostrarPolinomios();
                    break;
                case 5:
                    ingresarForma(1);
                    break;
                case 6:
                    ingresarForma(2);
                    break;
                case 7:
                    ingresarForma(3);
                    break;
                case 8:
                    JOptionPane.showMessageDialog(null, "Saliendo del programa...");
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opción inválida");
            }
        } while (opcion != 8);
    }

    private void ingresarPolinomio() {
        String polinomio;
        do {
            polinomio = JOptionPane.showInputDialog("Ingrese el polinomio:");
        } while (!Validaciones.validarPolinomio(polinomio));

        polinomios.add(new Polinomio(polinomio));
    }

    private void modificarPolinomio() {
        if (polinomios.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No hay polinomios para modificar");
            return;
        }

        int indice = seleccionarPolinomio("Seleccione el polinomio a modificar:");

        String nuevaExpresion = JOptionPane.showInputDialog("Ingrese la nueva expresión para el polinomio:");
        polinomios.get(indice).setExpresion(nuevaExpresion);
    }

    private void eliminarPolinomio() {
        if (polinomios.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No hay polinomios para eliminar");
            return;
        }

        int indice = seleccionarPolinomio("Seleccione el polinomio a eliminar:");

        polinomios.remove(indice);
    }

    private void mostrarPolinomios() {
        if (polinomios.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No hay polinomios para mostrar");
            return;
        }

        StringBuilder builder = new StringBuilder("Polinomios disponibles:\n");
        for (int i = 0; i < polinomios.size(); i++) {
            builder.append(i + 1).append(". ").append(polinomios.get(i).getExpresion()).append("\n");
        }

        JOptionPane.showMessageDialog(null, builder.toString());
    }

    public ArrayList<Polinomio> getPolinomios() {
        return polinomios;
    }

    public void setPolinomios(ArrayList<Polinomio> polinomios) {
        this.polinomios = polinomios;
    }

    private int seleccionarPolinomio(String mensaje) {
        StringBuilder builder = new StringBuilder(mensaje + "\n");
        for (int i = 0; i < polinomios.size(); i++) {
            builder.append(i + 1).append(". ").append(polinomios.get(i).getExpresion()).append("\n");
        }
        int indice = Integer.parseInt(JOptionPane.showInputDialog(builder.toString())) - 1;
        return indice;
    }

    public static void main(String[] args) {
        Principal menu = new Principal();
        menu.mostrarMenu();
    }

    private void ingresarForma(int forma) {
        switch (forma) {
            case 1:
                forma1();
                break;
            case 2:
                forma2();
                break;
            case 3:
                forma3();
                break;
            default:
                JOptionPane.showMessageDialog(null, "Forma no válida");
        }
    }

    private void forma1() {
        Forma1 ob = new Forma1();
        ArrayList<Polinomio> polinomiosForma1 = new ArrayList<>();
        int opcion;

        do {
            opcion = Integer.parseInt(JOptionPane.showInputDialog(
                    "Polinomios forma 1:\n" +
                            "1. Ingreso de polinomio F1\n" +
                            "2. Modificar polinomio F1\n" +
                            "3. Eliminar un polinomio F1\n" +
                            "4. Mostrar polinomios F1\n" +
                            "5. Evaluar X en un polinomio\n" +
                            "6. Sumar polinomios\n" +
                            "7. Multiplicar polinomios\n" +
                            "8. Regresar al menú principal\n" +
                            "9. Salir\n" +
                            "Ingrese una opción:"));

            switch (opcion) {
                case 1:
                    ob.ingresarPolinomioF1(polinomiosForma1);
                    break;
                case 2:
                    //ob.modificarPolinomioF1(polinomiosForma1);
                    break;
                case 3:
                    //ob.eliminarPolinomioF1(polinomiosForma1);
                    break;
                case 4:
                    ob.mostrarPolinomiosF1(polinomiosForma1);
                    break;
                case 5:
                    ob.evaluarXEnPolinomioF1(polinomiosForma1);
                    break;
                case 6:
                    ob.sumarPolinomiosF1(polinomiosForma1);
                    break;
                case 7:
                    ob.multiplicarPolinomiosF1(polinomiosForma1);
                    break;
                case 8:
                    JOptionPane.showMessageDialog(null, "Regresando al menú principal...");
                    return; // Salir del método actual y regresar al método del menú principal
                case 9:
                    JOptionPane.showMessageDialog(null, "Saliendo del programa...");
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opción inválida");
            }
        } while (opcion != 8);
    }
    

    private void forma2() {
        int opcion;
        do {
            opcion = Integer.parseInt(JOptionPane.showInputDialog(
                    "Polinomios forma 2:\n" +
                            "1. Ingreso de polinomio F2\n" +
                            "2. Modificar polinomio F2\n" +
                            "3. Eliminar un polinomio F2\n" +
                            "4. Mostrar polinomios F2\n" +
                            "5. Evaluar X en un polinomio\n" +
                            "6. Sumar polinomios\n" +
                            "7. Multiplicar polinomios\n" +
                            "8. Regresar al menú principal\n" +
                            "9. Salir\n" +
                            "Ingrese una opción:"));

            switch (opcion) {
                case 1:
                    // Implementación de ingreso de polinomio para la forma 2
                    break;
                case 2:
                    // Implementación de modificación de polinomio para la forma 2
                    break;
                case 3:
                    // Implementación de eliminación de polinomio para la forma 2
                    break;
                case 4:
                    // Implementación de mostrar polinomios para la forma 2
                    break;
                case 5:
                    // Implementación de evaluar X en un polinomio para la forma 2
                    break;
                case 6:
                    // Implementación de suma de polinomios para la forma 2
                    break;
                case 7:
                    // Implementación de multiplicación de polinomios para la forma 2
                    break;
                case 8:
                    JOptionPane.showMessageDialog(null, "Regresando al menú principal...");
                    return; // Salir del método actual y regresar al método del menú principal
                case 9:
                    JOptionPane.showMessageDialog(null, "Saliendo del programa...");
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opción inválida");
            }
        } while (opcion != 8);
    }

    private void forma3() {
        int opcion;
        do {
            opcion = Integer.parseInt(JOptionPane.showInputDialog(
                    "Polinomios forma 3:\n" +
                            "1. Ingreso de polinomio F3\n" +
                            "2. Modificar polinomio F3\n" +
                            "3. Eliminar un polinomio F3\n" +
                            "4. Mostrar polinomios F3\n" +
                            "5. Evaluar X en un polinomio\n" +
                            "6. Sumar polinomios\n" +
                            "7. Multiplicar polinomios\n" +
                            "8. Regresar al menú principal\n" +
                            "9. Salir\n" +
                            "Ingrese una opción:"));

            switch (opcion) {
                case 1:
                    // Implementación de ingreso de polinomio para la forma 3
                    break;
                case 2:
                    // Implementación de modificación de polinomio para la forma 3
                    break;
                case 3:
                    // Implementación de eliminación de polinomio para la forma 3
                    break;
                case 4:
                    // Implementación de mostrar polinomios para la forma 3
                    break;
                case 5:
                    // Implementación de evaluar X en un polinomio para la forma 3
                    break;
                case 6:
                    // Implementación de suma de polinomios para la forma 3
                    break;
                case 7:
                    // Implementación de multiplicación de polinomios para la forma 3
                    break;
                case 8:
                    JOptionPane.showMessageDialog(null, "Regresando al menú principal...");
                    return; // Salir del método actual y regresar al método del menú principal
                case 9:
                    JOptionPane.showMessageDialog(null, "Saliendo del programa...");
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opción inválida");
            }
        } while (opcion != 8);
    }

    public class Polinomio {
        private String expresion;
        private int grado;
        private int[] coeficientes;
    
        public Polinomio(String resultadoCoeficientes) {
            this.expresion = resultadoCoeficientes;
        }
    
        public Polinomio(int grado, int[] coeficientes) {
            this.grado = grado;
            this.coeficientes = coeficientes;
        }
    
        public String getExpresion() {
            return expresion;
        }
    
        public void setExpresion(String expresion) {
            this.expresion = expresion;
        }
    
        public Polinomio(ArrayList<Double> coeficientes) {
            this.coeficientes = new int[coeficientes.size()];
            for (int i = 0; i < coeficientes.size(); i++) {
                this.coeficientes[i] = coeficientes.get(i).intValue();
            }
        }
    
        public double evaluarEnX(double valorX) {
            double resultado = 0;
            double x = valorX;
            for (int i = 0; i < coeficientes.length; i++) {
                resultado += coeficientes[i] * Math.pow(x, i);
            }
            return resultado;
        }
    
        public Polinomio sumar(Polinomio otroPolinomio) {
            ArrayList<Double> resultadoCoeficientes = new ArrayList<>();
    
            int maxGrado = Math.max(coeficientes.length, otroPolinomio.coeficientes.length);
    
            for (int i = 0; i < maxGrado; i++) {
                double coeficienteActual = 0;
    
                if (i < coeficientes.length) {
                    coeficienteActual += coeficientes[i];
                }
    
                if (i < otroPolinomio.coeficientes.length) {
                    coeficienteActual += otroPolinomio.coeficientes[i];
                }
    
                resultadoCoeficientes.add(coeficienteActual);
            }
    
            return new Polinomio(resultadoCoeficientes);
        }
        public Polinomio(int[] coeficientes) {
            this.coeficientes = coeficientes;
        }
    
        // Método getter para el grado
        public int getGrado() {
            return grado;
        }
    
        // Método setter para el grado
        public void setGrado(int grado) {
            this.grado = grado;
        }
    
        // Método getter para los coeficientes
        public int[] getCoeficientes() {
            return coeficientes;
        }
    
        // Método setter para los coeficientes
        public void setCoeficientes(int[] coeficientes) {
            this.coeficientes = coeficientes;
        }
    }
 
}


   
   
   
   
   
   
   
   
   
   
   
    /*  public static void main(String[] args) throws Exception {
        int j = 0;
        String s = "", Cadena  = "15x^2+8x^3-3";



    }*/

