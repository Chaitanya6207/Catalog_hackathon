import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class InputJsonParser {
    
    public static InputData parseJsonFile(String filePath) throws IOException {
        Gson gson = new Gson();
        
        // Read the JSON file
        JsonParser parser = new JsonParser();
        JsonElement jsonElement = parser.parse(new FileReader(filePath));
        JsonObject jsonObject = jsonElement.getAsJsonObject();
        
        // Parse keys
        JsonObject keysJson = jsonObject.getAsJsonObject("keys");
        Keys keys = gson.fromJson(keysJson, Keys.class);
        
        // Parse roots
        Map<String, Root> roots = new HashMap<>();
        for (Map.Entry<String, JsonElement> entry : jsonObject.entrySet()) {
            String key = entry.getKey();
            if (!key.equals("keys")) {
                JsonObject rootJson = entry.getValue().getAsJsonObject();
                Root root = gson.fromJson(rootJson, Root.class);
                roots.put(key, root);
            }
        }
        
        // Create and return InputData
        InputData inputData = new InputData();
        inputData.setKeys(keys);
        inputData.setRoots(roots);
        
        return inputData;
    }
}

