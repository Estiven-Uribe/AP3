import javax.swing.*;
import java.util.ArrayList;

public class Forma2 {

    private int numTerminos;
    private int[] coeficientes;
    private int[] exponentes;

    public Forma2(int numTerminos) {
        this.numTerminos = numTerminos;
        coeficientes = new int[numTerminos];
        exponentes = new int[numTerminos];
    }

    public int getNumTerminos() {
        return numTerminos;
    }

    public int[] getCoeficientes() {
        return coeficientes;
    }

    public int[] getExponentes() {
        return exponentes;
    }

    public void setCoeficientes(int[] coeficientes) {
        this.coeficientes = coeficientes;
    }

    public void setExponentes(int[] exponentes) {
        this.exponentes = exponentes;
    }

    public static void mostrarForma2(Polinomio[] polinomios) {
        // Crear un objeto de la clase Forma2 para cada polinomio
        Forma2[] forma2Polinomios = new Forma2[polinomios.length];

        // Convertir cada polinomio a su forma 2 correspondiente
        for (int i = 0; i < polinomios.length; i++) {
            Polinomio polinomioActual = polinomios[i];
            forma2Polinomios[i] = convertirForma2(polinomioActual);
        }

        // Mostrar los polinomios en forma 2
        StringBuilder mensaje = new StringBuilder("Forma 2 de los polinomios:\n");
        for (int i = 0; i < forma2Polinomios.length; i++) {
            mensaje.append("Polinomio ").append(i + 1).append(":\n");
            mensaje.append("Número de términos: ").append(forma2Polinomios[i].getNumTerminos()).append("\n");
            mensaje.append("Coeficientes y exponentes:\n");
            int[] coeficientes = forma2Polinomios[i].getCoeficientes();
            int[] exponentes = forma2Polinomios[i].getExponentes();
            for (int j = 0; j < forma2Polinomios[i].getNumTerminos(); j++) {
                mensaje.append("Término ").append(j + 1).append(": Coeficiente: ").append(coeficientes[j]).append(", Exponente: ").append(exponentes[j]).append("\n");
            }
            mensaje.append("\n");
        }
        JOptionPane.showMessageDialog(null, mensaje.toString());
    }

   

    public static Forma2 convertirForma2(Polinomio polinomio) {
        // Obtener los términos del polinomio
        ArrayList<Termino> terminos = polinomio.getTerminos();

        // Crear un objeto de la clase Forma2 con el número de términos del polinomio
        Forma2 forma2 = new Forma2(terminos.size());

        // Rellenar los arreglos de coeficientes y exponentes
        for (int i = 0; i < terminos.size(); i++) {
            Termino termino = terminos.get(i);
            forma2.getCoeficientes()[i] = termino.getCoeficiente();
            forma2.getExponentes()[i] = termino.getExponente();
        }

        return forma2;
    }
}








/*public class Forma2 {
    //Atributos
    int DU, VPF2[];
    
    //Métodos
    public Forma2(int n) {
        this.DU = n-1;
        VPF2 = new int[n];
    }

    public int getDU() {
        return DU;
    }

    public void setDU(int dU) {
        DU = dU;
    }

    public int[] getVPF2() {
        return VPF2;
    }

    public void setVPF2(int[] vPF2) {
        VPF2 = vPF2;
    }



    
}*/
