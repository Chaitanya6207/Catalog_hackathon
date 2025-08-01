public class Root {
    private String base;
    private String value;
    
    public Root() {}
    
    public Root(String base, String value) {
        this.base = base;
        this.value = value;
    }
    
    public String getBase() {
        return base;
    }
    
    public void setBase(String base) {
        this.base = base;
    }
    
    public String getValue() {
        return value;
    }
    
    public void setValue(String value) {
        this.value = value;
    }
    
    @Override
    public String toString() {
        return "Root{base='" + base + "', value='" + value + "'}";
    }
}

