package utilities.config;

import com.google.gson.Gson;

import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

public class JsonReader {

    public JsonData jsonData(Integer key) {
        return data(System.getProperty("user.dir")
                +"/src/main/resources/config.json").get(key);
    }

    public JsonPath jsonPath(Integer key) {
        return path(System.getProperty("user.dir")
                +"/src/main/resources/paths.json").get(key);
    }

    private HashMap<Integer,JsonData> data(String file) {
        HashMap<Integer,JsonData> config = new HashMap<>();
        try {
            JsonWrapper wrapper = new Gson().fromJson(new FileReader(file), JsonWrapper.class);
            HashMap<Integer,JsonData> setMap = new HashMap<>(wrapper.dictionary.size());
            wrapper.dictionary.forEach(data ->
                    setMap.put(data.key, new JsonData(
                            data.platform,data.typeFromPlatform,data.url)));
            config = setMap;
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return config;
    }

    private HashMap<Integer,JsonPath> path(String file) {
        HashMap<Integer,JsonPath> config = new HashMap<>();
        try {
            JsonPathsWrapper wrapper = new Gson().fromJson(new FileReader(file), JsonPathsWrapper.class);
            HashMap<Integer, JsonPath> setMap = new HashMap<>(wrapper.dictionaryPath.size());
            wrapper.dictionaryPath.forEach(data ->
                    setMap.put(data.key, new JsonPath(
                            data.localBin,
                            data.androidSdk,
                            data.nodeJs,
                            data.appPath
                    ))
            );
            config = setMap;
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return config;
    }

}
