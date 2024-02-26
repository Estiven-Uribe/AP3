public class Nodo {
    private Termino termino;
    private Nodo siguiente;

    public Nodo(Termino termino) {
        this.termino = termino;
        this.siguiente = null;
    }

    public Termino getTermino() {
        return termino;
    }

    public Nodo getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(Nodo siguiente) {
        this.siguiente = siguiente;
    }
}




/*public class Nodo {
    //Atributos
    int Coe, Exp;
    Nodo Liga;

  
    public Nodo() {
        Coe = 0;
        Exp = 0;
        Liga = null;
    }
    public Nodo(int coe, int exp) {
        this.Coe = coe;
        this.Exp = exp;
        this.Liga = null;
    }

    public int getCoe() {
        return Coe;
    }

    public void setCoe(int coe) {
        Coe = coe;
    }

    public int getExp() {
        return Exp;
    }

    public void setExp(int exp) {
        Exp = exp;
    }

    public Nodo getLiga() {
        return Liga;
    }

    public void setLiga(Nodo liga) {
        Liga = liga;
    }
    
}*/
