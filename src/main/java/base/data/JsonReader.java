package base.data;

import com.google.gson.Gson;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

public class JsonReader {

    public JsonData jsonData(Integer key) {
        final String path = "/src/main/resources/data.json";
        return data(prop + path).get(key);
    }

    private final String prop = System.getProperty("user.dir");

    private HashMap<Integer,JsonData> data(String file) {
        HashMap<Integer,JsonData> config = new HashMap<>();
        try {
            JsonWrapper wrapper = new Gson().fromJson(new FileReader(file), JsonWrapper.class);
            HashMap<Integer,JsonData> setMap = new HashMap<>(wrapper.dictionary.size());
            wrapper.dictionary.forEach(data ->
                    setMap.put(data.key, new JsonData(data.userName,data.password)));
            config = setMap;
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return config;
    }

}
