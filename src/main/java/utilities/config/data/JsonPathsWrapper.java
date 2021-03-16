package utilities.config.data;

import com.google.gson.annotations.SerializedName;
import utilities.config.data.JsonPath;

import java.util.ArrayList;

public class JsonPathsWrapper {
    @SerializedName("dictionaryPath")
    public ArrayList<JsonPath> dictionaryPath;
}
