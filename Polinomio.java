import java.util.ArrayList;

public class Polinomio {
    private int grado;
    private ArrayList<Integer> coeficientes;

    // Constructor
    public Polinomio(int grado, ArrayList<Integer> coeficientes) {
        this.grado = grado;
        this.coeficientes = coeficientes;
    }
    

    // Método para evaluar el polinomio en un valor dado de x
    public double evaluarEnX(double x) {
        double resultado = 0;
        for (int i = 0; i < coeficientes.size(); i++) {
            resultado += coeficientes.get(i) * Math.pow(x, i);
        }
        return resultado;
    }

    // Método para sumar dos polinomios
    public Polinomio sumar(Polinomio otroPolinomio) {
        ArrayList<Integer> resultadoCoeficientes = new ArrayList<>();

        int maxGrado = Math.max(this.coeficientes.size(), otroPolinomio.coeficientes.size());

        for (int i = 0; i < maxGrado; i++) {
            int coeficienteActual = 0;

            if (i < this.coeficientes.size()) {
                coeficienteActual += this.coeficientes.get(i);
            }

            if (i < otroPolinomio.coeficientes.size()) {
                coeficienteActual += otroPolinomio.coeficientes.get(i);
            }

            resultadoCoeficientes.add(coeficienteActual);
        }

        return new Polinomio(maxGrado - 1, resultadoCoeficientes);
    }

    // Método para multiplicar dos polinomios
    public Polinomio multiplicar(Polinomio otroPolinomio) {
        ArrayList<Integer> resultadoCoeficientes = new ArrayList<>();

        int gradoResultado = this.coeficientes.size() + otroPolinomio.coeficientes.size() - 1;

        for (int i = 0; i < gradoResultado; i++) {
            int coeficienteActual = 0;
            for (int j = 0; j <= i; j++) {
                if (j < this.coeficientes.size() && (i - j) < otroPolinomio.coeficientes.size()) {
                    coeficienteActual += this.coeficientes.get(j) * otroPolinomio.coeficientes.get(i - j);
                }
            }
            resultadoCoeficientes.add(coeficienteActual);
        }

        return new Polinomio(gradoResultado - 1, resultadoCoeficientes);
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
    public ArrayList<Integer> getCoeficientes() {
        return coeficientes;
    }

    // Método setter para los coeficientes
    public void setCoeficientes(ArrayList<Integer> coeficientes) {
        this.coeficientes = coeficientes;
    }
}

