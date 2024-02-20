public class Forma2 {
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



    
}
