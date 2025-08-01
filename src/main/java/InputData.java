import java.util.Map;

public class InputData {
    private Keys keys;
    private Map<String, Root> roots;
    
    public InputData() {}
    
    public Keys getKeys() {
        return keys;
    }
    
    public void setKeys(Keys keys) {
        this.keys = keys;
    }
    
    public Map<String, Root> getRoots() {
        return roots;
    }
    
    public void setRoots(Map<String, Root> roots) {
        this.roots = roots;
    }
    
    @Override
    public String toString() {
        return "InputData{keys=" + keys + ", roots=" + roots + "}";
    }
}

