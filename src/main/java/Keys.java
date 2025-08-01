public class Keys {
    private int n;
    private int k;
    
    public Keys() {}
    
    public Keys(int n, int k) {
        this.n = n;
        this.k = k;
    }
    
    public int getN() {
        return n;
    }
    
    public void setN(int n) {
        this.n = n;
    }
    
    public int getK() {
        return k;
    }
    
    public void setK(int k) {
        this.k = k;
    }
    
    @Override
    public String toString() {
        return "Keys{n=" + n + ", k=" + k + "}";
    }
}

