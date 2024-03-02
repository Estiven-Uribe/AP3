import javax.swing.JOptionPane;
import java.util.ArrayList;

public class Forma1 {
    private int[] VPF1; // Arreglo que almacenará el grado y los coeficientes del polinomio

    public Forma1() {
        // Constructor vacío
    }

    public void ingresarPolinomioF1(ArrayList<Principal.Polinomio> arrayList) {
        String entrada = JOptionPane.showInputDialog("Ingrese el polinomio en forma 1 (grado, coeficientes y exponentes separados por espacios):");
        String[] partes = entrada.split(" ");
        int grado = Integer.parseInt(partes[0]); // Extraemos el grado del polinomio
        VPF1 = new int[partes.length]; // Creamos un arreglo para almacenar el grado y los coeficientes
        VPF1[0] = grado; // Almacenamos el grado en la primera posición del arreglo
        for (int i = 1; i < partes.length; i++) {
            VPF1[i] = Integer.parseInt(partes[i]); // Almacenamos los coeficientes en las siguientes posiciones
        }
        JOptionPane.showMessageDialog(null, "Polinomio ingresado correctamente en forma 1.");
    }

    public void modificarPolinomioF1(ArrayList<Principal.Polinomio> polinomios) {
        int indice = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el índice del polinomio a modificar:"));
        if (indice < 1 || indice > polinomios.size()) {
            JOptionPane.showMessageDialog(null, "Índice de polinomio inválido");
            return;
        }

        String entrada = JOptionPane.showInputDialog("Ingrese el nuevo polinomio en forma 1 (grado, coeficientes y exponentes separados por espacios):");
        String[] partes = entrada.split(" ");
        int nuevoGrado = Integer.parseInt(partes[0]); // Obtener el nuevo grado
        int[] nuevosCoeficientes = new int[partes.length - 1]; // Crear un nuevo arreglo para los coeficientes
        for (int i = 1; i < partes.length; i++) {
            nuevosCoeficientes[i - 1] = Integer.parseInt(partes[i]); // Almacenar los nuevos coeficientes
        }

        Principal.Polinomio polinomio = polinomios.get(indice - 1); // Obtener el polinomio a modificar
        polinomio.setGrado(nuevoGrado); // Establecer el nuevo grado
        polinomio.setCoeficientes(nuevosCoeficientes); // Establecer los nuevos coeficientes

        JOptionPane.showMessageDialog(null, "Polinomio modificado correctamente.");
    }

    public void eliminarPolinomioF1(ArrayList<Principal.Polinomio> polinomios) {
        if (polinomios.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No hay polinomios para eliminar.");
            return;
        }

        StringBuilder builder = new StringBuilder("Polinomios disponibles:\n");
        for (int i = 0; i < polinomios.size(); i++) {
            builder.append(i + 1).append(". ").append(polinomios.get(i).toString()).append("\n");
        }

        int indice = Integer.parseInt(JOptionPane.showInputDialog(builder.toString() +
                "Seleccione el polinomio a eliminar:")) - 1;

        polinomios.remove(indice);
        JOptionPane.showMessageDialog(null, "Polinomio eliminado correctamente.");
    }

    public void mostrarPolinomiosF1(ArrayList<Principal.Polinomio> polinomios) {
        StringBuilder mensaje = new StringBuilder("Polinomios en forma 1:\n");
        for (int i = 0; i < polinomios.size(); i++) {
            mensaje.append("Polinomio ").append(i + 1).append(":\n");
            int grado = VPF1[0]; // Obtenemos el grado del polinomio desde el arreglo
            mensaje.append("Grado: ").append(grado).append("\n");
            mensaje.append("Coeficientes y exponentes:\n");
            for (int j = 1; j < VPF1.length; j++) {
                mensaje.append("Coeficiente: ").append(VPF1[j]).append("\n"); // Mostramos los coeficientes
            }
            mensaje.append("\n");
        }
        JOptionPane.showMessageDialog(null, mensaje.toString());
    }

    public void evaluarXEnPolinomioF1(ArrayList<Principal.Polinomio> polinomios) {
        double valorX = Double.parseDouble(JOptionPane.showInputDialog("Ingrese el valor de X:"));
        StringBuilder resultado = new StringBuilder("Resultado de evaluar X en los polinomios en forma 1:\n");
        for (int i = 0; i < polinomios.size(); i++) {
            double evaluacion = polinomios.get(i).evaluarEnX(valorX);
            resultado.append("Polinomio ").append(i + 1).append(": ").append(evaluacion).append("\n");
        }
        JOptionPane.showMessageDialog(null, resultado.toString());
    }

    public void sumarPolinomiosF1(ArrayList<Principal.Polinomio> polinomios) {
        // Seleccionar los polinomios a sumar
        Principal.Polinomio polinomio1 = seleccionarPolinomio("Seleccione el primer polinomio para sumar:", polinomios);
        Principal.Polinomio polinomio2 = seleccionarPolinomio("Seleccione el segundo polinomio para sumar:", polinomios);

        // Realizar la suma de los polinomios
        Principal.Polinomio resultado = polinomio1.sumar(polinomio2);

        // Mostrar el resultado
        JOptionPane.showMessageDialog(null, "El resultado de la suma es:\n" + resultado.toString());

        // Agregar el resultado a la lista de polinomios
        polinomios.add(resultado);
    }

