import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;

public class Validaciones {
    public static boolean validarPolinomio(String polinomio) {
        String regex = "([+-]?\\d*x?(\\^\\d+)?)(([+-]\\d*x?(\\^\\d+)?)*)";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(polinomio);

        boolean resultado = matcher.matches();

        if (!resultado) {
            JOptionPane.showMessageDialog(null, "El polinomio no cumple con la estructura (±coe)x^(±exp)");
        }

        return resultado;
    }

    public static ArrayList<String> ordenarTerminos(ArrayList<String> terminos) {


        // Ordenar términos
        Collections.sort(terminos, new Comparator<String>() {
            @Override
            public int compare(String termino1, String termino2) {
                int exp1 = obtenerExponente(termino1);
                int exp2 = obtenerExponente(termino2);
                return exp2 - exp1;
            }
        });

        // Modificar términos según las reglas especificadas
        for (int i = 0; i < terminos.size(); i++) {
            String termino = terminos.get(i);
            if (termino.startsWith(" ")) {
                // Encuentra la posición del primer espacio
                int indiceEspacio = termino.indexOf(" ");
                
                // Verifica si se encontró un espacio
                if (indiceEspacio != -1) {
                    // Inserta el "+" en la posición del primer espacio
                    termino = termino.substring(0, indiceEspacio) + "+" + termino.substring(indiceEspacio + 1);
                    terminos.set(i, termino);
                }
            }
            if (termino.endsWith("^1")) {
                // Si el término termina con "^1", quitarlo
                termino = termino.substring(0, termino.length() - 2);
                terminos.set(i, termino);
            }
            if (termino.endsWith("x^0")) {
                // Si el término termina con "x^0", quitar "x^0"
                termino = termino.replace("x^0", "");
                terminos.set(i, termino);
            }
        }
        return terminos;
    }

    private static int obtenerExponente(String termino) {
        String[] partes = termino.split("\\^");
        if (partes.length == 2) {
            return Integer.parseInt(partes[1]);
        }
        return -1; // Exponente no encontrado
    }
}


