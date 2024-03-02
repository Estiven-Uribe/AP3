import javax.swing.*;
import java.util.ArrayList;

public class Forma3 {

    private Nodo inicio;

    public Forma3() {
        this.inicio = null;
    }

    public Nodo getInicio() {
        return inicio;
    }

    public void setInicio(Nodo inicio) {
        this.inicio = inicio;
    }

    public static void main(String[] args) {
        // Ejemplo de inicialización de memoria de polinomios
        Polinomio[] polinomios = new Polinomio[2];
        polinomios[0] = new Polinomio("2x^3 + 4x^2 - 5x + 3");
        polinomios[1] = new Polinomio("-x^2 + 2x - 1");

        mostrarForma3(polinomios);
    }

    public static void mostrarForma3(Polinomio[] polinomios) {
        // Crear un objeto de la clase Forma3 para cada polinomio
        Forma3[] forma3Polinomios = new Forma3[polinomios.length];

        // Convertir cada polinomio a su forma 3 correspondiente
        for (int i = 0; i < polinomios.length; i++) {
            Polinomio polinomioActual = polinomios[i];
            forma3Polinomios[i] = convertirForma3(polinomioActual);
        }

        // Mostrar los polinomios en forma 3
        StringBuilder mensaje = new StringBuilder("Forma 3 de los polinomios:\n");
        for (int i = 0; i < forma3Polinomios.length; i++) {
            mensaje.append("Polinomio ").append(i + 1).append(":\n");
            mensaje.append(forma3Polinomios[i].toString()).append("\n");
            mensaje.append("\n");
        }
        JOptionPane.showMessageDialog(null, mensaje.toString());
    }

    public static <Polinomio, Termino> Forma3 convertirForma3(Polinomio polinomio) {
        // Obtener los términos del polinomio
        ArrayList<Termino> terminos = polinomio.getTerminos();

        // Crear un objeto de la clase Forma3
        Forma3 forma3 = new Forma3();

        // Crear un nodo para cada término y enlazarlos
        Nodo previo = null;
        for (Termino termino : terminos) {
            Nodo nodo = new Nodo(termino);
            if (previo != null) {
                previo.setSiguiente(nodo);
            }
            previo = nodo;
            if (forma3.getInicio() == null) {
                forma3.setInicio(nodo);
            }
        }

        return forma3;
    }













/*public class Forma3 {
    //Atributo
    Nodo Punta;

    //Método
    public Forma3() {
        Punta = null;
    }


    
}*/