    public void multiplicarPolinomiosF1(ArrayList<Principal.Polinomio> polinomios) {
        // Seleccionar los polinomios a multiplicar
        Principal.Polinomio polinomio1 = seleccionarPolinomio("Seleccione el primer polinomio para multiplicar:", polinomios);
        Principal.Polinomio polinomio2 = seleccionarPolinomio("Seleccione el segundo polinomio para multiplicar:", polinomios);

        // Realizar la multiplicación de los polinomios
        Principal.Polinomio resultado = polinomio1.sumar(polinomio2);

        // Mostrar el resultado
        JOptionPane.showMessageDialog(null, "El resultado de la multiplicación es:\n" + resultado.toString());

        // Agregar el resultado a la lista de polinomios
        polinomios.add(resultado);
    }

    private Principal.Polinomio seleccionarPolinomio(String mensaje, ArrayList<Principal.Polinomio> polinomios) {
        StringBuilder builder = new StringBuilder(mensaje + "\n");
        for (int i = 0; i < polinomios.size(); i++) {
            builder.append(i + 1).append(". ").append(polinomios.get(i).toString()).append("\n");
        }
        int indice = Integer.parseInt(JOptionPane.showInputDialog(builder.toString())) - 1;
        return polinomios.get(indice);
    }
}







/*private Polinomio seleccionarPolinomio(String mensaje, ArrayList<Polinomio> polinomios) {
        int indice = Integer.parseInt(JOptionPane.showInputDialog(mensaje)) - 1;
        return polinomios.get(indice);
    }*/








/* 
import java.util.ArrayList;

public class Forma1<Polinomio> {
    
        // Atributos
        int DU;
        int[] VPF1;
        private int grado;
        ArrayList<Polinomio> polinomios;
    
        // Métodos
        public Forma1(int g, ArrayList<Polinomio> polinomios) {
            this.DU = g+1;
            this.VPF1 = new int[DU+1];
            this.polinomios = polinomios;
        }
        public void convertirForma1() {
            for (Polinomio polinomio : polinomios) {
                // Aquí va tu código para convertir el polinomio a la forma 1
            }
        }
    
    
    
    
    
    
    
    
    


    public Forma1(int grado) {
        this.grado = grado;
        VPF1 = new int[(grado + 1) * 2];
    }

    public Forma1() {
        //TODO Auto-generated constructor stub
    }

    public int getGrado() {
        return grado;
    }

    public int[] getVPF1() {
        return VPF1;
    }

    public void setVPF1(int[] VPF1) {
        this.VPF1 = VPF1;
    }



    public static void mostrarForma1(Polinomio[] polinomios) {
        // Crear un objeto de la clase Forma1 para cada polinomio
        Forma1[] forma1Polinomios = new Forma1[polinomios.length];

        // Convertir cada polinomio a su forma 1 correspondiente
        for (int i = 0; i < polinomios.length; i++) {
            Polinomio polinomioActual = polinomios[i];
            forma1Polinomios[i] = convertirForma1(polinomioActual);
        }

        // Mostrar los polinomios en forma 1
        StringBuilder mensaje = new StringBuilder("Forma 1 de los polinomios:\n");
        for (int i = 0; i < forma1Polinomios.length; i++) {
            mensaje.append("Polinomio ").append(i + 1).append(":\n");
            mensaje.append("Grado: ").append(forma1Polinomios[i].getGrado()).append("\n");
            mensaje.append("Coeficientes y exponentes:\n");
            int[] vpF1 = forma1Polinomios[i].getVPF1();
            for (int j = 0; j < vpF1.length; j += 2) {
                mensaje.append("Coeficiente: ").append(vpF1[j]).append(", Exponente: ").append(vpF1[j + 1]).append("\n");
            }
            mensaje.append("\n");
        }
        JOptionPane.showMessageDialog(null, mensaje.toString());
    }

    public static Forma1 convertirForma1(Polinomio polinomio) {
        // Obtener el grado del polinomio
        int grado = polinomio.getGrado();

        // Crear un objeto de la clase Forma1 con el grado del polinomio
        Forma1 forma1 = new Forma1(grado);

        // Obtener los términos del polinomio
        ArrayList<Termino> terminos = polinomio.getTerminos();

        // Rellenar el vector VPF1 con los coeficientes y exponentes de cada término
        int[] vPF1 = new int[(grado + 1) * 2]; // El tamaño del vector es (grado + 1) * 2 porque cada término tiene un coeficiente y un exponente
        for (Termino termino : terminos) {
            int exponente = termino.getExponente();
            int coeficiente = termino.getCoeficiente();
            vPF1[exponente * 2] = coeficiente; // Coeficiente
            vPF1[exponente * 2 + 1] = exponente; // Exponente
        }

        // Establecer el vector VPF1 en el objeto Forma1
        forma1.setVPF1(vPF1);

        return forma1;
    }
}
*/


/*public class Forma1 {
    
    //Atributos
    int DU, VPF1[];

    //Métodos
    public Forma1(int g) {
        this.DU = g+1;
        VPF1 = new int[DU+1];

    }

    public int getDU() {
        return DU;
    }

    public void setDU(int dU) {
        DU = dU;
    }

    public int[] getVPF1() {
        return VPF1;
    }

    public void setVPF1(int[] vPF1) {
        VPF1 = vPF1;
    }
    
// Métodos

    

}*/
