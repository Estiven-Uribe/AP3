public class Forma1 {
    
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
    


    

}
